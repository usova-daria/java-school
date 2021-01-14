package com.javaschool.domainlogic.admin.productmanagment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MusicianDto {

    /**
     * Musician id
     */
    private Integer id;

    /**
     * Musician name
     */
    private String name;

}
