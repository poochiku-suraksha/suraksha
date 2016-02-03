package com.poochiku.suraksha.common.filters;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NameBinding;



public class AuthenticationFilter implements Filter
{

	public static final String AUTHENTICATION_HEADER = "Authorization";

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException
	{

		String path = ((HttpServletRequest) request).getRequestURI();
		System.out.println("Inside authenctication filter :PATH =" + path);
		if (path.contains("open"))
		{
			System.out.println("NoFilter for path " + path);
			filter.doFilter(request, response); // Just continue chain.
		}
		else
		{

			if (request instanceof HttpServletRequest)
			{
				HttpServletRequest httpServletRequest = (HttpServletRequest) request;
				String authCredentials = httpServletRequest.getHeader(AUTHENTICATION_HEADER);

				// better injected
				AuthenticationService authenticationService = new AuthenticationService();

				boolean authenticationStatus = authenticationService.authenticate(authCredentials);

				if (authenticationStatus)
				{
					filter.doFilter(request, response);
				}
				else
				{
					if (response instanceof HttpServletResponse)
					{
						HttpServletResponse httpServletResponse = (HttpServletResponse) response;
						httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					}
				}
			}

		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		// TODO Auto-generated method stub
		
	}

	

}
