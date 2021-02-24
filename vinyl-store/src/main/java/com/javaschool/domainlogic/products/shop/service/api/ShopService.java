package com.javaschool.domainlogic.products.shop.service.api;

import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.domainlogic.products.common.dto.ProductDto;
import com.javaschool.domainlogic.products.shop.dto.ProductCriteria;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface ShopService {

    /**
     * Gets products.
     *
     * @return the products
     */
    List<ProductDto> getProducts();

    /**
     * Gets genres.
     *
     * @return the genres
     */
    List<GenreDto> getGenres();

    /**
     * Gets products by params and deleted false.
     *
     * @param productCriteria the product criteria
     * @return the products by params and deleted false
     */
    List<ProductDto> getProductsByParamsAndDeletedFalse(ProductCriteria productCriteria);

    /**
     * Fills show all products model map.
     *
     * @param modelMap the model map
     */
    void fillShowAllProductsModelMap(ModelMap modelMap);

    /**
     * Fills search model map.
     *
     * @param productCriteria the product criteria
     * @param modelMap        the model map
     */
    void fillSearchModelMap(ProductCriteria productCriteria, ModelMap modelMap);

    /**
     * Fills search results model map.
     *
     * @param productCriteria the product criteria
     * @param modelMap        the model map
     */
    void fillSearchResultsModelMap(ProductCriteria productCriteria, ModelMap modelMap);

    /**
     * Gets max price.
     *
     * @return the max price
     */
    float getMaxPrice();

    /**
     * Gets min price.
     *
     * @return the min price
     */
    float getMinPrice();

}
