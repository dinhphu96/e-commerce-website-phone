package com.fpoly.servlet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.DAO.*;
import com.fpoly.model.*;

@WebServlet({ "/home", "/index", "/product", "/about", "/contact", "/login", "/register", "/detail", "/phone", "/cart",
		"/addCart", "/luuBill", "/xoaBd", "/checkout", "/dathang" })
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();
	private CategoryDAO categoryDAO = new CategoryDAO();
	private BillDetailDAO billDetailDAO = new BillDetailDAO();
	private BillDAO billDAO = new BillDAO();
	private UserDAO userDAO = new UserDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		List<Product> list = new ArrayList<Product>();
		List<Category> listCategory = new ArrayList<Category>();

		String uri = req.getRequestURI();

		if (uri.contains("home")) {
			// xóa session

			req.getServletContext().setAttribute("tongTien", 0);
			req.getServletContext().removeAttribute("cartDetail");
			req.getServletContext().setAttribute("sl", 0);
			req.getSession().removeAttribute("user");

			this.soLuong(req, resp);

			listCategory = categoryDAO.findAll();
			req.setAttribute("listCategory", listCategory);

			list = productDAO.findAll();
			req.setAttribute("list", list);

			List<Product> listlaptop = new ArrayList<Product>();
			listlaptop = productDAO.findbycategory();
			req.setAttribute("listlaptop", listlaptop);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else if (uri.contains("index")) {

			listCategory = categoryDAO.findAll();
			req.setAttribute("listCategory", listCategory);

			list = productDAO.findAll();
			req.setAttribute("list", list);

			this.soLuong(req, resp);

			List<Product> listlaptop = new ArrayList<Product>();
			listlaptop = productDAO.findbycategory();
			req.setAttribute("listlaptop", listlaptop);
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		} else if (uri.contains("product")) {
			List<Product> page = productDAO.findAll();
			List<Product> ps = new ArrayList<Product>();
			Product pro = new Product();
			int p = Integer.valueOf(req.getParameter("idpage"));

			for (int i = ((p * 10) - 10); i < (p * 10); i++) {
				pro = page.get(i);
				ps.add(pro);
			}
			req.setAttribute("list", ps);
			req.setAttribute("idpage", p);
			req.setAttribute("listProduct", (Integer) (page.size() / 10));
			req.getRequestDispatcher("/product.jsp").forward(req, resp);
		} else if (uri.contains("about")) {
			// req.getRequestDispatcher("").forward(req, resp);
		} else if (uri.contains("contact")) {
			req.getRequestDispatcher("contact.jsp").forward(req, resp);
		} else if (uri.contains("login")) {
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else if (uri.contains("register")) {
			// req.getRequestDispatcher("").forward(req, resp);
		} else if (uri.contains("detail")) {

			int idSelected = Integer.parseInt(req.getParameter("idSelected"));
			Product prodSelected = productDAO.findById(idSelected);
			req.setAttribute("product", prodSelected);
			req.getRequestDispatcher("detail.jsp").forward(req, resp);
		} else if (uri.contains("phone")) {

			String name = req.getParameter("name");
			list = productDAO.findListByName(name);
			req.setAttribute("list", list);

			req.getRequestDispatcher("index.jsp").forward(req, resp);

		} else if (uri.contains("addCart")) {

			User user1 = (User) req.getSession().getAttribute("user");

			if (user1 == null) {
				req.setAttribute("message", "Vui lòng đăng nhập!");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);

			} else {

				// tìm sản phẩm
				int id = Integer.parseInt(req.getParameter("id"));
				Product pro = productDAO.findById(id);

				// check giỏ hàng
				User userCheckBill = (User) req.getSession().getAttribute("user");

				Bill b = billDAO.findBillByUser(userCheckBill.getPhone());// lấy hóa đơn chưa thanh toán có check trạng
																			// thái chưa thanh toán

				if (b != null) {

					List<BillDetail> bd = billDetailDAO.findBillDetailByBill(b.getID_Bill());

					// check xem có sp trong chi tiết giỏ hàng hay chưa
					if (isProductExist(pro, bd)) {
						List<BillDetail> listBilldt = billDetailDAO.findBillDetailByProduct(id);// tìm billdetail từ sản
																								// phẩm
						for (BillDetail x : listBilldt) {
							if (x.getBill().getID_Bill() == b.getID_Bill()) {
								x.setAmount(x.getAmount() + 1);
								billDetailDAO.update(x);
								break;
							}
						}

						int tongT = (int) req.getServletContext().getAttribute("tongTien") + pro.getPrice();
						req.getServletContext().setAttribute("tongTien", tongT);
						b.setTotal((int) req.getServletContext().getAttribute("tongTien"));
						billDAO.update(b);
					} else {
						BillDetail billDetailMoi = new BillDetail();
						billDetailMoi.setAmount(1);
						billDetailMoi.setBill(b);
						billDetailMoi.setProduct(pro);
						billDetailDAO.create(billDetailMoi);

						int tongT = (int) req.getServletContext().getAttribute("tongTien") + pro.getPrice();
						req.getServletContext().setAttribute("tongTien", tongT);
						b.setTotal((int) req.getServletContext().getAttribute("tongTien"));
						billDAO.update(b);
					}
				} else {
					// tạo bill mới
					Bill billmoi = new Bill();
					billmoi.setStatus(false);
					billmoi.setTotal(pro.getPrice());

					User us = (User) req.getSession().getAttribute("user");
					billmoi.setUser(us);
					billDAO.create(billmoi);

					// tạo bill detail mới
					BillDetail billDetailMoi = new BillDetail();
					billDetailMoi.setAmount(1);
					billDetailMoi.setBill(billmoi);
					billDetailMoi.setProduct(pro);
					billDetailDAO.create(billDetailMoi);

					req.getServletContext().setAttribute("tongTien", pro.getPrice());
				}

				this.soLuong(req, resp);

				list = productDAO.findAll();
				req.setAttribute("list", list);

				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		} else if (uri.contains("cart")) {
			this.soLuong(req, resp);

			req.getRequestDispatcher("/cart.jsp").forward(req, resp);
		} else if (uri.contains("luuBill")) {
			String layGt = req.getParameter("layGt");
			String tach[] = layGt.split("-");

			int soLuong = Integer.parseInt(tach[0]);
			int maBillDetail = Integer.parseInt(tach[1]);
			int tongBill = Integer.parseInt(tach[2]);

			BillDetail billDetail = billDetailDAO.findById(maBillDetail);
			billDetail.setAmount(soLuong);
			billDetailDAO.update(billDetail);

			User user = (User) req.getSession().getAttribute("user");
			Bill bill = billDAO.findBillByUser(user.getPhone());
			bill.setTotal(tongBill);
			billDAO.update(bill);

			req.getServletContext().setAttribute("tongTien", tongBill);

			this.soLuong(req, resp);
			req.getRequestDispatcher("/cart.jsp").forward(req, resp);
		} else if (uri.contains("xoaBd")) {
			String layGt = req.getParameter("layGt2");
			String tach[] = layGt.split("-");

			int maBillDetail = Integer.parseInt(tach[0]);
			int tongBill = Integer.parseInt(tach[1]);

			// xóa billdetail
			BillDetail billDetail = billDetailDAO.findById(maBillDetail);
			billDetailDAO.remove(maBillDetail);

			//
			User user = (User) req.getSession().getAttribute("user");
			Bill bill = billDAO.findBillByUser(user.getPhone());
			if (tongBill == 0) {
				billDAO.remove(bill.getID_Bill());
			} else {
				bill.setTotal(tongBill);
				billDAO.update(bill);
			}

			req.getServletContext().setAttribute("tongTien", tongBill);

			this.soLuong(req, resp);
			req.getRequestDispatcher("/cart.jsp").forward(req, resp);
		} else if (uri.contains("checkout")) {

			req.getRequestDispatcher("/checkout.jsp").forward(req, resp);
		} else if (uri.contains("dathang")) {

			User user = (User) req.getSession().getAttribute("user");
			if (user != null) {
				Bill bill = billDAO.findBillByUser(user.getPhone());
				if (bill != null) {
					bill.setStatus(true);
					billDAO.update(bill);
					this.soLuong(req, resp);

					req.setAttribute("tc", "Đặt hàng thành công!");
					req.getRequestDispatcher("/index").forward(req, resp);
				}else {
					req.getRequestDispatcher("/index").forward(req, resp);
				}
			}else {
				req.getRequestDispatcher("/index").forward(req, resp);
			}

		}

	}

	private boolean isProductExist(Product product, List<BillDetail> BillDetail) {

		for (int i = 0; i < BillDetail.size(); i++) {
			if (BillDetail.get(i).getProduct().getID_Product() == product.getID_Product()) {
				return true;
			}
		}
		return false;
	}

	private void soLuong(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");

		if (user != null) {
			Bill bill = billDAO.findBillByUser(user.getPhone());// lấy hóa đơn chưa thanh toán
			if (bill != null) {
				List<BillDetail> billDetail = billDetailDAO.findBillDetailByBill(bill.getID_Bill());// lấy các chi tiết
																									// giỏ hàng
				req.getServletContext().setAttribute("sl", billDetail.size());

				req.getServletContext().setAttribute("tongTien", bill.getTotal());
				req.getServletContext().setAttribute("cartDetail", billDetail);
			} else {
				req.getServletContext().setAttribute("tongTien", 0);
				req.getServletContext().setAttribute("cartDetail", null);
				req.getServletContext().setAttribute("sl", 0);
			}

		} else {
			req.getServletContext().setAttribute("sl", 0);
		}
	}

}
