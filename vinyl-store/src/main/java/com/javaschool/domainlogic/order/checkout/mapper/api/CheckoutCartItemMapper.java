package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.dao.impl.product.projection.ProductNamePriceProjection;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutCartItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CheckoutCartItemMapper {

    CheckoutCartItem toDto(ProductNamePriceProjection productNamePriceProjection);

    List<CheckoutCartItem> toDtoList(List<ProductNamePriceProjection> productNamePriceProjections);

}
