package com.javaschool.domainlogic.admin.productmanagement.service.api;

import com.javaschool.domainlogic.admin.productmanagement.dto.MusicianDto;
import com.javaschool.entity.product.Musician;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface MusicianService {

    /**
     * Gets musician dto list.
     *
     * @return the musician dto list
     */
    List<MusicianDto> getMusicianDtoList();

    /**
     * Gets musician by id.
     *
     * @param id the id
     * @return the musician
     */
    Musician getById(Integer id);

}
