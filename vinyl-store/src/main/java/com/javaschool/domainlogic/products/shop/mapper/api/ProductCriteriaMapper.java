package com.javaschool.domainlogic.products.shop.mapper.api;

import com.javaschool.domainlogic.products.shop.dto.ProductCriteria;
import com.javaschool.dao.impl.product.search.SearchCriteria;

import java.util.List;

public interface ProductCriteriaMapper {

    List<SearchCriteria> toSearchCriteria(ProductCriteria productCriteria);

}
