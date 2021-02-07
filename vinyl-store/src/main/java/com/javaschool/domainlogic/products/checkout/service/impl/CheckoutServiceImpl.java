package com.javaschool.domainlogic.products.checkout.service.impl;

import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.dto.CartItem;
import com.javaschool.domainlogic.products.cart.service.CartService;
import com.javaschool.domainlogic.products.checkout.dto.*;
import com.javaschool.domainlogic.products.checkout.service.api.CheckoutService;
import com.javaschool.domainlogic.products.checkout.service.api.CountryService;
import com.javaschool.domainlogic.products.checkout.service.api.DeliveryService;
import com.javaschool.domainlogic.products.checkout.service.api.TownService;
import com.javaschool.entity.order.enumeration.PaymentMethod;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CountryService countryService;

    @Autowired
    private TownService townService;

    @Autowired
    private CartService cartService;

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public boolean cartItemIsAvailable(CartItem cartItem) {
        Long productId = cartItem.getProduct().getId();
        int unitsInStock = productRepository.findProductUnitsInStoreById(productId);

        return unitsInStock >= cartItem.getQuantity();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountryDto> getCountries() {
        try {
            return countryService.getCountries();
        } catch (PersistenceException e) {
            log.error("An error occurred while getting list of countries", e);
        }

        return new ArrayList<>();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TownDto> getTownsByCountryId(Integer countryId) {
        if (countryId == null) return new ArrayList<>();

        try {
            return townService.getTownByCountry(countryId);
        } catch (PersistenceException e) {
            log.error("An error occurred while getting towns in country with id=" + countryId, e);
        }

        return new ArrayList<>();
    }

    @Override
    public void updateCart(HttpSession session) {
        cartService.updateCart(session);
    }

    @Override
    public List<DeliveryDto> getDeliveryOptions() {
        return deliveryService.getDeliveryOptions();
    }

    @Override
    public boolean cartIsEmpty(HttpSession session) {
        return cartService.cartIsEmpty(session);
    }

    @Override
    public CheckoutFormDto getNewCheckoutForm() {
        CheckoutFormDto checkoutFormDto = new CheckoutFormDto();

        checkoutFormDto.setAddress( new AddressDto());
        checkoutFormDto.setPaymentMethod( PaymentMethod.DEBIT_CARD );

        User user = userService.getCurrentUser();

        checkoutFormDto.setFirstName( user.getFirstName() );
        checkoutFormDto.setLastName( user.getLastName() );

        return checkoutFormDto;
    }
}
