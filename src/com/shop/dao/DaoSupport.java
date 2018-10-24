package com.shop.dao;

import com.shop.util.hibernateUtils.GenericsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author chenchen
 * @date 2018/10/24 19:42
 * @Content:
 */
public class DaoSupport<T> implements BaseDao<T> {

    protected Class <T> entityClass = GenericsUtils.getGenericType(this.getClass());
    @Autowired
    private HibernateTemplate template;//hibernate模板

    public HibernateTemplate getTemplate() {
        return template;
    }

    @Override
    public void save(Object object) {
        getTemplate().save(object);
    }

    @Override
    public void saveOrUpdate(Object object) {
        getTemplate().saveOrUpdate(object);
    }

    @Override
    public void update(Object object) {
        getTemplate().update(object);
    }

    @Override
    public void delete(Serializable... ids) {
        for (Serializable id :
                ids) {
            T t = (T) getTemplate().load(this.entityClass, id);
            getTemplate().delete(t);
        }
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public T get(Serializable entityId) {
        return (T) getTemplate().get(this.entityClass, entityId);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public T load(Serializable entityId) {
        return (T) getTemplate().load(this.entityClass, entityId);
    }

    @Override
    public Object uniqueResult(String hql, Object[] queryParams) {
        return null;
    }

}
