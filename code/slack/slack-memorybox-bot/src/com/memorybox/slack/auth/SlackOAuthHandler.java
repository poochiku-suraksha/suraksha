package com.memorybox.slack.auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.memorybox.slack.constant.Constant_Auth;
import com.memorybox.slack.manager.SlackObjectManager;
import com.memorybox.slack.model.SlackObject;

@Path("/auth")
public class SlackOAuthHandler {

	@GET
	@Path("/slack")
	public Response authenticateSlack(@QueryParam("code") String code, @QueryParam("state") String state) throws JSONException {

		JSONObject accessJO = null;
		JSONObject userJO = null;
		

		try {
			accessJO = getAccessToken(code);
			String token = accessJO.getString("access_token");
			userJO = getUser(token);
		} catch (Exception ex) {
			
			return Response.serverError().status(500).entity(ex.getMessage()).build();
		}

		try {

			sendToObjectManger(accessJO, userJO);

		} catch (Exception e) {

			System.out.println("Error to start the connection : solve this" + e.getMessage());
		}

		return Response.ok("Congratulations !!!! Memory box Application is installed	.").build();

	}

	private void sendToObjectManger(JSONObject access_data, JSONObject user_data) throws Exception {
		
		System.out.println(access_data);

		SlackObjectManager slackObjectMng = SlackObjectManager.getInstance();
		SlackObject sObj = slackObjectMng.createOrUpdate(access_data, user_data);
		slackObjectMng.process(sObj);

	}

	// oauth.access
	private JSONObject getAccessToken(String code) throws UnirestException, JSONException {
		String access_token_body = "client_id=" + Constant_Auth.CLIENT_ID + "&client_secret=" + Constant_Auth.CLIENT_SECRET + "&code=" + code;
		HttpResponse<JsonNode> response1 = Unirest.post("https://slack.com/api/oauth.access").header("cache-control", "no-cache").header("postman-token", "c207fe41-f818-2d0c-e9c9-2df4f72967de")
				.header("content-type", "application/x-www-form-urlencoded").body(access_token_body).asJson();
		JSONObject accessdata = response1.getBody().getObject();
		System.out.println("Slack accessdata after authentication = " + accessdata);
		return accessdata;
	}

	// auth.test
	private JSONObject getUser(String token) throws UnirestException {
		HttpResponse<JsonNode> response2 = Unirest.post("https://slack.com/api/auth.test").header("cache-control", "no-cache").header("postman-token", "8fde8d56-5dba-fa69-6c1e-81c34bf24e78")
				.header("content-type", "application/x-www-form-urlencoded").body("token=" + token).asJson();
		JSONObject userdata = response2.getBody().getObject();
		return userdata;
	}

}
