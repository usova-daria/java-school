package com.javaschool.domainlogic.admin.productmanagment.service.api;

import com.javaschool.domainlogic.admin.productmanagment.dto.MusicianDto;
import com.javaschool.entity.product.Musician;

import java.util.List;

public interface MusicianService {

    List<MusicianDto> getMusicianDtoList();

    Musician getById(Integer id);

}
