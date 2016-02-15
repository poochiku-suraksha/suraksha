/**
 * @author madhusudhanmahale
 */
package com.memorybox.slack.model;

public class SlackBot {

	private String bot_user_id;
	private String bot_access_token;

	public String getBot_user_id() {
		return bot_user_id;
	}

	public void setBot_user_id(String bot_user_id) {
		this.bot_user_id = bot_user_id;
	}

	public String getBot_access_token() {
		return bot_access_token;
	}

	public void setBot_access_token(String bot_access_token) {
		this.bot_access_token = bot_access_token;
	}

}
