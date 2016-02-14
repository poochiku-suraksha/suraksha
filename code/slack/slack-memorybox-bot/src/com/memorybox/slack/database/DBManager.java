/**
 * @author Madhu
 */
package com.memorybox.slack.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.memorybox.slack.base.MemoryBase;
import com.memorybox.slack.constant.Constant_Database;

public class DBManager extends MemoryBase
{

	private static DBManager instance;
	private Connection connection;

	private DBManager()
	{}

	public static DBManager getInstance()
	{
		if (instance == null)
		{
			instance = new DBManager();
			try
			{
				instance.connection = DriverManager.getConnection(Constant_Database.DB_URL, Constant_Database.DB_USERNAME, Constant_Database.DB_PASSWORD);
			} catch (SQLException e)
			{
				instance.logError(DBManager.class, e.getMessage());
			}
		}
		return instance;
	}

}
