package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.dao.impl.product.projection.*;
import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.entity.product.Product;
import com.javaschool.dao.impl.product.search.SearchCriteria;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends AbstractRepository<Product, Long> {

    void updateWithLock(Product product);

    List<ProductData> findTopProductsBySalesVolume(int resultSize);

    List<ProductProjection> findProductProjectionByDeletedFalse();

    List<ProductProjection> findProductProjectionByDeletedFalseAndSortByPrice();

    List<ProductProjection> findProductAndSortByCreated(int resultSize);

    Optional<ProductProjection> findProductProjectionById(Long id);

    int findProductUnitsInStoreById(Long id);

    List<ProductUnitsInStoreProjection> findUnitsInStoreByIdList(List<Long> idList);

    List<OrderItemProjection> findOrderItemProjectionByOrderId(Long id);

    List<ProductProjection> findProductByParams(List<SearchCriteria> params, Class<? extends Product> category,
                                                String orderBy, boolean desc);

    float findMaxPrice();

    float findMinPrice();

    List<ProductPriceProjection> findPriceByProductId(List<Long> idList);

    boolean findDeletedById(Long id);

    List<ProductProjection> findProductProjectionsByIdList(List<Long> idList);

    List<ProductNamePriceProjection> findProductNameAndPriceByIdList(List<Long> idList);

}
