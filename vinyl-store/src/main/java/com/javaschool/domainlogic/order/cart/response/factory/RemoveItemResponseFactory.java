package com.javaschool.domainlogic.order.cart.response.factory;

import com.javaschool.domainlogic.order.cart.response.dto.RemoveItemResponse;
import org.springframework.http.ResponseEntity;

public class RemoveItemResponseFactory {

    private static final String ILLEGAL_ARGUMENT = "Illegal arguments.";
    private static final String NO_SUCH_ITEM = "There is no such item in the cart!";
    private static final String OK = "Item is removed from the cart successfully.";

    private RemoveItemResponseFactory() {}

    public static ResponseEntity<RemoveItemResponse> getIllegalArgument() {
        RemoveItemResponse response = new RemoveItemResponse(ILLEGAL_ARGUMENT, null);
        return ResponseEntity.badRequest().body(response);
    }

    public static ResponseEntity<RemoveItemResponse> getNoSuchItem(double total) {
        RemoveItemResponse response = new RemoveItemResponse(NO_SUCH_ITEM, total);
        return ResponseEntity.badRequest().body(response);
    }

    public static ResponseEntity<RemoveItemResponse> getOk(double newTotal) {
        RemoveItemResponse response = new RemoveItemResponse(OK, newTotal);
        return ResponseEntity.ok().body(response);
    }

}
