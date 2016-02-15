package com.memorybox.slack.factory;

import com.memorybox.slack.model.SlackObject;
import com.memorybox.slack.websocket.ISlackRTMConnection;
import com.memorybox.slack.websocket.SlackRTMConnection;

public class SlackRTMConnectionFactory {

	private SlackRTMConnectionFactory() {
	};

	private static SlackRTMConnectionFactory instance;

	public static SlackRTMConnectionFactory getInstance() {
		if (instance == null) {
			instance = new SlackRTMConnectionFactory();

		}
		return instance;
	}

	public ISlackRTMConnection getConnectionObject(SlackObject slackObject) {
		
		ISlackRTMConnection connection = new SlackRTMConnection(slackObject);
		
		//TODO : Implement this
		
		//1. check if there is this connection already in connection bus 
		//2. if exists  , return same 
		//3. 
		return connection;

	}

}
