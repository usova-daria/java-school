package com.javaschool.domainlogic.admin.stats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Daria Usova
 */
@Data
@ToString
@AllArgsConstructor
public class ProductData implements Serializable {

    /**
     * Id of the product
     */
    private Long id;

    /**
     * Name of the product
     */
    private String name;

    /**
     * Number of units sold
     */
    private long unitsSold;

}
