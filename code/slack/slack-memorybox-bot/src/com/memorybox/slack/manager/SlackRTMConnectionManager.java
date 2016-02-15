package com.memorybox.slack.manager;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.memorybox.slack.websocket.ISlackRTMConnection;

public class SlackRTMConnectionManager implements ISlackRTMConnectionManager {

	//TODO : LaterImplementation will be to add connection objects into RMQ and
	// have subscriber to process it

	private List<ISlackRTMConnection> connections;

	private SlackRTMConnectionManager() {
	};

	private static SlackRTMConnectionManager instance;

	public static SlackRTMConnectionManager getInstance() {
		if (instance == null) {
			instance = new SlackRTMConnectionManager();
			instance.connections = new ArrayList<ISlackRTMConnection>();
		}
		return instance;
	}

	// add is also start
	@Override
	public void add(ISlackRTMConnection sc) throws Exception {

		System.out.println("Inside SlackRTMConnectionManager");
		
		instance.connections.add(sc);
		sc.connect();

	}

	@Override
	public void remove(ISlackRTMConnection sc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(ISlackRTMConnection sc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void retreive(JSONObject criteria) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean createAllConnections() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createAllWithStart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean startAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stopAll() {
		// TODO Auto-generated method stub
		return false;
	}

}
