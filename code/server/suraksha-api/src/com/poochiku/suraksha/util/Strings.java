package com.poochiku.suraksha.util;

import java.io.IOException;
import java.util.Properties;

public class Strings
{

	private Strings()
	{
	};

	private static Properties prop;

	public static Strings getStrings(String name) throws IOException
	{
		Strings s = new Strings();
		if (prop == null)
		{

			prop = s.getPropertyFile(name , Strings.class);
		}

		return s;

	}

	public static String get(String key)
	{

		return (String) prop.get(key);

	}

	private Properties getPropertyFile(String name,Class<?> type) throws IOException
	{

		Properties prop = new Properties();
		prop.load(type.getClassLoader().getResourceAsStream(name));
		return prop;

	}
}
