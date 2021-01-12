package com.javaschool.domainlogic.admin.stats.service.impl;

import com.javaschool.dao.api.order.PaymentDetailsRepository;
import com.javaschool.domainlogic.admin.stats.dto.SalesStats;
import com.javaschool.domainlogic.admin.stats.service.api.SalesStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Transactional
public class SalesStatsStatsServiceImpl implements SalesStatsService {

    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;

    @Override
    public SalesStats getSalesStats() {
        int year = LocalDate.now().getYear();
        return getSalesStats(year);
    }

    @Override
    public SalesStats getSalesStats(int year) {
        Map<Month, Double> yearProfit = getYearProfit(year);
        double lastWeekProfit = getWeekProfit(LocalDate.now());
        return new SalesStats(yearProfit, lastWeekProfit);
    }

    private Map<Month, Double> getYearProfit(int year) {
        Map<Month, Double> yearProfit = new LinkedHashMap<>();

        for (Month month : Month.values()) {
            LocalDate date = LocalDate.of(year, month, 1);
            double monthProfit = getMonthProfit(date);

            yearProfit.put(month, monthProfit);
        }

        return yearProfit;
    }

    private double getMonthProfit(LocalDate date) {
        LocalDate from = date.withDayOfMonth(1);
        int lastDayOfMonth = date.lengthOfMonth();
        LocalDate to = date.withDayOfMonth(lastDayOfMonth);

        return paymentDetailsRepository.getTotalAmountBetween(from, to);
    }

    private double getWeekProfit(LocalDate date) {
        int startOfWeek = date.getDayOfMonth() - (date.getDayOfWeek().getValue() - 1);
        LocalDate from = date.withDayOfMonth(startOfWeek);
        LocalDate to = from.plusDays(6);

        return paymentDetailsRepository.getTotalAmountBetween(from, to);
    }

}
