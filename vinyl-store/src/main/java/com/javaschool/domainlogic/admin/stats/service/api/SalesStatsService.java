package com.javaschool.domainlogic.admin.stats.service.api;

import com.javaschool.domainlogic.admin.stats.dto.SalesStats;

public interface SalesStatsService {

    SalesStats getSalesStats();

    SalesStats getSalesStats(int year);

}
