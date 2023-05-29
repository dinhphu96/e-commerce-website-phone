package com.fpoly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fpoly.model.User;
import com.fpoly.utils.JpaUtil;

public class UserDAO {
	EntityManager em = JpaUtil.getEntityManager();
	public List<User> findAll() {
		String jpql = "SELECT o FROM User o";
		TypedQuery<User> query= em.createQuery(jpql,User.class);
		return query.getResultList();
	}
	
	public User findByName(String name){
		String jpql = "SELECT o FROM User o where o.Pr_Name like ?0";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter(0, name);
		return query.getSingleResult();
	}
	
	public User findById(String id) {
		User us = em.find(User.class, id);
		return us;
	}
}
