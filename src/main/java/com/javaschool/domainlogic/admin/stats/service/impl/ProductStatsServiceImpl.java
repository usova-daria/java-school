package com.javaschool.domainlogic.admin.stats.service.impl;

import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.domainlogic.admin.stats.dto.ProductStats;
import com.javaschool.domainlogic.admin.stats.service.api.ProductStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductStatsServiceImpl implements ProductStatsService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public ProductStats getProductStats() {
        List<ProductData> bestProducts = getTop10ProductsBySalesVolume();
        return new ProductStats(bestProducts);
    }

    public List<ProductData> getTop10ProductsBySalesVolume() {
        return productRepository.findTopProductsBySalesVolume(10);
    }

}
