package com.javaschool.domainlogic.admin.stats.service.impl;

import com.javaschool.dao.api.user.UserRepository;
import com.javaschool.domainlogic.admin.stats.dto.CustomerData;
import com.javaschool.domainlogic.admin.stats.dto.CustomerStats;
import com.javaschool.domainlogic.admin.stats.service.api.CustomerStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerStatsServiceImpl implements CustomerStatsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomerStats getCustomerStats() {
        List<CustomerData> bestCustomers = getTop10CustomersByNumberOfOrders();
        return new CustomerStats(bestCustomers);
    }

    public List<CustomerData> getTop10CustomersByNumberOfOrders() {
        return userRepository.findTopCustomersByNumberOfOrders(10);
    }

}
