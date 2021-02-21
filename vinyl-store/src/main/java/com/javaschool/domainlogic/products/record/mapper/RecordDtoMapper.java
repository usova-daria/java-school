package com.javaschool.domainlogic.products.record.mapper;

import com.javaschool.domainlogic.products.record.dto.RecordDto;
import com.javaschool.entity.product.Genre;
import com.javaschool.entity.product.Musician;
import com.javaschool.entity.product.Record;
import com.javaschool.util.ImageCompress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface RecordDtoMapper {

    @Mapping(target = "available", source = "unitsInStore")
    RecordDto toDto(Record record);

    default boolean unitsInStoreToAvailable(int unitsInStore) {
        return unitsInStore > 0;
    }

    // TODO: duplication of code -> see ProductDtoMapper
    default String byteArrayToString(byte[] picture) {
        if (picture == null) return null;
        byte[] decodedPicture  = ImageCompress.decompressBytes(picture);
        return Base64.getEncoder().encodeToString(decodedPicture);
    }

    default String genreToString(Genre genre) {
        if (genre == null) return "NA";
        return genre.getName();
    }

    default String musiciansToString(List<Musician> musicians) {
        if (musicians == null) return "NA";

        List<String> musiciansNames =  musicians.stream()
                                                .map(Musician::getName)
                                                .collect(Collectors.toList());

        return String.join("\n", musiciansNames);
    }

}
