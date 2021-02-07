package com.javaschool.domainlogic.admin.productmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GenreDto implements Serializable {

    /**
     * Genre id
     */
    private Integer id;

    /**
     * Genre name
     */
    private String name;

}
