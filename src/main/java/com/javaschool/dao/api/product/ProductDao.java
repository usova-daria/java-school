package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractDao;
import com.javaschool.entity.product.Product;

import java.util.List;

public interface ProductDao extends AbstractDao<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findTopProductsBySalesVolume(int resultSize);

    List<Product> findProductByDeletedFalse();

}
