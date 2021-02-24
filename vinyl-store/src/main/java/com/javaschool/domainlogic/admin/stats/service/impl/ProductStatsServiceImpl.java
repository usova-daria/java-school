package com.javaschool.domainlogic.admin.stats.service.impl;

import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.domainlogic.admin.stats.dto.ProductStats;
import com.javaschool.domainlogic.admin.stats.service.api.ProductStatsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daria Usova
 */
@Log4j
@Service
@RequiredArgsConstructor
public class ProductStatsServiceImpl implements ProductStatsService {

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public ProductStats getProductStats() {
        List<ProductData> bestProducts;
        try {
            bestProducts = productRepository.findTopProductsBySalesVolume(10);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding top 10 products", e);
            bestProducts = new ArrayList<>();
        }
        return new ProductStats(bestProducts);
    }

}
