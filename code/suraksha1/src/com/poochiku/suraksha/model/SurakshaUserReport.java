package com.poochiku.suraksha.model;

import java.lang.reflect.Type;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SurakshaUserReport implements ISurakshaEntity
{

	private String reportId;
	private SurakshaUser surakshaUser;
	private long latitude;
	private long longitude;
	private String comment;
	private SurakshaCategory surakshaCategory;
	private String description;
	private JSONArray fileIds;
	private long createdDatetime;

	public long getDateTime()
	{
		return createdDatetime;
	}

	public SurakshaUserReport setDateTime(long dateTime)
	{
		this.createdDatetime = dateTime;
		return this;
	}

	public JSONArray getFileIds()
	{
		return fileIds;
	}

	public SurakshaUserReport setFileIds(JSONArray fileIds)
	{
		this.fileIds = fileIds;
		return this;
	}

	public String getReportId()
	{
		return reportId;
	}

	public SurakshaUserReport setReportId(String reportId)
	{
		this.reportId = reportId;
		return this;
	}

	public SurakshaUser getSurakshaUser()
	{
		return surakshaUser;
	}

	public SurakshaUserReport setSurakshaUser(SurakshaUser surakshaUser)
	{
		this.surakshaUser = surakshaUser;
		return this;

	}

	public long getLatitude()
	{
		return latitude;
	}

	public SurakshaUserReport setLatitude(long latitude)
	{
		this.latitude = latitude;
		return this;
	}

	public long getLongitude()
	{
		return longitude;
	}

	public SurakshaUserReport setLongitude(long longitude)
	{
		this.longitude = longitude;
		return this;
	}

	public String getComment()
	{
		return comment;
	}

	public SurakshaUserReport setComment(String comment)
	{
		this.comment = comment;
		return this;
	}

	public SurakshaCategory getCategory()
	{
		return surakshaCategory;
	}

	public SurakshaUserReport setCategory(SurakshaCategory category)
	{
		this.surakshaCategory = category;
		return this;
	}

	public String getDescription()
	{
		return description;
	}

	public SurakshaUserReport setDescription(String description)
	{
		this.description = description;
		return this;
	}

	public SurakshaTag getTag()
	{
		return surakshaTag;
	}

	public SurakshaUserReport setTag(SurakshaTag tag)
	{
		this.surakshaTag = tag;
		return this;
	}

	



	private SurakshaTag surakshaTag;


	@Override
	public JSONObject toJSONObject()
	{
		Gson gson = new Gson();
		try
		{
			return new JSONObject(gson.toJson(this));
		} catch (JSONException e)
		{
			return null;
		}

	}

	@Override
	public ISurakshaEntity fromJSONObject(String json)
	{
		Type type = new TypeToken<SurakshaUser>()
		{
		}.getType();

		return new Gson().fromJson(json, type);

	}

}
