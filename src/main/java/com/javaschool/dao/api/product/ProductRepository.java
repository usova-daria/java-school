package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.domainlogic.products.dto.ProductProjection;
import com.javaschool.entity.product.Product;

import java.util.List;

public interface ProductRepository extends AbstractRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<ProductData> findTopProductsBySalesVolume(int resultSize);

    List<Product> findProductByDeletedFalse();

    List<ProductProjection> findProductAndSortByCreated(int resultSize);

}
