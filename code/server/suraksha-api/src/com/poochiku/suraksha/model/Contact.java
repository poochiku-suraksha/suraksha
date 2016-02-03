package com.poochiku.suraksha.model;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.poochiku.suraksha.contract.ISurakshaEntity;

public class Contact implements ISurakshaEntity
{

	private Phone phone;
	private Address address;

	public Phone getPhone()
	{
		return phone;
	}

	public Contact setPhone(Phone phone)
	{
		this.phone = phone;
		return this;

	}

	public Address getAddress()
	{
		return address;
	}

	public Contact setAddress(Address address)
	{
		this.address = address;
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
