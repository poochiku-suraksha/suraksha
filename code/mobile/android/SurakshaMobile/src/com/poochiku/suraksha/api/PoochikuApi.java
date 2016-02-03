package com.poochiku.suraksha.api;

import java.util.HashMap;

import org.json.JSONObject;

import android.content.Context;

import com.google.gson.Gson;
import com.poochiku.suraksha.http.HttpHandler;
import com.poochiku.suraksha.mobile.R;
import com.poochiku.suraksha.model.SurakshaUser;


public class PoochikuApi
{

	Gson gson;

	public PoochikuApi()
	{
		gson = new Gson();
	}

	public void createuser(SurakshaUser user, Context ctx, ISurakshaResponseHandler handler)
	{
		String url = ctx.getString(R.string.createUser);
		HttpHandler http = new HttpHandler();
		http.setUrl(url);
		HashMap<String, String> params = new HashMap();
		params.put("firstName", user.getFirstName());
		params.put("lastName", user.getLastName());
		params.put("gender", user.getGender());
		params.put("phoneNumber", user.getPhoneNumber());
		params.put("dob", String.valueOf(user.getDob()));
		params.put("password", user.getPassword());
		params.put("email", user.getEmail());
		
		http.setParams(params);

		http.executePost(new IResponseHandler()
		{
			
			@Override
			public void onSuccess(JSONObject obj)
			{
				// TODO Auto-generated method stub
				
			}
		});

	}

}
