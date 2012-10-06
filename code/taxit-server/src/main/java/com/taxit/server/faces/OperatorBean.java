package com.taxit.server.faces;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.taxit.server.database.dbo.Operator;
import com.taxit.server.service.UserService;
import com.taxit.server.util.FacesUtil;
import com.taxit.server.util.Navigations;

@ManagedBean
@RequestScoped
public class OperatorBean implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	@ManagedProperty(value = "#{userService}")
	private UserService			userService;

	private Operator			operator			= new Operator();

	public OperatorBean()
	{

	}

	@PostConstruct
	public void init()
	{
		Operator operator = userService.getOperator();
		if (operator != null)
		{
			this.operator = operator;
		}
	}

	public String updateOperator()
	{
		userService.updateOperator(operator);
		FacesUtil.setFacesMessage(FacesMessage.SEVERITY_INFO, "success", "operatorUpdated");
		return Navigations.GOTO_EDIT_OPERATOR_PAGE;
	}

	public List<Operator> getAllOperators()
	{
		List<Operator> operator = userService.getAllOperators();
		return operator;
	}

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public Operator getOperator()
	{
		return operator;
	}

	public void setOperator(Operator operator)
	{
		this.operator = operator;
	}

}
