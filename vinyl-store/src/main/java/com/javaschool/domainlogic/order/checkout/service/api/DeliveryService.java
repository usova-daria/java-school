package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.checkout.dto.DeliveryDto;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface DeliveryService {

    /**
     * Gets delivery options.
     *
     * @return the delivery options
     */
    List<DeliveryDto> getDeliveryOptions();

}
