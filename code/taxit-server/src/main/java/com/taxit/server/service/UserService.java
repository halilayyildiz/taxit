package com.taxit.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.taxit.server.database.dao.UserDAO;
import com.taxit.server.database.dbo.Driver;
import com.taxit.server.database.dbo.Operator;

@Service
public class UserService
{
	private UserDAO	userDAO;

	@Autowired
	public UserService(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public Operator saveOperator(Operator operator)
	{
		Operator registeredUser = userDAO.save(operator);
		return registeredUser;
	}

	public void updateOperator(Operator operator)
	{
		userDAO.update(operator);
	}

	public Operator getOperator()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null)
		{
			String operatorUsername = auth.getName();
			Operator operator = userDAO.getOperatorByUsername(operatorUsername);
			return operator;
		}
		return null;
	}

	public List<Driver> getAllDrivers()
	{
		List<Driver> drivers = userDAO.getAll(Driver.class);
		return drivers;
	}

	public List<Operator> getAllOperators()
	{
		List<Operator> operators = userDAO.getAll(Operator.class);
		return operators;
	}

	public Driver addNewDriver(Driver driver)
	{
		Driver newDriver = userDAO.save(driver);
		return newDriver;
	}

	public void updateDriver(Driver driver)
	{
		userDAO.update(driver);
	}

	public void deleteDriver(Driver driver)
	{
		userDAO.delete(driver);
	}

}
