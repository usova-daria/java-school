package com.javaschool.domainlogic.admin.productmanagement.service.api;

import com.javaschool.domainlogic.admin.productmanagement.dto.AddRecordDto;
import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagement.dto.MusicianDto;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface AddRecordService {

    /**
     * Save record.
     *
     * @param recordDto the record dto
     */
    void saveRecord(AddRecordDto recordDto);

    /**
     * Gets genres.
     *
     * @return the genres
     */
    List<GenreDto> getGenres();

    /**
     * Gets musicians.
     *
     * @return the musicians
     */
    List<MusicianDto> getMusicians();

}
