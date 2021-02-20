package com.javaschool.domainlogic.products.common.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class ProductDto implements Serializable {

    /**
     * Product id
     */
    private Long id;

    /**
     * Product price
     */
    private float price;

    /**
     * Product name
     */
    private String name;

    /**
     * Product picture
     */
    @ToString.Exclude
    private String picture;

    /**
     * True if the product is available (there is at least one item in the store),
     * false - otherwise
     */
    private boolean available;

}
