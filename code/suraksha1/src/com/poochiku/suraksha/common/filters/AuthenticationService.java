package com.poochiku.suraksha.common.filters;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.poochiku.common.KONSTANTS.COLLECTIONS;
import com.poochiku.common.KONSTANTS.MAGIC_PARAMS;
import com.poochiku.suraksha.component.helper.CommonUtil;
import com.poochiku.suraksha.component.helper.Strings;
import com.poochiku.suraksha.db.DBHandler;
import com.poochiku.suraksha.model.SurakshaUser;

public class AuthenticationService
{

	public boolean authenticate(String authCredentials)
	{

		if (null == authCredentials)
			return false;
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic" + " ", "");
		String usernameAndPassword = null;
		try
		{
			byte[] decodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encodedUserPassword.getBytes());
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();
		return check(username,password);
	
	}
	
	private boolean check(String username,String password)
	{
		System.out.println("Authenticating for :"+username+"|"+password);
	    
		DB db;
		try
		{
			db = DBHandler.getDBInstance();
			DBCollection col = db.getCollection(COLLECTIONS.SURAKSHA_USER);
			BasicDBObject fields = new BasicDBObject();
			password =CommonUtil.encode(password);
			fields.put(MAGIC_PARAMS.KEY_PHONE_NUMBER, username);
			fields.put(MAGIC_PARAMS.KEY_SURAKSHA_PASSWORD, password);
			DBCursor cursor = col.find(fields);
			if (cursor.hasNext())
			{
				cursor.close();
				System.out.println("Auth Scussesful...");
				return true;
			} else
			{
				System.out.println("Auth Failed...");
				cursor.close();
				return false;
			}
		}
		catch (IOException e)
		{
			return false;
		}
		
	}

}
