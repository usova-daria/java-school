package com.javaschool.domainlogic.products.shop.mapper.impl;

import com.javaschool.domainlogic.products.shop.mapper.api.ProductCriteriaMapper;
import com.javaschool.domainlogic.products.shop.dto.ProductCriteria;
import com.javaschool.dao.impl.product.search.SearchCriteria;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProductCriteriaMapperImpl implements ProductCriteriaMapper {

    @Override
    public List<SearchCriteria> toSearchCriteria(ProductCriteria productCriteria) {
        if (productCriteria == null) {
            return new ArrayList<>();
        }

        List<SearchCriteria> criteria = new ArrayList<>();
        criteria.add( genreCriteria(productCriteria) );
        criteria.add( maxPriceCriteria(productCriteria) );
        criteria.add( minPriceCriteria(productCriteria) );
        criteria.add( available(productCriteria) );
        criteria.add( nameContains(productCriteria) );

        return criteria.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private SearchCriteria genreCriteria(ProductCriteria criteria) {
        if (criteria.getGenre() == null || criteria.getGenre().length == 0) {
            return null;
        }

        return new SearchCriteria("genre", ":", Arrays.asList(criteria.getGenre()));
    }

    private SearchCriteria maxPriceCriteria(ProductCriteria criteria) {
        return new SearchCriteria("price", "<", criteria.getMaxPrice());
    }

    private SearchCriteria minPriceCriteria(ProductCriteria criteria) {
        return new SearchCriteria("price", ">", criteria.getMinPrice());
    }

    private SearchCriteria available(ProductCriteria productCriteria) {
        if (productCriteria.isAvailable()) {
            return new SearchCriteria("unitsInStore", ">", 1);
        } else {
            return null;
        }
    }

    private SearchCriteria nameContains(ProductCriteria productCriteria) {
        String nameContains = productCriteria.getNameContains();
        if (nameContains == null || nameContains.trim().length() == 0) {
            return null;
        }

        return new SearchCriteria("name", ":", productCriteria.getNameContains());
    }

}
