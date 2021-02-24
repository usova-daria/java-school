package com.javaschool.domainlogic.products.shop.mapper.api;

import com.javaschool.domainlogic.products.shop.dto.ProductCriteria;
import com.javaschool.dao.impl.product.search.SearchCriteria;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface ProductCriteriaMapper {

    /**
     * Maps product criteria to search criteria
     *
     * @param productCriteria the product criteria
     * @return the list
     */
    List<SearchCriteria> toSearchCriteria(ProductCriteria productCriteria);

}
