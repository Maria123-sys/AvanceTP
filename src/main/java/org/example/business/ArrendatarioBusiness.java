package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Arrendatario;
import org.example.repository.ArrendatarioRepository;

@Named
public class ArrendatarioBusiness implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ArrendatarioRepository arrendatarioRepository;
	
	@Transactional
	public Long insert(Arrendatario arrendatario) throws Exception{
		return arrendatarioRepository.insert(arrendatario);
	}
	
	@Transactional
	public Long update(Arrendatario arrendatario) throws Exception{
		return arrendatarioRepository.update(arrendatario);
	}
	
	public List<Arrendatario> getAll() throws Exception{
		return arrendatarioRepository.findAll();
	}
	
	public List<Arrendatario> getArrendatarioById(Long id) throws Exception{
		return arrendatarioRepository.findById(id);
	}
}