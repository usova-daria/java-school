package com.javaschool.domainlogic.admin.productmanagement.service.impl;

import com.javaschool.dao.api.product.GenreRepository;
import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagement.exception.GenreNotFound;
import com.javaschool.domainlogic.admin.productmanagement.mapper.GenreMapper;
import com.javaschool.domainlogic.admin.productmanagement.service.api.GenreService;
import com.javaschool.entity.product.Genre;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.javaschool.domainlogic.admin.productmanagement.response.UpdateOrSaveGenreResponseFactory.*;
import static com.javaschool.domainlogic.admin.productmanagement.response.DeleteGenreResponseFactory.*;

@Log4j
@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreMapper genreMapper;
    private final GenreRepository genreRepository;

    @Override
    @Transactional(readOnly = true)
    public List<GenreDto> getGenreDtoList() {
        List<GenreDto> genreDtoList = new ArrayList<>();

        try {
            List<Genre> genreList = genreRepository.findAllOrderById();
            genreDtoList = genreMapper.toDtoList(genreList);
        } catch (PersistenceException e) {
            log.error("An error occurred while getting genre list", e);
        }

        return genreDtoList;
    }

    @Override
    @Transactional
    public ResponseEntity<GenreDto> saveGenre(GenreDto genreDto) {
        Genre genre = genreMapper.toEntity(genreDto);

        try {
            genre = genreRepository.save(genre);
        } catch (PersistenceException e) {
            log.error("An error occurred while saving a genre", e);
            return getFailedToSaveOrUpdate(genreDto);
        }

        return getGenreIsSavedOrUpdated( genreMapper.toDto(genre) );
    }

    @Override
    @Transactional
    public ResponseEntity<GenreDto> updateGenre(GenreDto genreDto) {
        try {
           GenreDto updated = tryToUpdateGenre(genreDto);
           return getGenreIsSavedOrUpdated(updated);
        } catch (PersistenceException e) {
            log.error("An error occurred while updating genre with id=" + genreDto.getId(), e);
            return getFailedToSaveOrUpdate(genreDto);
        } catch (GenreNotFound e) {
            return getGenreNotFound();
        }
    }

    private GenreDto tryToUpdateGenre(GenreDto genreDto) {
        Genre genre = findById(genreDto.getId());

        genre.setName(genreDto.getName());
        genre = genreRepository.update(genre);
        return genreMapper.toDto(genre);
    }

    @Override
    @Transactional(readOnly = true)
    public Genre findById(Integer id) {
        return genreRepository.findById(id).orElseThrow(GenreNotFound::new);
    }

    @Override
    @Transactional
    public ResponseEntity<GenreDto> saveOrUpdate(GenreDto genreDto) {
        try {
            Optional<Genre> genreOptional = genreRepository.findById(genreDto.getId());
            return genreOptional.map(o -> updateGenre(genreDto))
                    .orElseGet(() -> saveGenre(genreDto));
        } catch (PersistenceException e) {
            log.error("An error occurred while getting a genre by id=" + genreDto.getId(), e);
            return getFailedToSaveOrUpdate(genreDto);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteById(Integer id) {
        try {
            return tryToDeleteById(id);
        } catch (PersistenceException e) {
            log.error("An error occurred while deleting a genre with id=" + id, e);
            return getGenreIsNotDeleted();
        }
    }

    private ResponseEntity<String> tryToDeleteById(Integer id) {
        long numberOfRecords = genreRepository.findNumberOfRecordByGenreId(id);
        if (numberOfRecords > 0) {
            return getImpossibleToDeleteGenre(numberOfRecords);
        }

        return genreRepository.deleteById(id) ? getGenreIsDeleted() : getGenreIsNotDeleted();
    }

}
