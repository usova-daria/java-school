package com.javaschool.domainlogic.products.home.mapper;

import com.javaschool.domainlogic.products.dto.ProductDto;
import com.javaschool.domainlogic.products.dto.ProductProjection;
import com.javaschool.util.ImageCompress;
import org.mapstruct.Mapper;

import java.util.Base64;
import java.util.List;

@Mapper
public interface ProductDtoMapper {

    /**
     * Maps {@link ProductProjection} product projection to {@link ProductDto} product dto
     *
     * @param productProjection product projection
     * @return product dto
     */
    ProductDto toDto(ProductProjection productProjection);

    /**
     * Maps product projection list to product dto list
     *
     * @param productProjectionList genre entity list
     * @return product dto list
     */
    List<ProductDto> toDtoList(List<ProductProjection> productProjectionList);

    default String byteArrayToString(byte[] picture) {
        if (picture == null) return null;
        byte[] decodedPicture  = ImageCompress.decompressBytes(picture);
        return Base64.getEncoder().encodeToString(decodedPicture);
    }

}
