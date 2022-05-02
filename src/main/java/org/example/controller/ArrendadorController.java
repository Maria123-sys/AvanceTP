package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.ArrendadorBusiness;
import org.example.entities.Arrendador;
import org.example.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class ArrendadorController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ArrendadorBusiness arrendadorBusiness;

	private Arrendador arrendador;
	private List<Arrendador> arrendadores;

	private Arrendador arrendadorSeleccionado;

	private Long idFiltro;

	@PostConstruct
	public void init() {

		arrendador = new Arrendador();
		arrendadores = new ArrayList<Arrendador>();

		arrendadorSeleccionado = new Arrendador();

		mostrarArrendadores();
	}

	public void mostrarArrendadores() {
		try {
			arrendadores = arrendadorBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de citas :" + e.getMessage());
		}
	}

	public void seleccionarArrendador(SelectEvent e) {
		this.arrendadorSeleccionado = (Arrendador) e.getObject();
	}

	public ArrendadorBusiness getArrendadorBusiness() {
		return arrendadorBusiness;
	}

	public void setArrendadorBusiness(ArrendadorBusiness arrendadorBusiness) {
		this.arrendadorBusiness = arrendadorBusiness;
	}

	public Arrendador getArrendador() {
		return arrendador;
	}

	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}

	public List<Arrendador> getArrendadores() {
		return arrendadores;
	}

	public void setArrendadores(List<Arrendador> arrendadores) {
		this.arrendadores = arrendadores;
	}

	public Arrendador getArrendadorSeleccionado() {
		return arrendadorSeleccionado;
	}

	public void setArrendadorSeleccionado(Arrendador arrendadorSeleccionado) {
		this.arrendadorSeleccionado = arrendadorSeleccionado;
	}

	public Long getIdFiltro() {
		return idFiltro;
	}

	public void setIdFiltro(Long idFiltro) {
		this.idFiltro = idFiltro;
	}

}