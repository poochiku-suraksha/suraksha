package com.memorybox.slack.websocket;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.MessageHandler;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.memorybox.slack.constant.Constant_Auth;

@ClientEndpoint
public class SlackWSClient
{

	Session userSession = null;

	public void connect()
	{
		slackClient(getWebscoketUrl());
	}



	private void slackClient(URI endpointURI)
	{
		try
		{
			System.out.println(endpointURI.toString());
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			container.connectToServer(this, endpointURI);
		} 
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@OnOpen
	public void onOpen(Session userSession)
	{
		System.out.println("opening websocket");
		this.userSession = userSession;
	}

	@OnClose
	public void onClose(Session userSession, CloseReason reason)
	{
		System.out.println("closing websocket");
		this.userSession = null;
	}

	
	@OnMessage
	public void onMessage(String message)
	{
		System.out.println("on message :" + message);
	}

	private URI getWebscoketUrl()
	{
		try
		{
			HttpResponse<JsonNode> response = Unirest.post("https://slack.com/api/rtm.start?token=" + Constant_Auth.GUPSHUP_TOKEN).header("content-type", "application/json").header("cache-control", "no-cache").header("postman-token", "13cf7227-bf6c-3f02-0781-87f5a8f654b7").asJson();
			String url = response.getBody().getObject().getString("url");
			return new URI(url);

		} catch (Exception e)
		{
			return null;
		}

	}
}
