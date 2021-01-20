package com.javaschool.domainlogic.user.registration.service.impl;

import com.javaschool.dao.api.user.RoleRepository;
import com.javaschool.domainlogic.user.registration.service.api.RoleService;
import com.javaschool.entity.user.Role;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Log4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public Role findCustomerRole() {
        return roleRepository.findRoleByName("CUSTOMER")
                .orElseThrow(() -> new EntityNotFoundException("Customer role was not found"));
    }
}
