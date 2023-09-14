package com.visa.prj.web;

import com.visa.prj.dao.DaoException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao = new ProductDaoJdbcImpl();
       String uri = req.getRequestURI();
       if(uri.endsWith("getProducts.do")) {

           try {
               List<Product> products = productDao.getProducts();
               req.setAttribute("products", products);
               req.getRequestDispatcher("productList.jsp").forward(req, resp);
           } catch (DaoException e) {
               e.printStackTrace();
           }

       } else if (uri.endsWith("addProduct.do")) {

       } else  if(uri.endsWith("login.do")) {

       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
