package com.javaschool.service.api;

import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    String getEmailOfCurrentUser();

    User findUserByEmail(String email);

    void update(User user);

    User getCurrentUser();

    boolean currentUserHasOrder(Long orderId);

    boolean currentUserHasAddress(Long addressId);

    List<Address> getAddressesOfCurrentUser();


}
