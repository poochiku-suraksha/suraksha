package com.poochiku.suraksha.module.response;

import javax.ws.rs.core.Response;

public class SurakshaResponse
{

	
	
	
	public static Response sendBadParameterError(String message)
	{
		return Response.status(400).entity(message).build();
	}
	
	public static Response sendForbiddenError(String message)
	{
		return Response.status(403).entity(message).build();
	}
}
