package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Arrendatario;

@Named
public class ArrendatarioRepository  implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	
	public Long insert(Arrendatario arrendatario) throws Exception{
		em.persist(arrendatario);
		return arrendatario.getId();
	}
	
	public Long update(Arrendatario arrendatario) throws Exception{
		em.merge(arrendatario);
		return arrendatario.getId();
	}
	
	public List<Arrendatario> findAll() throws Exception {
		List<Arrendatario> arrendatarios = new ArrayList<>();
		TypedQuery<Arrendatario> query = em.createQuery("FROM Arrendatario ario", Arrendatario.class);
		arrendatarios = query.getResultList();
		return arrendatarios;
	}
	
	public List<Arrendatario> findById(Long id)  throws Exception{
		List<Arrendatario> arrendatarios = new ArrayList<>();
		TypedQuery<Arrendatario> query=em.createQuery("FROM Arrendatario ario WHERE ario.id=?1", Arrendatario.class);
		query.setParameter(1, id);
		arrendatarios=query.getResultList();		
		return arrendatarios;
	}

}