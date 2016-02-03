package com.poochiku.suraksha.model;

import com.poochiku.suraksha.contract.ISurakshaEntity;

public class SurakshaUser  implements ISurakshaEntity
{

	/**
	 * @required fields
	 */

	private String firstName;
	private String lastName;
	private long dob;
	private String gender;
	private String email;
	private String phoneNumber;
	private String surakshaId;
	private String password;

	public String getPassword()
	{
		return password;
	}

	public SurakshaUser setPassword(String password)
	{
		this.password = password;
		return this;
	}

	boolean isPhoneVerified;

	public boolean isPhoneVerified()
	{
		return isPhoneVerified;
	}

	public SurakshaUser setPhoneVerified(boolean isPhoneVerified)
	{
		this.isPhoneVerified = isPhoneVerified;
		return this;
	}

	public String getSurakshaId()
	{
		return surakshaId;
	}

	public SurakshaUser setSurakshaId(String surakshaId)
	{
		this.surakshaId = surakshaId;
		return this;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public SurakshaUser setFirstName(String firstName)
	{
		this.firstName = firstName;
		return this;
	}

	public String getLastName()
	{
		return lastName;
	}

	public SurakshaUser setLastName(String lastName)
	{
		this.lastName = lastName;
		return this;
	}

	public long getDob()
	{
		return dob;
	}

	public SurakshaUser setDob(long dob)
	{
		this.dob = dob;
		return this;

	}

	public String getGender()
	{
		return gender;
	}

	public SurakshaUser setGender(String gender)
	{
		this.gender = gender;
		return this;
	}

	public String getEmail()
	{
		return email;
	}

	public SurakshaUser setEmail(String email)
	{
		this.email = email;
		return this;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public SurakshaUser setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
		return this;
	}

	
}
