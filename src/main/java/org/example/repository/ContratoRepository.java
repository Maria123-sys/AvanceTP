package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Contrato;

@Named
public class ContratoRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;
	
	public Long insert(Contrato contrato) throws Exception{
		em.persist(contrato);
		return contrato.getId();
	}
	
	public Long update(Contrato contrato) throws Exception{
		em.merge(contrato);
		return contrato.getId();
	}
	
	public List<Contrato> findAll()  throws Exception{
		List<Contrato> contratos=new ArrayList<>();
		TypedQuery<Contrato> query=em.createQuery("FROM Contrato c", Contrato.class);
		contratos=query.getResultList();		
		return contratos;
	}
	
	public List<Contrato> findById(Long id)  throws Exception{
		List<Contrato> contratos=new ArrayList<>();
		TypedQuery<Contrato> query=em.createQuery("FROM Contrato c WHERE c.id=?1", Contrato.class);
		query.setParameter(1, id);
		contratos=query.getResultList();		
		return contratos;
	}
}

