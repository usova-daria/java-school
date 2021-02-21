package com.javaschool.service.impl;

import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.dao.impl.product.projection.ProductNamePriceProjection;
import com.javaschool.dao.impl.product.projection.ProductPriceProjection;
import com.javaschool.dao.impl.product.projection.ProductUnitsInStoreProjection;
import com.javaschool.domainlogic.products.common.dto.ProductDto;
import com.javaschool.dao.impl.product.projection.ProductProjection;
import com.javaschool.domainlogic.products.common.mapper.ProductDtoMapper;
import com.javaschool.service.api.ProductService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDtoMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getNotDeletedProductsSortedByCreated(int resultSize) {
        List<ProductProjection> products = new ArrayList<>();
        try {
            products = productRepository.findProductAndSortByCreated(resultSize);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding products", e);
        }

        return productMapper.toDtoList(products);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto getProductById(Long id) {
        return productRepository.findProductProjectionById(id).map(p -> productMapper.toDto(p))
                .orElseThrow(() -> new EntityNotFoundException("Product with id=" + id + "not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public int getUnitsInStoreById(Long id) {
        try {
            return productRepository.findProductUnitsInStoreById(id);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding number of units in store for product with id=" + id, e);
            return 0;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductPriceProjection> getPriceByProductId(List<Long> idList) {
        try {
            return productRepository.findPriceByProductId(idList);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding total price by product id: " + idList, e);
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean getDeletedById(Long id) {
        try {
            return productRepository.findDeletedById(id);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding deleted by id=" + id, e);
            return true;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getProductsByIdList(List<Long> idList) {
        List<ProductProjection> products = getProductProjectionsByIdList(idList);
        return productMapper.toDtoList(products);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductProjection> getProductProjectionsByIdList(List<Long> idList) {
        try {
            return productRepository.findProductProjectionsByIdList(idList);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding product projections by id: " + idList, e);
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductNamePriceProjection> getNameAndPriceByIdList(List<Long> idList) {
        try {
            return productRepository.findProductNameAndPriceByIdList(idList);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding product name and price by id: " + idList, e);
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductUnitsInStoreProjection> getUnitsInStoreByIdList(List<Long> idList) {
        try {
            return productRepository.findUnitsInStoreByIdList(idList);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding product units in store by id: " + idList, e);
            return new ArrayList<>();
        }
    }

}
