package com.javaschool.service.impl;

import com.javaschool.dao.api.address.AddressRepository;
import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import com.javaschool.domainlogic.order.checkout.exception.AddressMappingException;
import com.javaschool.domainlogic.order.checkout.mapper.api.AddressMapper;
import com.javaschool.domainlogic.user.profile.exception.address.AddressNotSavedException;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.user.User;
import com.javaschool.exception.AddressNotFoundException;
import com.javaschool.service.api.AddressService;
import com.javaschool.service.api.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

@Log4j
@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserService userService;
    private final AddressMapper addressMapper;

    @Override
    @Transactional(readOnly = true)
    public Address getAddressById(Long id) {
        try {
            return addressRepository.findById(id)
                    .orElseThrow(() -> new AddressNotFoundException(id));
        } catch (PersistenceException e) {
            log.error("An error occurred while getting address by id=" + id, e);
            return null;
        }
    }

    @Override
    @Transactional
    public void update(Address address) {
        addressRepository.update(address);
    }

    @Override
    @Transactional
    public boolean deleteById(Long addressId) {
        try {
            Address address = getAddressById(addressId);
            addressRepository.delete(address);

            return true;
        } catch (AddressNotFoundException e) {
            return false;
        } catch (PersistenceException e) {
            log.error("An error occurred while deleting an address by id=" + addressId, e);
            return false;
        }
    }

    @Override
    @Transactional
    public void save(AddressDto addressDto) {
        try {
            Address address = addressMapper.toEntity(addressDto);
            User user = userService.getCurrentUser();
            user.getAddresses().add(address);
        } catch (PersistenceException | AddressMappingException e) {
            log.error("An error occurred while saving an address", e);
            throw new AddressNotSavedException(e.getMessage(), e);
        }
    }

}
