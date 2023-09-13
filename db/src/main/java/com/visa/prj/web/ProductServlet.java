package com.visa.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.visa.prj.dao.DaoException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); // opens character stream to client
		response.setContentType("text/html"); // MIME 
		out.print("<html>");
		out.print("<body>");
		out.print("<table border=\"1\">");
		out.print("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
		
		ProductDao productDao = new ProductDaoJdbcImpl();

	        try {
	            List<Product> products = productDao.getProducts();
	            for(Product p : products) {
	            	out.print("<tr>");
	                out.println("<td>"+ p.getId() + "</td>");
	                out.println("<td>"+ p.getName() + "</td>");
	                out.println("<td>"+ p.getPrice() + "</td>");
	                out.print("</tr>");
	            }
	        } catch (DaoException e) {
	            throw new RuntimeException(e);
	        }
	        
	        out.print("</table></body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
