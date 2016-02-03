package com.poochiku.suraksha.component.helper;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtil
{

	public static Properties getPropertyFile(String name,Class<?> type) throws IOException
	{

		Properties prop = new Properties();
		prop.load(type.getClassLoader().getResourceAsStream(name));
		return prop;

	}
}
