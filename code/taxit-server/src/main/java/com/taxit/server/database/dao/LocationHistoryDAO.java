package com.taxit.server.database.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.taxit.server.database.dbo.LocationHistory;
import com.taxit.server.database.dbo.Taxi;

@Repository
public class LocationHistoryDAO extends BaseDAO
{
	// private final Log log = LogFactory.getLog(getClass());

	public LocationHistoryDAO()
	{

	}

	public List<LocationHistory> getLocationHistory(Taxi taxi)
	{
		@SuppressWarnings("unchecked")
		List<LocationHistory> list = getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(LocationHistory.class, "history").add(Restrictions.eq("history.taxi.id", taxi.getId()))
						.addOrder(Order.desc("storeDate")));
		return list;
	}

	public List<LocationHistory> getAllLocationHistory()
	{
		@SuppressWarnings("unchecked")
		List<LocationHistory> list = getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(LocationHistory.class, "history").addOrder(Order.desc("storeDate")));
		return list;
	}

}
