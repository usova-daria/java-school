package com.javaschool.dao.impl.address;

import com.javaschool.dao.api.address.AddressRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.address.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepositoryImpl extends AbstractRepositoryImpl<Address, Long> implements AddressRepository {

    public AddressRepositoryImpl() {
        super(Address.class);
    }

}
