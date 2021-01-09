package com.javaschool.dao.impl.order;

import com.javaschool.dao.api.order.ShippingMethodRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.order.ShippingMethod;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingMethodRepositoryImpl extends AbstractRepositoryImpl<ShippingMethod, Integer> implements ShippingMethodRepository {

    public ShippingMethodRepositoryImpl() {
        super(ShippingMethod.class);
    }

}
