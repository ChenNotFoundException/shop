package com.shop.dao;

import java.io.Serializable;

/**
 * @author chenchen
 * @date 2018/10/24 19:38
 * @Content:
 */
public interface BaseDao<T> {
    public void save(Object object);
    public void saveOrUpdate(Object object);
    public void update(Object object);
    public void delete(Serializable... ids);

    public T get(Serializable entityId);

    public T load(Serializable entityId);

    public Object uniqueResult(String hql, Object[] queryParams);


}
