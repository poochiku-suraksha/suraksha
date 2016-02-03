package com.poochiku.suraksha.http;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.content.Entity;
import android.os.AsyncTask;
import android.util.Log;

import com.poochiku.suraksha.api.IResponseHandler;

public class HttpHandler
{

	private HashMap<String, String> headers;
	private HashMap<String, String> params;
	private String url;

	public HashMap<String, String> getHeaders()
	{
		return headers;
	}

	public HttpHandler setHeaders(HashMap<String, String> headers)
	{
		this.headers = headers;
		return this;
	}

	public HashMap<String, String> getParams()
	{
		return params;
	}

	public HttpHandler setParams(HashMap<String, String> params)
	{
		this.params = params;
		return this;
	}

	public String getUrl()
	{
		return url;
	}

	public HttpHandler setUrl(String url)
	{
		this.url = url;
		return this;
	}

	public void executeGet(IResponseHandler handler)
	{

	}

	@SuppressWarnings("unchecked")
	public void executePost(IResponseHandler handler)
	{

		@SuppressWarnings("rawtypes")
		AsyncTask task = new AsyncTask()
		{

			@Override
			protected Object doInBackground(Object... data)
			{

				HttpResponse response = null;
				try
				{

					HttpClient httpClient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(getUrl());
					List<NameValuePair> paramValuePair = new ArrayList<NameValuePair>();
					if (headers != null)
					{

						for (Map.Entry<String, String> header : headers.entrySet())
						{

							httpPost.setHeader(header.getKey(), header.getValue());
						}
					}
					if (params != null)
					{
						for (Map.Entry<String, String> entry : params.entrySet())
						{
							paramValuePair.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
						}

					}

					httpPost.setEntity(new UrlEncodedFormEntity(paramValuePair));
					response = httpClient.execute(httpPost);
					Log.d("Suraksha", response.getStatusLine().getStatusCode()+"");
					Log.d("Suraksha", EntityUtils.toString(response.getEntity()));

				}
				catch (Exception e)
				{
					e.printStackTrace();
				}

				return response.toString();
			}

			protected void onPostExecute(Object result)
			{
				String response = (String)result;
			};

		}.execute("");
	}

}
