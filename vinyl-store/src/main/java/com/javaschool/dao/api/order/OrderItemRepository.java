package com.javaschool.dao.api.order;

import com.javaschool.domainlogic.salesdisplay.dto.GenreProfit;
import com.javaschool.domainlogic.salesdisplay.dto.GenreUnitsSold;
import com.javaschool.entity.order.OrderItem;

import java.util.List;

public interface OrderItemRepository {

    void save(OrderItem orderItem);

    List<GenreUnitsSold> getGenreUnitsSold();

    List<GenreProfit> getGenreProfit();

}
