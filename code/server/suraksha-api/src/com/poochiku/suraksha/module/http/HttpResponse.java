package com.poochiku.suraksha.module.http;

import org.json.JSONArray;
import org.json.JSONObject;

public class HttpResponse
{

	@Override
	public String toString()
	{
		return "HttpResponse [isSuccess=" + isSuccess + ", httpStatusCode=" + httpStatusCode + ", errorObject=" + errorObject + ", errorMessage=" + errorMessage + ", dataObject=" + dataObject + ", dataArray=" + dataArray + "]";
	}

	private boolean isSuccess;
	private int httpStatusCode;
	private JSONObject errorObject;
	private String errorMessage;
	private JSONObject dataObject;
	private String dataMessage;
	
	
	public String getDataMessage()
	{
		return dataMessage;
	}

	public HttpResponse setDataMessage(String dataMessage)
	{
		this.dataMessage = dataMessage;
		return this;
	}

	private JSONArray dataArray;
	
	public JSONObject getResponseData()
	{
		return responseData;
	}

	public HttpResponse setResponseData(JSONObject responseData)
	{
		this.responseData = responseData;
		return this;
	}

	private JSONObject responseData;

	public boolean isSuccess()
	{
		return isSuccess;
	}

	public HttpResponse setSuccess(boolean isSuccess)
	{
		this.isSuccess = isSuccess;
		return this;
	}

	public int getHttpStatusCode()
	{
		return httpStatusCode;
	}

	public HttpResponse setHttpStatusCode(int httpStatusCode)
	{
		this.httpStatusCode = httpStatusCode;
		return this;
	}

	public JSONObject getErrorObject()
	{
		return errorObject;
	}

	public HttpResponse setErrorObject(JSONObject errorObject)
	{
		this.errorObject = errorObject;
		return this;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public HttpResponse setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
		return this;
	}

	public JSONObject getDataObject()
	{
		return dataObject;
	}

	public HttpResponse setDataObject(JSONObject dataObject)
	{
		this.dataObject = dataObject;
		return this;
	}

	public JSONArray getDataArray()
	{
		return dataArray;
	}

	public HttpResponse setDataArray(JSONArray dataArray)
	{
		this.dataArray = dataArray;
		return this;
	}

}
