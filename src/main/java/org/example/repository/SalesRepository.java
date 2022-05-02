package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Sale;

@Named
public class SalesRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	public Long insert(Sale sale) throws Exception {
		em.persist(sale);
		return sale.getId();
	}

	public Long update(Sale sale) throws Exception {
		em.merge(sale);
		return sale.getId();
	}
	
	
	public List<Sale> findAll() throws Exception {
		List<Sale> sales = new ArrayList<>();

		TypedQuery<Sale> query = em.createQuery("FROM Sale pv", Sale.class);
		sales = query.getResultList();

		return sales;
	}

	
	
	public List<Sale> findByClave(int clave) throws Exception {
		List<Sale> sales = new ArrayList<>();

		TypedQuery<Sale> query = em.createQuery("FROM Sale pv WHERE pv.clave=?1", Sale.class);
		query.setParameter(1, clave);
		sales = query.getResultList();

		return sales;
	}
}
