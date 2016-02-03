package com.poochiku.suraksha.model;

import java.lang.reflect.Type;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SurakshaHome extends SurakshaInstitutionalEntity implements ISurakshaEntity
{

	@Override
	public JSONObject toJSONObject()
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
	public ISurakshaEntity fromJSONObject(String json)
	{

		Type type = new TypeToken<SurakshaHome>()
		{
		}.getType();

		return new Gson().fromJson(json, type);
	}

}
