package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.checkout.dto.DeliveryDto;
import com.javaschool.entity.order.ShippingMethod;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Daria Usova
 */
@Mapper
public interface DeliveryMapper {

    /**
     * Maps entity to dto.
     *
     * @param shippingMethod the shipping method
     * @return the delivery dto
     */
    DeliveryDto toDto(ShippingMethod shippingMethod);

    /**
     * Maps entity list to dto list.
     *
     * @param shippingMethodList the shipping method list
     * @return the list
     */
    List<DeliveryDto> toDtoList(List<ShippingMethod> shippingMethodList);

}
