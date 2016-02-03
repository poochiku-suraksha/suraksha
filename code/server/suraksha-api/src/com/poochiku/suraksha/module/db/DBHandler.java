package com.poochiku.suraksha.module.db;

import java.io.IOException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DBHandler
{

	public static DBHandler instance;

	private MongoClient mongoClient;
	private DB db;
	private String host;
	private String dbName;
	private String username;
	private String password;
	private int port;

	private DBHandler()
	{

	}

	public DB getDb()
	{
		return db;
	}

	public static DBHandler getInstance(int port,String host,String dbName,String username,String password) throws IOException
	{
		if (instance == null)
		{
			instance = new DBHandler();
			instance.port = port;
			instance.host = host;
			instance.dbName = dbName;
			instance.username = username;
			instance.password = password;
			instance.mongoClient = new MongoClient(host, port);
			instance.db = instance.mongoClient.getDB(dbName);
			instance.db.addUser(username, password.toCharArray(), false);

		}
		return instance;
	}
}
