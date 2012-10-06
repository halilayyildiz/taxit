package com.taxit.server.security;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class UsernamePasswordAuthenticationFilterWrapper extends UsernamePasswordAuthenticationFilter
{
	public UsernamePasswordAuthenticationFilterWrapper()
	{
		super();
		setPostOnly(false);
	}
}
