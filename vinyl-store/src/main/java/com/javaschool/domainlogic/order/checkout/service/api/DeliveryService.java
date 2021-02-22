package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.checkout.dto.DeliveryDto;

import java.util.List;

public interface DeliveryService {

    List<DeliveryDto> getDeliveryOptions();

}
