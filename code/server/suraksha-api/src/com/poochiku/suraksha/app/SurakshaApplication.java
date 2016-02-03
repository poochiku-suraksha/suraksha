package com.poochiku.suraksha.app;

import com.poochiku.suraksha.module.db.DBHandler;
import com.poochiku.suraksha.util.Strings;

public class SurakshaApplication
{
	private DBHandler mongo;

	private Strings hindi;
	private Strings english;

	public Strings getHindi()
	{
		return hindi;
	}

	public SurakshaApplication setHindi(Strings hindi)
	{
		this.hindi = hindi;
		return this;
	}

	public Strings getEnglish()
	{
		return english;
	}

	public SurakshaApplication setEnglish(Strings english)
	{
		this.english = english;
		return this;
	}

	private static SurakshaApplication instance;

	public static SurakshaApplication getInstance()
	{

		if (instance == null)
		{
			System.out.println("Creating SurakshaApplication Instance");
			instance = new SurakshaApplication();
		}

		return instance;
	}

	public SurakshaApplication setDBHandler(DBHandler m)
	{
		System.out.println("Attaching DBHandler to SurakshaApplication");
		instance.mongo = m;
		return instance;
	}

	public DBHandler getDBHandler()
	{
		return instance.mongo;
	}

}
