package com.taxit.server.util;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public enum LanguageEnum
{

	ENGLISH("en"), TURKISH("tr");

	private String	code;

	LanguageEnum(String code)
	{
		this.code = code;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public static List<SelectItem> getItems()
	{
		List<SelectItem> items = new ArrayList<SelectItem>();

		items.add(new SelectItem(ENGLISH, FacesUtil.getBundleKeyValue("english")));
		items.add(new SelectItem(TURKISH, FacesUtil.getBundleKeyValue("turkish")));

		return items;
	}

}
