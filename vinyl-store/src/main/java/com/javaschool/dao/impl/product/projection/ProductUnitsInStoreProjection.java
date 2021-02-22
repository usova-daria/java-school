package com.javaschool.dao.impl.product.projection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductUnitsInStoreProjection {

    private Long id;
    private int unitsInStore;

}
