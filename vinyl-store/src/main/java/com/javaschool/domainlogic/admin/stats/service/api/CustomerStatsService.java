package com.javaschool.domainlogic.admin.stats.service.api;

import com.javaschool.domainlogic.admin.stats.dto.CustomerStats;

/**
 * @author Daria Usova
 */
public interface CustomerStatsService {

    /**
     * Gets customer stats.
     *
     * @return the customer stats
     */
    CustomerStats getCustomerStats();

}
