package com.javaschool.domainlogic.admin.stats.service.api;

import com.javaschool.domainlogic.admin.stats.dto.SalesStats;
import org.springframework.ui.ModelMap;

/**
 * @author Daria Usova
 */
public interface SalesStatsService {

    /**
     * Gets sales stats of this year.
     *
     * @return the sales stats
     */
    SalesStats getSalesStats();

    /**
     * Gets sales stats by year.
     *
     * @param year the year
     * @return the sales stats
     */
    SalesStats getSalesStats(int year);

    /**
     * Gets first payment year.
     *
     * @return the first payment year
     */
    int getFirstPaymentYear();

    /**
     * Gets sales stats by year and fills model map.
     *
     * @param year     the year
     * @param modelMap the model map
     */
    void fillModelMap(int year, ModelMap modelMap);

    /**
     * Get sales stats for this year and fills model map.
     *
     * @param modelMap the model map
     */
    void fillModelMap(ModelMap modelMap);

}
