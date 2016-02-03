package com.poochiku.suraksha.model;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.poochiku.suraksha.contract.ISurakshaEntity;

public class Address implements ISurakshaEntity
{
	private String lineOne;
	private String lineTwo;
	private String state;
	private String country;
	private String pinCode;

	public String getLineOne()
	{
		return lineOne;
	}

	public Address setLineOne(String lineOne)
	{
		this.lineOne = lineOne;
		return this;
	}

	public String getLineTwo()
	{
		return lineTwo;
	}

	public Address setLineTwo(String lineTwo)
	{
		this.lineTwo = lineTwo;
		return this;
	}

	public String getState()
	{
		return state;
	}

	public Address setState(String state)
	{
		this.state = state;
		return this;
	}

	public String getCountry()
	{
		return country;
	}

	public Address setCountry(String country)
	{
		this.country = country;
		return this;
	}

	public String getPin()
	{
		return pinCode;
	}

	public Address setPin(String pin)
	{
		this.pinCode = pin;
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
