package com.javaschool.domainlogic.order.checkout.dto;

import lombok.Data;

/**
 * @author Daria Usova
 */
@Data
public class DeliveryDto {

    /**
     * Delivery option id
     */
    private Integer id;

    /**
     * Delivery company name
     */
    private String companyName;

}
