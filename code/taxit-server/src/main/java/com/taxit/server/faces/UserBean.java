package com.taxit.server.faces;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.firewall.FirewalledRequest;

import com.taxit.common.util.Constants;
import com.taxit.server.UserRole;
import com.taxit.server.database.dbo.Operator;
import com.taxit.server.service.UserService;
import com.taxit.server.util.FacesUtil;
import com.taxit.server.util.Navigations;

@ManagedBean
@RequestScoped
public class UserBean implements Serializable
{
	private static final long		serialVersionUID	= 1L;
	private final Log				log					= LogFactory.getLog(getClass());

	@ManagedProperty(value = "#{authenticationManager}")
	private AuthenticationManager	authManager;

	@ManagedProperty(value = "#{userService}")
	private UserService				userService;

	private String					contextPath			= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
	private Authentication			auth				= SecurityContextHolder.getContext().getAuthentication();
	private Operator				operator			= new Operator();

	public UserBean()
	{

	}

	@PostConstruct
	public void handleLoginErrorMessage()
	{
		ResourceBundle bundle = FacesUtil.getBundle(Constants.BUNDLE_I18N);
		Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);

		if (e instanceof BadCredentialsException)
		{
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("loginFail") + " : ", bundle.getString("loginFailDetail")));
		}
	}

	public String doLogin()
	{
		try
		{
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			FirewalledRequest request = (FirewalledRequest) context.getRequest();
			request.reset();

			RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
			dispatcher.forward(request, (ServletResponse) context.getResponse());
		}
		catch (Exception e)
		{
			log.error("User Login Failed : " + operator.getUsername() + " - " + e.getMessage());
		}

		FacesContext.getCurrentInstance().responseComplete();
		return Navigations.NULL;
	}

	public String doRegister()
	{
		ResourceBundle bundle = FacesUtil.getBundle(Constants.BUNDLE_I18N);

		try
		{
			operator.setRole(UserRole.ROLE_OPERATOR);
			userService.saveOperator(operator);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("registerSuccess") + ", ", bundle.getString("registerSuccessDetail")));
		}
		catch (Exception e)
		{
			log.info("User Registration Failed !", e);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("registerFail") + ", ", bundle.getString("registerFailDetail")));

			return Navigations.GOTO_REGISTRATION_PAGE;
		}

		return Navigations.GOTO_NEW_STATION_PAGE;
	}

	public boolean isAdminUser()
	{
		for (GrantedAuthority authority : auth.getAuthorities())
		{
			if (authority.getAuthority().equals(UserRole.ROLE_OPERATOR.toString()))
			{
				return true;
			}
		}

		return false;
	}

	public boolean isUserAuthenticated()
	{
		if (auth != null && auth.isAuthenticated())
		{
			return true;
		}

		return false;
	}

	// setter & getters

	public String getContextPath()
	{
		return contextPath;
	}

	public void setContextPath(String contextPath)
	{
		this.contextPath = contextPath;
	}

	public Operator getOperator()
	{
		return operator;
	}

	public void setOperator(Operator operator)
	{
		this.operator = operator;
	}

	public AuthenticationManager getAuthManager()
	{
		return authManager;
	}

	public void setAuthManager(AuthenticationManager authManager)
	{
		this.authManager = authManager;
	}

	public Authentication getAuth()
	{
		return auth;
	}

	public void setAuth(Authentication auth)
	{
		this.auth = auth;
	}

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

}
