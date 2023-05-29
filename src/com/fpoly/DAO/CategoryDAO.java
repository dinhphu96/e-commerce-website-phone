package com.fpoly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fpoly.model.Category;
import com.fpoly.utils.JpaUtil;

public class CategoryDAO{
EntityManager em = JpaUtil.getEntityManager();
	
	public List<Category> findAll() {
		TypedQuery<Category> query = em.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}
	
	public Category findById(String id) {
		Category category = new Category();
		try {
			em.getTransaction().begin();

			category = em.find(Category.class, id);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return category;
	}
}
