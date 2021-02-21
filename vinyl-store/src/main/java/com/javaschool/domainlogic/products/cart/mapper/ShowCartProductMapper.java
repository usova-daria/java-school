package com.javaschool.domainlogic.products.cart.mapper;

import com.javaschool.domainlogic.products.cart.dto.ShowCartProduct;
import com.javaschool.dao.impl.product.projection.ProductProjection;
import com.javaschool.util.ImageCompress;
import org.mapstruct.Mapper;

import java.util.Base64;
import java.util.List;

@Mapper
public interface ShowCartProductMapper {

    /**
     * Maps {@link ProductProjection} product projection to {@link ShowCartProduct} product dto
     *
     * @param productProjection product projection
     * @return product dto
     */
    ShowCartProduct toDto(ProductProjection productProjection);

    /**
     * Maps product projection list to product dto list
     *
     * @param productProjectionList product projection list
     * @return product dto list
     */
    List<ShowCartProduct> toDtoList(List<ProductProjection> productProjectionList);

    default String byteArrayToString(byte[] picture) {
        if (picture == null) return null;
        byte[] decodedPicture  = ImageCompress.decompressBytes(picture);
        return Base64.getEncoder().encodeToString(decodedPicture);
    }

}
