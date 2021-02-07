package com.javaschool.domainlogic.admin.productmanagement.service.api;

import com.javaschool.domainlogic.admin.productmanagement.dto.AddRecordDto;
import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagement.dto.MusicianDto;

import java.util.List;

public interface AddRecordService {

    Long saveRecord(AddRecordDto recordDto);

    List<GenreDto> getGenres();

    List<MusicianDto> getMusicians();

}
