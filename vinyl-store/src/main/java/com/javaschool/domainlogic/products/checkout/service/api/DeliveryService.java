package com.javaschool.domainlogic.products.checkout.service.api;

import com.javaschool.domainlogic.products.checkout.dto.DeliveryDto;

import java.util.List;

public interface DeliveryService {

    List<DeliveryDto> getDeliveryOptions();

}
