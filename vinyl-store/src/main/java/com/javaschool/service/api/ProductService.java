package com.javaschool.service.api;

import com.javaschool.dao.impl.product.projection.ProductNamePriceProjection;
import com.javaschool.dao.impl.product.projection.ProductPriceProjection;
import com.javaschool.dao.impl.product.projection.ProductUnitsInStoreProjection;
import com.javaschool.domainlogic.products.common.dto.ProductDto;
import com.javaschool.dao.impl.product.projection.ProductProjection;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface ProductService {

    /**
     * Gets not deleted products sorted by created.
     *
     * @param resultSize the result size
     * @return the not deleted products sorted by created
     */
    List<ProductDto> getNotDeletedProductsSortedByCreated(int resultSize);

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */
    ProductDto getProductById(Long id);

    /**
     * Gets units in store by id.
     *
     * @param id the id
     * @return the units in store by id
     */
    int getUnitsInStoreById(Long id);

    /**
     * Gets price by product id.
     *
     * @param idList the id list
     * @return the price by product id
     */
    List<ProductPriceProjection> getPriceByProductId(List<Long> idList);

    /**
     * Gets deleted by id.
     *
     * @param id the id
     * @return the deleted by id
     */
    boolean getDeletedById(Long id);

    /**
     * Gets products by id list.
     *
     * @param idList the id list
     * @return the products by id list
     */
    List<ProductDto> getProductsByIdList(List<Long> idList);

    /**
     * Gets product projections by id list.
     *
     * @param idList the id list
     * @return the product projections by id list
     */
    List<ProductProjection> getProductProjectionsByIdList(List<Long> idList);

    /**
     * Gets name and price by id list.
     *
     * @param idList the id list
     * @return the name and price by id list
     */
    List<ProductNamePriceProjection> getNameAndPriceByIdList(List<Long> idList);

    /**
     * Gets units in store by id list.
     *
     * @param idList the id list
     * @return the units in store by id list
     */
    List<ProductUnitsInStoreProjection> getUnitsInStoreByIdList(List<Long> idList);

}
