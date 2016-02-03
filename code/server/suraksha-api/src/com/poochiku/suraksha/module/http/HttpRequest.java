package com.poochiku.suraksha.module.http;

import java.util.Map;

public class HttpRequest
{
	@Override
	public String toString()
	{
		return "SolutionRequest [headers=" + headers + ", params=" + params + ", method=" + method + ", url=" + url + ", getHeaders()=" + getHeaders() + ", getParams()=" + getParams() + ", getMethod()=" + getMethod() + ", getUrl()=" + getUrl() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public HttpRequest(Map<String, String> headers2, Map<String, String> params2, String method, String url)
	{
		super();
		this.headers = headers2;
		this.params = params2;
		this.method = method;
		this.url = url;
	}

	public Map<String, String> getHeaders()
	{
		return headers;
	}

	public void setHeaders(Map<String, String> headers)
	{
		this.headers = headers;
	}

	public Map<String, String> getParams()
	{
		return params;
	}

	public void setParams(Map<String, String> params)
	{
		this.params = params;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	private Map<String, String> headers;
	private Map<String, String> params;
	private String method;
	private String url;

}
