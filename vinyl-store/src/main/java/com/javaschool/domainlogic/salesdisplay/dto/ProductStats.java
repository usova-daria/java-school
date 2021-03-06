package com.javaschool.domainlogic.salesdisplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStats implements Serializable {

    private HashMap<String, Double> profitByGenre;
    private HashMap<String, Long> unitsSoldByGenre;
    private List<ProductUnitsSold> topProducts;

}
