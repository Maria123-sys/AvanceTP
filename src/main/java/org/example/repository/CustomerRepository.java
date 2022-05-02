package org.example.repository;

import java.io.Serializable;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

import org.example.entities.Customer;



@Named
public class CustomerRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	public Optional<Customer> findByDni(String dni) throws Exception {
		Customer customer;
		TypedQuery<Customer> customerExist = em.createQuery("FROM Customer c  WHERE c.dni =?1", Customer.class);
		customerExist.setParameter(1, dni);
		customer = customerExist.getSingleResult();

		return Optional.of(customer);
	}

}
