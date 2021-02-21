package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.entity.product.Record;

import java.util.Optional;

public interface RecordRepository extends AbstractRepository<Record, Long> {

    Optional<Record> findByIdAndDeletedFalseWithEntityGraph(Long id);

}
