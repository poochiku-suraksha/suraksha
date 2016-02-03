package com.poochiku.suraksha.db;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.poochiku.suraksha.greenDao.DaoMaster;
import com.poochiku.suraksha.greenDao.DaoMaster.DevOpenHelper;
import com.poochiku.suraksha.greenDao.DaoSession;

public class SurakshaDB
{

	private static SurakshaDB instance;

	private SQLiteDatabase db;

	private DevOpenHelper daoMaster;

	private DaoSession daoSession;

	public static SurakshaDB getDBInstance(Context ctx)
	{
		if(instance == null)
		{
			instance = new  SurakshaDB();
			instance.daoMaster = new DaoMaster.DevOpenHelper(ctx, "surakshadb", null);
		}
		
		return instance;
	}
}
