package com.poochiku.suraksha.model;

public class SurakshaLocation
{

	private long latitude;
	private long longitude;
	private long updateTime;

	public long getLatitude()
	{
		return latitude;
	}

	public SurakshaLocation setLatitude(long latitude)
	{
		this.latitude = latitude;
		return this;
	}

	public long getLongitude()
	{
		return longitude;
	}

	public SurakshaLocation setLongitude(long longitude)
	{
		this.longitude = longitude;
		return this;
	}

	public long getUpdateTime()
	{
		return updateTime;
	}

	public SurakshaLocation setUpdateTime(long updateTime)
	{
		this.updateTime = updateTime;
		return this;
	}
}
