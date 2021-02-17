package com.javaschool.dao.impl.product.search;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.function.Consumer;

@AllArgsConstructor
public class ProductSearchQueryCriteriaConsumer implements Consumer<SearchCriteria> {

    @Getter
    private Predicate predicate;

    private final CriteriaBuilder builder;
    private final Root root;

    @Override
    public void accept(SearchCriteria param) {
        String operation = param.getOperation();

        switch (operation) {
            case ">":
                predicate = greaterThanOrEqualTo(param);
                break;

            case "<":
                predicate = lessThanOrEqualTo(param);
                break;

            case ":":
                boolean likeQuery = root.get(param.getKey()).getJavaType() == String.class;
                predicate = likeQuery ? like(param) : equal(param);
                break;

            default:
                throw new UnsupportedOperationException();

        }

    }

    private Predicate greaterThanOrEqualTo(SearchCriteria param) {
        String key = param.getKey();
        String value = param.getValue().toString();

        Path path = root.get(key);

        return builder.and(predicate, builder.greaterThanOrEqualTo(path, value));
    }

    private Predicate lessThanOrEqualTo(SearchCriteria param) {
        String key = param.getKey();
        String value = param.getValue().toString();

        Path path = root.get(key);

        return builder.and(predicate, builder.lessThanOrEqualTo(path, value));
    }

    private Predicate like(SearchCriteria param) {
        String key = param.getKey();
        String value = "%" + param.getValue().toString().toUpperCase() + "%";

        Path path = root.get(key);

        return builder.and(predicate, builder.like(builder.upper(path), value));
    }

    private Predicate equal(SearchCriteria param) {
        String key = param.getKey();
        Object value = param.getValue();

        Path path = root.get(key);

        boolean inQuery = value instanceof List<?>;
        if (!inQuery) {
            return builder.and(predicate, builder.equal(path, value));
        }

        List<?> valueList = (List<?>) param.getValue();
        CriteriaBuilder.In in = builder.in(path);
        valueList.forEach(in::value);

        return builder.and(predicate, in);
    }


}
