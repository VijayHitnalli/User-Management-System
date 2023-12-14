package com.jsp.ums.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.ums.entity.User;

public class UserDao {
	
	Configuration cfg = new Configuration().configure().addAnnotatedClass(User.class);
	SessionFactory sf = cfg.buildSessionFactory();
	
	public String saveUser(User user) {
		Session session = sf.openSession();
		Transaction tr = session.getTransaction();
		tr.begin();
		session.save(user);
		tr.commit();
		session.close();
		return "User successfully saved!!";
	}

	public List<User> getAllUsers() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("From User");
		List<User> list = query.getResultList();
		tr.commit();
		session.close();
		return list;
	}

	public User getUserById(int id) {
		Session session = sf.openSession();
		Transaction tr = session.getTransaction();
		tr.begin();
		User user = session.find(User.class, id);
		tr.commit();
		session.close();
		return user;
	}
	
	public String deleteUser(User user) {
		Session session = sf.openSession();
		Transaction tr = session.getTransaction();
		tr.begin();
		session.delete(user);
		tr.commit();
		session.close();
		return "User successfully deleted!!";
	}

	public String updateUser(User user) {
		Session session = sf.openSession();
		Transaction tr = session.getTransaction();
		tr.begin();
		session.update(user);
		tr.commit();
		session.close();
		return "User successfully updated!!";
	}

}
