package com.memorybox.slack.test;

import java.io.IOException;

import com.memorybox.slack.websocket.SlackWSClient;

public class SlackWSClientTest
{

	public static void main(String [] args) throws IOException
	{
		 SlackWSClient sWScl = new SlackWSClient();
		 sWScl.connect();
		 System.in.read();
	}
}
