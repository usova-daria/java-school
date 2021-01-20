package com.javaschool.domainlogic.admin.productmanagment.mapper;

import com.javaschool.domainlogic.admin.productmanagment.dto.AddRecordDto;
import com.javaschool.domainlogic.admin.productmanagment.service.api.GenreService;
import com.javaschool.domainlogic.admin.productmanagment.service.api.MusicianService;
import com.javaschool.entity.product.Record;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(uses = {GenreMapper.class, MusicianMapper.class,
        GenreService.class, MusicianService.class})
public interface AddRecordMapper {

    /**
     * Maps record dto to record entity
     *
     * @param addRecordDto record dto
     * @return record entity
     */
    @Mapping(target = "deleted", ignore = true)
    @Mapping(source = "genreId", target = "genre")
    @Mapping(source = "musicianIdList", target = "musicians")
    Record toEntity(AddRecordDto addRecordDto);

    /**
     * From file to byte array
     *
     * @param file file to be converted
     * @return byte array
     * @throws IOException
     */
    default byte[] toBytes(MultipartFile file) throws IOException {
        return file == null ? null : file.getBytes();
    }

}