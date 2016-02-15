package com.memorybox.slack.test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.json.JSONException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.memorybox.slack.websocket.SlackWebsocketClient;

public class SlackWSClientTest {

	public static void main(String[] args) throws IOException, UnirestException, JSONException {

		try {
			
			
			String token_url = "https://slack.com/api/rtm.start?token=xoxb-21536044725-pRJKVO1EaEsz71iC64mcEqjo";
			System.out.println("Token url :" + token_url);
			Unirest.setTimeouts(3000, 5000);
			HttpResponse<JsonNode> response = Unirest.post(token_url).header("content-type", "application/x-www-form-urlencoded").header("cache-control", "no-cache")
					.header("postman-token", "cfacf629-fa57-4a48-4566-4176e630daa2").asJson();
			String url = response.getBody().getObject().getString("url");
			URI ws = new URI(url);
			SlackWebsocketClient client = new SlackWebsocketClient(ws);
			//client.sendMessage("Teamchat");
			System.out.println("after send message");
			System.in.read();
			System.out.println("XXXXXXXX");
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
