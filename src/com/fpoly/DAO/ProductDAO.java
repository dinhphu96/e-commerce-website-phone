package com.fpoly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fpoly.model.Product;
import com.fpoly.utils.JpaUtil;

public class ProductDAO {
	EntityManager em = JpaUtil.getEntityManager();
	
	public List<Product> findAll() {
		TypedQuery<Product> query = em.createNamedQuery("Product.findAll", Product.class);
		return query.getResultList();
	}

	public Product findByName(String name) {
		String jpql = "SELECT o FROM Product o where o.pr_Name = ?0";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter(0, name);
		return query.getSingleResult();
	}
	
	public Product findById(int id) {
		return em.find(Product.class, id);
	}
	

	public List<Product> findbycategory() {
		String jpql = "SELECT o FROM Product o where o.category = 'LMH02'";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		return query.getResultList();
	}
	
	public List<Product> findListByName(String name) {
		String jpql = "SELECT o FROM Product o where o.pr_Name like ?0";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter(0, "%" + name + "%");
		return query.getResultList();
	}

	public void create(Product prod) {
		try {
			em.getTransaction().begin();
			
			em.persist(prod);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void update(Product prod) {
		try {
			em.getTransaction().begin();

			em.merge(prod);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void remove(Integer id) {
		try {
			em.getTransaction().begin();

			Product entity = em.find(Product.class, id);
			em.remove(entity);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public Product findById(Integer id) {
		Product prod = new Product();
		try {
			em.getTransaction().begin();

			prod = em.find(Product.class, id);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return prod;
	}
}
