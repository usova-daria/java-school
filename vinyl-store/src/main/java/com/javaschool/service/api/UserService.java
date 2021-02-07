package com.javaschool.service.api;

import com.javaschool.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    String getEmailOfCurrentUser();

    User findUserByEmail(String email);

    void update(User user);

    User getCurrentUser();

}
