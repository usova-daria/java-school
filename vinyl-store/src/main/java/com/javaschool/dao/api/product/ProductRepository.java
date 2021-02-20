package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.dao.impl.product.projection.OrderItemProjection;
import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.domainlogic.products.common.dto.ProductProjection;
import com.javaschool.entity.product.Product;
import com.javaschool.dao.impl.product.search.SearchCriteria;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends AbstractRepository<Product, Long> {

    List<ProductData> findTopProductsBySalesVolume(int resultSize);

    List<ProductProjection> findProductProjectionByDeletedFalse();

    List<ProductProjection> findProductProjectionByDeletedFalseAndSortByPrice();

    List<ProductProjection> findProductAndSortByCreated(int resultSize);

    Optional<ProductProjection> findProductProjectionById(Long id);

    int findProductUnitsInStoreById(Long id);

    List<OrderItemProjection> findOrderItemProjectionByOrderId(Long id);

    List<ProductProjection> findProductByParams(List<SearchCriteria> params, Class category,
                                                String orderBy, boolean desc);

    float findMaxPrice();

    float findMinPrice();

}
