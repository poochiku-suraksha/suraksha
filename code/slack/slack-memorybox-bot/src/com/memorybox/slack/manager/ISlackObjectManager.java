package com.memorybox.slack.manager;

import org.json.JSONException;
import org.json.JSONObject;

import com.memorybox.slack.model.SlackObject;

public interface ISlackObjectManager {
	
	void process(SlackObject obj) throws Exception;
	SlackObject createOrUpdate(JSONObject accessObj, JSONObject userObj) throws JSONException;

}
