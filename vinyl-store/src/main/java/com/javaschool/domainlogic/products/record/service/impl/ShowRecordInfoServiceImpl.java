package com.javaschool.domainlogic.products.record.service.impl;

import com.javaschool.dao.api.product.RecordRepository;
import com.javaschool.domainlogic.products.record.dto.RecordDto;
import com.javaschool.domainlogic.products.record.exception.GetRecordFailed;
import com.javaschool.domainlogic.products.record.exception.RecordNotFound;
import com.javaschool.domainlogic.products.record.mapper.RecordDtoMapper;
import com.javaschool.domainlogic.products.record.service.api.ShowRecordInfoService;
import com.javaschool.entity.product.Record;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

@Log4j
@Service
@AllArgsConstructor
public class ShowRecordInfoServiceImpl implements ShowRecordInfoService {

    private final RecordRepository recordRepository;
    private final RecordDtoMapper recordDtoMapper;

    @Override
    @Transactional(readOnly = true)
    public RecordDto getRecordById(Long id) {
        Record record;

        try {
            record = recordRepository.findByIdAndDeletedFalseWithEntityGraph(id)
                    .orElseThrow(RecordNotFound::new);
        } catch (PersistenceException e) {
            log.error("An error occurred while getting record by id=" + id, e);
            throw new GetRecordFailed();
        }

        return recordDtoMapper.toDto(record);
    }

}
