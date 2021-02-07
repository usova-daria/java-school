package com.javaschool.dao.impl.user;

import com.javaschool.dao.api.user.RoleRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.user.Role;
import org.springframework.stereotype.Repository;


import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class RoleRepositoryImpl extends AbstractRepositoryImpl<Role, Integer>
        implements RoleRepository {

    public RoleRepositoryImpl() {
        super(Role.class);
    }

    @Override
    public Optional<Role> findRoleByName(String name) {
        Role role;
        try {
            role = entityManager.createNamedQuery("Role.findByName", Role.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            role = null;
        }

        return Optional.ofNullable(role);
    }

}
