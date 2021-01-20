package com.javaschool.domainlogic.admin.productmanagment.service.api;

import com.javaschool.domainlogic.admin.productmanagment.dto.AddRecordDto;
import com.javaschool.domainlogic.admin.productmanagment.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagment.dto.MusicianDto;

import java.util.List;

public interface AddRecordService {

    Long saveRecord(AddRecordDto recordDto);

    List<GenreDto> getGenres();

    List<MusicianDto> getMusicians();

}
