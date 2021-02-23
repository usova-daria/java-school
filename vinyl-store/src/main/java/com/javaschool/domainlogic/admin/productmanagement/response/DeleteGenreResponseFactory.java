package com.javaschool.domainlogic.admin.productmanagement.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Daria Usova
 */
public class DeleteGenreResponseFactory {

    private DeleteGenreResponseFactory() {
    }

    /**
     * Gets genre is deleted response entity.
     *
     * @return the genre is deleted
     */
    public static ResponseEntity<String> getGenreIsDeleted() {
        return ResponseEntity.ok().body("Genre has been deleted");
    }

    /**
     * Gets genre is not deleted response entity.
     *
     * @return the genre is not deleted
     */
    public static ResponseEntity<String> getGenreIsNotDeleted() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Genre has not been deleted");
    }

    /**
     * Gets impossible to delete genre response entity.
     *
     * @return the impossible delete genre
     */
    public static ResponseEntity<String> getImpossibleToDeleteGenre(long numberOfRecords) {
        return ResponseEntity.badRequest().body("Genre has not been deleted. There are records (" +
                numberOfRecords + ") of this genre.");
    }

}
