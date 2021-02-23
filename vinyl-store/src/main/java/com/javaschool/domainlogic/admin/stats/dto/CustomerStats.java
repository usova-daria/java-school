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
public class CustomerStats implements Serializable {

    /**
     * List of best customers
     */
    private List<CustomerData> bestCustomers;

}
