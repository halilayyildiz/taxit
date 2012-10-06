package com.taxit.server.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.taxit.common.config.Config;

public class ImageResourceServlet implements Servlet
{
	private Config	config;

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		HttpServletRequest httpreq = (HttpServletRequest) req;
		String requestURI = httpreq.getRequestURI();

		if (requestURI.contains("/" + "/get/image/" + "/"))
		{
			// ImageUtil.writeToOutputStream(inputStream, res.getOutputStream());
			return;
		}
	}

}
