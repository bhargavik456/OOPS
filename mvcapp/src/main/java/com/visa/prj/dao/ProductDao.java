package com.visa.prj.dao;

import com.visa.prj.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    void addProduct(Product product) throws PersistenceException;
    List<Product> getProducts() throws  DaoException;
    void updateProduct(Product p) throws  DaoException;
    Product getProduct(int id) throws  DaoException;
}


