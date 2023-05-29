package com.fpoly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fpoly.model.BillDetail;
import com.fpoly.utils.JpaUtil;

public class BillDetailDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public BillDetail create(BillDetail bd) {
		try {
			em.getTransaction().begin();
			em.persist(bd);
			em.getTransaction().commit();
			return bd;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public BillDetail update(BillDetail bd) {
		try {
			em.getTransaction().begin();
			em.merge(bd);
			em.getTransaction().commit();
			return bd;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public BillDetail remove(int id) {
		try {
			em.getTransaction().begin();
			BillDetail bd = this.findById(id);
			if (bd != null) {
				em.remove(bd);
			}
			em.getTransaction().commit();

			return bd;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}

	}

	public BillDetail findById(int id) {
		BillDetail bd = em.find(BillDetail.class, id);
		return bd;
	}

	public List<BillDetail> findAll() {
		String jpql = "SELECT o FROM BillDetail o";
		TypedQuery<BillDetail> query = em.createQuery(jpql, BillDetail.class);
		return query.getResultList();
	}

	public BillDetail findBillDetail(String id, String pass) {
		String jqpl = "SELECT o from BillDetail o where o.id = :id and o.password = : pass";
		TypedQuery<BillDetail> query = em.createQuery(jqpl, BillDetail.class);
		query.setParameter("id", id);
		query.setParameter("pass", pass);
		return query.getSingleResult();
	}

	public List<BillDetail> findByRole(boolean role) {
		String jqpl = "Select o from BillDetail o where o.admin = :role";
		TypedQuery<BillDetail> querty = em.createQuery(jqpl, BillDetail.class);
		querty.setParameter("role", role);
		return querty.getResultList();
	}

	public List<BillDetail> findByKeyword(String keyword) {
		String jqpl = "Select o from BillDetail o where o.fullname like :keyword";
		TypedQuery<BillDetail> querty = em.createQuery(jqpl, BillDetail.class);
		querty.setParameter("keyword", "%" + keyword + "%");
		return querty.getResultList();
	}
	
	
	
	
	public List<BillDetail> findBillDetailByProduct(int id) {
		String jqpl = "SELECT o from BillDetail o where o.product.ID_Product = :id";
		TypedQuery<BillDetail> query = em.createQuery(jqpl, BillDetail.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public List<BillDetail> findBillDetailByBill(int id) {
		try {
			String jqpl = "SELECT o from BillDetail o where o.bill.ID_Bill = :id";
			TypedQuery<BillDetail> query = em.createQuery(jqpl, BillDetail.class);
			query.setParameter("id", id);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
		
	}
}
