package com.poochiku.suraksha.app;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;


@Provider
public class SurakshaResponseFilter implements ContainerResponseFilter
{

	@Override
	public void filter(ContainerRequestContext arg0,ContainerResponseContext response) throws IOException
	{
//		System.out.println("%%%%%%%%%%%%  Inside SurakshaResponseFilter%%%%%%%%%%%%");
//		MediaType type = response.getMediaType();
//		String contentType = type.toString();
//		contentType = contentType + ";charset=utf-8";
//		response.getHeaders().putSingle("Content-Type", contentType);
	}

}
