package com.poochiku.suraksha.util;

import org.apache.log4j.Logger;

public class SurakshaLogger
{

	public static void error(Class<?> o,String error)
	{
		Logger logger = Logger.getLogger(o);
		logger.error(error);
	}

}
