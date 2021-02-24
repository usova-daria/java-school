package com.javaschool.dao.api.order;

import com.javaschool.domainlogic.salesdisplay.dto.GenreProfit;
import com.javaschool.domainlogic.salesdisplay.dto.GenreUnitsSold;
import com.javaschool.entity.order.OrderItem;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface OrderItemRepository {

    /**
     * Save order item.
     *
     * @param orderItem the order item
     */
    void save(OrderItem orderItem);

    /**
     * Gets genre units sold.
     *
     * @return the genre units sold
     */
    List<GenreUnitsSold> getGenreUnitsSold();

    /**
     * Gets genre profit.
     *
     * @return the genre profit
     */
    List<GenreProfit> getGenreProfit();

}
