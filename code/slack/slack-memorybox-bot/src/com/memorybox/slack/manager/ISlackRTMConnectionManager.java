package com.memorybox.slack.manager;

import org.json.JSONObject;

import com.memorybox.slack.websocket.ISlackRTMConnection;

public interface ISlackRTMConnectionManager {

	void add(ISlackRTMConnection sc) throws Exception;

	void remove(ISlackRTMConnection sc);

	void save(ISlackRTMConnection sc);

	void retreive(JSONObject criteria);

	boolean createAllConnections();

	boolean createAllWithStart();

	boolean startAll();

	boolean stopAll();
}
