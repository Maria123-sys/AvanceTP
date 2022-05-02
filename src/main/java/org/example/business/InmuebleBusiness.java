package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Inmueble;
import org.example.repository.InmuebleRepository;

@Named
public class InmuebleBusiness implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private InmuebleRepository inmuebleRepository;
	
	@Transactional
	public Long insert(Inmueble inmueble) throws Exception{
		return inmuebleRepository.insert(inmueble);
	}
	
	@Transactional
	public Long update(Inmueble inmueble) throws Exception{
		return inmuebleRepository.update(inmueble);
	}
	
	public List<Inmueble> getAll() throws Exception{
		return inmuebleRepository.findAll();
	}
	
	public List<Inmueble> getCitaById(Long id) throws Exception{
		return inmuebleRepository.findById(id);
	}
}