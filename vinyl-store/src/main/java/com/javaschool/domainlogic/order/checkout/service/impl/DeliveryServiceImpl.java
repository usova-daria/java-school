package com.javaschool.domainlogic.order.checkout.service.impl;

import com.javaschool.dao.api.order.ShippingMethodRepository;
import com.javaschool.domainlogic.order.checkout.dto.DeliveryDto;
import com.javaschool.domainlogic.order.checkout.mapper.api.DeliveryMapper;
import com.javaschool.domainlogic.order.checkout.service.api.DeliveryService;
import com.javaschool.entity.order.ShippingMethod;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryMapper deliveryMapper;

    @Autowired
    private ShippingMethodRepository shippingMethodRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DeliveryDto> getDeliveryOptions() {
        List<ShippingMethod> methods;
        try {
            methods = shippingMethodRepository.findAll();
        } catch (PersistenceException e) {
            log.error("An error occurred while getting delivery options", e);
            methods = new ArrayList<>();
        }

        return deliveryMapper.toDtoList(methods);
    }
}
