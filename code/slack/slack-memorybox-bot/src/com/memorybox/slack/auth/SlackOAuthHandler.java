package com.memorybox.slack.auth;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.http.auth.AUTH;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.memorybox.slack.constant.Constant_Auth;

@Path("/auth")
public class SlackOAuthHandler
{

	private HashMap<String, JSONObject> authorizedUserMap = new HashMap<String, JSONObject>();

	@GET
	@Path("/slack")
	public Response authenticateSlack(@QueryParam("code") String code, @QueryParam("state") String state) throws JSONException
	{

		String access_token_body = "client_id=" + Constant_Auth.CLIENT_ID + "&client_secret=" + Constant_Auth.CLIENT_SECRET + "&code=" + code;

		try
		{
			// oauth.access call
			HttpResponse<JsonNode> response1 = Unirest.post("https://slack.com/api/oauth.access").header("cache-control", "no-cache").header("postman-token", "c207fe41-f818-2d0c-e9c9-2df4f72967de").header("content-type", "application/x-www-form-urlencoded").body(access_token_body).asJson();
			JSONObject accessdata = response1.getBody().getObject();
			String token = accessdata.getString("access_token");

			// auth.test
			HttpResponse<JsonNode> response2 = Unirest.post("https://slack.com/api/auth.test").header("cache-control", "no-cache").header("postman-token", "8fde8d56-5dba-fa69-6c1e-81c34bf24e78").header("content-type", "application/x-www-form-urlencoded").body("token=" + token).asJson();
			JSONObject userdata = response2.getBody().getObject();
			store(accessdata, userdata);

		} catch (UnirestException e)
		{
			e.printStackTrace();
		}

		return Response.ok("Congratulations !!!! Memory box Application is installed	.").build();

	}

	private void store(JSONObject access_data, JSONObject userd_data) throws JSONException
	{
		String userId = userd_data.getString("user_id");
		authorizedUserMap.put(userId, access_data);

	}

}
