package com.javaschool.domainlogic.admin.productmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Daria Usova
 */
@Data
@ToString
@NoArgsConstructor
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
