package com.poochiku.suraksha.i18N;

import com.poochiku.suraksha.app.SurakshaApplication;

public class Hindi implements ILocale
{
	
	

	@Override
	public String getString(String key)
	{
		System.out.println("Inside Hindi ILocale & key: "+key);
		return SurakshaApplication.getInstance().getHindi().get(key);
		
	}

}
