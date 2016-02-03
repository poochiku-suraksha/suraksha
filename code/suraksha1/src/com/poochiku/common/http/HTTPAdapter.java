/**
 * @author Madhusudhan
 */
package com.poochiku.common.http;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;


public class HTTPAdapter extends HttpRequest
{

	public HTTPAdapter(Map<String, Object> headers, Map<String, Object> params, String method, String url)
	{
		super(headers, params, method, url);

	}
	public void execute(HttpResponseHandler handler)
	{
		if (this.getMethod().equals(KONSTANTS.HTTP.METHOD_POST))
		{
			executePost(handler);
		}
		else
		{
			executeGet(handler);
		}
	}
	public String execute() throws Exception
	{
		if (this.getMethod().equals(KONSTANTS.HTTP.METHOD_POST))
		{
			return executePost();
		}
		else
		{
			return executeGet();
		}
		
	}

	private void executeGet(HttpResponseHandler handler)
	{
		GetMethod method = null;
		try
		{

			String url = this.getUrl();
			HttpClient client = new HttpClient();

			QueryString qs = new QueryString();

			if (this.getParams() != null)
			{
				for (Entry<String, Object> entry : this.getParams().entrySet())
				{
					qs.add((String) entry.getKey(), (String) entry.getValue());
				}
			}
			url = url + qs;
			method = new GetMethod(url);
			if (this.getHeaders() != null)
			{
				for (Entry<String, Object> entry : this.getHeaders().entrySet())
				{

					method.setRequestHeader((String) entry.getKey(), (String) entry.getValue());
				}
			}
			int statusCode = client.executeMethod(method);
			if (statusCode != HttpStatus.SC_ACCEPTED && statusCode!= HttpStatus.SC_OK)
			{
				System.err.println("Method failed: " + method.getStatusLine());
			}

			// Read the response body.
			byte[] responseBody = method.getResponseBody();

			// Deal with the response.
			// Use caution: ensure correct character encoding and is not binary
			// data
			String response = new String(responseBody);
			handler.onSuccess(response);

		}
		catch (Exception ex)
		{
			handler.onError(ex.getMessage());
		}
		finally
		{
			// Release the connection.
			if (method != null)
			{
				method.releaseConnection();
			}

		}
	}

	private void executePost(HttpResponseHandler handler)
	{

		PostMethod method = null;
		try
		{
			String url = this.getUrl();
			HttpClient client = new HttpClient();
			method = new PostMethod(url);
			
			method.setRequestHeader("Accept-Charset", "UTF-8");
			method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
			//method.setRequestHeader("charset", "UTF-8");
			
			if (this.getParams() != null)
			{
				
				for (Entry<String, Object> entry : this.getParams().entrySet())
				{
					method.addParameter(entry.getKey(), (String) entry.getValue());
					
				}
			}
			if (this.getHeaders() != null)
			{
				for (Entry<String, Object> entry : this.getHeaders().entrySet())
				{
					method.setRequestHeader(entry.getKey(), (String) entry.getValue());
				}
			}
			int statusCode = client.executeMethod(method);
			if (statusCode != HttpStatus.SC_ACCEPTED && statusCode!= HttpStatus.SC_OK && statusCode!= HttpStatus.SC_CREATED )
			{
				System.err.println("Method failed: " + method.getStatusLine() + "Error Resposne Body " + 	method.getResponseBodyAsString());
				
			
				
				handler.onError(method.getStatusLine().toString());
				
				
				
			}
			else
			{
				byte[] responseBody = method.getResponseBody();

				// Deal with the response.
				// Use caution: ensure correct character encoding and is not
				// binary
				// data
				String response = new String(responseBody);
				handler.onSuccess(response);
			}

		}
		catch (Exception ex)
		{
			handler.onError(ex.getMessage());
		}
		finally
		{
			// Release the connection.
			if (method != null)
			{
				method.releaseConnection();
			}

		}
	}

	/**
	 * Without Handlers
	 * @throws Exception
	 */

	private String executeGet() throws Exception
	{
		GetMethod method = null;
		try
		{

			String url = this.getUrl();
			HttpClient client = new HttpClient();

			QueryString qs = new QueryString();
			if (this.getParams() != null)
			{
				for (Entry<String, Object> entry : this.getParams().entrySet())
				{
					qs.add((String) entry.getKey(), (String) entry.getValue());
				}
			}
			url = url + qs;
			method = new GetMethod(url);
			if (this.getHeaders() != null)
			{
				for (Entry<String, Object> entry : this.getHeaders().entrySet())
				{

					method.setRequestHeader((String) entry.getKey(), (String) entry.getValue());
				}
			}

			int statusCode = client.executeMethod(method);
			if (statusCode != HttpStatus.SC_ACCEPTED && statusCode!= HttpStatus.SC_OK)
			{
				System.err.println("Method failed: " + method.getStatusLine());
			}

			// Read the response body.
			byte[] responseBody = method.getResponseBody();

			// Deal with the response.
			// Use caution: ensure correct character encoding and is not binary
			// data
			String response = new String(responseBody);
			return response;

		}
		catch (Exception ex)
		{
			throw ex;
		}
		finally
		{
			// Release the connection.
			if (method != null)
			{
				method.releaseConnection();
			}

		}
	}

	private String executePost() throws Exception
	{

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
				for (Entry<String, Object> entry : this.getParams().entrySet())
				{
					method.addParameter(entry.getKey(), (String) entry.getValue());
				}
			}
			if (this.getHeaders() != null)
			{
				for (Entry<String, Object> entry : this.getHeaders().entrySet())
				{
					method.setRequestHeader(entry.getKey(), (String) entry.getValue());
				}
			}

			int statusCode = client.executeMethod(method);
			if (statusCode != HttpStatus.SC_ACCEPTED && statusCode!= HttpStatus.SC_OK)
			{
				System.err.println("Method failed: " + method.getStatusLine());
				throw new Exception(method.getStatusLine().toString());
			}
			else
			{
				byte[] responseBody = method.getResponseBody();

				// Deal with the response.
				// Use caution: ensure correct character encoding and is not
				// binary
				// data
				String response = new String(responseBody);
				return response;
			}

		}
		catch (Exception ex)
		{
			throw ex;
		}
		finally
		{
			// Release the connection.
			if (method != null)
			{
				method.releaseConnection();
			}

		}
	}

}
