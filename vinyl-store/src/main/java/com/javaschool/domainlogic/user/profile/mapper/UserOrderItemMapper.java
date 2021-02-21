package com.javaschool.domainlogic.user.profile.mapper;

import com.javaschool.dao.impl.product.projection.OrderItemProjection;
import com.javaschool.domainlogic.user.profile.dto.order.UserOrderItem;
import com.javaschool.util.PictureEncoder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserOrderItemMapper {

    @Mapping(target = "quantity", source = "quantity")
    UserOrderItem toDto(OrderItemProjection orderItemProjection);

    List<UserOrderItem> toDtoList(List<OrderItemProjection> orderItemProjectionList);

    default String byteArrayToString(byte[] picture) {
        return PictureEncoder.toString(picture);
    }

}
