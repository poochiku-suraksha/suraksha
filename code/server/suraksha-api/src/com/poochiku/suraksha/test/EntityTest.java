package com.poochiku.suraksha.test;

import com.poochiku.suraksha.model.SurakshaUser;
import com.poochiku.suraksha.util.SurakshaUtil;

public class EntityTest
{

	public static void main(String[] args)
	{
		
		SurakshaUser user = new SurakshaUser();
		user.setSurakshaId("12345");
		String otp = SurakshaUtil.generateOTP();
		System.out.println(otp);
		

	}

}
