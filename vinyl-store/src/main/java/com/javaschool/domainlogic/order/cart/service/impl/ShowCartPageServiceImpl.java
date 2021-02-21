package com.javaschool.domainlogic.order.cart.service.impl;

import com.javaschool.domainlogic.order.cart.dto.*;
import com.javaschool.domainlogic.order.cart.mapper.ShowCartProductMapper;
import com.javaschool.domainlogic.order.cart.service.api.ShowCartPageService;
import com.javaschool.dao.impl.product.projection.ProductProjection;
import com.javaschool.domainlogic.order.cart.service.api.UpdateCartService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j
@Service
@AllArgsConstructor
public class ShowCartPageServiceImpl extends CartServiceImpl implements ShowCartPageService {

    private final ShowCartProductMapper showCartProductMapper;
    private final UpdateCartService updateCartService;

    @Override
    public CartDto getCartDto(Cart cart) {
        List<CartItemDto> cartItems = getItems(cart);
        updateCartItems(cartItems, cart);

        return new CartDto(cartItems, cart.getTotal());
    }

    private List<CartItemDto> getItems(Cart cart) {
        List<ShowCartProduct> products = getProducts(cart);
        HashMap<Long, Integer> productQuantityMap = getProductQuantityMap(cart);

        return products.stream()
                .map(p -> {
                    int prevQuantity = productQuantityMap.get(p.getId());
                    return new CartItemDto(p, prevQuantity, prevQuantity);
                })
                .collect(Collectors.toList());
    }

    private List<ShowCartProduct> getProducts(Cart cart) {
        List<Long> idList = getProductIdList(cart);
        List<ProductProjection> products = productService.getProductProjectionsByIdList(idList);
        return showCartProductMapper.toDtoList(products);
    }

    private void updateCartItems(List<CartItemDto> cartItems, Cart cart) {
        Map<Long, Integer> notAvailableProducts = updateCartService.updateCartItems(cart);

        cartItems.forEach(ci -> {
            Long productId = ci.getProduct().getId();
            int newQuantity = notAvailableProducts.getOrDefault(productId, ci.getPrevQuantity());

            ci.setNewQuantity(newQuantity);
        });
    }

}
