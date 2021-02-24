package com.javaschool.domainlogic.user.registration.service.impl;

import com.javaschool.dao.api.user.RoleRepository;
import com.javaschool.domainlogic.user.registration.exception.RoleNotFoundException;
import com.javaschool.domainlogic.user.registration.service.api.RoleService;
import com.javaschool.entity.user.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public Role findCustomerRole() {
        return roleRepository.findRoleByName("CUSTOMER")
                .orElseThrow(() -> new RoleNotFoundException("Customer role not found"));
    }
}
