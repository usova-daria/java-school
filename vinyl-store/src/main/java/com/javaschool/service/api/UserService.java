package com.javaschool.service.api;

import com.javaschool.entity.address.Address;
import com.javaschool.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface UserService extends UserDetailsService {

    /**
     * Gets email of current user.
     *
     * @return the email of current user
     */
    String getEmailOfCurrentUser();

    /**
     * Find user by email user.
     *
     * @param email the email
     * @return the user
     */
    User findUserByEmail(String email);

    /**
     * Update user.
     *
     * @param user the user
     */
    void update(User user);

    /**
     * Gets current user.
     *
     * @return the current user
     */
    User getCurrentUser();

    /**
     * Current user has order boolean.
     *
     * @param orderId the order id
     * @return the boolean
     */
    boolean currentUserHasOrder(Long orderId);

    /**
     * Current user has address boolean.
     *
     * @param addressId the address id
     * @return the boolean
     */
    boolean currentUserHasAddress(Long addressId);

    /**
     * Gets addresses of current user.
     *
     * @return the addresses of current user
     */
    List<Address> getAddressesOfCurrentUser();


}
