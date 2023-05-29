package com.fpoly.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.fpoly.DAO.CategoryDAO;
import com.fpoly.DAO.ProductDAO;
import com.fpoly.model.Category;
import com.fpoly.model.Product;

@WebServlet({"/management-products", "/edit-product", "/delete-product", "/create-product", "/update-product"})
public class ProductManagementServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		List<Product> productList = new ArrayList<Product>();
		
		String uri = req.getRequestURI();
		
		if (uri.contains("management-products")) {
			productList = productDAO.findAll();
			req.setAttribute("productList", productList);
			req.getRequestDispatcher("/products-management.jsp").forward(req, resp);
		} 
		
		else if (uri.contains("edit-product")) {
			productList = productDAO.findAll();
			req.setAttribute("productList", productList);
			Integer idSelected = Integer.parseInt(req.getParameter("idSelected"));
			
			for (Product product : productList) {
				if (idSelected == product.getID_Product()) {
					req.setAttribute("prodSelected", product);
					break;
				}
			}
			req.getRequestDispatcher("/products-management.jsp").forward(req, resp);
		} 
		
		else if (uri.contains("delete-product")) {
			String id = req.getParameter("idSelected");
			productDAO.remove(Integer.parseInt(id));
			
			productList = productDAO.findAll();
			req.setAttribute("productList", productList);
			req.getRequestDispatcher("/products-management.jsp").forward(req, resp);
		} 
		
		else if (uri.contains("create-product")) {
			Product prod = new Product();
			prod.setImage("hinh.png");
			prod.setPr_Name(req.getParameter("pr_Name"));
			prod.setInfo(req.getParameter("info"));
			prod.setPrice(Integer.parseInt(req.getParameter("price")));
			prod.setQuantity(Integer.parseInt(req.getParameter("quantity")));
			
			String category_id = req.getParameter("category");
			CategoryDAO categoryDAO = new CategoryDAO();
			Category category = categoryDAO.findById(category_id);
			
			prod.setCategory(category);
			
			productDAO.create(prod);
			
			productList = productDAO.findAll();
			req.setAttribute("productList", productList);
			req.getRequestDispatcher("/products-management.jsp").forward(req, resp);
		} 
		
		else if (uri.contains("update-product")) {
			Product prod = new Product();
			prod.setID_Product(Integer.parseInt(req.getParameter("ID_Product")));
			
			/*
			 * Part image = req.getPart("image"); 
			 * prod.setImage(image.getName());
			 */
			
			prod.setImage("hinh.png");
			prod.setPr_Name(req.getParameter("pr_Name"));
			prod.setInfo(req.getParameter("info"));
			prod.setPrice(Integer.parseInt(req.getParameter("price")));
			prod.setQuantity(Integer.parseInt(req.getParameter("quantity")));
			
			String category_id = req.getParameter("category");
			CategoryDAO categoryDAO = new CategoryDAO();
			Category category = categoryDAO.findById(category_id);
			prod.setCategory(category);
			
			productDAO.update(prod);
			
			productList = productDAO.findAll();
			req.setAttribute("productList", productList);
			req.getRequestDispatcher("/products-management.jsp").forward(req, resp);
		}
	}
}
