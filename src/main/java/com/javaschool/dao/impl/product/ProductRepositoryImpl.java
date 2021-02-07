package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.domainlogic.products.dto.ProductProjection;
import com.javaschool.entity.product.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl extends AbstractRepositoryImpl<Product, Long> implements ProductRepository {

    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        return entityManager.createNamedQuery("Product.findByNameContaining", Product.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<ProductData> findTopProductsBySalesVolume(int resultSize) {
        return entityManager.createNamedQuery("Product.findAndSortBySalesVolume", ProductData.class)
                .setMaxResults(resultSize)
                .getResultList();
    }

    @Override
    public List<Product> findProductByDeletedFalse() {
        return entityManager.createNamedQuery("Product.findByDeletedFalse", Product.class)
                .getResultList();
    }

    @Override
    public List<ProductProjection> findProductAndSortByCreated(int resultSize) {
        return entityManager.createNamedQuery("Product.findByDeletedFalseAndSortByCreated", ProductProjection.class)
                .setMaxResults(resultSize)
                .getResultList();
    }
}
