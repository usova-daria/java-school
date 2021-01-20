package com.javaschool.domainlogic.admin.stats.service.impl;

import com.javaschool.dao.api.user.UserRepository;
import com.javaschool.domainlogic.admin.stats.dto.CustomerData;
import com.javaschool.domainlogic.admin.stats.dto.CustomerStats;
import com.javaschool.domainlogic.admin.stats.service.api.CustomerStatsService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class CustomerStatsServiceImpl implements CustomerStatsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public CustomerStats getCustomerStats() {
        List<CustomerData> bestCustomers;
        try {
             bestCustomers = getTop10CustomersByNumberOfOrders();
        } catch (PersistenceException e) {
            log.error("An error occurred while finding top 10 customers", e);
            bestCustomers = new ArrayList<>();
        }
        return new CustomerStats(bestCustomers);
    }

    public List<CustomerData> getTop10CustomersByNumberOfOrders() {
        return userRepository.findTopCustomersByNumberOfOrders(10);
    }

}
