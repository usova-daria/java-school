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
public class CustomerData implements Serializable {

    /**
     * Customer's first name
     */
    private String firstName;

    /**
     * Customer's last name
     */
    private String lastName;

    /**
     * Customer's email
     */
    private String email;

    /**
     * Total number of orders placed by the customer
     */
    private long numberOfOrders;



}
