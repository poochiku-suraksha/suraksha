package com.poochiku.suraksha.test;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.poochiku.suraksha.component.helper.CommonUtil;
import com.poochiku.suraksha.db.DBHandler;

public class DBTest
{

	public static void main(String[] args)
	{
		try
		{
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("name", "madhu").put("email", "madhu@teamchat.com");
			DB db = DBHandler.getDBInstance();
			DBCollection coll = db.getCollection("org");
			coll.insert(CommonUtil.getDBObject(jsonObj));

		}
		catch (IOException | JSONException e)
		{
			e.printStackTrace();
		}
	}
}
