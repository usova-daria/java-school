package com.javaschool.domainlogic.products.shop.mapper.impl;

import com.javaschool.dao.impl.product.search.SearchCriteria;
import com.javaschool.domainlogic.products.shop.dto.ProductCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static com.javaschool.domainlogic.products.shop.mapper.impl.DefaultCriteriaFactory.*;
import static com.javaschool.domainlogic.products.shop.mapper.impl.TestUtil.*;

/**
 * @author Daria Usova
 */
@RunWith(Parameterized.class)
public class ProductCriteriaMapperImplContainsNameTest {

    private final ProductCriteriaMapperImpl mapper = new ProductCriteriaMapperImpl();
    private final String name;

    public ProductCriteriaMapperImplContainsNameTest(String name) {
        super();
        this.name = name;
    }

    @Parameterized.Parameters
    public static Collection<Object> names() {
        return Arrays.asList(new Object[]{null, "",  "    "});
    }

    @Test
    public void testToSearchCriteria() {
        ProductCriteria input = getDefaultProductCriteria();
        input.setNameContains(name);

        List<SearchCriteria> expected = getDefaultSearchCriteriaList();
        List<SearchCriteria> actual = mapper.toSearchCriteria(input);

        assertTrue(listsAreContainsEqualElements(expected, actual));
    }

}
