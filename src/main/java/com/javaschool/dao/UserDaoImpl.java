package com.javaschool.dao;

import com.javaschool.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findByEmail(String email) {
        try {
           return entityManager.createNamedQuery("findUserWithEmail", User.class)
                   .setParameter("userEmail", email)
                   .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }


}
