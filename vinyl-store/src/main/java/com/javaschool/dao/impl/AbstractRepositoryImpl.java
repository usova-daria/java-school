package com.javaschool.dao.impl;

import com.javaschool.dao.api.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepositoryImpl<T, ID extends Number> implements AbstractRepository<T, ID> {

    private final Class<T> tClass;

    @PersistenceContext
    protected EntityManager entityManager;

    protected AbstractRepositoryImpl(Class<T> tClass) {
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
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(tClass);
        Root<T> root = criteriaQuery.from(tClass);
        criteriaQuery.select(root);

        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * Selects entity by its id
     * @param id must not be null
     * @return entity wrapped in {@link Optional}
     */
    @Override
    public Optional<T> findById(ID id) {
        if (id == null) return Optional.empty();

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
     * @return true if the entity is deleted, false otherwise
     */
    @Override
    public boolean deleteById(ID id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<T> criteriaDelete = criteriaBuilder.createCriteriaDelete(tClass);
        Root<T> root = criteriaDelete.from(tClass);
        criteriaDelete.where( criteriaBuilder.equal(root.get("id"), id) );

        return entityManager.createQuery(criteriaDelete).executeUpdate() == 1;
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
