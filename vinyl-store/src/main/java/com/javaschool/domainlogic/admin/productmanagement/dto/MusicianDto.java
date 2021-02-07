package com.javaschool.domainlogic.admin.productmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class MusicianDto implements Serializable {

    /**
     * Musician id
     */
    private Integer id;

    /**
     * Musician name
     */
    private String name;

}
