/**
 * @author Madhusudhan Mahale
 */
package com.poochiku.suraksha.api.base;

import javax.servlet.ServletContext;


public class SurakshaApiBase 
{
	private ServletContext context;

	public SurakshaApiBase(ServletContext context)
	{
		this.context = context;
	}
	
	
	protected boolean isNull(Object o)
	{
		if(o==null) return true ; return false;
			
	}
	protected boolean notNull(Object o)
	{
		if(o==null) return false ; return true;
			
	}
	
	
}
