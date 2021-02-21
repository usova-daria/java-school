package com.javaschool.domainlogic.products.cart.response.factory;

import com.javaschool.domainlogic.products.cart.response.dto.NumberOfItemsResponse;
import org.springframework.http.ResponseEntity;

public class ChangeNumberOfItemsFactory {

    private static final String NO_SUCH_ITEM = "There is no such item in the cart!";
    private static final String NOT_ENOUGH_UNITS_IN_STORE = "Not enough units in the store.";
    private static final String OK = "The number of items has been changed.";
    private static final String ILLEGAL_ARGUMENT = "Illegal arguments.";

    public static ResponseEntity<NumberOfItemsResponse> getIllegalArgumentResponse() {
        NumberOfItemsResponse response = new NumberOfItemsResponse(ILLEGAL_ARGUMENT, 0, null);
        return ResponseEntity.badRequest().body(response);
    }

    public static ResponseEntity<NumberOfItemsResponse> getNoSuchItemResponse() {
        NumberOfItemsResponse response = new NumberOfItemsResponse(NO_SUCH_ITEM, 0, null);
        return ResponseEntity.badRequest().body(response);
    }

    public static ResponseEntity<NumberOfItemsResponse> getResponseByRequired(int required, int newQuantity,
                                                                              double total) {
        if (required > newQuantity) {
            return getNotEnoughResponse(newQuantity, total);
        }

        return getOkResponse(required, total);
    }

    public static ResponseEntity<NumberOfItemsResponse> getOkResponse(int required, double total) {
        NumberOfItemsResponse response = new NumberOfItemsResponse(OK, required, total);
        return ResponseEntity.ok().body(response);
    }

    public static ResponseEntity<NumberOfItemsResponse> getNotEnoughResponse(int unitsInStore, double total) {
        NumberOfItemsResponse response = new NumberOfItemsResponse(NOT_ENOUGH_UNITS_IN_STORE, unitsInStore, total);
        return ResponseEntity.badRequest().body(response);
    }
}
