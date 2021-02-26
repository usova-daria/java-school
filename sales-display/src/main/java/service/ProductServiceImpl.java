package service;

import dto.BestProducts;
import lombok.extern.log4j.Log4j;
import util.BestProductsJsonParser;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Log4j
@Singleton
public class ProductServiceImpl implements ProductService {

    @Inject
    private BestProductsJsonParser bestProductsParser;

    private static final String GET_BEST_PRODUCTS_URI = "http://localhost:8080/vinyl-store/api/product-stats";

    public BestProducts getBestProducts() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(GET_BEST_PRODUCTS_URI);
        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        return bestProductsParser.parse(response);
    }

}
