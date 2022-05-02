package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Arrendador;

@Named
public class ArrendadorRepository  implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	public Long insert(Arrendador arrendador) throws Exception{
		em.persist(arrendador);
		return arrendador.getId();
	}
	
	public Long update(Arrendador arrendador) throws Exception{
		em.merge(arrendador);
		return arrendador.getId();
	}
	
	public List<Arrendador> findAll() throws Exception {
		List<Arrendador> arrendadores = new ArrayList<>();
		TypedQuery<Arrendador> query = em.createQuery("FROM Arrendador or", Arrendador.class);
		arrendadores = query.getResultList();
		return arrendadores;
	}
	
	public List<Arrendador> findById(Long id)  throws Exception{
		List<Arrendador> arrendadores = new ArrayList<>();
		TypedQuery<Arrendador> query=em.createQuery("FROM Arrendador or WHERE or.id=?1", Arrendador.class);
		query.setParameter(1, id);
		arrendadores=query.getResultList();		
		return arrendadores;
	}

}
