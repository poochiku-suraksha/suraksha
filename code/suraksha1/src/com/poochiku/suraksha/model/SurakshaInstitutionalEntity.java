package com.poochiku.suraksha.model;

import com.poochiku.suraksha.component.base.SurakshaEntity;

public class SurakshaInstitutionalEntity extends SurakshaEntity
{

	String name;
	String address;
	long latitude;
	long longitude;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public long getLatitude()
	{
		return latitude;
	}

	public void setLatitude(long latitude)
	{
		this.latitude = latitude;
	}

	public long getLongitude()
	{
		return longitude;
	}

	public void setLongitude(long longitude)
	{
		this.longitude = longitude;
	}
}
