package com.poochiku.suraksha.i18N;

import com.poochiku.suraksha.app.SurakshaApplication;

public class English implements ILocale
{

	@Override
	public String getString(String key)
	{
		System.out.println("Inside English ILocale & key: "+key);
		return SurakshaApplication.getInstance().getEnglish().get(key);
	}

}
