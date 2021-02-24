package com.javaschool.domainlogic.admin.productmanagement.service.impl;

import com.javaschool.dao.api.product.MusicianRepository;
import com.javaschool.domainlogic.admin.productmanagement.dto.MusicianDto;
import com.javaschool.domainlogic.admin.productmanagement.mapper.MusicianMapper;
import com.javaschool.domainlogic.admin.productmanagement.service.api.MusicianService;
import com.javaschool.entity.product.Musician;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
public class MusicianServiceImpl implements MusicianService {

    private final MusicianMapper musicianMapper;
    private final MusicianRepository musicianRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MusicianDto> getMusicianDtoList() {
        List<MusicianDto> musicianDtoList = new ArrayList<>();

        try {
            List<Musician> musicianList = musicianRepository.findAll();
            musicianDtoList = musicianMapper.toDtoList(musicianList);
        } catch (PersistenceException e) {
            log.error("An error occurred while getting musicians", e);
        }

        return musicianDtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public Musician getById(Integer id) {
        return musicianRepository.findById(id).orElse(null);
    }

}
