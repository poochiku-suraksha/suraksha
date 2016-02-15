/**
 * @author madhusudhanmahale
 * @copyrights 2016 poochiku.com
 */
package com.memorybox.slack.model;

/**
 * @author madhusudhanmahale
 */
public class SlackObject {

	private String uid;
	private String channel;
	private String channel_id;
	private String team_name;
	private String team_id;
	private String scope;

	public SlackBot getBot() {
		return bot;
	}

	public void setBot(SlackBot bot) {
		this.bot = bot;
	}

	public SlackUser getUser() {
		return user;
	}

	public void setUser(SlackUser user) {
		this.user = user;
	}

	private String configuration_url;
	private String wsUrl;
	private SlackBot bot;
	private SlackUser user;

	public String getWsUrl() {
		return wsUrl;
	}

	public void setWsUrl(String wsUrl) {
		this.wsUrl = wsUrl;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getConfiguration_url() {
		return configuration_url;
	}

	public void setConfiguration_url(String configuration_url) {
		this.configuration_url = configuration_url;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String access_token;
	private String url;

}
