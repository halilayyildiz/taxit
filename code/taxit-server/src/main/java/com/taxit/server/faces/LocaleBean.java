package com.taxit.server.faces;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.taxit.server.util.LanguageEnum;

@ManagedBean
@SessionScoped
public class LocaleBean implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	private Locale				locale				= FacesContext.getCurrentInstance().getViewRoot().getLocale();
	private String				language			= LanguageEnum.ENGLISH.getCode();

	public LocaleBean()
	{

	}

	public void languageChanged(ValueChangeEvent e)
	{
		locale = new Locale((String) e.getNewValue());
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public Locale getLocale()
	{
		return locale;
	}

	public void setLocale(Locale locale)
	{
		this.locale = locale;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

}
