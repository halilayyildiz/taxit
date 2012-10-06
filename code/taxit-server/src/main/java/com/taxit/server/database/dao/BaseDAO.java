package com.taxit.server.database.dao;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.taxit.common.util.Constants;
import com.taxit.common.util.StreamUtil;
import com.taxit.server.exception.TaxitServerException;

@Repository
public class BaseDAO extends HibernateDaoSupport
{

	@Autowired
	public void init(SessionFactory sessionFactory)
	{
		setSessionFactory(sessionFactory);
	}

	/* CRUD Operations */

	public <T> T save(T object)
	{
		getHibernateTemplate().saveOrUpdate(object);
		return object;
	}

	public <T> T get(Class<T> clazz, long id)
	{
		return getHibernateTemplate().get(clazz, id);
	}

	public void update(Serializable entity)
	{
		getHibernateTemplate().update(entity);
	}

	public void delete(Serializable entity)
	{
		getHibernateTemplate().delete(entity);
	}

	// get all
	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(Class<T> clazz)
	{
		return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz));
	}

	// get multiple
	@SuppressWarnings("unchecked")
	public <T> List<T> get(Class<T> clazz, List<Long> ids)
	{
		if (ids.isEmpty())
		{
			return new ArrayList<T>();
		}
		return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz).add(Restrictions.in("id", ids)));
	}

	// delete multiple
	public void deleteAll(List<? extends Object> entities)
	{
		getHibernateTemplate().deleteAll(entities);
	}

	/* Check table */
	public boolean isTableEmpty(final Class<?> clazz)
	{
		return getHibernateTemplate().execute(new HibernateCallback<Boolean>() {
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException, SQLException
			{

				Long count = (Long) session.createCriteria(clazz).setProjection(Projections.rowCount()).uniqueResult();
				return count < 1;
			}
		});
	}

	/* Execute SQL script from file */

	public void executeDatabaseScriptFromFile(final String sqlScriptFileLocation)
	{
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException
			{
				try
				{
					InputStream stream = StreamUtil.getStream(sqlScriptFileLocation);
					LineIterator lineIterator = IOUtils.lineIterator(stream, Constants.DEFAULT_ENCODING);
					while (lineIterator.hasNext())
					{
						String sqlString = (String) lineIterator.next();
						session.createSQLQuery(sqlString).executeUpdate();
					}
					return 1;
				}
				catch (Exception e)
				{
					throw new TaxitServerException(" Execute Database Init Script { FAILED }", e);
				}
			}
		});
	}

	// /* Execute SQL script */
	// public List executeDatabaseScript(String sqlScript) {
	// HibernateCallbackForSqlScript hibernateCallback = new
	// HibernateCallbackForSqlScript(sqlScript);
	// List resultList = getHibernateTemplate().execute(hibernateCallback);
	// return resultList;
	// }

	/* search */

}
