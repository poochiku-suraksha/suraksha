package com.poochiku.suraksha.model;

public class SurakshaTag
{

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDispName()
	{
		return dispName;
	}

	public void setDispName(String dispName)
	{
		this.dispName = dispName;
	}

	int type;
	String name;
	String dispName;
}
