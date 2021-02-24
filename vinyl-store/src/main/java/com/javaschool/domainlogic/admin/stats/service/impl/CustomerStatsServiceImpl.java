package com.javaschool.domainlogic.admin.stats.service.impl;

import com.javaschool.dao.api.user.UserRepository;
import com.javaschool.domainlogic.admin.stats.dto.CustomerData;
import com.javaschool.domainlogic.admin.stats.dto.CustomerStats;
import com.javaschool.domainlogic.admin.stats.service.api.CustomerStatsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daria Usova
 */
@Log4j
@Service
@RequiredArgsConstructor
public class CustomerStatsServiceImpl implements CustomerStatsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public CustomerStats getCustomerStats() {
        List<CustomerData> bestCustomers;
        try {
             bestCustomers = userRepository.findTopCustomersByNumberOfOrders(10);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding top 10 customers", e);
            bestCustomers = new ArrayList<>();
        }
        return new CustomerStats(bestCustomers);
    }

}
