package com.javaschool.domainlogic.admin.productmanagement.service.impl;

import com.javaschool.dao.api.product.MusicianRepository;
import com.javaschool.domainlogic.admin.productmanagement.dto.MusicianDto;
import com.javaschool.domainlogic.admin.productmanagement.mapper.MusicianMapper;
import com.javaschool.domainlogic.admin.productmanagement.service.api.MusicianService;
import com.javaschool.entity.product.Musician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicianServiceImpl implements MusicianService {

    @Autowired
    private MusicianMapper musicianMapper;

    @Autowired
    private MusicianRepository musicianRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MusicianDto> getMusicianDtoList() {
        List<Musician> musicianList = musicianRepository.findAll();
        return musicianMapper.toDtoList(musicianList);
    }

    @Override
    @Transactional(readOnly = true)
    public Musician getById(Integer id) {
        return musicianRepository.findById(id).orElse(null);
    }

}
