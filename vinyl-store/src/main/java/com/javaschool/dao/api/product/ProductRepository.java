package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.dao.impl.product.projection.OrderItemProjection;
import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.domainlogic.products.dto.ProductProjection;
import com.javaschool.entity.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends AbstractRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<ProductData> findTopProductsBySalesVolume(int resultSize);

    List<Product> findProductByDeletedFalse();

    List<ProductProjection> findProductAndSortByCreated(int resultSize);

    Optional<ProductProjection> findProductProjectionById(Long id);

    int findProductUnitsInStoreById(Long id);

    List<OrderItemProjection> findOrderItemProjectionByOrderId(Long id);

}
