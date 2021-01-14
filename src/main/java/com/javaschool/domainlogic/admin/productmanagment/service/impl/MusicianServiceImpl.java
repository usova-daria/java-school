package com.javaschool.domainlogic.admin.productmanagment.service.impl;

import com.javaschool.dao.api.product.MusicianRepository;
import com.javaschool.domainlogic.admin.productmanagment.dto.MusicianDto;
import com.javaschool.domainlogic.admin.productmanagment.mapper.MusicianMapper;
import com.javaschool.domainlogic.admin.productmanagment.service.api.MusicianService;
import com.javaschool.entity.product.Musician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicianServiceImpl implements MusicianService {

    @Autowired
    private MusicianMapper musicianMapper;

    @Autowired
    private MusicianRepository musicianRepository;

    @Override
    public List<MusicianDto> getMusicianDtoList() {
        List<Musician> musicianList = musicianRepository.findAll();
        List<MusicianDto> musicianDtoList = musicianMapper.toDTOList(musicianList);
        return musicianDtoList;
    }

    @Override
    public Musician getById(Integer id) {
        return musicianRepository.findById(id).orElse(null);
    }

}
