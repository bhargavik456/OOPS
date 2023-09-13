package com.visa.prj.dao;

import com.visa.prj.entity.Product;
import com.visa.prj.util.DBUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoJdbcImpl implements  ProductDao{

    @Override
    public void addProduct(Product product) throws PersistenceException {
        String SQL = "INSERT INTO products(id, name, price, quantity) VALUES(0, ? ,? ,?)";
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.executeUpdate();
        } catch (SQLException e) {
           // log
            throw  new PersistenceException("unable to add product", e);
        } finally {
            DBUtil.closeConnection(con);
        }

    }

    @Override
    public List<Product> getProducts() throws DaoException {
        String SQL = "SELECT id, name, price, quantity FROM products";
        Connection con = null;
        List<Product> products = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            // log
            throw  new DaoException("unable to get products", e);
        } finally {
            DBUtil.closeConnection(con);
        }

        return products;
    }

    @Override
    public void updateProduct(Product p) throws DaoException {

    }

    @Override
    public Product getProduct(int id) throws DaoException {
        return null;
    }
}
