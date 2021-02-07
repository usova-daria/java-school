package com.javaschool.domainlogic.products.home.service;

import com.javaschool.domainlogic.products.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getNotDeletedProductsSortedByCreated(int resultSize);

}
