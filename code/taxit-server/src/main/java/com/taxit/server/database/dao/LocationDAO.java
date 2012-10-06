package com.taxit.server.database.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDAO extends BaseDAO
{
	private final Log	log	= LogFactory.getLog(getClass());

	public LocationDAO()
	{

	}

}
