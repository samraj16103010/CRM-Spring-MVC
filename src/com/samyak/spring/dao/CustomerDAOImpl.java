package com.samyak.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.samyak.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer>query = session.createQuery("from Customer order by lastName", Customer.class);

		return query.getResultList();
	}

	@Override
	public void addCustomer(Customer theCustomer) {
	  Session session = sessionFactory.getCurrentSession();
	  
	  session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer theCustomer = session.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId",theId);
		
		query.executeUpdate();
	}

}
