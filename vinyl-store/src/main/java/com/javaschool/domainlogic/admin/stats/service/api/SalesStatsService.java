package com.javaschool.domainlogic.admin.stats.service.api;

import com.javaschool.domainlogic.admin.stats.dto.SalesStats;
import org.springframework.ui.ModelMap;

public interface SalesStatsService {

    SalesStats getSalesStats();

    SalesStats getSalesStats(int year);

    int getFirstPaymentYear();

    void fillModelMap(int year, ModelMap modelMap);

    void fillModelMap(ModelMap modelMap);

}
