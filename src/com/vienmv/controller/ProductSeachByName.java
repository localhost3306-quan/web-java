package com.vienmv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vienmv.model.Product;
import com.vienmv.service.ProductService;
import com.vienmv.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/product/seach")
public class ProductSeachByName extends HttpServlet {
	ProductService productService=new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		List<Product> productSeachByName =productService.seachByName(name);
		req.setAttribute("productSeachByName", productSeachByName);
		req.getRequestDispatcher("/view/client/view/product-seach-by-name.jsp").forward(req, resp);
		
		
	}
}
