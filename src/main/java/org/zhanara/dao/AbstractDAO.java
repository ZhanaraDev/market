package org.zhanara.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDAO<PK extends Serializable,T> {
    private final Class<T> persistentClass;

    public AbstractDAO(){

        this.persistentClass = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    protected void persist(T entity){
        getSession().persist(entity);
    }

    protected void save(T entity){
        getSession().save(entity);
    }

    protected void update(T entity){
        getSession().update(entity);
    }

    protected void delete(T entity){
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
