package com.javaschool.dao.impl.user;

import com.javaschool.dao.api.user.UserDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl() {
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
    public List<User> findTopCustomersByNumberOfOrders(int resultSize) {
        return entityManager.createNamedQuery("User.findAndSortByNumberOfOrders", User.class)
                .setMaxResults(resultSize)
                .getResultList();
    }
}
