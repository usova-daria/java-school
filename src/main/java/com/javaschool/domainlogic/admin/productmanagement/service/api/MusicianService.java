package com.javaschool.domainlogic.admin.productmanagement.service.api;

import com.javaschool.domainlogic.admin.productmanagement.dto.MusicianDto;
import com.javaschool.entity.product.Musician;

import java.util.List;

public interface MusicianService {

    List<MusicianDto> getMusicianDtoList();

    Musician getById(Integer id);

}
