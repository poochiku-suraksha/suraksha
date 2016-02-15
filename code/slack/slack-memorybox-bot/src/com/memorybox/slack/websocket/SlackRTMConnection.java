/**
 * @author madhusudhanmahale
 */
package com.memorybox.slack.websocket;

import java.net.URI;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.memorybox.slack.base.MemoryBase;
import com.memorybox.slack.model.SlackObject;

public class SlackRTMConnection extends MemoryBase implements ISlackRTMConnection {

	private SlackObject slackObj;
	private String sConnectionId;
	SlackWebsocketClient client;

	public SlackRTMConnection(SlackObject slackObj) {

		this.slackObj = slackObj;
	}

	@Override
	public boolean isConnected() {

		if (client == null)
			return false;
		return true;

	}

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void connect() throws Exception {

		System.out.println("Inside ISlackRTMConnection :: connect()");

		if (isConnected())
			return;

		handshake();
		System.out.println(slackObj.getWsUrl());
		//client = new SlackWebsocketClient(new URI(slackObj.getWsUrl()));
		//client.sendMessage("hello-madhu");

	}

	@Override
	public boolean suspend() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean terminate() {

		return false;
	}

	@Override
	public ISlackRTMConnection restart() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ISlackRTMConnection handshake() throws Exception {
		System.out.println("Inside ISlackRTMConnection : handshake");
		String token_url = "https://slack.com/api/rtm.start?token=" + slackObj.getBot().getBot_access_token();
		System.out.println("Token url :" + token_url);
		Unirest.setTimeouts(3000, 5000);
		HttpResponse<JsonNode> response = Unirest.post(token_url).header("content-type", "application/x-www-form-urlencoded").header("cache-control", "no-cache")
				.header("postman-token", "cfacf629-fa57-4a48-4566-4176e630daa2").asJson();
		String url = response.getBody().getObject().getString("url");
		slackObj.setWsUrl(url);
		return this;
	}

	@Override
	public void sendMessageToSlack(String message) {
		// TODO Auto-generated method stub

	}

}
