package com.javaschool.domainlogic.user.profile.mapper.order;

import com.javaschool.entity.order.ShippingMethod;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

/**
 * @author Daria Usova
 */
public class UserOrderInfoMapperTest {

    private UserOrderInfoMapper mapper = spy(UserOrderInfoMapper.class);

    @Test
    public void shippingMethodToString_NullInput() {
        assertEquals("NA", mapper.shippingMethodToString(null));
    }

    @Test
    public void shippingMethodToString_NotNullInput() {
        ShippingMethod shippingMethod = new ShippingMethod();

        String companyName = "company name";
        shippingMethod.setCompanyName(companyName);

        assertEquals(companyName, mapper.shippingMethodToString(shippingMethod));
    }

    @Test
    public void createdToString_NullInput() {
        assertEquals("NA", mapper.createdToString(null));
    }

    @Test
    public void createdToString_NotNullInput() {
        LocalDate created = LocalDate.of(2021, Month.FEBRUARY, 24);
        String expected = "Feb 24, 2021";

        assertEquals(expected, mapper.createdToString(created));
    }

}