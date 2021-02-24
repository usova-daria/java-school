package com.javaschool.domainlogic.user.profile.mapper.order;

import com.javaschool.dao.impl.product.projection.OrderItemProjection;
import com.javaschool.domainlogic.user.profile.dto.order.UserOrderItem;
import com.javaschool.util.PictureEncoder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author Daria Usova
 */
@Mapper
public interface UserOrderItemMapper {

    /**
     * Maps order item projection to user order item.
     *
     * @param orderItemProjection the order item projection
     * @return the user order item
     */
    @Mapping(target = "quantity", source = "quantity")
    UserOrderItem toDto(OrderItemProjection orderItemProjection);

    /**
     * Maps list of order item projections to list of user order items.
     *
     * @param orderItemProjectionList the order item projection list
     * @return the list
     */
    List<UserOrderItem> toDtoList(List<OrderItemProjection> orderItemProjectionList);

    /**
     * Maps byte array to string.
     *
     * @param picture the picture
     * @return the string
     */
    default String byteArrayToString(byte[] picture) {
        return PictureEncoder.toString(picture);
    }

}
