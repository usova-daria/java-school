package com.javaschool.domainlogic.admin.order.mapper;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

/**
 * @author Daria Usova
 */
public class AdminOrderInfoMapperTest {

    AdminOrderInfoMapper adminOrderInfoMapper = spy(AdminOrderInfoMapper.class);

    @Test
    public void createdToStringNullInput() {
        LocalDate input = null;

        String expected = "NA";
        String actual = adminOrderInfoMapper.createdToString(input);

        assertEquals(expected, actual);
    }

    @Test
    public void createdToStringNotNullInput() {
        LocalDate input = LocalDate.of(2020, Month.JUNE, 15);

        String expected = "Jun 15, 2020";
        String actual = adminOrderInfoMapper.createdToString(input);

        assertEquals(expected, actual);
    }

}