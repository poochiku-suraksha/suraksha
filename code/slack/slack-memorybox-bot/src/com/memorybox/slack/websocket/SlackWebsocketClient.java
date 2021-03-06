package com.memorybox.slack.websocket;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class SlackWebsocketClient {

	Session userSession = null;
	private MessageHandler messageHandler;

	public SlackWebsocketClient(URI endpointURI) {
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			container.connectToServer(this, endpointURI);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@OnOpen
	public void onOpen(Session userSession) {
		this.userSession = userSession;
		System.out.println("Session onOpen :");
	}

	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		this.userSession = null;
		System.out.println("Session onClose !!!!!" + reason );
	}
	
	
	@OnError
	public void OnError(Session session, Throwable t)
	{
		System.out.println("Session OnError -" + t.getMessage() );
	}

	@OnMessage
	public void onMessage(String message) {
		System.out.println("Message :" +message);

	}

	public void addMessageHandler(MessageHandler msgHandler) {
		this.messageHandler = msgHandler;
	}

	public void sendMessage(String message) {
		this.userSession.getAsyncRemote().sendText(message);
	}

	public static interface MessageHandler {
		public void handleMessage(String message);
	}
}
