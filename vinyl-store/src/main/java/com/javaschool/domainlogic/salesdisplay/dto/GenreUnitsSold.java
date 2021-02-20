package com.javaschool.domainlogic.salesdisplay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreUnitsSold {

    private Long unitsSold;
    private String genreName;

}
