package com.taxit.server.database.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.taxit.server.database.dbo.Operator;

@Repository
public class UserDAO extends BaseDAO
{
	public UserDAO()
	{

	}


	public Operator getOperatorByUsername(String username)
	{
		@SuppressWarnings("unchecked")
		List<Operator> listedUsers = getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(Operator.class, "user").add(Restrictions.eq("user.username", username)));
		return listedUsers.iterator().next();
	}

}
