package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.dao.impl.product.projection.*;
import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.entity.product.Product;
import com.javaschool.dao.impl.product.search.SearchCriteria;

import java.util.List;
import java.util.Optional;

/**
 * @author Daria Usova
 */
public interface ProductRepository extends AbstractRepository<Product, Long> {

    /**
     * Update with lock.
     *
     * @param product the product
     */
    void updateWithLock(Product product);

    /**
     * Find top products by sales volume list.
     *
     * @param resultSize the result size
     * @return the list
     */
    List<ProductData> findTopProductsBySalesVolume(int resultSize);

    /**
     * Find product projection by deleted false list.
     *
     * @return the list
     */
    List<ProductProjection> findProductProjectionByDeletedFalse();

    /**
     * Find product projection by deleted false and sort by price list.
     *
     * @return the list
     */
    List<ProductProjection> findProductProjectionByDeletedFalseAndSortByPrice();

    /**
     * Find product and sort by created list.
     *
     * @param resultSize the result size
     * @return the list
     */
    List<ProductProjection> findProductAndSortByCreated(int resultSize);

    /**
     * Find product projection by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<ProductProjection> findProductProjectionById(Long id);

    /**
     * Find product units in store by id int.
     *
     * @param id the id
     * @return the int
     */
    int findProductUnitsInStoreById(Long id);

    /**
     * Find units in store by id list list.
     *
     * @param idList the id list
     * @return the list
     */
    List<ProductUnitsInStoreProjection> findUnitsInStoreByIdList(List<Long> idList);

    /**
     * Find order item projection by order id list.
     *
     * @param id the id
     * @return the list
     */
    List<OrderItemProjection> findOrderItemProjectionByOrderId(Long id);

    /**
     * Find product by params list.
     *
     * @param params   the params
     * @param category the category
     * @param orderBy  the order by
     * @param desc     the desc
     * @return the list
     */
    List<ProductProjection> findProductByParams(List<SearchCriteria> params, Class<? extends Product> category,
                                                String orderBy, boolean desc);

    /**
     * Find max price float.
     *
     * @return the float
     */
    float findMaxPrice();

    /**
     * Find min price float.
     *
     * @return the float
     */
    float findMinPrice();

    /**
     * Find price by product id list.
     *
     * @param idList the id list
     * @return the list
     */
    List<ProductPriceProjection> findPriceByProductId(List<Long> idList);

    /**
     * Find deleted by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean findDeletedById(Long id);

    /**
     * Find product projections by id list list.
     *
     * @param idList the id list
     * @return the list
     */
    List<ProductProjection> findProductProjectionsByIdList(List<Long> idList);

    /**
     * Find product name and price by id list list.
     *
     * @param idList the id list
     * @return the list
     */
    List<ProductNamePriceProjection> findProductNameAndPriceByIdList(List<Long> idList);

}
