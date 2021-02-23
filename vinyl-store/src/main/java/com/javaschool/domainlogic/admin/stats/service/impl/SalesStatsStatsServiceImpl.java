package com.javaschool.domainlogic.admin.stats.service.impl;

import com.javaschool.dao.api.order.PaymentDetailsRepository;
import com.javaschool.domainlogic.admin.stats.dto.SalesStats;
import com.javaschool.domainlogic.admin.stats.service.api.SalesStatsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Daria Usova
 */
@Log4j
@Service
@RequiredArgsConstructor
public class SalesStatsStatsServiceImpl implements SalesStatsService {

    private final PaymentDetailsRepository paymentDetailsRepository;

    @Override
    @Transactional(readOnly = true)
    public SalesStats getSalesStats() {
        int year = LocalDate.now().getYear();
        return getSalesStats(year);
    }

    @Override
    @Transactional(readOnly = true)
    public SalesStats getSalesStats(int year) {
        Map<Month, Double> yearProfit = getYearProfit(year);
        return new SalesStats(yearProfit, year);
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

        double monthProfit;
        try {
           monthProfit = paymentDetailsRepository.getTotalAmountBetween(from, to);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding month profit between " +
                    from + "to " + to, e);
            monthProfit = 0;
        }

        return monthProfit;
    }

    @Override
    @Transactional(readOnly = true)
    public int getFirstPaymentYear() {
        try {
            LocalDate firstPaymentDate = paymentDetailsRepository.getMinPaymentDate();
            return firstPaymentDate.getYear();
        } catch (PersistenceException e) {
            log.error("An error occurred while getting the year of first payment date", e);
            return LocalDate.now().getYear() - 5;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void fillModelMap(int year, ModelMap modelMap) {
        SalesStats salesStats = getSalesStats(year);
        modelMap.addAttribute("salesStats", salesStats);
    }

    @Override
    @Transactional(readOnly = true)
    public void fillModelMap(ModelMap modelMap) {
        SalesStats salesStats = getSalesStats();
        int firstPaymentYear = getFirstPaymentYear();

        modelMap.addAttribute("salesStats", salesStats);
        modelMap.addAttribute("firstPaymentYear", firstPaymentYear);
    }

}
