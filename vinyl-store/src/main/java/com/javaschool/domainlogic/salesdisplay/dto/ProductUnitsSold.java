package com.javaschool.domainlogic.salesdisplay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUnitsSold implements Serializable {

    private Long id;
    private String name;
    private long unitsSold;

}
