package com.javaschool.domainlogic.products.home.service;

import com.javaschool.dao.impl.product.projection.ProductNamePriceProjection;
import com.javaschool.dao.impl.product.projection.ProductPriceProjection;
import com.javaschool.dao.impl.product.projection.ProductUnitsInStoreProjection;
import com.javaschool.domainlogic.products.common.dto.ProductDto;
import com.javaschool.dao.impl.product.projection.ProductProjection;

import java.util.List;

public interface ProductService {

    List<ProductDto> getNotDeletedProductsSortedByCreated(int resultSize);

    ProductDto getProductById(Long id);

    int getUnitsInStoreById(Long id);

    List<ProductPriceProjection> getPriceByProductId(List<Long> idList);

    boolean getDeletedById(Long id);

    List<ProductDto> getProductsByIdList(List<Long> idList);

    List<ProductProjection> getProductProjectionsByIdList(List<Long> idList);

    List<ProductNamePriceProjection> getNameAndPriceByIdList(List<Long> idList);

    List<ProductUnitsInStoreProjection> getUnitsInStoreByIdList(List<Long> idList);

}
