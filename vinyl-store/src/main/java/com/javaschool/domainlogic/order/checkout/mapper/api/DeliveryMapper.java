package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.checkout.dto.DeliveryDto;
import com.javaschool.entity.order.ShippingMethod;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {

    DeliveryDto toDto(ShippingMethod shippingMethod);

    List<DeliveryDto> toDtoList(List<ShippingMethod> shippingMethodList);

}
