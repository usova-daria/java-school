package com.javaschool.dao.impl.user;

import com.javaschool.dao.api.user.UserRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.domainlogic.admin.stats.dto.CustomerData;
import com.javaschool.entity.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl extends AbstractRepositoryImpl<User, Long> implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user;
        try {
            user = entityManager.createNamedQuery("User.findByEmail", User.class)
                                .setParameter("userEmail", email)
                                .getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }

        return Optional.ofNullable(user);
    }


    @Override
    public List<CustomerData> findTopCustomersByNumberOfOrders(int resultSize) {
        return entityManager.createNamedQuery("User.findAndSortByNumberOfOrders", CustomerData.class)
                .setMaxResults(resultSize)
                .getResultList();
    }

    @Override
    public boolean userHasOrder(Long userId, Long orderId) {
        String countQuery = "SELECT count(*) from customer_has_order cho " +
                "where cho.order_id = :order_id and cho.user_id = :user_id";

        int numberOfRows = ((Number) entityManager.createNativeQuery(countQuery)
                .setParameter("user_id", userId)
                .setParameter("order_id", orderId)
                .getSingleResult())
                .intValue();

        return numberOfRows == 1;
    }
}
