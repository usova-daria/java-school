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

    private static final float DEFAULT_MIN_PRICE = 0;
    private static final float DEFAULT_MAX_PRICE = 10_000;

    private static final String PRODUCTS = "products";
    private static final String GENRES = "genres";
    private static final String MAX_PRICE = "maxPrice";
    private static final String MIN_PRICE = "minPrice";
    private static final String HIGH_PRICE_FIRST = "highPriceFirst";
    private static final String NAME_CONTAINS = "nameContains";
    private static final String SELECTED_GENRES_ID = "selectedGenresId";
    private static final String AVAILABLE = "available";

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
    @Transactional(readOnly = true)
    public void fillShowAllProductsModelMap(ModelMap modelMap) {
        List<ProductDto> products = getProducts();
        List<GenreDto> genres = getGenres();

        modelMap.put(PRODUCTS, products);
        modelMap.put(GENRES, genres);

        modelMap.put(MAX_PRICE, getMaxPrice());
        modelMap.put(MIN_PRICE, getMinPrice());

        modelMap.put(HIGH_PRICE_FIRST, false);
    }

    @Override
    @Transactional(readOnly = true)
    public void fillSearchModelMap(ProductCriteria productCriteria, ModelMap modelMap) {
        List<ProductDto> products = getProductsByParamsAndDeletedFalse(productCriteria);

        modelMap.put(PRODUCTS, products);
        modelMap.put(NAME_CONTAINS, productCriteria.getNameContains());
        modelMap.put(HIGH_PRICE_FIRST, productCriteria.isHighPriceFirst());
    }

    @Override
    @Transactional(readOnly = true)
    public void fillSearchResultsModelMap(ProductCriteria productCriteria, ModelMap modelMap) {
        List<ProductDto> products = getProductsByParamsAndDeletedFalse(productCriteria);
        List<GenreDto> genres = getGenres();

        modelMap.put(PRODUCTS, products);
        modelMap.put(GENRES, genres);
        modelMap.put(SELECTED_GENRES_ID, Arrays.asList(productCriteria.getGenre()));

        modelMap.put(NAME_CONTAINS, productCriteria.getNameContains());
        modelMap.put(HIGH_PRICE_FIRST, productCriteria.isHighPriceFirst());
        modelMap.put(AVAILABLE, productCriteria.isAvailable());

        modelMap.put(MAX_PRICE, getMaxPrice());
        modelMap.put(MIN_PRICE, getMinPrice());
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
