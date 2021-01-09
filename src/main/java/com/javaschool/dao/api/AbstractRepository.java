package com.javaschool.dao.api;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AbstractRepository<T, ID> {

    T save(T t);

    T update(T t);

    List<T> findAll();

    Optional<T> findById(ID id);

    void delete(T t);

    void deleteById(ID id);

    void saveAll(Collection<T> collection);

}
