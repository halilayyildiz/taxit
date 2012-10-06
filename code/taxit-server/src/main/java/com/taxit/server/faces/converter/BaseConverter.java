package com.taxit.server.faces.converter;

import com.taxit.common.BeanFactory;
import com.taxit.server.database.dao.BaseDAO;

public class BaseConverter
{
	private BaseDAO	baseDAO;

	public BaseConverter()
	{
		this.baseDAO = BeanFactory.getBean("baseDAO", BaseDAO.class);
	}

	public BaseDAO getBaseDAO()
	{
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO)
	{
		this.baseDAO = baseDAO;
	}

}
