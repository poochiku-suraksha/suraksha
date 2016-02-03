package com.poochiku.suraksha.component.helper;

import java.io.IOException;
import java.util.Properties;

public class Strings
{

	private static Properties prop;

	private static void load(String name)
	{
		try
		{
			if (prop == null)
			{
				prop = PropertyUtil.getPropertyFile(name+".properties", Strings.class);
			}

		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block

		}
	}

	public static String get(String key)
	{

		load();
		return (String) prop.get(key);

	}
}
