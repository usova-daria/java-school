package com.javaschool.domainlogic.admin.productmanagement.service.api;

import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.entity.product.Genre;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface GenreService {

    /**
     * Gets genre dto list.
     *
     * @return the genre dto list
     */
    List<GenreDto> getGenreDtoList();

    /**
     * Saves genre.
     *
     * @param genreDto the genre dto
     * @return the genre dto
     */
    ResponseEntity<GenreDto> saveGenre(GenreDto genreDto);

    /**
     * Updates genre.
     *
     * @param genreDto the genre dto
     * @return the genre dto
     */
    ResponseEntity<GenreDto> updateGenre(GenreDto genreDto);

    /**
     * Finds genre by id.
     *
     * @param id the id
     * @return the genre
     */
    Genre findById(Integer id);

    /**
     * Saves or updates genre.
     *
     * @param genreDto the genre dto
     * @return the genre dto
     */
    ResponseEntity<GenreDto> saveOrUpdate(GenreDto genreDto);


    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return true if the genre is deleted, false otherwise
     */
    ResponseEntity<String> deleteById(Integer id);

}
