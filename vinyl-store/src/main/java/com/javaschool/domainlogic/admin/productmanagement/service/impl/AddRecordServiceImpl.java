package com.javaschool.domainlogic.admin.productmanagement.service.impl;

import com.javaschool.dao.api.product.RecordRepository;
import com.javaschool.domainlogic.admin.productmanagement.dto.AddRecordDto;
import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagement.dto.MusicianDto;
import com.javaschool.domainlogic.admin.productmanagement.mapper.AddRecordMapper;
import com.javaschool.domainlogic.admin.productmanagement.service.api.AddRecordService;
import com.javaschool.domainlogic.admin.productmanagement.service.api.GenreService;
import com.javaschool.domainlogic.admin.productmanagement.service.api.MusicianService;
import com.javaschool.entity.product.Record;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
public class AddRecordServiceImpl implements AddRecordService {

    private final GenreService genreService;
    private final MusicianService musicianService;
    private final AddRecordMapper addRecordMapper;
    private final RecordRepository recordRepository;

    @Override
    @Transactional
    public void saveRecord(AddRecordDto recordDto) {
        Record record = addRecordMapper.toEntity(recordDto);

        try {
            recordRepository.save(record);
        } catch (PersistenceException e) {
            log.error("An error occurred while saving a record", e);
        }
    }

    @Override
    public List<GenreDto> getGenres() {
        return genreService.getGenreDtoList();
    }

    @Override
    public List<MusicianDto> getMusicians() {
        return musicianService.getMusicianDtoList();
    }

}
