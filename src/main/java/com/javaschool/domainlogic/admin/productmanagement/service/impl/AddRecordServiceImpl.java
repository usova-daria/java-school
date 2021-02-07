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
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j
public class AddRecordServiceImpl implements AddRecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private GenreService genreService;

    @Autowired
    private MusicianService musicianService;

    @Autowired
    private AddRecordMapper addRecordMapper;

    @Override
    @Transactional
    public Long saveRecord(AddRecordDto recordDto) {
        Record record = addRecordMapper.toEntity(recordDto);
        Record savedRecord = recordRepository.save(record);
        return savedRecord.getId();
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
