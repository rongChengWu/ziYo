package com.wrc.ziyo.service;

import java.io.Serializable;
import java.util.List;

import com.wrc.ziyo.dao.BaseDao;

public class BaseService<T extends Serializable> {
	protected BaseDao<T> baseDao;

	public void save(T t) throws Exception {
		/* 13 */this.baseDao.save(t);
	}

	public void update(T t) throws Exception {
		/* 17 */this.baseDao.update(t);
	}

	public void delete(T t) throws Exception {
		/* 21 */this.baseDao.delete(t);
	}

	public T get(Serializable id) throws Exception {
		/* 25 */return this.baseDao.get(id);
	}

	public List<T> findAll() throws Exception {
		/* 29 */return this.baseDao.findAll();
	}

	public List<T> findByExample(T t) throws Exception {
		/* 33 */return this.baseDao.findByExample(t);
	}

	public List<T> findByExample(T t, int offset, int size) throws Exception {
		/* 37 */return this.baseDao.findByExample(t, offset, size);
	}

	public List find(Object obj) throws Exception {
		return this.baseDao.find(obj);
	}

	public List<Object[]> findBySql(String sql, final Object... objects) {
		return this.baseDao.findBySql(sql, objects);
	}

	public List<Object[]> findBySql(String sql, int offset, int size,
			final Object... objects) {
		return this.baseDao.findBySql(sql, offset, size, objects);
	}

	public List<Object[]> findByHql(String hql, int offset, int size,
			final Object... objects) throws Exception {
		return this.baseDao.findByHql(hql, offset, size, objects);
	}

	public List<Object[]> findByHql(String hql, final Object... objects)
			throws Exception {
		return this.baseDao.findByHql(hql, objects);
	}

	public BaseDao<T> getBaseDao() {
		/* 41 */return this.baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		/* 45 */this.baseDao = baseDao;
	}

}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.service.BaseService JD-Core Version: 0.6.0
 */