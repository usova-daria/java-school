package com.javaschool.domainlogic.products.shop.mapper.impl;

import com.javaschool.dao.impl.product.search.SearchCriteria;
import com.javaschool.domainlogic.products.shop.dto.ProductCriteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daria Usova
 */
public class DefaultCriteriaFactory {

    private static final float minPrice = 0;
    private static final float maxPrice = 10_000;

    private DefaultCriteriaFactory() {}

    public static List<SearchCriteria> getDefaultSearchCriteriaList() {
        List<SearchCriteria> defaultSearchCriteriaList = new ArrayList<>();
        defaultSearchCriteriaList.addAll(getDefaultMinPriceSearchCriteriaList());
        defaultSearchCriteriaList.addAll(getDefaultMaxPriceSearchCriteriaList());

        return defaultSearchCriteriaList;
    }

    public static List<SearchCriteria> getDefaultMinPriceSearchCriteriaList() {
        List<SearchCriteria> defaultMinPriceSearchCriteriaList = new ArrayList<>();
        defaultMinPriceSearchCriteriaList.add(new SearchCriteria("price", ">", minPrice));

        return defaultMinPriceSearchCriteriaList;
    }

    public static List<SearchCriteria> getDefaultMaxPriceSearchCriteriaList() {
        List<SearchCriteria> defaultMaxPriceSearchCriteriaList = new ArrayList<>();
        defaultMaxPriceSearchCriteriaList.add(new SearchCriteria("price", "<", maxPrice));

        return defaultMaxPriceSearchCriteriaList;
    }

    public static ProductCriteria getDefaultProductCriteria() {
        ProductCriteria criteria = new ProductCriteria();
        criteria.setMaxPrice(maxPrice);
        criteria.setMinPrice(minPrice);

        return criteria;
    }

}
