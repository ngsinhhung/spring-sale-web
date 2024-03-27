package com.nsh.repositories.impl;

import org.hibernate.Session;
import com.nsh.pojo.Product;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductRepositoryImpl {

    @Autowired
    public LocalSessionFactoryBean factoryBean;

    public List<Product> getProducts(Map<String, String> params) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root<Product> root = q.from(Product.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();
        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
        }

        String fromPrice = params.get("fromPrice");
        if (fromPrice != null && !fromPrice.isEmpty()) {
            predicates.add(b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice)));
        }

        String toPrice = params.get("toPrice");
        if (toPrice != null && !toPrice.isEmpty()) {
            predicates.add(b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice)));
        }

        String cateId = params.get("cateId");
        if (cateId != null && !cateId.isEmpty()) {
            predicates.add(b.equal(root.get("category").as(Integer.class), Integer.parseInt(cateId)));
        }

        q.where(predicates.toArray(Predicate[]::new));

        q.orderBy(b.desc(root.get("id")));
        Query query = s.createQuery(q);
        List<Product> products = query.getResultList();
        return products;

    }

    public Product getProductById(int id) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        return s.get(Product.class, id);

    }

    public void addOrUpdateProduct(Product p) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        s.persist(p);

    }
}
