package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.ProductRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.dao.impl.product.projection.*;
import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.dao.impl.product.search.ProductSearchQueryCriteriaConsumer;
import com.javaschool.entity.product.Product;
import com.javaschool.dao.impl.product.search.SearchCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl extends AbstractRepositoryImpl<Product, Long> implements ProductRepository {

    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    public void updateWithLock(Product product) {
        entityManager.lock(product, LockModeType.OPTIMISTIC);
        entityManager.merge(product);
    }

    @Override
    public List<ProductData> findTopProductsBySalesVolume(int resultSize) {
        return entityManager.createNamedQuery("Product.findAndSortBySalesVolume", ProductData.class)
                .setMaxResults(resultSize)
                .getResultList();
    }

    @Override
    public List<ProductProjection> findProductProjectionByDeletedFalse() {
        return entityManager.createNamedQuery("Product.findByDeletedFalse", ProductProjection.class)
                .getResultList();
    }

    @Override
    public List<ProductProjection> findProductProjectionByDeletedFalseAndSortByPrice() {
        return entityManager.createNamedQuery("Product.findByDeletedFalseAndSortByPrice", ProductProjection.class)
                .getResultList();
    }

    @Override
    public List<ProductProjection> findProductAndSortByCreated(int resultSize) {
        return entityManager.createNamedQuery("Product.findByDeletedFalseAndSortByCreated", ProductProjection.class)
                .setMaxResults(resultSize)
                .getResultList();
    }

    @Override
    public Optional<ProductProjection> findProductProjectionById(Long id) {
        ProductProjection product;
        try {
            product = entityManager.createNamedQuery("Product.findById", ProductProjection.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            product = null;
        }

        return Optional.ofNullable(product);
    }

    @Override
    public List<ProductProjection> findProductProjectionsByIdList(List<Long> idList) {
       return entityManager.createNamedQuery("Product.findByIdList", ProductProjection.class)
                .setParameter("idList", idList)
                .getResultList();
    }

    @Override
    public int findProductUnitsInStoreById(Long id) {
        return entityManager.createNamedQuery("Product.findUnitsInStoreById", Integer.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<ProductUnitsInStoreProjection> findUnitsInStoreByIdList(List<Long> idList) {
        return entityManager.createNamedQuery("Product.findUnitsInStoreByIdList", ProductUnitsInStoreProjection.class)
                .setParameter("idList", idList)
                .getResultList();
    }

    @Override
    public List<OrderItemProjection> findOrderItemProjectionByOrderId(Long id) {
        return entityManager.createNamedQuery("Product.findOrderItemProjectionByOrderId", OrderItemProjection.class)
                .setParameter("order_id", id)
                .getResultList();
    }

    public List<ProductProjection> findProductByParams(List<SearchCriteria> params, Class category,
                                                       String orderBy, boolean desc) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductProjection> query = builder.createQuery(ProductProjection.class);
        Root root = query.from(category);
        query.select(builder.construct(ProductProjection.class,
                root.get("id"), root.get("price"),
                root.get("name"), root.get("picture"),
                root.get("unitsInStore")));

        Predicate predicate = builder.conjunction();
        ProductSearchQueryCriteriaConsumer searchConsumer =
                new ProductSearchQueryCriteriaConsumer(predicate, builder, root);

        params.forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();

        query.where(predicate);
        query.orderBy(desc ? builder.desc(root.get(orderBy)) : builder.asc(root.get(orderBy)));

        return entityManager.createQuery(query)
                .getResultList();
    }

    @Override
    public float findMaxPrice() {
        return entityManager.createNamedQuery("Product.findMaxPrice", Float.class)
                .getSingleResult();
    }

    @Override
    public float findMinPrice() {
        return entityManager.createNamedQuery("Product.findMinPrice", Float.class)
                .getSingleResult();
    }

    @Override
    public List<ProductPriceProjection> findPriceByProductId(List<Long> idList) {
        return entityManager.createNamedQuery("Product.findPrice", ProductPriceProjection.class)
                .setParameter("idList", idList)
                .getResultList();
    }

    @Override
    public boolean findDeletedById(Long id) {
        return entityManager.createNamedQuery("Product.findDeletedById", Boolean.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<ProductNamePriceProjection> findProductNameAndPriceByIdList(List<Long> idList) {
        return entityManager.createNamedQuery("Product.findNameAndPriceByIdList", ProductNamePriceProjection.class)
                .setParameter("idList", idList)
                .getResultList();
    }
}
