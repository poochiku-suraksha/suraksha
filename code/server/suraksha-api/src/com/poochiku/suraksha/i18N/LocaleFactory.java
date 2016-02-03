package com.poochiku.suraksha.i18N;

import com.poochiku.suraksha.util.SURAKSHA_PARAMS.SURAKSHA_LOCALE;

public class LocaleFactory
{

	
	public static ILocale getLocale(String locale)
	{
		
		
		switch (locale)
		{
		case SURAKSHA_LOCALE.ENGLISH:
			return new English();
			
		case SURAKSHA_LOCALE.HINDI:
			return new Hindi();

		default:
			return new English();
		}
		
	}
}
