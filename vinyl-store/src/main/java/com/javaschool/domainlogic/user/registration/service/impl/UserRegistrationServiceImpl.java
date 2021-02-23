package com.javaschool.domainlogic.user.registration.service.impl;

import com.javaschool.dao.api.user.UserRepository;
import com.javaschool.domainlogic.user.registration.dto.UserRegistrationDto;
import com.javaschool.domainlogic.user.registration.exception.RoleNotFoundException;
import com.javaschool.domainlogic.user.registration.exception.UserRegistrationException;
import com.javaschool.domainlogic.user.registration.mapper.api.UserRegistrationMapper;
import com.javaschool.domainlogic.user.registration.service.api.RoleService;
import com.javaschool.domainlogic.user.registration.service.api.UserRegistrationService;
import com.javaschool.entity.user.CustomerInfo;
import com.javaschool.entity.user.Role;
import com.javaschool.entity.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.Collections;

@Log4j
@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRegistrationMapper userMapper;
    private final RoleService roleService;

    @Override
    @Transactional(readOnly = true)
    public boolean emailExists(String email) {
        try {
            return userRepository.findByEmail(email).isPresent();
        } catch (PersistenceException e) {
            log.error("An error occurred while finding user by email", e);
            throw new UserRegistrationException();
        }
    }

    @Override
    @Transactional
    public void registerUser(UserRegistrationDto userRegistrationDto) {
        try {
            tryToRegisterUser(userRegistrationDto);
        } catch (PersistenceException | RoleNotFoundException e) {
            log.error("An error occurred during user registration", e);
            throw new UserRegistrationException();
        }
    }

    private void tryToRegisterUser(UserRegistrationDto userRegistrationDto) {
        User user = userMapper.toEntity(userRegistrationDto);
        user.setCustomerInfo(new CustomerInfo());

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role customerRole = roleService.findCustomerRole();
        user.setRoles(Collections.singletonList(customerRole));

        userRepository.save(user);
    }

}
