package com.poochiku.suraksha.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.poochiku.suraksha.module.db.DBHandler;
import com.poochiku.suraksha.util.SURAKSHA_PARAMS.SURAKSHA_LOCALE;
import com.poochiku.suraksha.util.Strings;
import com.poochiku.suraksha.util.SurakshaLogger;

public class SurakshaApplicationContext implements ServletContextListener
{

	@Override
	public void contextDestroyed(ServletContextEvent context)
	{

	}

	@Override
	public void contextInitialized(ServletContextEvent context)
	{
		try
		{

			System.out.println("####################################### --------------------------- #################################");
			System.out.println("####################################### Suraksha contextInitialized #################################");
			System.out.println("####################################### --------------------------- #################################");

			Properties properties = new Properties();
			InputStream stream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
			properties.load(stream);

			String environment = properties.getProperty("env").trim();
			String mongo_port = properties.getProperty(environment + "_mongo_port").trim();
			String mongo_host = properties.getProperty(environment + "_mongo_host").trim();
			String mongo_name = properties.getProperty(environment + "_mongo_name").trim();
			String mongo_username = properties.getProperty(environment + "_mongo_username").trim();
			String mongo_password = properties.getProperty(environment + "_mongo_password").trim();

			//Strings
			Strings hindi = Strings.getStrings(SURAKSHA_LOCALE.HINDI+".properties");
			Strings english = Strings.getStrings(SURAKSHA_LOCALE.ENGLISH+".properties");

			DBHandler mongo = DBHandler.getInstance(Integer.parseInt(mongo_port), mongo_host, mongo_name, mongo_username, mongo_password);

			// Set all the Application level data here
			SurakshaApplication.getInstance().setDBHandler(mongo).setEnglish(english).setHindi(hindi);

		}
		catch (Exception e)
		{
			SurakshaLogger.error(this.getClass(), e.getMessage());
		}

	}

}
