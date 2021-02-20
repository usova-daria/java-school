package mapper;

import dto.BestProducts;
import dto.ProductStats;

public interface BestProductsMapper {

    BestProducts toBestProducts(ProductStats productStats);

}
