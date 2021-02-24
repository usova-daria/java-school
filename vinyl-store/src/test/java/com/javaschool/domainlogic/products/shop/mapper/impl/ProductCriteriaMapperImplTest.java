package com.javaschool.domainlogic.products.shop.mapper.impl;

import com.javaschool.dao.impl.product.search.SearchCriteria;
import com.javaschool.domainlogic.products.shop.dto.ProductCriteria;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static com.javaschool.domainlogic.products.shop.mapper.impl.DefaultCriteriaFactory.*;
import static com.javaschool.domainlogic.products.shop.mapper.impl.TestUtil.*;

/**
 * @author Daria Usova
 */
public class ProductCriteriaMapperImplTest {

    private final ProductCriteriaMapperImpl mapper = new ProductCriteriaMapperImpl();
    private final List<SearchCriteria> empty = new ArrayList<>();

    @Test
    public void toSearchCriteria_NullInput() {
        assertEquals(empty, mapper.toSearchCriteria(null));
    }

    @Test
    public void toSearchCriteria_DefaultCriteria() {
        ProductCriteria input = getDefaultProductCriteria();
        List<SearchCriteria> actual = mapper.toSearchCriteria(input);

        assertTrue(listsAreContainsEqualElements(actual, getDefaultSearchCriteriaList()));
    }

    @Test
    public void toSearchCriteria_NoGenreCriteria() {
        ProductCriteria input = getDefaultProductCriteria();
        input.setGenre(new Integer[]{});

        List<SearchCriteria> actual = mapper.toSearchCriteria(input);

        assertTrue(listsAreContainsEqualElements(actual, getDefaultSearchCriteriaList()));
    }

    @Test
    public void toSearchCriteria_GenreCriteria() {
        Integer[] genresId = new Integer[]{1};

        // input
        ProductCriteria input = getDefaultProductCriteria();
        input.setGenre(genresId);

        // expected
        List<SearchCriteria> expected = getDefaultSearchCriteriaList();
        expected.add(new SearchCriteria("genre", ":", Arrays.asList(genresId)));

        // actual
        List<SearchCriteria> actual = mapper.toSearchCriteria(input);

        assertTrue(listsAreContainsEqualElements(actual, expected));
    }

    @Test
    public void toSearchCriteria_MaxPriceCriteria() {
        float newMaxPrice = 300;

        ProductCriteria input = getDefaultProductCriteria();
        input.setMaxPrice(newMaxPrice);

        List<SearchCriteria> expected = getDefaultMinPriceSearchCriteriaList();
        expected.add(new SearchCriteria("price", "<", newMaxPrice));

        List<SearchCriteria> actual = mapper.toSearchCriteria(input);

        assertTrue(listsAreContainsEqualElements(expected, actual));
    }

    @Test
    public void toSearchCriteria_MinPriceCriteria() {
        float newMinPrice = 300;

        ProductCriteria input = getDefaultProductCriteria();
        input.setMinPrice(newMinPrice);

        List<SearchCriteria> expected = getDefaultMaxPriceSearchCriteriaList();
        expected.add(new SearchCriteria("price", ">", newMinPrice));

        List<SearchCriteria> actual = mapper.toSearchCriteria(input);

        assertTrue(listsAreContainsEqualElements(expected, actual));
    }

    @Test
    public void toSearchCriteria_Available() {
        ProductCriteria input = getDefaultProductCriteria();
        input.setAvailable(true);

        List<SearchCriteria> expected = getDefaultSearchCriteriaList();
        expected.add(new SearchCriteria("unitsInStore", ">", 1));

        List<SearchCriteria> actual = mapper.toSearchCriteria(input);

        assertTrue(listsAreContainsEqualElements(expected, actual));
    }

    @Test
    public void testToSearchCriteria2() {
        String name = "record name";

        ProductCriteria input = getDefaultProductCriteria();
        input.setNameContains(name);

        List<SearchCriteria> expected = getDefaultSearchCriteriaList();
        expected.add(new SearchCriteria("name", ":", name));

        List<SearchCriteria> actual = mapper.toSearchCriteria(input);

        assertTrue(listsAreContainsEqualElements(expected, actual));
    }

}