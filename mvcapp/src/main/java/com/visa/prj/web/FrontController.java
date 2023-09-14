package com.visa.prj.web;

import com.visa.prj.dao.DaoException;
import com.visa.prj.dao.PersistenceException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
            // need to get data from FORM
            Product p = Product.builder()
                    .name(req.getParameter("name"))
                    .price(Double.parseDouble(req.getParameter("price")))
                    .quantity(Integer.parseInt(req.getParameter("qty")))
                    .build();
           try {
               productDao.addProduct(p);
               resp.sendRedirect("index.jsp?msg=Product added Successfully!!!");
           } catch (PersistenceException e) {
               resp.sendRedirect("productForm.jsp?errMsg=" + e.getMessage());
           }
       } else  if(uri.endsWith("login.do")) {
            // read email and pwd, check if it's valid
           HttpSession session = req.getSession(true);
           session.setAttribute("user", req.getParameter("email"));
           resp.sendRedirect("index.jsp");
       } else if (uri.endsWith("addToCart.do")){
           String[] items = req.getParameterValues("items");
           HttpSession session = req.getSession(false);
           if(session.getAttribute("cart") == null) {
               session.setAttribute("cart", new ArrayList<String>());
           }
           List<String> cartItems = (List<String>) session.getAttribute("cart");
           for(String item: items) {
               cartItems.add(item);
           }
           session.setAttribute("cart", cartItems);
           resp.sendRedirect("getProducts.do");
       } else  if(uri.endsWith("logout.do")) {
           HttpSession ses = req.getSession(false);
           if(ses != null) {
               ses.invalidate();
           }
           resp.sendRedirect("login.jsp");
       }
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
