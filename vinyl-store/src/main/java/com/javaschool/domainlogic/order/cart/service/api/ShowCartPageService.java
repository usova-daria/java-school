package com.javaschool.domainlogic.order.cart.service.api;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.dto.CartDto;

public interface ShowCartPageService {

    CartDto getCartDto(Cart cart);

}
