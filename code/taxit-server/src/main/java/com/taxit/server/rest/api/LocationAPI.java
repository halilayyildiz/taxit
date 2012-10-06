package com.taxit.server.rest.api;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taxit.common.BeanFactory;
import com.taxit.server.rest.StationStatusResult;
import com.taxit.server.rest.TaxiStatusResult;
import com.taxit.server.service.LocationService;

@Path("get/status/")
public class LocationAPI
{

	private static final Log	log	= LogFactory.getLog(LocationAPI.class);

	@Context
	ServletContext				context;

	@GET
	@Path("station")
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public StationStatusResult getStationStatus(@QueryParam("o") String operatorUsername)
	{
		StationStatusResult result = null;
		log.debug("Station location requested...");

		try
		{
			LocationService locationService = BeanFactory.getBean(LocationService.class);
			result = locationService.getStationStatus(operatorUsername);
		}
		catch (Exception e)
		{
			log.error("Get Station Status Failed !", e);
		}

		return result;
	}

	@GET
	@Path("taxi")
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public TaxiStatusResult getTaxiStatus(@QueryParam("o") String operatorUsername)
	{
		TaxiStatusResult result = null;
		log.debug("Taxi location requested...");

		try
		{
			LocationService locationService = BeanFactory.getBean(LocationService.class);
			result = locationService.getTaxiStatus(operatorUsername);
		}
		catch (Exception e)
		{
			log.error("Get Taxi Status Failed !", e);
		}

		return result;
	}
}
