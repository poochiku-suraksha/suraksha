package com.poochiku.suraksha.util;

import android.app.Activity;

public class UIManager
{

	public static void setActionBarTitle(Activity ctx, String title)
	{
		ctx.getActionBar().setTitle(title);
	}

	public static void setActionBarIcon(Activity ctx, int drawableId)
	{
		ctx.getActionBar().setIcon(drawableId);
	}
}
