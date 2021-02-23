package com.javaschool.domainlogic.admin.productmanagement.response;

import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Daria Usova
 */
public class UpdateOrSaveGenreResponseFactory {

    private UpdateOrSaveGenreResponseFactory() { }

    /**
     * Gets ok response entity.
     *
     * @param genreDto the genre dto
     * @return response entity
     */
    public static ResponseEntity<GenreDto> getGenreIsSavedOrUpdated(GenreDto genreDto) {
        return ResponseEntity.ok().body(genreDto);
    }

    /**
     * Gets service unavailable response.
     *
     * @param genreDto the genre dto
     * @return response entity
     */
    public static ResponseEntity<GenreDto> getFailedToSaveOrUpdate(GenreDto genreDto) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(genreDto);
    }

    /**
     * Gets genre not found response.
     *
     * @return the genre not found
     */
    public static ResponseEntity<GenreDto> getGenreNotFound() {
        return ResponseEntity.badRequest().body(null);
    }

}
