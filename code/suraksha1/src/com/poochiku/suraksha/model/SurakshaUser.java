
package com.poochiku.suraksha.model;

import java.lang.reflect.Type;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.*;
import com.poochiku.suraksha.component.base.SurakshaEntity;
import com.poochiku.suraksha.component.helper.CommonUtil;

public class SurakshaUser extends SurakshaEntity implements ISurakshaEntity
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
	private String profileImgUrl;
	private boolean isProfileSearchAllowed;

	public boolean isProfileSearchAllowed()
	{
		return isProfileSearchAllowed;
	}

	public SurakshaUser setProfileSearchAllowed(boolean isProfileSearchAllowed)
	{
		this.isProfileSearchAllowed = isProfileSearchAllowed;
		return this;
	}

	public String getProfileImgUrl()

	{
		return profileImgUrl;
	}

	public SurakshaUser setProfileImgUrl(String profileImgUrl)
	{
		this.profileImgUrl = profileImgUrl;
		return this;
	}

	public String getProfileImgData()
	{
		return profileImgData;
	}

	public SurakshaUser setProfileImgData(String profileImgData)
	{
		this.profileImgData = profileImgData;
		return this;
	}

	private String profileImgData;

	public String getPassword()
	{
		return CommonUtil.decode(password);
	}

	public SurakshaUser setPassword(String password)
	{
		this.password = CommonUtil.encode(password);
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

	@Override
	public JSONObject toJSONObject()
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
	public ISurakshaEntity fromJSONObject(String json)
	{
		Type type = new TypeToken<SurakshaUser>()
		{
		}.getType();

		return new Gson().fromJson(json, type);

	}

	/**
	 * @optional field
	 */
}
