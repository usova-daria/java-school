package com.javaschool.service.impl;

import com.javaschool.dao.api.user.UserRepository;
import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import com.javaschool.domainlogic.user.profile.exception.UserNotFoundException;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.user.Role;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles())
        );
    }

    private List<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getEmailOfCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getCurrentUser() {
        String email = getEmailOfCurrentUser();
        return findUserByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean currentUserHasOrder(Long orderId) {
        User user;
        try {
            user = getCurrentUser();
        } catch (UserNotFoundException e) {
            return false;
        }

        return userRepository.userHasOrder(user.getId(), orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Address> getAddressesOfCurrentUser() {
        User user;
        try {
            user = getCurrentUser();
            return user.getAddresses();
        } catch (UserNotFoundException | PersistenceException e) {
            log.error("An error occurred while getting user addresses", e);
            return new ArrayList<>();
        }
    }

}
