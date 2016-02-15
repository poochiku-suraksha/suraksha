/**
 * @author madhusudhanmahale
 */
package com.memorybox.slack.websocket;

public interface ISlackRTMConnection {
	
	ISlackRTMConnection handshake() throws Exception;

	boolean isConnected();

	boolean isAvailable();

	void connect() throws Exception;

	boolean suspend();

	boolean terminate();

	ISlackRTMConnection restart();
	
	void sendMessageToSlack(String message);

}
