package com.javaschool.domainlogic.salesdisplay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreProfit implements Serializable {

    private String genreName;
    private Double profit;

}
