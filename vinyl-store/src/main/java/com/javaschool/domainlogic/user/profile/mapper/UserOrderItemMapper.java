package com.javaschool.domainlogic.user.profile.mapper;

import com.javaschool.dao.impl.product.projection.OrderItemProjection;
import com.javaschool.domainlogic.user.profile.dto.order.UserOrderItem;
import com.javaschool.util.PictureEncoder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserOrderItemMapper {

    UserOrderItem toDto(OrderItemProjection orderItemProjection);

    List<UserOrderItem> toDtoList(List<OrderItemProjection> orderItemProjectionList);

    default String byteArrayToString(byte[] picture) {
        return PictureEncoder.toString(picture);
    }

}
