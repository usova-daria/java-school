package com.javaschool.domainlogic.order.cart.response.factory;

import com.javaschool.domainlogic.order.cart.response.dto.NumberOfItemsResponse;
import org.springframework.http.ResponseEntity;

public class AddItemResponseFactory {

    private static final String ITEM_IS_DELETED = "The item is deleted. You cannot buy it!";
    private static final String ZERO_UNITS_IN_STORE = "Not enough units in store. The item has not been added to the cart!";
    private static final String NOT_ENOUGH_UNITS_IN_STORE = "Not enough units in the store. Number of items in the cart - ";
    private static final String OK = "The item is added to the cart! Number of items in the cart - ";
    private static final String ILLEGAL_ARGUMENT = "Illegal arguments.";

    private AddItemResponseFactory() {}

    public static ResponseEntity<NumberOfItemsResponse> getIllegalArgumentResponse() {
        NumberOfItemsResponse response = new NumberOfItemsResponse(ILLEGAL_ARGUMENT, 0, null);
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
        NumberOfItemsResponse response = new NumberOfItemsResponse(OK + required, required, total);
        return ResponseEntity.ok().body(response);
    }

    public static ResponseEntity<NumberOfItemsResponse> getDeletedResponse() {
        NumberOfItemsResponse response = new NumberOfItemsResponse(ITEM_IS_DELETED, 0, null);
        return ResponseEntity.badRequest().body(response);
    }

    public static ResponseEntity<NumberOfItemsResponse> getNotAvailableResponse() {
        NumberOfItemsResponse response = new NumberOfItemsResponse(ZERO_UNITS_IN_STORE, 0, null);
        return ResponseEntity.badRequest().body(response);
    }

    public static ResponseEntity<NumberOfItemsResponse> getNotEnoughResponse(int unitsInStore, double total) {
        NumberOfItemsResponse response = new NumberOfItemsResponse(NOT_ENOUGH_UNITS_IN_STORE + unitsInStore,
                                                                     unitsInStore, total);
        return ResponseEntity.badRequest().body(response);
    }

}
