package com.shop.dao;

import com.shop.model.PageModel;

import java.io.Serializable;
import java.util.Map;

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

    public long getCount();

    public PageModel <T> find(int pageNo, int MaxResult);

    public PageModel <T> find(int pageNo, int MaxResult, String where, Object[] queryParams);

    public PageModel <T> find(int pageNO, int MaxResult, Map <String, String> orderby);

    public PageModel <T> find(String where, Object[] queryParams, Map <String, String> orderby, int pageNo, int MaxResult);


}
