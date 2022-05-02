package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.ContratoBusiness;
import org.example.entities.Contrato;
import org.example.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class ContratoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContratoBusiness contratoBusiness;


	private Contrato contrato;
	private List<Contrato> contratos;
	private Contrato contratoSeleccionado;
	
	private Long idFiltrar;

	@PostConstruct
	public void init() {
		contrato=new Contrato();
		contratos= new ArrayList<>();
		contratoSeleccionado= new Contrato();
		
		mostrarContratos();
	}
	
	public void mostrarContratos() {
		try {
			contratos=contratoBusiness.getAll();
		}catch (Exception e) {
			Message.messageError("Error Carga de contratos :" + e.getMessage());
		}
		
	}
	
	public String editarContrato() {
		String view = "";
		try {
			if (this.contratoSeleccionado != null) {
				this.contrato = contratoSeleccionado;

				view = "/contrato/update";
			} else {
				Message.messageInfo("Debe seleccionar un contrato de la lista");
			}
		} catch (Exception e) {
			Message.messageError("Error Editar Contrato :" + e.getMessage());
		}

		return view;
	}
	
	public String actualizarContrato() {
		String view = "";
		try {

			contratoBusiness.update(contrato);
			Message.messageInfo("Registro actualizado exitosamente");
			mostrarContratos();
			limpiarFormulario();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Actualizar :" + e.getStackTrace());
		}

		return view;
	}
	
	public String nuevoContrato() {
		limpiarFormulario();
		return "insert.xhtml";
	}
	
	public String regresarContrato() {
		limpiarFormulario();
		return "list.xhtml";
	}

	public void limpiarFormulario() {
		this.contrato = new Contrato();
	}

	public void consultarContratoPorId() {
		try {

			contratos = contratoBusiness.getContratoById(idFiltrar);
			limpiarFormulario();
			if (contratos.isEmpty()) {
				Message.messageInfo("No se encontraron contratos con el id ingresado");
				mostrarContratos();
			}

		} catch (Exception e) {
			Message.messageError("Error Consultar :" + e.getMessage());
		}
	}

	
	public void seleccionarContrato(SelectEvent e) {
		this.contratoSeleccionado = (Contrato) e.getObject();
	}
	
	public ContratoBusiness getContratoBusiness() {
		return contratoBusiness;
	}

	public void setContratoBusiness(ContratoBusiness contratoBusiness) {
		this.contratoBusiness = contratoBusiness;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Contrato getContratoSeleccionado() {
		return contratoSeleccionado;
	}

	public void setContratoSeleccionado(Contrato contratoSeleccionado) {
		this.contratoSeleccionado = contratoSeleccionado;
	}

	public Long getIdFiltrar() {
		return idFiltrar;
	}

	public void setIdFiltrar(Long idFiltrar) {
		this.idFiltrar = idFiltrar;
	}

}