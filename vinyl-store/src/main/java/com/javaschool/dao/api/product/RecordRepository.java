package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.entity.product.Record;

import java.util.Optional;

/**
 * @author Daria Usova
 */
public interface RecordRepository extends AbstractRepository<Record, Long> {

    /**
     * Find by id and deleted false with entity graph optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Record> findByIdAndDeletedFalseWithEntityGraph(Long id);

}
