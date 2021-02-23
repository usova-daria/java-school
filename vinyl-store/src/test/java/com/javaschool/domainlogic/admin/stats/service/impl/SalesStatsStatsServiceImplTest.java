package com.javaschool.domainlogic.admin.stats.service.impl;

import com.javaschool.dao.api.order.PaymentDetailsRepository;
import com.javaschool.domainlogic.admin.stats.dto.SalesStats;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SalesStatsStatsServiceImplTest {

    @Mock
    private PaymentDetailsRepository paymentDetailsRepository;

    @InjectMocks
    private SalesStatsStatsServiceImpl salesStatsService;

    private SalesStats expected2020Stats;

    @Before
    public void setUp() {
        fillData();
        defineMocks();
    }

    private void defineMocks() {
        LocalDate[] monthLastDate = get2020MonthLastDate();
        for (LocalDate lastDate : monthLastDate) {
            LocalDate firstDate = lastDate.withDayOfMonth(1);
            double total = expected2020Stats.getYearProfit().get(lastDate.getMonth());
            Mockito.when(paymentDetailsRepository.getTotalAmountBetween(firstDate, lastDate))
                   .thenReturn( total );
        }
    }

    private LocalDate[] get2020MonthLastDate() {
        LocalDate[] endOfTheMonth = new LocalDate[12];
        int year = 2020;

        endOfTheMonth[0] = LocalDate.of(year, 1, 31);
        endOfTheMonth[1] = LocalDate.of(year, 2, 29);
        endOfTheMonth[2] = LocalDate.of(year, 3, 31);
        endOfTheMonth[3] = LocalDate.of(year, 4, 30);
        endOfTheMonth[4] = LocalDate.of(year, 5, 31);
        endOfTheMonth[5] = LocalDate.of(year, 6, 30);
        endOfTheMonth[6] = LocalDate.of(year, 7, 31);
        endOfTheMonth[7] = LocalDate.of(year, 8, 31);
        endOfTheMonth[8] = LocalDate.of(year, 9, 30);
        endOfTheMonth[9] = LocalDate.of(year, 10, 31);
        endOfTheMonth[10] = LocalDate.of(year, 11, 30);
        endOfTheMonth[11] = LocalDate.of(year, 12, 31);

        return endOfTheMonth;
    }

    private void fillData() {
        Map<Month, Double> yearProfit = new HashMap<>();
        for (Month month : Month.values()) {
            yearProfit.put(month, month.getValue() * 100.0);
        }

        this.expected2020Stats = new SalesStats(yearProfit, 2020);
    }

    @Test
    public void getSalesStats() {
        SalesStats actual = salesStatsService.getSalesStats(2020);
        SalesStats expected = expected2020Stats;

        assertEquals(expected, actual);
    }

}