package com.javaschool.domainlogic.admin.productmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Year;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class AddRecordDto implements Serializable {

    /**
     * Record's price
     */
    @Min(value = 0, message = "{price.negative}")
    private float price;

    /**
     * Number of units in store
     */
    @Min(value = 0, message = "{units.in.store.negative}")
    private int unitsInStore;

    /**
     * Record's name to show on products page
     */
    @Length(min = 1, max = 70, message = "{record.name.length}")
    private String name;

    /**
     * Image of the record
     */
    @ToString.Exclude
    private MultipartFile picture;

    /**
     * Record's description
     */
    @Length(max = 2000, message = "{record.description.length}")
    private String description;

    /**
     * Name of the album
     */
    @Length(min = 1, max = 45, message = "{record.album.name.length}")
    private String albumName;

    /**
     * Release year
     */
    private Year year;

    /**
     * Genre
     */
    @NotNull(message = "{record.genre.null}")
    private Integer genreId;

    /**
     * Musicians participated in the recording
     */
    @Size(min = 1, message = "{record.musician.size}")
    private List<Integer> musicianIdList;

}