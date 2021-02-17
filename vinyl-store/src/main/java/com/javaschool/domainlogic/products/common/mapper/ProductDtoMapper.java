package com.javaschool.domainlogic.products.common.mapper;

import com.javaschool.domainlogic.products.common.dto.ProductDto;
import com.javaschool.domainlogic.products.common.dto.ProductProjection;
import com.javaschool.util.ImageCompress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

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
    @Mapping(source = "unitsInStore", target = "available", qualifiedByName = "unitsInStoreToAvailable")
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

    @Named("unitsInStoreToAvailable")
    default boolean unitsInStoreToAvailable(int unitsInStore) {
        return unitsInStore > 0;
    }

}
