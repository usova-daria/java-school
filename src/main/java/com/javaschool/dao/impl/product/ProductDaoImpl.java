package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.ProductDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.product.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDaoImpl extends AbstractDaoImpl<Product, Long> implements ProductDao {

    public ProductDaoImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        return entityManager.createNamedQuery("Product.findByNameContaining", Product.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Product> findTopProductsBySalesVolume(int resultSize) {
        return entityManager.createNamedQuery("Product.findAndSortBySalesVolume", Product.class)
                .setMaxResults(resultSize)
                .getResultList();
    }

    @Override
    public List<Product> findProductByDeletedFalse() {
        return entityManager.createNamedQuery("Product.findByDeletedFalse", Product.class)
                .getResultList();
    }
}
