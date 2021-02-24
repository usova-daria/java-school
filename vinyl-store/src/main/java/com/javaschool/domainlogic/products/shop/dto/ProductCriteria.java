package com.javaschool.domainlogic.products.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Daria Usova
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCriteria {

    /**
     * Genres id array
     */
    private Integer[] genre;

    /**
     * Max price
     */
    private float maxPrice;

    /**
     * Min price
     */
    private float minPrice;

    /**
     * Is product available
     */
    private boolean available;

    /**
     * The record name must contain (nameContains)
     */
    private String nameContains;

    /**
     * Sort by price with products with high price first
     */
    private boolean highPriceFirst;

}
