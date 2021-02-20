package com.javaschool.domainlogic.products.shop.service.impl;

import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.domainlogic.admin.productmanagement.service.api.GenreService;
import com.javaschool.domainlogic.products.common.dto.ProductDto;
import com.javaschool.dao.impl.product.projection.ProductProjection;
import com.javaschool.domainlogic.products.common.mapper.ProductDtoMapper;
import com.javaschool.domainlogic.products.shop.mapper.api.ProductCriteriaMapper;
import com.javaschool.domainlogic.products.shop.service.api.ShopService;
import com.javaschool.entity.product.Record;
import com.javaschool.domainlogic.products.shop.dto.ProductCriteria;
import com.javaschool.dao.impl.product.search.SearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private static float DEFAULT_MIN_PRICE = 0;
    private static float DEFAULT_MAX_PRICE = 10_000;

    private final ProductRepository productRepository;
    private final ProductDtoMapper productDtoMapper;
    private final GenreService genreService;
    private final ProductCriteriaMapper productCriteriaMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getProducts() {
        List<ProductProjection> products;

        try {
            products = productRepository.findProductProjectionByDeletedFalseAndSortByPrice();
        } catch (PersistenceException e) {
            log.error("An error occurred while getting all products");
            return new ArrayList<>();
        }

        return productDtoMapper.toDtoList(products);
    }

    @Override
    public List<GenreDto> getGenres() {
        return genreService.getGenreDtoList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getProductsByParamsAndDeletedFalse(ProductCriteria productCriteria) {
        try {
            List<SearchCriteria> criteria = productCriteriaMapper.toSearchCriteria(productCriteria);
            criteria.add( new SearchCriteria("deleted", ":", false) );

            List<ProductProjection> products =
                    productRepository.findProductByParams(criteria, Record.class,
                            "price", productCriteria.isHighPriceFirst());

            return productDtoMapper.toDtoList(products);
        } catch (PersistenceException e) {
            log.error("An error occurred while getting products by params", e);
            return new ArrayList<>();
        }
    }

    @Override
    public void fillShowAllProductsModelMap(ModelMap modelMap) {
        List<ProductDto> products = getProducts();
        List<GenreDto> genres = getGenres();

        modelMap.put("products", products);
        modelMap.put("genres", genres);

        modelMap.put("maxPrice", getMaxPrice());
        modelMap.put("minPrice", getMinPrice());

        modelMap.put("highPriceFirst", false);
    }

    @Override
    public void fillSearchModelMap(ProductCriteria productCriteria, ModelMap modelMap) {
        List<ProductDto> products = getProductsByParamsAndDeletedFalse(productCriteria);

        modelMap.put("products", products);
        modelMap.put("nameContains", productCriteria.getNameContains());
        modelMap.put("highPriceFirst", productCriteria.isHighPriceFirst());
    }

    @Override
    public void fillSearchResultsModelMap(ProductCriteria productCriteria, ModelMap modelMap) {
        List<ProductDto> products = getProductsByParamsAndDeletedFalse(productCriteria);
        List<GenreDto> genres = getGenres();

        modelMap.put("products", products);
        modelMap.put("genres", genres);
        modelMap.put("selectedGenresId", Arrays.asList(productCriteria.getGenre()));

        modelMap.put("nameContains", productCriteria.getNameContains());
        modelMap.put("highPriceFirst", productCriteria.isHighPriceFirst());
        modelMap.put("available", productCriteria.isAvailable());

        modelMap.put("maxPrice", getMaxPrice());
        modelMap.put("minPrice", getMinPrice());
    }

    @Override
    @Transactional(readOnly = true)
    public float getMaxPrice() {
        try {
            return productRepository.findMaxPrice();
        } catch (PersistenceException e) {
            log.error("An error occurred while getting max price", e);
            return DEFAULT_MAX_PRICE;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public float getMinPrice() {
        try {
            return productRepository.findMinPrice();
        } catch (PersistenceException e) {
            log.error("An error occurred while getting min price", e);
            return DEFAULT_MIN_PRICE;
        }
    }
}
