package com.wrc.ziyo.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T extends Serializable> {
	@Autowired
	private SessionFactory sessionFactory;
	// 当前泛型类
	@SuppressWarnings("rawtypes")
	private Class entityClass;
	// 当前主键名称
	private String pkname;
	private final String HQL_LIST_ALL;
	private final String HQL_COUNT_ALL;

	@SuppressWarnings("rawtypes")
	public Class getEntityClass() {
		return entityClass;
	}

	@SuppressWarnings("rawtypes")
	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}

	@SuppressWarnings("rawtypes")
	public BaseDao() {
		// 获取当前泛型类
		Type type = this.getClass().getGenericSuperclass();
		if (type.toString().indexOf("BaseDao") != -1) {
			ParameterizedType type1 = (ParameterizedType) type;
			Type[] types = type1.getActualTypeArguments();
			setEntityClass((Class) types[0]);
		} else {
			type = ((Class) type).getGenericSuperclass();
			ParameterizedType type1 = (ParameterizedType) type;
			Type[] types = type1.getActualTypeArguments();
			setEntityClass((Class) types[0]);
		}
		getPkname();
		HQL_LIST_ALL = "from " + this.entityClass.getSimpleName()
				+ " order by " + pkname + " desc";
		HQL_COUNT_ALL = "select count(*) from "
				+ this.entityClass.getSimpleName();
	}

	/**
	 * 获取主键名称
	 * 
	 * @return
	 */
	public String getPkname() {
		Field[] fields = this.entityClass.getDeclaredFields();// 反射类字段
		for (Field field : fields) {
			field.isAnnotationPresent(Id.class);
			this.pkname = field.getName();
			break;
		}
		return pkname;
	}

	/**
	 * 保存实例
	 * 
	 * @param t
	 * @throws HibernateException
	 */
	public void save(T t) throws HibernateException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException(e);
		} finally {
			session.close();
		}
	}

	/**
	 * 修改实例
	 * 
	 * @param t
	 * @throws HibernateException
	 */
	public void update(T t) throws HibernateException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException(e);
		} finally {
			session.close();
		}
	}

	/**
	 * 删除实例
	 * 
	 * @param t
	 * @throws HibernateException
	 */
	public void delete(T t) throws HibernateException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException(e);
		} finally {
			session.close();
		}
	}

	/**
	 * 获取实例
	 * 
	 * @param id
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public T get(Serializable id) throws Exception {
		Session session = null;
		T t = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			t = (T) session.get(getEntityClass(), id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException(e);
		} finally {
			session.close();
		}
		return t;
	}

	/**
	 * 查询全部
	 * 
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() throws Exception {
		List<T> list = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(HQL_LIST_ALL);
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * 查询总数
	 * 
	 * @throws HibernateException
	 */
	public Integer findAllCount() throws Exception {
		Session session = null;
		Integer count = 0;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(HQL_COUNT_ALL);
			List<?> list = query.list();
			session.getTransaction().commit();
			if (list != null && !list.isEmpty()) {
				count = ((Integer) list.get(0)).intValue();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}

	/**
	 * QBC查询
	 * 
	 * @param criteria
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Criteria criteria) throws Exception {
		List<T> list = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Criteria criteria1 = session.createCriteria(getEntityClass());
			criteria1 = criteria;
			list = criteria1.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * QBE查询
	 * 
	 * @param t
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T t) throws Exception {
		List<T> list = null;
		Session session = null;
		Example example = Example.create(t);
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(getEntityClass());
			criteria.add(example);
			list = criteria.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * HQL查询
	 * 
	 * @param hql
	 * @param objects
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findByHql(String hql, final Object... objects)
			throws Exception {
		List<Object[]> list = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * HQL 分页 查询
	 * 
	 * @param hql
	 * @param objects
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findByHql(String hql, int offset, int size,
			final Object... objects) throws Exception {
		List<Object[]> list = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
			query.setMaxResults(size);
			query.setFirstResult(offset);
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * SQL查询
	 * 
	 * @param sql
	 * @param objects
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findBySql(String sql, int offset, int size,
			final Object... objects) {
		List<Object[]> list = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = sessionFactory.getCurrentSession()
					.createSQLQuery(sql);
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
			list = query.list();
			query.setMaxResults(size);
			query.setFirstResult(offset);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * SQL 分页 查询
	 * 
	 * @param sql
	 * @param objects
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findBySql(String sql, final Object... objects) {
		List<Object[]> list = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = sessionFactory.getCurrentSession()
					.createSQLQuery(sql);
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * QBE查询
	 * 
	 * @param t
	 * @param offset
	 * @param size
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T t, int offset, int size) throws Exception {
		List list = null;
		Session session = null;
		Example example = Example.create(t);
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			Criteria criterial = session.createCriteria(getEntityClass());
			criterial.add(example);
			criterial.setMaxResults(size);
			criterial.setFirstResult(offset);
			list = criterial.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List find(Object obj) throws Exception {
		final String hql;
		if (obj instanceof String)
			hql = (String) obj;
		else
			hql = "select a from " + obj.getClass().getName() + " a";

		List<Object[]> list = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
