package com.javaschool.dao;

import com.javaschool.entity.User;

public interface UserDao {

    void save(User user);

    User findByEmail(String email);
}
