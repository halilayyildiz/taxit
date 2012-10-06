package com.taxit.server.faces;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.taxit.server.database.dbo.Driver;
import com.taxit.server.service.UserService;
import com.taxit.server.util.FacesUtil;
import com.taxit.server.util.Navigations;

@ManagedBean
@RequestScoped
public class DriverBean implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	// private static final Log log = LogFactory.getLog(DriverBean.class);

	@ManagedProperty(value = "#{userService}")
	private UserService			userService;

	private Driver				driver				= new Driver();

	// edit driver
	private Driver				selectedDriver		= new Driver();

	public DriverBean()
	{

	}

	public void handleDriverSelect()
	{
		driver = selectedDriver;
	}

	public String addNewDriver()
	{
		userService.addNewDriver(driver);
		FacesUtil.setFacesMessage(FacesMessage.SEVERITY_INFO, "success", "newDriverAdded");
		driver = new Driver();
		return Navigations.GOTO_NEW_DRIVER_PAGE;
	}

	public String updateDriver()
	{
		userService.updateDriver(driver);
		FacesUtil.setFacesMessage(FacesMessage.SEVERITY_INFO, "success", "driverUpdated");
		driver = new Driver();
		return Navigations.GOTO_EDIT_DRIVER_PAGE;
	}

	public String deleteDriver()
	{
		userService.deleteDriver(driver);
		FacesUtil.setFacesMessage(FacesMessage.SEVERITY_INFO, "success", "driverDeleted");
		driver = new Driver();
		return Navigations.GOTO_EDIT_DRIVER_PAGE;
	}

	public List<Driver> getAllDrivers()
	{
		List<Driver> drivers = userService.getAllDrivers();
		return drivers;
	}

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public Driver getDriver()
	{
		return driver;
	}

	public void setDriver(Driver driver)
	{
		this.driver = driver;
	}

	public Driver getSelectedDriver()
	{
		return selectedDriver;
	}

	public void setSelectedDriver(Driver selectedDriver)
	{
		this.selectedDriver = selectedDriver;
	}

}
