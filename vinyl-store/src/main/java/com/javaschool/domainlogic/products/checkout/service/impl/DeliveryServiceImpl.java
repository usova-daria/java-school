package com.javaschool.domainlogic.products.checkout.service.impl;

import com.javaschool.dao.api.order.ShippingMethodRepository;
import com.javaschool.domainlogic.products.checkout.dto.DeliveryDto;
import com.javaschool.domainlogic.products.checkout.mapper.api.DeliveryMapper;
import com.javaschool.domainlogic.products.checkout.service.api.DeliveryService;
import com.javaschool.entity.order.ShippingMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryMapper deliveryMapper;

    @Autowired
    private ShippingMethodRepository shippingMethodRepository;

    @Override
    public List<DeliveryDto> getDeliveryOptions() {
        List<ShippingMethod> methods =  shippingMethodRepository.findAll();
        return deliveryMapper.toDtoList(methods);
    }
}
