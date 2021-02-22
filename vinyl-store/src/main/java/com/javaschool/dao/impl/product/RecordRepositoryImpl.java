package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.RecordRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.product.Record;
import com.javaschool.util.ImageCompress;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class RecordRepositoryImpl extends AbstractRepositoryImpl<Record, Long> implements RecordRepository {

    public RecordRepositoryImpl() {
        super(Record.class);
    }

    @Override
    public Record save(Record record) {
        byte[] picture = record.getPicture();
        byte[] compressedPicture = ImageCompress.compressBytes(picture);

        record.setPicture(compressedPicture);

        return super.save(record);
    }

    @Override
    public Optional<Record> findByIdAndDeletedFalseWithEntityGraph(Long id) {
        if (id == null) return Optional.empty();

        EntityGraph entityGraph = entityManager.getEntityGraph("record-graph");

        Record record;
        try {
            record = entityManager.createNamedQuery("Record.findByIdAndDeletedFalse", Record.class)
                    .setParameter("id", id)
                    .setHint("javax.persistence.fetchgraph", entityGraph)
                    .getSingleResult();
        } catch (NoResultException e) {
            record = null;
        }

        return Optional.ofNullable(record);
    }
}
