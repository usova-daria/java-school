package com.javaschool.domainlogic.admin.productmanagment.service.impl;

import com.javaschool.dao.api.product.GenreRepository;
import com.javaschool.domainlogic.admin.productmanagment.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagment.mapper.GenreMapper;
import com.javaschool.entity.product.Genre;
import com.javaschool.domainlogic.admin.productmanagment.service.api.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<GenreDto> getGenreDtoList() {
        List<Genre> genreList = genreRepository.findAll();
        List<GenreDto> genreDtoList = genreMapper.toDtoList(genreList);
        return genreDtoList;
    }

    @Override
    public void saveGenre(GenreDto genreDto) {
        Genre genre = genreMapper.toEntity(genreDto);
        genreRepository.save(genre);
    }

    @Override
    public void updateGenre(GenreDto genreDto) {
        Optional<Genre> genre = genreRepository.findById(genreDto.getId());

        genre.ifPresent(g -> {
            g.setName(genreDto.getName());
            genreRepository.update(g);
        });
    }

    @Override
    public Genre findById(Integer id) {
        return genreRepository.findById(id).orElse(null);
    }
}
