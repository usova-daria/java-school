package com.javaschool.dao.api.user;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.entity.user.Role;

import java.util.Optional;

public interface RoleRepository extends AbstractRepository<Role, Integer> {

    Optional<Role> findRoleByName(String name);

}
