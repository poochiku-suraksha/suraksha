package com.poochiku.suraksha.test;

import org.apache.catalina.connector.Request;

import com.poochiku.suraksha.component.helper.PoochikuLogger;

public class Loggertest
{

	public static void main (String args [])
	{
		PoochikuLogger logger = new PoochikuLogger();
		logger.log("Sorry",Loggertest.class);
	}
}
