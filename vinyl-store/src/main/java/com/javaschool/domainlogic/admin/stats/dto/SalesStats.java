package com.javaschool.domainlogic.admin.stats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.Month;
import java.time.Year;
import java.util.Map;

/**
 * @author Daria Usova
 */
@Data
@AllArgsConstructor
public class SalesStats implements Serializable {

    /**
     *  A {@link Map} collection that contains {@link Month} as
     *  key and {@link Double} (month profit) as value
     */
    private Map<Month, Double> yearProfit;

    /**
     *  Year
     */
    private int year;

}
