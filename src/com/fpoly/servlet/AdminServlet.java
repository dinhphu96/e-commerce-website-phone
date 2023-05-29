package com.fpoly.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.DAO.DoanhThuDAO;
import com.fpoly.model.DoanhThu;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		req.getRequestDispatcher("/admin-index.jsp").forward(req, resp);
	}
}
