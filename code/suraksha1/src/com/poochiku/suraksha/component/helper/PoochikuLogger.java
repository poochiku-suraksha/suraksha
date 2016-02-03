package com.poochiku.suraksha.component.helper;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class PoochikuLogger

{
	private static Logger logger;

	// HTTP Request Logging
	public static void logHttpRequestInfo(HttpServletRequest request)
	{
		request.getRemoteAddr();
		request.getRemotePort();
		request.getRequestURL();
	}

	public static void logHttpRequestAsError(HttpServletRequest request)
	{
		request.getRemoteAddr();
		request.getRemotePort();
		request.getRequestURL();
	}

	public static void logHttpRequestAsWarning(HttpServletRequest request)
	{
		request.getRemoteAddr();
		request.getRemotePort();
		request.getRequestURL();
	}

	// General Logging

	public static void log(String message, Class cls)
	{
		logInfo(cls, message);
	}

	/**
	 * Internal Methods
	 * 
	 * @param cls
	 * @param message
	 */

	public static void logError(Class cls, String message)
	{
		logger = Logger.getLogger(cls);
		logger.error(cls.getCanonicalName() + "::" + message);

	}

	private static void logInfo(Class cls, String message)
	{
		logger = Logger.getLogger(cls);
		logger.info(cls.getCanonicalName() + "::" + message);

	}

	private static void logWarning(Class cls, String message)
	{

		logger = Logger.getLogger(cls);
		logger.warn(cls.getCanonicalName() + "::" + message);

	}

}
