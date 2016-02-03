package com.poochiku.suraksha.auth;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

public class SurakshaAuthFilter implements ContainerRequestFilter
{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException
	{

		
	}

	private boolean isFiltered(String path)
	{
		if (path.equals("subscriber") || path.equals("auth/login"))
		{
			
			return false;
		}
		else
		{
			return true;
		}

	}

}
