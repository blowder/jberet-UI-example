package org.jberet.test.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by sesshoumaru on 8/13/17.
 */
public class EntityRepository<T> {

    @PersistenceContext
    private EntityManager em;

    public T save(T entity) {
        entity = em.merge(entity);
        em.persist(entity);
        return entity;
    }

    public List<T> getAll(Class<T> clazz) {
        return em.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
    }
}
