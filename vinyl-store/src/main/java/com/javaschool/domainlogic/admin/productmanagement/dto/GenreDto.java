package com.javaschool.domainlogic.admin.productmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Daria Usova
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {

    /**
     * Genre id
     */
    private Integer id;

    /**
     * Genre name
     */
    @NotNull(message = "{genre.name.null}")
    @Size(min = 1, max = 45, message = "{genre.name.length}")
    private String name;

}
