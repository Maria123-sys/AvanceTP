package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Inmueble;

@Named
public class InmuebleRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;
	
	public Long insert(Inmueble inmueble) throws Exception{
		em.persist(inmueble);
		return inmueble.getId();
	}
	
	public Long update(Inmueble inmueble) throws Exception{
		em.merge(inmueble);
		return inmueble.getId();
	}
	
	public List<Inmueble> findAll()  throws Exception{
		List<Inmueble> inmuebles=new ArrayList<>();
		TypedQuery<Inmueble> query=em.createQuery("FROM Inmueble i", Inmueble.class);
		inmuebles=query.getResultList();		
		return inmuebles;
	}
	
	public List<Inmueble> findById(Long id)  throws Exception{
		List<Inmueble> inmuebles =new ArrayList<>();
		TypedQuery<Inmueble> query=em.createQuery("FROM Inmueble i WHERE i.id=?1", Inmueble.class);
		query.setParameter(1, id);
		inmuebles=query.getResultList();		
		return inmuebles;
	}
}