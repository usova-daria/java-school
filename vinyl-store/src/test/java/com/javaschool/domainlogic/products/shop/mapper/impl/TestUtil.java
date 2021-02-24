package com.javaschool.domainlogic.products.shop.mapper.impl;

import java.util.List;

/**
 * @author Daria Usova
 */
public class TestUtil {

    private TestUtil() {}

    public static boolean listsAreContainsEqualElements(List<?> list1, List<?> list2) {
        if (list1 == null || list2 == null) {
            return false;
        }
        return list1.containsAll(list2) && list2.containsAll(list1);
    }

}
