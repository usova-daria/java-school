package com.javaschool.domainlogic.order.cart.service.impl;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.dto.CartItem;
import com.javaschool.domainlogic.order.cart.response.dto.RemoveItemResponse;
import com.javaschool.domainlogic.order.cart.response.factory.RemoveItemResponseFactory;
import com.javaschool.domainlogic.order.cart.service.api.RemoveFromCartService;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j
@Service
public class RemoveFromCartServiceImpl extends CartServiceImpl implements RemoveFromCartService {

    @Override
    public ResponseEntity<RemoveItemResponse> removeItemFromCart(Long productId, Cart cart) {
        if (productId == null || cart == null || cart.getItems() == null) {
            return RemoveItemResponseFactory.getIllegalArgument();
        }

        Optional<CartItem> cartItem = cart.getItems()
                                .stream()
                                .filter(ci -> productId.equals(ci.getProductId()))
                                .findFirst();

        if (!cartItem.isPresent()) {
            return RemoveItemResponseFactory.getNoSuchItem( cart.getTotal() );
        }

        removeItemFromCart(cartItem.get(), cart);
        return RemoveItemResponseFactory.getOk( cart.getTotal() );
    }


}
