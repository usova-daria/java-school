package com.javaschool.dao.impl.order;

import com.javaschool.dao.api.order.ShippingMethodDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.order.ShippingMethod;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingMethodDaoImpl extends AbstractDaoImpl<ShippingMethod, Integer> implements ShippingMethodDao {

    public ShippingMethodDaoImpl() {
        super(ShippingMethod.class);
    }

}
