package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.BestProducts;
import dto.ProductStats;
import lombok.extern.log4j.Log4j;
import mapper.BestProductsMapper;

import javax.inject.Inject;
import javax.inject.Singleton;

@Log4j
@Singleton
public class BestProductsJsonParser {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    private BestProductsMapper bestProductsMapper;

    public BestProducts parse(String json) {
        ProductStats productStats = new ProductStats();
        try {
            productStats = objectMapper.readValue(json, ProductStats.class);
        } catch (JsonProcessingException e) {
            log.error("An error occurred while parsing product stats: " + json, e);
        }

        return bestProductsMapper.toBestProducts(productStats);
    }

}
