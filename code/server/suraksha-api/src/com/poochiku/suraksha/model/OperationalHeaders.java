package com.poochiku.suraksha.model;

import javax.ws.rs.container.ContainerRequestContext;

import com.poochiku.suraksha.util.SURAKSHA_PARAMS.SURAKSHA_LOCALE;

public class OperationalHeaders
{
	@SuppressWarnings( "unused" )
	private ContainerRequestContext context;

	public OperationalHeaders(ContainerRequestContext context)
	{
		this.context = context;
		String locale = context.getHeaderString("locale");
		if(locale!=null)
		{
			this.locale =  locale;
		}
		else
		{
			this.locale = SURAKSHA_LOCALE.ENGLISH;
		}
	}

	String locale;

	public String getLocale()
	{
		return locale;
	}

	public void setLocale(String locale)
	{
		this.locale = locale;
	}

}
