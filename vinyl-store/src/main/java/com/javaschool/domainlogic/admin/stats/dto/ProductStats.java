package com.javaschool.domainlogic.admin.stats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Daria Usova
 */
@Data
@AllArgsConstructor
public class ProductStats implements Serializable {

    /**
     * List of top products
     */
    private List<ProductData> topProducts;

}
