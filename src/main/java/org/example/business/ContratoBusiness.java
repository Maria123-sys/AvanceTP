package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Contrato;
import org.example.repository.ContratoRepository;

@Named
public class ContratoBusiness implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContratoRepository contratoRepository;
	
	@Transactional
	public Long insert(Contrato contrato) throws Exception{
		return contratoRepository.insert(contrato);
	}
	
	@Transactional
	public Long update(Contrato contrato) throws Exception{
		return contratoRepository.update(contrato);
	}
	
	public List<Contrato> getAll() throws Exception{
		return contratoRepository.findAll();
	}
	
	public List<Contrato> getContratoById(Long id) throws Exception{
		return contratoRepository.findById(id);
	}
}