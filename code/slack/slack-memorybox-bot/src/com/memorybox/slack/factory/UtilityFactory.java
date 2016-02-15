package com.memorybox.slack.factory;

import org.json.JSONException;
import org.json.JSONObject;

import com.memorybox.slack.model.SlackBot;
import com.memorybox.slack.model.SlackObject;
import com.memorybox.slack.model.SlackUser;

public class UtilityFactory {

	private UtilityFactory() {
	};

	private static UtilityFactory instance;

	public static UtilityFactory getInstance() {
		if (instance == null) {
			instance = new UtilityFactory();
		}
		return instance;
	}

	public SlackObject getSlackObjectFromAuthResponse(JSONObject accesObj, JSONObject userObj) throws JSONException {
		
		
		SlackObject s = new SlackObject();
		SlackBot bot = new SlackBot();
		SlackUser user = new SlackUser();
		JSONObject botJO = accesObj.getJSONObject("bot");
		s.setChannel_id(accesObj.getString("scope"));
		s.setTeam_name(accesObj.getString("team_name"));
		s.setTeam_id(accesObj.getString("team_id"));
		s.setAccess_token(accesObj.getString("access_token"));
		bot.setBot_user_id(botJO.getString("bot_user_id"));
		bot.setBot_access_token(botJO.getString("bot_access_token"));
		s.setBot(bot);
		s.setUser(user);
		return s;
	}

}
