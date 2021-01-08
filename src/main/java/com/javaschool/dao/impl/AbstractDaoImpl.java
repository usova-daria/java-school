package com.javaschool.dao.impl;

import com.javaschool.dao.api.AbstractDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDaoImpl<T, ID> implements AbstractDao<T, ID> {

    private Class<T> tClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractDaoImpl(Class<T> tClass) {
        this.tClass = tClass;
    }

    /**
     * Saves given entity
     * @param t entity to save, must not be null
     * @return saved entity
     */
    @Override
    public T save(T t) {
        entityManager.persist(t);
        return t;
    }

    /**
     * Updates given entity
     * @param t entity to update
     * @return updated entity
     */
    @Override
    public T update(T t) {
        return entityManager.merge(t);
    }

    /**
     * Selects all entities from corresponding database table
     * @return list of entities
     */
    @Override
    public List<T> findAll() {
        String findQueryStr = "SELECT from " + tClass.getSimpleName();
        TypedQuery<T> findQuery = entityManager.createQuery(findQueryStr, tClass);
        return findQuery.getResultList();
    }

    /**
     * Selects entity by its id
     * @param id must not be null
     * @return entity wrapped in {@link Optional}
     */
    @Override
    public Optional<T> findById(ID id) {
        T t = entityManager.find(tClass, id);
        return Optional.ofNullable(t);
    }

    /**
     * Deletes given entity
     * @param t must not be null
     */
    @Override
    public void delete(T t) {
        entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
    }

    /**
     * Deletes entity by its id
     * @param id must not be null
     */
    @Override
    public void deleteById(ID id) {
        String deleteQuery = String.format("DELETE from %s t where t.id = %d", tClass.getSimpleName(), id);
        entityManager.createQuery(deleteQuery).executeUpdate();
    }

    /**
     * Saves entities from given collection
     * @param collection collection of entities to save, must not be null
     */
    @Override
    public void saveAll(Collection<T> collection) {
        for (T entity : collection) {
            save(entity);
        }
    }

}
