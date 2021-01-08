package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.ProductCategoryDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.product.ProductCategory;

public class ProductCategoryDaoImpl extends AbstractDaoImpl<ProductCategory, Integer> implements ProductCategoryDao {

    public ProductCategoryDaoImpl() {
        super(ProductCategory.class);
    }

}
