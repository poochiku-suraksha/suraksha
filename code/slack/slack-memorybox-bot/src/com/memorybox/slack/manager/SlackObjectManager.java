package com.memorybox.slack.manager;

import org.json.JSONException;
import org.json.JSONObject;

import com.memorybox.slack.factory.SlackRTMConnectionFactory;
import com.memorybox.slack.factory.UtilityFactory;
import com.memorybox.slack.model.SlackObject;
import com.memorybox.slack.websocket.ISlackRTMConnection;

public class SlackObjectManager implements ISlackObjectManager {

	private SlackObjectManager() {
	};

	private static SlackObjectManager instance;

	public static SlackObjectManager getInstance() {
		if (instance == null) {
			instance = new SlackObjectManager();

		}
		return instance;
	}

	@Override
	public void process(SlackObject obj) throws Exception {

		SlackRTMConnectionFactory factory = SlackRTMConnectionFactory.getInstance();
		ISlackRTMConnection conObj = factory.getConnectionObject(obj);
		SlackRTMConnectionManager manager = SlackRTMConnectionManager.getInstance();
		manager.add(conObj);

	}

	@Override
	public SlackObject createOrUpdate(JSONObject accessObj, JSONObject userObj) throws JSONException {

		// TODO: Implement saveOrUpdate database functionality
		return UtilityFactory.getInstance().getSlackObjectFromAuthResponse(accessObj, userObj);
	}

}
