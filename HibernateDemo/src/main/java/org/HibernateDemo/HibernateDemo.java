package org.HibernateDemo;

import org.hibernate.Session;
import org.pojo.Category;
import org.pojo.Product;
import repository.impl.ProductRepositoryImpl;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HibernateDemo {
    public static void main(String[] args) {
        ProductRepositoryImpl rs = new ProductRepositoryImpl();

        Map<String, String> params = new HashMap<>();
        params.put("kw", "iPhone");
        params.put("fromPrice", "0");
        params.put("toPrice", "20000000");
        rs.getProducts(params).forEach(p-> System.out.println(p.getId() + " - " + p.getName()  + " - " + p.getPrice()));

//        try(Session session = HibernateUtils.getFactory().openSession()){
//            Query q = session.createNamedQuery("Product.findAll");
//            List<Product> products = q.getResultList();
//            products.forEach(p -> System.out.println(p.getName()));
//        }

//        ProductRepository pre = new ProductRepository();
//        pre.getProducts(null).forEach(p -> System.out.println(p.getName()));
    }
}
