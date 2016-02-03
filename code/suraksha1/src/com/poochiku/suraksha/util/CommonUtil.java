package com.poochiku.suraksha.util;

import org.json.JSONObject;

import com.mongodb.DBObject;

public class CommonUtil
{

	
	public static DBObject getDBObject(JSONObject json)
	{
		return (DBObject) json;
	}
	
	

}
