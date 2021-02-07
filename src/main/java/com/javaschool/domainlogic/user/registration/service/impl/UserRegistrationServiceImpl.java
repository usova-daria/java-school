package com.javaschool.domainlogic.user.registration.service.impl;

import com.javaschool.dao.api.user.UserRepository;
import com.javaschool.domainlogic.user.registration.dto.UserRegistrationDto;
import com.javaschool.domainlogic.user.registration.exception.UserRegistrationException;
import com.javaschool.domainlogic.user.registration.mapper.UserRegistrationMapper;
import com.javaschool.domainlogic.user.registration.service.api.RoleService;
import com.javaschool.domainlogic.user.registration.service.api.UserRegistrationService;
import com.javaschool.entity.user.CustomerInfo;
import com.javaschool.entity.user.Role;
import com.javaschool.entity.user.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.Arrays;

@Service
@Log4j
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRegistrationMapper userMapper;

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional(readOnly = true)
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    @Transactional
    public void registerUser(UserRegistrationDto userRegistrationDto) {
        try {
            User user = userMapper.toEntity(userRegistrationDto);
            user.setCustomerInfo(new CustomerInfo());

            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            Role customerRole = roleService.findCustomerRole();
            user.setRoles(Arrays.asList(customerRole));

            userRepository.save(user);

        } catch (PersistenceException e) {
            log.error("An error occurred  during user registration", e);
            throw new UserRegistrationException();
        }

    }
}
