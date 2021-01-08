package com.javaschool.dao.api.user;

import com.javaschool.dao.api.AbstractDao;
import com.javaschool.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends AbstractDao<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findTopCustomersByNumberOfOrders(int resultSize);

}
