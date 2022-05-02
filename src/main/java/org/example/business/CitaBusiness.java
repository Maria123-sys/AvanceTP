package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Cita;
import org.example.repository.CitaRepository;

@Named
public class CitaBusiness implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CitaRepository citaRepository;
	
	@Transactional
	public Long insert(Cita cita) throws Exception{
		return citaRepository.insert(cita);
	}
	
	@Transactional
	public Long update(Cita cita) throws Exception{
		return citaRepository.update(cita);
	}
	
	public List<Cita> getAll() throws Exception{
		return citaRepository.findAll();
	}
	
	public List<Cita> getCitaById(Long id) throws Exception{
		return citaRepository.findById(id);
	}
}