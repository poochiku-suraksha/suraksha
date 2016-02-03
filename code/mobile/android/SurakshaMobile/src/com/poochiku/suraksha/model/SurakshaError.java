package com.poochiku.suraksha.model;

import com.poochiku.suraksha.contract.ISurakshaEntity;

public class SurakshaError implements ISurakshaEntity
{
	int statusCode;
	String message;

	public int getStatusCode()
	{
		return statusCode;
	}

	public SurakshaError setStatusCode(int statusCode)
	{
		this.statusCode = statusCode;
		return this;
	}

	public String getMessage()
	{
		return message;
	}

	public SurakshaError setMessage(String message)
	{
		this.message = message;
		return this;
	}
}
