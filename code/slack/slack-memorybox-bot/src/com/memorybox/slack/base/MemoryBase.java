package com.memorybox.slack.base;

public class MemoryBase
{

	public void logError(Class <?>cls,String err)
	{
		//TODO : Add Log4j
		System.out.println(cls.getCanonicalName() +":"+err);
	}
}
