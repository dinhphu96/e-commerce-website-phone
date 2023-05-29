package com.fpoly.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.DAO.BillDAO;
import com.fpoly.DAO.BillDetailDAO;
import com.fpoly.DAO.CategoryDAO;
import com.fpoly.DAO.DoanhThuDAO;
import com.fpoly.DAO.ProductDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.model.Bill;
import com.fpoly.model.BillDetail;
import com.fpoly.model.Category;
import com.fpoly.model.DoanhThu;
import com.fpoly.model.Product;
import com.fpoly.model.User;

@WebServlet({ "/sign-in","/signned", "/sign-out", "/sign-up", "/forgot-password","/get-password" })
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	UserDAO usDAO = new UserDAO();
	private ProductDAO productDAO = new ProductDAO();
	private CategoryDAO categoryDAO = new CategoryDAO();
	private BillDAO billDAO = new BillDAO();
	private BillDetailDAO billDetailDAO = new BillDetailDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> list = new ArrayList<Product>();
		List<Category> listCategory = new ArrayList<Category>();
		String uri = req.getRequestURI();
		if (uri.contains("sign-in")) {
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}else if(uri.contains("signned")) {
			
			DoanhThuDAO doanhThuDAO = new DoanhThuDAO();
			List<DoanhThu> listDoanhThu = doanhThuDAO.findDoanhThu(2020);
			List<Integer> listDoanhThuItem = new ArrayList<Integer>();
			List<Long> listDoanhThuValue = new ArrayList<Long>();
			
			for (DoanhThu doanhThu : listDoanhThu) {
				listDoanhThuItem.add(doanhThu.getGourp());
				listDoanhThuValue.add(doanhThu.getTotal());
			}
			
			// Tổng 3 cái là 100%
			List<Integer> list2 = new ArrayList<Integer>();
			list2.add(20);
			list2.add(30);
			list2.add(15);
			list2.add(15);
			list2.add(20);
			
			// Truyền list cho areaChart
			req.setAttribute("doanhThuItem", listDoanhThuItem);
			req.setAttribute("doanhThuValue", listDoanhThuValue);
			
			// Truyền list2 (...) cho pieChart
			req.setAttribute("pieChart", list2);
			
			
			listCategory = categoryDAO.findAll();
			req.setAttribute("listCategory",listCategory);
			 
			list = productDAO.findAll();
			req.setAttribute("list", list);
			
			List<Product> listlaptop = new ArrayList<Product>();
			listlaptop = productDAO.findbycategory();
			req.setAttribute("listlaptop",listlaptop);
			this.doSignIn(req, resp);
		}else if (uri.contains("sign-out")) {
			this.doSignOut(req, resp);
		} else if (uri.contains("sign-up")) {
			this.doSignUp(req, resp);
		} else if (uri.contains("forgot-password")) {
			this.doForgotPassword(req, resp);
		} else if(uri.contains("get-password")) {
			try {
				this.doGetPassword(req, resp);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				req.setAttribute("message", "Vui lÃ²ng nháº­p Email chÃ­nh xÃ¡c Ä‘á»ƒ láº¥y láº¡i tÃ i khoáº£n!");
				req.getRequestDispatcher("/forgot-password.jsp").forward(req, resp);
			}
		}
	}

	
	protected void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String phone = req.getParameter("phone");
			String pw = req.getParameter("password");
			
			UserDAO dao = new UserDAO();

			User user = dao.findById(phone);
			if (user != null) {
				if (!user.getPassword().equalsIgnoreCase(pw)) {
					req.setAttribute("message", "Sai máº­t kháº©u!");
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
				} else {
					System.out.println(phone);
					req.getSession().setAttribute("user", user);
					if(user.getRole()==true) {
						req.getRequestDispatcher("/admin-index.jsp").forward(req, resp);
					}else {
						req.getRequestDispatcher("/index").forward(req, resp);
					}					
				}
			}else {
				req.setAttribute("message", "Vui lÃ²ng nháº­p tÃ i khoáº£n vÃ  máº­t kháº©u!");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doSignOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	protected void doSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/register.jsp").forward(req, resp);
	}

	protected void doForgotPassword(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/forgot-password.jsp").forward(req, resp);
	}
	
	protected void doGetPassword(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, MessagingException {
		
		//ThÃ´ng sá»‘ káº¿t ná»‘i smtp server
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new Authenticator() {
		
			protected PasswordAuthentication getPasswordAuthentication() {
				String username = "trungpbps19244@fpt.edu.vn";
				String password = "0799517465";
				return new PasswordAuthentication(username, password);
			}
		});
		List<User> listU = usDAO.findAll();		
		String email = req.getParameter("mailGetPass");
		
		//tao message
		
		
		for(int i = 0; i <listU.size();i++) {
			if(email.equals(listU.get(i).getEmail())) {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress("trungpbps19244@fpt.edu.vn"));
				message.setRecipients(Message.RecipientType.TO, listU.get(i).getEmail());
				message.setSubject("Báº£o máº­t tÃ i khoáº£n Elec-Pro","utf-8");
				message.setText("TÃ i khoáº£n cá»§a báº¡n lÃ : "+listU.get(i).getPhone() +"\n"+ "Máº­t kháº©u cá»§a tÃ i khoáº£n: "+listU.get(i).getPassword() +"\n"+"Cáº£m Æ¡n báº¡n Ä‘Ã£ sá»­ dá»¥ng á»©ng dá»¥ng cá»§a chÃºng tÃ´i!" , "utf-8","html");
				message.setReplyTo(message.getFrom());
				
				//gui message
				Transport.send(message);				
				break;
			}
		}		
		req.getRequestDispatcher("/forgot-password.jsp").forward(req, resp);		
	}
	
	private void soLuong(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");
		
		if(user != null) {
			Bill bill = billDAO.findBillByUser(user.getPhone());// lấy hóa đơn chưa thanh toán
			if(bill !=null) {
				List<BillDetail> billDetail = billDetailDAO.findBillDetailByBill(bill.getID_Bill());//lấy các chi tiết giỏ hàng
				req.getServletContext().setAttribute("sl", billDetail.size());
			}
			
		}else {
			req.getServletContext().setAttribute("sl", 0);
		}
	}
}
