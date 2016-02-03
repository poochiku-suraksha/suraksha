package com.poochiku.suraksha.contract;

import org.json.JSONObject;

public interface ISurakshaEntity
{

	JSONObject toJson();
	ISurakshaEntity fromJson(String json);
}
