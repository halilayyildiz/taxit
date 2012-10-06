package com.taxit.server.faces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;

import com.taxit.server.database.dbo.Station;

@FacesConverter(forClass = Station.class, value = "stationConverter")
public class StationConverter extends BaseConverter implements Converter
{
	public StationConverter()
	{

	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		if (StringUtils.isBlank(value))
		{
			return null;
		}

		return getBaseDAO().get(Station.class, Long.parseLong(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if (value == null)
		{
			return "";
		}

		return ((Station) value).getId() + "";
	}

}
