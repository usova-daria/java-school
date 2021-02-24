package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.dao.impl.product.projection.ProductNamePriceProjection;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutCartItem;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Daria Usova
 */
@Mapper
public interface CheckoutCartItemMapper {

    /**
     * Maps product projection to cart item.
     *
     * @param productNamePriceProjection the product name price projection
     * @return the checkout cart item
     */
    CheckoutCartItem toDto(ProductNamePriceProjection productNamePriceProjection);

    /**
     * Maps product projection list to cart item list.
     *
     * @param productNamePriceProjections the product name price projections
     * @return the list
     */
    List<CheckoutCartItem> toDtoList(List<ProductNamePriceProjection> productNamePriceProjections);

}
