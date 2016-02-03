/**
 * @author Madhusudhan
 */
package com.poochiku.suraksha.module.http;

import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONObject;

public class HTTPAdapter extends HttpRequest
{

	public HTTPAdapter(Map<String, String> headers, Map<String, String> params, String method, String url)
	{
		super(headers, params, method, url);

	}

	//
	// public void execute()
	// {
	// if (this.getMethod().equals(HTTP_CONSTANTS.METHOD_POST))
	// {
	// executePost();
	// }
	// else
	// {
	// //executeGet();
	// }
	// }
	//
	// public String executeHandler() throws Exception
	// {
	// if (this.getMethod().equals(HTTP_CONSTANTS.METHOD_POST))
	// {
	// return executePost();
	// }
	// else
	// {
	// //sreturn executeGet();
	// }
	//
	// }
	//
	// // private String executeGet()
	// // {
	// // GetMethod method = null;
	// // try
	// // {
	// //
	// // String url = this.getUrl();
	// // HttpClient client = new HttpClient();
	// //
	// // QueryString qs = new QueryString();
	// //
	// // if (this.getParams() != null)
	// // {
	// // for (Entry<String, String> entry : this.getParams().entrySet())
	// // {
	// // qs.add((String) entry.getKey(), (String) entry.getValue());
	// // }
	// // }
	// // url = url + qs;
	// // method = new GetMethod(url);
	// // if (this.getHeaders() != null)
	// // {
	// // for (Entry<String, String> entry : this.getHeaders().entrySet())
	// // {
	// //
	// // method.setRequestHeader((String) entry.getKey(), (String) entry.getValue());
	// // }
	// // }
	// // int statusCode = client.executeMethod(method);
	// // if (statusCode != HttpStatus.SC_ACCEPTED && statusCode != HttpStatus.SC_OK)
	// // {
	// // System.err.println("Method failed: " + method.getStatusLine());
	// // }
	// //
	// // // Read the response body.
	// // byte[] responseBody = method.getResponseBody();
	// //
	// // // Deal with the response.
	// // // Use caution: ensure correct character encoding and is not binary
	// // // data
	// // String response = new String(responseBody);
	// // return response;
	// //
	// // }
	// // catch (Exception ex)
	// // {
	// //
	// // }
	// // finally
	// // {
	// // // Release the connection.
	// // if (method != null)
	// // {
	// // method.releaseConnection();
	// // }
	// //
	// // }
	// // }
	//
	// private String executePost()
	// {
	//
	// PostMethod method = null;
	// try
	// {
	// String url = this.getUrl();
	// HttpClient client = new HttpClient();
	// method = new PostMethod(url);
	// JSONObject response = null;
	//
	// method.setRequestHeader("Accept-Charset", "UTF-8");
	// method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
	// //method.setRequestHeader("charset", "UTF-8");
	//
	// if (this.getParams() != null)
	// {
	//
	// for (Entry<String, String> entry : this.getParams().entrySet())
	// {
	// method.addParameter(entry.getKey(), (String) entry.getValue());
	//
	// }
	// }
	// if (this.getHeaders() != null)
	// {
	// for (Entry<String, String> entry : this.getHeaders().entrySet())
	// {
	// method.setRequestHeader(entry.getKey(), (String) entry.getValue());
	// }
	// }
	// int statusCode = client.executeMethod(method);
	// if (statusCode != HttpStatus.SC_ACCEPTED && statusCode!= HttpStatus.SC_OK && statusCode!= HttpStatus.SC_CREATED )
	// {
	// System.err.println("Method failed: " + method.getStatusLine() + "Error Resposne Body " + method.getResponseBodyAsString());
	//
	// response.put("status", "failed");
	// response.put("error", method.getStatusLine().toString())
	//
	//
	// return response.toString();
	//
	//
	//
	// }
	// else
	// {
	// byte[] responseBody = method.getResponseBody();
	//
	// // Deal with the response.
	// // Use caution: ensure correct character encoding and is not
	// // binary
	// // data
	// String res1 = new String(responseBody);
	//
	// return res1;
	// }
	//
	// }
	// catch (Exception ex)
	// {
	// res1.put("error", ex.getMessage());
	// }
	// finally
	// {
	// // Release the connection.
	// if (method != null)
	// {
	// method.releaseConnection();
	// }
	//
	// }
	// }
	//
	public HttpResponse post()
	{

		HttpResponse httpResponse = new HttpResponse();
		int statusCode = 0;
		JSONObject response = new JSONObject();
		PostMethod method = null;
		try
		{

			String url = this.getUrl();
			HttpClient client = new HttpClient();
			method = new PostMethod(url);
			method.setRequestHeader("Accept-Charset", "UTF-8");
			method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");

			if (this.getParams() != null)
			{

				for (Entry<String, String> entry : this.getParams().entrySet())
				{
					if (entry.getValue() != null)
					{
						method.addParameter(entry.getKey(), (String) entry.getValue());
					}

				}

				method.addParameter("seqId", UUID.randomUUID() + "");
			}
			if (this.getHeaders() != null)
			{
				for (Entry<String, String> entry : this.getHeaders().entrySet())
				{
					if (entry.getValue() != null)
					{
						method.setRequestHeader(entry.getKey(), (String) entry.getValue());
					}
				}
			}

			statusCode = client.executeMethod(method);
			httpResponse.setHttpStatusCode(statusCode);

			if (statusCode != HttpStatus.SC_ACCEPTED && statusCode != HttpStatus.SC_OK && statusCode != HttpStatus.SC_CREATED)
			{
				System.err.println("Method failed: " + method.getStatusLine() + "Error Resposne Body " + method.getResponseBodyAsString());
				response.put("status", "failed");
				response.put("error", method.getStatusLine().toString());
				httpResponse.setSuccess(false);

				httpResponse.setErrorObject(response);
				byte[] responseBody = method.getResponseBody();
				try
				{
					response = new JSONObject(new String(responseBody));
					httpResponse.setErrorMessage(response.toString());
				}
				catch (Exception ex)
				{
					httpResponse.setErrorMessage(method.getStatusLine().toString());
				}

			}
			else
			{
				byte[] responseBody = method.getResponseBody();
				String res1 = new String(responseBody);
				try
				{
					response = new JSONObject(res1);
					httpResponse.setDataObject(response);
				}
				catch (Exception ex)
				{
					httpResponse.setDataMessage(res1);
				}

				httpResponse.setSuccess(true);

			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		finally
		{

			method.releaseConnection();
		}

		return httpResponse;

	}

	public HttpResponse get()
	{
		return null;

	}

	public HttpResponse put()
	{

		return post();
	}
}
