package com.taxit.server.util;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.taxit.common.util.Constants;

public class FacesUtil
{

	public static void setLanguage(LanguageEnum lang)
	{
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(lang.getCode()));
	}

	public static ResourceBundle getBundle(String bundleName)
	{
		return FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), bundleName);
	}

	public static void setFacesMessage(Severity severity, String summary, String detail)
	{
		setFacesMessage(Constants.BUNDLE_I18N, severity, summary, detail);
	}

	public static void setFacesMessage(String bundleName, Severity severity, String summary, String detail)
	{
		ResourceBundle bundle = getBundle(bundleName);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, bundle.getString(summary) + ", ", bundle.getString(detail)));
	}

	public static String getParam(String param)
	{
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		return params.get(param);
	}

	public static long getParamAsLong(String param)
	{
		if (getParam(param) != null)
		{
			return Long.parseLong(getParam(param));
		}
		return 0;
	}

	public static int getParamAsInt(String param)
	{
		if (getParam(param) != null)
		{
			return Integer.parseInt(getParam(param));
		}
		return 0;
	}

	public static boolean getParamAsBoolean(String param)
	{
		if (getParam(param) != null)
		{
			return Boolean.parseBoolean(getParam(param));
		}
		return false;
	}

	public static String getBundleKeyValue(String key)
	{
		ResourceBundle bundle = getBundle(Constants.BUNDLE_I18N);
		return bundle.getString(key);
	}

	public static Object getAttribute(ActionEvent event, String attribute)
	{
		return event.getComponent().getAttributes().get(attribute);
	}

	public static String getContextPath()
	{
		return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
	}

}
