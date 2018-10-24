package com.shop.dao;

import com.shop.util.hibernateUtils.GenericsUtils;

import java.io.Serializable;

/**
 * @author chenchen
 * @date 2018/10/24 19:42
 * @Content:
 */
public class DaoSupport<T> implements BaseDao<T> {

    protected Class <T> entityClass = GenericsUtils.getGenericType(this.getClass());
    @Override
    public void save(Object object) {

    }

    @Override
    public void saveOrUpdate(Object object) {

    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void delete(Serializable... ids) {

    }

    @Override
    public T get(Serializable entityId) {
        return null;
    }

    @Override
    public T load(Serializable entityId) {
        return null;
    }

    @Override
    public Object uniqueResult(String hql, Object[] queryParams) {
        return null;
    }
}
