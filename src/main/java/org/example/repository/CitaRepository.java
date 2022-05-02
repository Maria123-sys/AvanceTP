package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Cita;

@Named
public class CitaRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;
	
	public Long insert(Cita cita) throws Exception{
		em.persist(cita);
		return cita.getId();
	}
	
	public Long update(Cita cita) throws Exception{
		em.merge(cita);
		return cita.getId();
	}
	
	public List<Cita> findAll()  throws Exception{
		List<Cita> citas=new ArrayList<>();
		TypedQuery<Cita> query=em.createQuery("FROM Cita ci", Cita.class);
		citas=query.getResultList();		
		return citas;
	}
	
	public List<Cita> findById(Long id)  throws Exception{
		List<Cita> citas=new ArrayList<>();
		TypedQuery<Cita> query=em.createQuery("FROM Cita ci WHERE ci.id=?1", Cita.class);
		query.setParameter(1, id);
		citas=query.getResultList();		
		return citas;
	}
}

