package com.javaschool.dao.impl.product;

import com.javaschool.util.ImageCompress;
import com.javaschool.dao.api.product.RecordRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.product.Genre;
import com.javaschool.entity.product.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

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

}
