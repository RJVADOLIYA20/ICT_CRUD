package com.ty.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ty.Entity.userEntity;

@Repository
public class EmployeeDao {

	@Autowired
	private EntityManager entityManager;

	public void save(userEntity user) {
		// TODO Auto-generated method stub
		EntityTransaction entityTransaction = this.entityManager.getTransaction();
		entityTransaction.begin();
		this.entityManager.persist(user);
		entityTransaction.commit();
	}
	public List<String> getAllUsers() {
		Query query = this.entityManager.createQuery("select u from userEntity u");
		return query.getResultList();
	}
	
	public userEntity getUserById(int id) {
	      return (userEntity)this.entityManager.find(userEntity.class, id);
	   }

	 public void update(userEntity user) {
	      EntityTransaction entityTransaction = this.entityManager.getTransaction();
	      entityTransaction.begin();
	      this.entityManager.merge(user);
	      entityTransaction.commit();
	   }

	   public void delete(int id) {
	      EntityTransaction entityTransaction = this.entityManager.getTransaction();
	      entityTransaction.begin();
	      this.entityManager.remove(this.getUserById(id));
	      entityTransaction.commit();
	   }
}

