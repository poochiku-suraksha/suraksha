package com.poochiku.suraksha.util;

import com.google.gson.Gson;
import com.poochiku.suraksha.util.Konstants.MAGIC_PARAMETERS;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class StorageManager
{

	public static boolean save(Activity ctx, String key, String value)
	{
		SharedPreferences mPrefs = ctx.getSharedPreferences(MAGIC_PARAMETERS.STORAGE_SHARED_PREF_NAME, ctx.MODE_PRIVATE);
		Editor prefsEditor = mPrefs.edit();
		prefsEditor.putString(key, value);
		prefsEditor.commit();
		return true;

	}

	public static boolean savePojo(Activity ctx, String key, Object obj)
	{
		SharedPreferences mPrefs = ctx.getSharedPreferences(MAGIC_PARAMETERS.STORAGE_SHARED_PREF_NAME, ctx.MODE_PRIVATE);
		Editor prefsEditor = mPrefs.edit();
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		prefsEditor.putString(key, json);
		prefsEditor.commit();
		return true;

	}

	public static String retrieve(Activity ctx, String key)
	{

		SharedPreferences mPrefs = ctx.getPreferences(ctx.MODE_PRIVATE);
		String data = mPrefs.getString(key, null);
		return data;

	}

	public static Object retrievePojo(Activity ctx, String key, Class<?> cls)
	{
		SharedPreferences mPrefs = ctx.getPreferences(ctx.MODE_PRIVATE);
		String data = mPrefs.getString(key, null);
		if (data != null)
		{
			Gson gson = new Gson();
			return gson.fromJson(data, cls);
		}
		return null;

	}

}
