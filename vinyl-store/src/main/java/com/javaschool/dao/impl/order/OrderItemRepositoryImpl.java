package com.javaschool.dao.impl.order;

import com.javaschool.dao.api.order.OrderItemRepository;
import com.javaschool.domainlogic.salesdisplay.dto.GenreProfit;
import com.javaschool.domainlogic.salesdisplay.dto.GenreUnitsSold;
import com.javaschool.entity.order.OrderItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(OrderItem orderItem) {
        em.persist(orderItem);
    }

    @Override
    public List<GenreUnitsSold> getGenreUnitsSold() {
        return em.createNamedQuery("OrderItem.getGenreUnitsSold", GenreUnitsSold.class)
                .getResultList();
    }

    @Override
    public List<GenreProfit> getGenreProfit() {
        String queryStr = "select coalesce(sum(amount*price), 0) as total, genre.name " +
                "from order_item inner join record " +
                "on order_item.product_id = record.product_id " +
                "inner join genre on record.genre_id=genre.genre_id " +
                "group by record.genre_id";

        List<Object[]> result = em.createNativeQuery(queryStr).getResultList();
        List<GenreProfit> genreProfitList = new ArrayList<>();
        for (Object[] obj : result) {
            Double profit = (Double) obj[0];
            String genreName = (String) obj[1];

            genreProfitList.add( new GenreProfit(genreName, profit) );
        }

        return genreProfitList;
    }

}
