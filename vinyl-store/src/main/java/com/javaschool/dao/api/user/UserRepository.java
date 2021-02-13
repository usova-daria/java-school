package com.javaschool.dao.api.user;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.domainlogic.admin.stats.dto.CustomerData;
import com.javaschool.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends AbstractRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<CustomerData> findTopCustomersByNumberOfOrders(int resultSize);

    boolean userHasOrder(Long userId, Long orderId);

}
