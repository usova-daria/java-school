package com.javaschool.domainlogic.products.cart.service;

import com.javaschool.domainlogic.products.cart.exception.AddItemToCartException;
import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.dto.CartItem;
import com.javaschool.domainlogic.products.common.dto.ProductDto;
import com.javaschool.domainlogic.products.home.service.ProductService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;

@Service
@Log4j
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductService productService;

    @Override
    @Transactional(readOnly = true)
    public void addItemToCartByProductId(Long id, HttpSession session) {
        try {
            ProductDto productDto = productService.getProductById(id);
            Cart cart = getCart(session);

            addItemToCart(productDto, cart);
        } catch (NullPointerException | PersistenceException e) {
            log.error("An error occurred while adding a new item to cart", e);
            throw new AddItemToCartException();
        }
    }

    private void addItemToCart(ProductDto product, Cart cart) {
        CartItem cartItem = getCartItemByProductOrCreateNew(product, cart);
        int unitsInStore = productService.getUnitsInStoreById(product.getId());

        int newQuantity = cartItem.getQuantity() + 1;
        if (unitsInStore < newQuantity) {
            throw new AddItemToCartException("Not enough units in store");
        }

        if (newQuantity == 1) {
            cart.getItems().add(cartItem);
        }

        cartItem.setQuantity(newQuantity);
        updateTotal(cart);
    }

    @Override
    public Cart getCart(HttpSession session) {
        Cart cart;

        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        } else {
            cart = (Cart) session.getAttribute("cart");
        }

        return cart;
    }

    private CartItem getCartItemByProductOrNull(ProductDto productDto, Cart cart) {
        if (productDto == null || productDto.getId() == null) {
            return null;
        }

        Long productId = productDto.getId();
        for (CartItem item : cart.getItems()) {
            Long productItemId = item.getProduct().getId();
            if (productId.equals(productItemId)) {
                return item;
            }
        }

        return null;
    }

    private CartItem getCartItemByProductOrCreateNew(ProductDto productDto, Cart cart) {
        CartItem cartItem = getCartItemByProductOrNull(productDto, cart);
        return cartItem == null ? new CartItem(productDto, 0) : cartItem;
    }

    @Override
    @Transactional(readOnly = true)
    public void removeItemFromCartByProductId(Long id, HttpSession session) {
        try {
            ProductDto productDto = productService.getProductById(id);
            Cart cart = getCart(session);

            removeCartItemFromCart(productDto, cart);
        } catch (NullPointerException | PersistenceException e) {
            log.error("An error occurred while adding a new item to cart", e);
            throw new AddItemToCartException();
        }
    }

    private void removeCartItemFromCart(ProductDto productDto, Cart cart) {
        CartItem cartItem = getCartItemByProductOrNull(productDto, cart);

        if (cartItem == null) return;
        boolean success = cart.getItems().remove(cartItem);

        if (success) {
            updateTotal(cart);
        }
    }

    private void updateTotal(Cart cart) {
        double newTotal = cart.getItems().stream()
                .mapToDouble(ci -> ci.getQuantity() * ci.getProduct().getPrice())
                .sum();

        cart.setTotal(newTotal);
    }

    @Override
    public Cart updateCart(HttpSession session) {
        Cart cart = getCart(session);
        return updateCart(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        for (CartItem item : cart.getItems()) {
            ProductDto productDto = item.getProduct();
            int unitsInStore = productService.getUnitsInStoreById(productDto.getId());

            int minQuantity = Math.min(unitsInStore, item.getQuantity());

            if (minQuantity == 0) {
                removeCartItemFromCart(productDto, cart);
            } else {
                item.setQuantity(minQuantity);
            }
        }

        updateTotal(cart);
        return cart;
    }

    @Override
    public boolean cartIsEmpty(HttpSession session) {
        Cart cart = getCart(session);
        return cart.getItems().size() == 0;
    }


}
