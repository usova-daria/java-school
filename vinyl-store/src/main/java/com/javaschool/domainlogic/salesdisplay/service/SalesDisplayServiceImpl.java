package com.javaschool.domainlogic.salesdisplay.service;

import com.javaschool.dao.api.order.OrderItemRepository;
import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.domainlogic.salesdisplay.dto.GenreProfit;
import com.javaschool.domainlogic.salesdisplay.dto.GenreUnitsSold;
import com.javaschool.domainlogic.salesdisplay.dto.ProductStats;
import com.javaschool.domainlogic.salesdisplay.dto.ProductUnitsSold;
import com.javaschool.domainlogic.salesdisplay.mapper.ProductUnitsSoldMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Log4j
@Service
public class SalesDisplayServiceImpl implements SalesDisplayService {

    private ProductRepository productRepository;
    private ProductUnitsSoldMapper productUnitsSoldMapper;
    private OrderItemRepository orderItemRepository;

    @Autowired
    public SalesDisplayServiceImpl(ProductRepository productRepository,
                                   ProductUnitsSoldMapper productUnitsSoldMapper,
                                   OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.productUnitsSoldMapper = productUnitsSoldMapper;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    @Transactional
    public ProductStats getProductStats() {
        List<ProductUnitsSold> bestProducts = get10BestProducts();
        HashMap<String, Double> profit = getProfitByGenre();
        HashMap<String, Long> unitsSold = getUnitsSoldByGenre();

        ProductStats productStats = new ProductStats();
        productStats.setTopProducts(bestProducts);
        productStats.setProfitByGenre(profit);
        productStats.setUnitsSoldByGenre(unitsSold);

        return productStats;
    }

    private List<ProductUnitsSold> get10BestProducts() {
        List<ProductData> bestProducts;
        try {
             bestProducts = productRepository.findTopProductsBySalesVolume(10);
        } catch (PersistenceException e) {
            log.error("An error occurred while finding top products by sales volume", e);
            bestProducts = new ArrayList<>();
        }

        return productUnitsSoldMapper.toDtoList(bestProducts);
    }

    private HashMap<String, Double> getProfitByGenre() {
        HashMap<String, Double> map = new HashMap<>();

        List<GenreProfit> genreProfitList;
        try {
            genreProfitList = orderItemRepository.getGenreProfit();
        } catch (PersistenceException e) {
            log.error("An error occurred while getting profit by genre", e);
            genreProfitList = new ArrayList<>();
        }

        genreProfitList.forEach( g -> map.put(g.getGenreName(), g.getProfit()));

        return map;
    }

    private HashMap<String, Long> getUnitsSoldByGenre() {
        HashMap<String, Long> map = new HashMap<>();

        List<GenreUnitsSold> genreUnitsSoldList;
        try {
            genreUnitsSoldList = orderItemRepository.getGenreUnitsSold();
        } catch (PersistenceException e) {
            log.error("An error occurred while getting units sold by genre", e);
            genreUnitsSoldList = new ArrayList<>();
        }

        genreUnitsSoldList.forEach( g -> map.put(g.getGenreName(), g.getUnitsSold()));

        return map;
    }


}
