package com.javaschool.domainlogic.admin.productmanagement.service.impl;

import com.javaschool.dao.api.product.GenreRepository;
import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagement.exception.GenreNotFound;
import com.javaschool.domainlogic.admin.productmanagement.mapper.GenreMapper;
import com.javaschool.entity.product.Genre;
import com.javaschool.domainlogic.admin.productmanagement.service.api.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    @Transactional(readOnly = true)
    public List<GenreDto> getGenreDtoList() {
        List<Genre> genreList = genreRepository.findAll();
        return genreMapper.toDtoList(genreList);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GenreDto> getGenreDtoListOrderById() {
        List<Genre> genreList = genreRepository.findAllOrderById();
        return genreMapper.toDtoList(genreList);
    }

    @Override
    @Transactional
    public GenreDto saveGenre(GenreDto genreDto) {
        Genre genre = genreMapper.toEntity(genreDto);
        genre = genreRepository.save(genre);
        return genreMapper.toDto(genre);
    }

    @Override
    @Transactional
    public GenreDto updateGenre(GenreDto genreDto) {
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
    public GenreDto saveOrUpdate(GenreDto genreDto) {
        Optional<Genre> genreOptional = genreRepository.findById(genreDto.getId());
        return genreOptional.map(o -> updateGenre(genreDto))
                     .orElseGet(() -> saveGenre(genreDto));
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        genreRepository.deleteById(id);
    }

}
