package com.javaschool.dao.impl.address;

import com.javaschool.dao.api.address.AddressDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.address.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends AbstractDaoImpl<Address, Long> implements AddressDao {

    public AddressDaoImpl() {
        super(Address.class);
    }

}
