package com.javaschool.domainlogic.products.home.service;

import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.domainlogic.products.dto.ProductDto;
import com.javaschool.domainlogic.products.dto.ProductProjection;
import com.javaschool.domainlogic.products.home.mapper.ProductDtoMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDtoMapper productMapper;

    @Override
    public List<ProductDto> getNotDeletedProductsSortedByCreated(int resultSize) {
        List<ProductProjection> products = new ArrayList<>();
        try {
            products = productRepository.findProductAndSortByCreated(resultSize);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding products", e);
        }

        return productMapper.toDtoList(products);
    }

}
