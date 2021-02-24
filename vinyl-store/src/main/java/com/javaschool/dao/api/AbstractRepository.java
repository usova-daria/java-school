package com.javaschool.dao.api;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author Daria Usova
 */
public interface AbstractRepository<T, ID extends Number> {

    /**
     * Save t.
     *
     * @param t the t
     * @return the t
     */
    T save(T t);

    /**
     * Update t.
     *
     * @param t the t
     * @return the t
     */
    T update(T t);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<T> findAll();

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<T> findById(ID id);

    /**
     * Delete.
     *
     * @param t the t
     */
    void delete(T t);

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteById(ID id);

    /**
     * Save all.
     *
     * @param collection the collection
     */
    void saveAll(Collection<T> collection);

}
