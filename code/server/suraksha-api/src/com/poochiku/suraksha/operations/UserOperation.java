package com.poochiku.suraksha.operations;

import java.util.Date;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;
import com.poochiku.suraksha.app.SurakshaApplication;
import com.poochiku.suraksha.i18N.ILocale;
import com.poochiku.suraksha.i18N.LocaleFactory;
import com.poochiku.suraksha.model.OperationalHeaders;
import com.poochiku.suraksha.model.SurakshaUser;
import com.poochiku.suraksha.module.db.DBHandler;
import com.poochiku.suraksha.module.response.SurakshaResponse;
import com.poochiku.suraksha.util.SURAKSHA_PARAMS;
import com.poochiku.suraksha.util.SURAKSHA_PARAMS.KEYS;
import com.poochiku.suraksha.util.SURAKSHA_PARAMS.SURAKSHA_STRINGS;
import com.poochiku.suraksha.util.SurakshaUtil;
import com.poochiku.suraksha.util.SURAKSHA_PARAMS.AUTH_TYPE;

public class UserOperation
{

	private OperationalHeaders opsHeader;
	
	public UserOperation( OperationalHeaders opsHeader)
	{
		this.opsHeader=opsHeader;
	}

	public Response registerUser(SurakshaUser user)
	{
		// Save in database

		String authType = user.getAuthType();
		switch (authType)
		{
		case AUTH_TYPE.PHONE:

			return phoneUser(user);

		case AUTH_TYPE.EMAIL:

			return null;

		default:
			return null;

		}

	}

	private Response phoneUser(SurakshaUser user)
	{
		DBHandler db = SurakshaApplication.getInstance().getDBHandler();
		DBCollection col = db.getDb().getCollection(SURAKSHA_PARAMS.COLLECTIONS.SURAKSHA_USERS);
		WriteResult result = null;
		BasicDBObject fields = new BasicDBObject();
		fields.put(KEYS.PHONE + "." + KEYS.NUMBER, user.getPhone().getNumber());
		fields.put(KEYS.PHONE + "." + KEYS.COUNTRY_CODE, user.getPhone().getCountryCode());
		DBCursor cursor = col.find(fields);
		if (cursor.hasNext())
		{
			// phone number exists
			System.out.println("User already exists");
			ILocale locale = LocaleFactory.getLocale(opsHeader.getLocale());
			System.out.println("Current Locale:"+opsHeader.getLocale());
			String comment =locale.getString(SURAKSHA_STRINGS.USER_ALREADY_RESGISTERED);
			System.out.println(comment);
			return SurakshaResponse.sendForbiddenError(comment);

		}
		else
		{
			// store and create suraksha user
			user = massageUser(user);
			result = col.insert(SurakshaUtil.getDBObject(user.toJson()));
		}
		return null;
	}

	private SurakshaUser massageUser(SurakshaUser user)
	{
		String sid = SurakshaUtil.generateRandomSurakshaID(user.getPhone().getNumber());
		user.setSurakshaId(sid);
		Date cdate = new Date();
		user.setCreatedTime(cdate.getTime());
		return user;
	}

}
