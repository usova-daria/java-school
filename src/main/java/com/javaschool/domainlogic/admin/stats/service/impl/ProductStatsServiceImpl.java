package com.javaschool.domainlogic.admin.stats.service.impl;

import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.domainlogic.admin.stats.dto.ProductStats;
import com.javaschool.domainlogic.admin.stats.service.api.ProductStatsService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class ProductStatsServiceImpl implements ProductStatsService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public ProductStats getProductStats() {
        List<ProductData> bestProducts;
        try {
            bestProducts = getTop10ProductsBySalesVolume();
        } catch (PersistenceException e) {
            log.error("An error occurred while finding top 10 products", e);
            bestProducts = new ArrayList<>();
        }
        return new ProductStats(bestProducts);
    }

    public List<ProductData> getTop10ProductsBySalesVolume() {
        return productRepository.findTopProductsBySalesVolume(10);
    }

}
