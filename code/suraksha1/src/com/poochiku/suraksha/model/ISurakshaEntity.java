package com.poochiku.suraksha.model;

import org.json.JSONObject;

public abstract interface ISurakshaEntity
{

	public JSONObject toJSONObject();
	public ISurakshaEntity  fromJSONObject(String json);
	
}
