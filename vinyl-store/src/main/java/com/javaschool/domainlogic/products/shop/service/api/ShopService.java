package com.javaschool.domainlogic.products.shop.service.api;

import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.domainlogic.products.common.dto.ProductDto;
import com.javaschool.domainlogic.products.shop.dto.ProductCriteria;
import org.springframework.ui.ModelMap;

import java.util.List;

public interface ShopService {

    List<ProductDto> getProducts();

    List<GenreDto> getGenres();

    List<ProductDto> getProductsByParamsAndDeletedFalse(ProductCriteria productCriteria);

    void fillShowAllProductsModelMap(ModelMap modelMap);

    void fillSearchModelMap(ProductCriteria productCriteria, ModelMap modelMap);

    void fillSearchResultsModelMap(ProductCriteria productCriteria, ModelMap modelMap);

    float getMaxPrice();

    float getMinPrice();

}
