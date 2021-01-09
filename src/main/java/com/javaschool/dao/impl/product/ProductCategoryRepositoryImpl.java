package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.ProductCategoryRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.product.ProductCategory;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCategoryRepositoryImpl extends AbstractRepositoryImpl<ProductCategory, Integer> implements ProductCategoryRepository {

    public ProductCategoryRepositoryImpl() {
        super(ProductCategory.class);
    }

}
