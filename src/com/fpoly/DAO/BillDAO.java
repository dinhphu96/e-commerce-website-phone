package com.fpoly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fpoly.model.Bill;
import com.fpoly.utils.JpaUtil;

public class BillDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public Bill create(Bill bill) {
		try {
			em.getTransaction().begin();
			em.persist(bill);
			em.getTransaction().commit();
			return bill;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public Bill update(Bill bill) {
		try {
			em.getTransaction().begin();
			em.merge(bill);
			em.getTransaction().commit();
			return bill;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public Bill remove(int id) {
		try {
			em.getTransaction().begin();
			Bill bill = this.findById(id);
			if (bill != null) {
				em.remove(bill);
			}
			em.getTransaction().commit();

			return bill;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}

	}

	public Bill findById(int id) {
		Bill bill = em.find(Bill.class, id);
		return bill;
	}

	public List<Bill> findAll() {
		String jpql = "SELECT o FROM Bill o";
		TypedQuery<Bill> query = em.createQuery(jpql, Bill.class);
		return query.getResultList();
	}

	public Bill findBill(String id, String pass) {
		String jqpl = "SELECT o from Bill o where o.id = :id and o.password = : pass";
		TypedQuery<Bill> query = em.createQuery(jqpl, Bill.class);
		query.setParameter("id", id);
		query.setParameter("pass", pass);
		return query.getSingleResult();
	}

	public List<Bill> findByRole(boolean role) {
		String jqpl = "Select o from Bill o where o.admin = :role";
		TypedQuery<Bill> querty = em.createQuery(jqpl, Bill.class);
		querty.setParameter("role", role);
		return querty.getResultList();
	}

	public List<Bill> findByKeyword(String keyword) {
		String jqpl = "Select o from Bill o where o.fullname like :keyword";
		TypedQuery<Bill> querty = em.createQuery(jqpl, Bill.class);
		querty.setParameter("keyword", "%" + keyword + "%");
		return querty.getResultList();
	}
	

		public Bill findBillByUser(String id) {
			try {
				String jqpl = "SELECT o from Bill o where o.user.phone = :id and o.status = false";
				TypedQuery<Bill> query = em.createQuery(jqpl, Bill.class);
				query.setParameter("id", id);
				return query.getSingleResult();
			} catch (Exception e) {
				return null;
			}
			
		}
}
