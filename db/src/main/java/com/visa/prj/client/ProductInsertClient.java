package com.visa.prj.client;

import com.visa.prj.dao.PersistenceException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;

public class ProductInsertClient {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoJdbcImpl();
        Product p = new Product(0, "Sony Bravis",219000.00, 100);
        try {
            productDao.addProduct(p);
            System.out.println("product added!!");
        } catch (PersistenceException e) {
           System.out.println(e.getMessage()); // production code
           e.printStackTrace(); // development mode
        }

    }
}
