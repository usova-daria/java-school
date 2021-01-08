package com.javaschool.dao.impl.product;

import com.javaschool.config.JpaConfig;
import com.javaschool.dao.api.product.GenreDao;
import com.javaschool.dao.api.product.RecordDao;
import com.javaschool.entity.product.Genre;
import com.javaschool.entity.product.Record;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class})
@Transactional
public class RecordDaoImplTest {

    @Autowired
    private RecordDao recordDao;

    @Autowired
    private GenreDao genreDao;

    private List<Record> records = new ArrayList<>();
    private Genre jazz;
    private Genre rock;

    @Before
    public void setUp() {
        jazz = Genre.builder()
                .name("Jazz")
                .build();

        rock = Genre.builder()
                .name("Rock")
                .build();

        Record record1 = Record.rBuilder()
                .albumName("Jazz album")
                .name("Jazz album without author")
                .genre(jazz)
                .deleted(true)
                .build();

        Record record2 = Record.rBuilder()
                .albumName("Rock album")
                .name("Rock album without author")
                .genre(rock)
                .deleted(false)
                .build();

        Record record3 = Record.rBuilder()
                .albumName("Jazz album 2")
                .name("Jazz album 2 without author")
                .genre(jazz)
                .deleted(false)
                .build();

        genreDao.save(jazz);
        genreDao.save(rock);

        records.add(record1);
        records.add(record2);
        records.add(record3);
        recordDao.saveAll(records);
    }

    @Test
    public void findByGenre() {
        List<Record> jazzRecords = recordDao.findByGenre(jazz);

        String expectedGenreName = jazz.getName();
        jazzRecords.forEach(r -> assertEquals(expectedGenreName, r.getGenre().getName()));
    }

    @Test
    public void findAllByGenreAndDeletedFalse() {
        List<Record> records = recordDao.findByGenreAndDeletedFalse(jazz);

        String expectedGenreName = jazz.getName();
        records.forEach(r -> assertFalse(r.isDeleted()));
        records.forEach(r -> assertEquals(expectedGenreName, r.getGenre().getName()));
    }


}