package com.fpoly.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fpoly.model.DoanhThu;
import com.fpoly.utils.JpaUtil;

public class DoanhThuDAO {
	
	EntityManager em = JpaUtil.getEntityManager();
	
	public List<DoanhThu> findDoanhThu(Integer year) {
	
		List<DoanhThu> listDoanhThu = new ArrayList<DoanhThu>();
		try {
			em.getTransaction().begin();
			
			String jpql = "SELECT new DoanhThu(MONTH(b.date), SUM(b.total)) FROM Bill b WHERE b.status = true AND YEAR(b.date) = :year GROUP BY MONTH(b.date)";
			TypedQuery<DoanhThu> query = em.createQuery(jpql, DoanhThu.class);
			query.setParameter("year", year);
			
			listDoanhThu = query.getResultList();
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return listDoanhThu;
	}
}
