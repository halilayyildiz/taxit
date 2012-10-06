package com.taxit.server.faces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;

import com.taxit.server.database.dbo.Taxi;

@FacesConverter(forClass = Taxi.class, value = "taxiConverter")
public class TaxiConverter extends BaseConverter implements Converter
{
	public TaxiConverter()
	{

	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		if (StringUtils.isBlank(value))
		{
			return null;
		}

		return getBaseDAO().get(Taxi.class, Long.parseLong(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if (value == null)
		{
			return "";
		}

		return ((Taxi) value).getId() + "";
	}

}
