package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Arrendador;
import org.example.repository.ArrendadorRepository;

@Named
public class ArrendadorBusiness implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ArrendadorRepository arrendadorRepository;
	
	@Transactional
	public Long insert(Arrendador arrendador) throws Exception{
		return arrendadorRepository.insert(arrendador);
	}
	
	@Transactional
	public Long update(Arrendador arrendador) throws Exception{
		return arrendadorRepository.update(arrendador);
	}
	
	public List<Arrendador> getAll() throws Exception{
		return arrendadorRepository.findAll();
	}
	
	public List<Arrendador> getArrendadorById(Long id) throws Exception{
		return arrendadorRepository.findById(id);
	}
}