/**
 * @author Madhusudhan Mahale
 */
package com.poochiku.suraksha.model;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.poochiku.suraksha.contract.ISurakshaEntity;

public class SurakshaUser extends SurakshaEntity implements ISurakshaEntity
{

	private String authType;
	private String firstName;
	private String lastName;
	private long dob;
	private String gender;
	private String password;
	private String email;
	private boolean isVerified;
	private boolean profileSearchEnabled;
	private SurakshaLocation currentLocation;

	public String getEmail()
	{
		return email;
	}

	public SurakshaLocation getCurrentLocation()
	{
		return currentLocation;
	}

	public void setCurrentLocation(SurakshaLocation currentLocation)
	{
		this.currentLocation = currentLocation;
	}

	public boolean isVerified()
	{
		return isVerified;
	}

	public void setVerified(boolean isVerified)
	{
		this.isVerified = isVerified;
	}

	public SurakshaUser setEmail(String email)
	{
		this.email = email;
		return this;
	}

	public String getAuthType()
	{
		return authType;
	}

	public SurakshaUser setAuthType(String authType)
	{
		this.authType = authType;
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

	public String getPassword()
	{
		return password;
	}

	public SurakshaUser setPassword(String password)
	{
		this.password = password;
		return this;
	}

	public boolean isProfileSearchEnabled()
	{
		return profileSearchEnabled;
	}

	public SurakshaUser setProfileSearchEnabled(boolean profileSearchEnabled)
	{
		this.profileSearchEnabled = profileSearchEnabled;
		return this;
	}

	@Override
	public JSONObject toJson()
	{

		Gson gson = new Gson();
		try
		{
			return new JSONObject(gson.toJson(this));
		}
		catch (JSONException e)
		{
			return null;
		}

	}

	@Override
	public ISurakshaEntity fromJson(String json)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
