package com.poochiku.suraksha.model;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.poochiku.suraksha.contract.ISurakshaEntity;

public class Phone implements ISurakshaEntity
{

	private String countryCode;
	private String number;

	public String getCountryCode()
	{
		return countryCode;
	}

	public Phone setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
		return this;
	}

	public String getNumber()
	{
		return number;
	}

	public Phone setNumber(String number)
	{
		this.number = number;
		return this;
	}
	
	@Override
	public JSONObject toJson()
	{
		Gson gson = new Gson();
		try
		{
			return new JSONObject(gson.toJson(this));
		}
		catch (JSONException e)
		{
			return null;
		}

	}

	@Override
	public ISurakshaEntity fromJson(String json)
	{
		return new Gson().fromJson(json, this.getClass());
	}
}
