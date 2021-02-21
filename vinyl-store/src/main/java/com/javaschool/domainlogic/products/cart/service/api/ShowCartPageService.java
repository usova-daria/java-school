package com.javaschool.domainlogic.products.cart.service.api;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.dto.CartDto;

public interface ShowCartPageService {

    CartDto getCartDto(Cart cart);

}
