package com.javaschool.domainlogic.admin.productmanagment.service.impl;

import com.javaschool.dao.api.product.RecordRepository;
import com.javaschool.domainlogic.admin.productmanagment.dto.AddRecordDto;
import com.javaschool.domainlogic.admin.productmanagment.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagment.dto.MusicianDto;
import com.javaschool.domainlogic.admin.productmanagment.mapper.AddRecordMapper;
import com.javaschool.domainlogic.admin.productmanagment.service.api.AddRecordService;
import com.javaschool.domainlogic.admin.productmanagment.service.api.GenreService;
import com.javaschool.domainlogic.admin.productmanagment.service.api.MusicianService;
import com.javaschool.entity.product.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
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
