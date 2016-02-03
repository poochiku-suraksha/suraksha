package com.poochiku.suraksha.component.user;

import java.io.IOException;
import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;
import com.poochiku.common.KONSTANTS.COLLECTIONS;
import com.poochiku.common.KONSTANTS.MAGIC_PARAMS;
import com.poochiku.suraksha.component.base.ISurakshaDBOperation;
import com.poochiku.suraksha.component.helper.CommonUtil;
import com.poochiku.suraksha.component.helper.PoochikuLogger;
import com.poochiku.suraksha.component.helper.Strings;
import com.poochiku.suraksha.component.service.EmailService;
import com.poochiku.suraksha.db.DBHandler;
import com.poochiku.suraksha.model.ISurakshaEntity;
import com.poochiku.suraksha.model.SurakshaUser;

public class UserController implements ISurakshaDBOperation
{

	@Override
	public Response create(ISurakshaEntity entity)
	{
		try
		{
			DB db = DBHandler.getDBInstance();
			DBCollection col = db.getCollection(COLLECTIONS.SURAKSHA_USER);
			SurakshaUser user = (SurakshaUser) entity;
			BasicDBObject fields = new BasicDBObject();
			fields.put(MAGIC_PARAMS.KEY_PHONE_NUMBER, user.getPhoneNumber());
			DBCursor cursor = col.find(fields);
			if (cursor.hasNext())
			{
				String errMsg = String.format(Strings.get(MAGIC_PARAMS.ERROR_HTTP_USER_EXISTS), user.getPhoneNumber());
				PoochikuLogger.logError(getClass(), errMsg + " => " + user.toJSONObject().toString());
				return Response.serverError().entity(errMsg).build();
			} else
			{
				user.setSurakshaId(CommonUtil.generateRandomSurakshaID(user.getPhoneNumber()));
				user.setPhoneVerified(false);
				user.setCreateDate(CommonUtil.getSurakshaDate(new Date()));
				user.setUpdatedDate(CommonUtil.getSurakshaDate(new Date()));
				WriteResult result = col.insert(CommonUtil.getDBObject(user.toJSONObject()));
				// TODO : Fetch from html template
				EmailService emailService = new EmailService(user.getEmail(), "Welcome To Suraksha", "", "Dear " + user.getFirstName() + " Thanks for Joining Suraksha Project."
						+ "<h3>Your suraksha ID : " + user.getSurakshaId() + "</h3>");
				emailService.send();
				return Response.ok(user, MediaType.APPLICATION_JSON).build();
			}

		} catch (Exception e)
		{
			PoochikuLogger.logError(getClass(), e.getMessage());
			return Response.serverError().status(520).entity(Strings.get(MAGIC_PARAMS.ERROR_UNKNOWN)).build();
		}
	}

	@Override
	public Response read(ISurakshaEntity entity)
	{

		return null;

	}

	@Override
	public Response delete(ISurakshaEntity entity)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response update(ISurakshaEntity entity)
	{

		return null;
	}

	@Override
	public Response readById(ISurakshaEntity entity)
	{
		try
		{
			SurakshaUser user = (SurakshaUser) entity;
			DB db = DBHandler.getDBInstance();
			DBCollection col = db.getCollection(COLLECTIONS.SURAKSHA_USER);
			BasicDBObject fields = new BasicDBObject();
			fields.put(MAGIC_PARAMS.KEY_SURAKSHA_ID, user.getSurakshaId());
			DBCursor cursor = col.find(fields);
			if (cursor.hasNext())
			{
				user = (SurakshaUser) user.fromJSONObject(cursor.next().toString());
				System.out.println("Retrieved user :" + user.toJSONObject().toString());
				return Response.ok(user, MediaType.APPLICATION_JSON).build();
			} else
			{
				System.out.println("No content");
				return Response.serverError().status(404).entity(Strings.get(MAGIC_PARAMS.ERROR_HTTP_USER_NOT_FOUND)).build();
			}

		} catch (IOException e)
		{
			PoochikuLogger.logError(getClass(), e.getMessage());
			return Response.serverError().status(520).entity(Strings.get(MAGIC_PARAMS.ERROR_UNKNOWN)).build();
		}

	}

	public Response login(ISurakshaEntity entity)
	{

		try
		{

			SurakshaUser user = (SurakshaUser) entity;
			String encodedPassword = CommonUtil.encode(user.getPassword());
			DB db = DBHandler.getDBInstance();
			DBCollection col = db.getCollection(COLLECTIONS.SURAKSHA_USER);
			BasicDBObject fields = new BasicDBObject();
			fields.put(MAGIC_PARAMS.KEY_PHONE_NUMBER, user.getPhoneNumber());
			fields.put(MAGIC_PARAMS.KEY_SURAKSHA_PASSWORD, encodedPassword);
			DBCursor cursor = col.find(fields);
			if (cursor.hasNext())
			{
				user = (SurakshaUser) user.fromJSONObject(cursor.next().toString());
				System.out.println("Retrieved user :" + user.toJSONObject().toString());
				return Response.ok(user, MediaType.APPLICATION_JSON).build();
			} else
			{
				System.out.println("Invalid username/password");
				return Response.serverError().status(403).entity(Strings.get(MAGIC_PARAMS.ERROR_INVALID_USERNAME_OR_PASSWORD)).build();
			}

		} catch (IOException e)
		{
			PoochikuLogger.logError(getClass(), e.getMessage());
			return Response.serverError().status(520).entity(Strings.get(MAGIC_PARAMS.ERROR_UNKNOWN)).build();
		}

	}

}
