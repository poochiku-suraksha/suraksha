package com.poochiku.suraksha.db;

import java.io.IOException;
import java.util.Properties;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.poochiku.suraksha.component.helper.PropertyUtil;

public class DBHandler
{

	public static DBHandler instance;

	private MongoClient mongoClient;
	private DB db;

	private DBHandler()
	{

	}

	public static DB getDBInstance() throws IOException
	{
		if (instance == null)
		{
			try
			{
				instance = new DBHandler();
				Properties dbprop = PropertyUtil.getPropertyFile("db.prop", instance.getClass());
				int port = Integer.parseInt(dbprop.getProperty("port"));
				String host = dbprop.getProperty("host");
				String dbName = dbprop.getProperty("db");
				String username = dbprop.getProperty("username");
				String password= dbprop.getProperty("password");
				instance.mongoClient = new MongoClient(host, port);
				
				instance.db = instance.mongoClient.getDB(dbName);
				instance.db.addUser(username, password.toCharArray(), false);

			}
			catch (IOException e)
			{
				throw e;
			}

		}

		return instance.db;
	}
}
