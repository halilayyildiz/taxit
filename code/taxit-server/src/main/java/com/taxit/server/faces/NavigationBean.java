package com.taxit.server.faces;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.taxit.server.util.FacesUtil;

@ManagedBean
@RequestScoped
public class NavigationBean implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	private String				contextPath			= FacesUtil.getContextPath();

	public NavigationBean()
	{

	}

	public String gotoHomePage()
	{
		return "gotoHomePage";
	}

	public String gotoAdministrationPage()
	{
		return "gotoAdministrationPage";
	}

	public String gotoReportsPage()
	{
		return "gotoReportPage";
	}

	public String getContextPath()
	{
		return contextPath;
	}

	public void setContextPath(String contextPath)
	{
		this.contextPath = contextPath;
	}

}
