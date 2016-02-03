/**
 * @author Madhusudhan Mahale
 */
package com.poochiku.suraksha.model;

public class SurakshaEntity
{
	private String surakshaId;
	private String surakshaType;
	private SurakshaLocation surakshaBaseLocation;
	private SurakshaLocation surakshaCurrentLocation;
	private int surakshaSecuredFactor;
	private String profileImgUrlThumb;
	private String profileImgUrl;
	private Phone phone;
	public Phone getPhone()
	{
		return phone;
	}

	public SurakshaEntity  setPhone(Phone phone)
	{
		this.phone = phone;
		return this;
	}

	public Phone getSecondaryPhone()
	{
		return secondaryPhone;
	}

	public SurakshaEntity setSecondaryPhone(Phone secondaryPhone)
	{
		this.secondaryPhone = secondaryPhone;
		return this;
	}

	private Phone secondaryPhone;
	private Address primaryAddress;
	private long createdTime;

	public long getCreatedTime()
	{
		return createdTime;
	}

	public SurakshaEntity setCreatedTime(long createdTime)
	{
		this.createdTime = createdTime;
		return this;
	}

	public String getProfileImgUrl()
	{
		return profileImgUrl;
	}

	public SurakshaEntity setProfileImgUrl(String profileImgUrl)
	{
		this.profileImgUrl = profileImgUrl;
		return this;
	}

	public String getProfileImgUrlThumb()
	{
		return profileImgUrlThumb;
	}

	public SurakshaEntity setProfileImgUrlThumb(String profileImgUrlThumb)
	{
		this.profileImgUrlThumb = profileImgUrlThumb;
		return this;
	}

	

	public Address getPrimaryAddress()
	{
		return primaryAddress;
	}

	public SurakshaEntity setPrimaryAddress(Address primaryAddress)
	{
		this.primaryAddress = primaryAddress;
		return this;
	}

	public String getSurakshaId()
	{
		return surakshaId;
	}

	public SurakshaEntity setSurakshaId(String surakshaId)
	{
		this.surakshaId = surakshaId;
		return this;
	}

	public String getSurakshaType()
	{
		return surakshaType;
	}

	public SurakshaEntity setSurakshaType(String surakshaType)
	{
		this.surakshaType = surakshaType;
		return this;
	}

	public SurakshaLocation getSurakshaBaseLocation()
	{
		return surakshaBaseLocation;
	}

	public SurakshaEntity setSurakshaBaseLocation(SurakshaLocation surakshaBaseLocation)
	{
		this.surakshaBaseLocation = surakshaBaseLocation;
		return this;
	}

	public SurakshaLocation getSurakshaCurrentLocation()
	{
		return surakshaCurrentLocation;
	}

	public SurakshaEntity setSurakshaCurrentLocation(SurakshaLocation surakshaCurrentLocation)
	{
		this.surakshaCurrentLocation = surakshaCurrentLocation;
		return this;
	}

	public int getSurakshaSecuredFactor()
	{
		return surakshaSecuredFactor;
	}

	public SurakshaEntity setSurakshaSecuredFactor(int surakshaSecuredFactor)
	{
		this.surakshaSecuredFactor = surakshaSecuredFactor;
		return this;
	}

}
