package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.InmuebleBusiness;
import org.example.business.ArrendadorBusiness;
import org.example.entities.Arrendador;
import org.example.entities.Inmueble;
import org.example.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class InmuebleController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private InmuebleBusiness inmuebleBusiness;

	@Inject
	private ArrendadorBusiness arrendadorBusiness;

	private Inmueble inmueble;
	private List<Inmueble> inmuebles;
	private Arrendador arrendador;
	private List<Arrendador> arrendadores;

	private Inmueble inmuebleSeleccionado;

	private Long idFiltro;

	@PostConstruct
	public void init() {
		inmueble = new Inmueble();
		inmuebles = new ArrayList<Inmueble>();
		inmuebleSeleccionado = new Inmueble();

		arrendador = new Arrendador();
		arrendadores = new ArrayList<Arrendador>();

		mostrarInmueble();
	}

	public void mostrarInmueble() {
		try {
			inmuebles = inmuebleBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de inmuebles :" + e.getMessage());
		}
	}

	public String guardarInmueble() {
		String view = "";

		try {
			inmueble.setArrendador(arrendador);
			inmuebleBusiness.insert(inmueble);
			Message.messageInfo("Registro guardado exitosamente");
			mostrarInmueble();
			limpiarFormulario();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Guardar :" + e.getStackTrace());
		}

		return view;

	}

	public String editarInmueble() {
		String view = "";
		try {
			if (this.inmuebleSeleccionado != null) {
				this.inmueble = inmuebleSeleccionado;

				view = "/inmueble/update";
			} else {
				Message.messageInfo("Debe seleccionar un inmueble de la lista");
			}
		} catch (Exception e) {
			Message.messageError("Error Editar inmueble :" + e.getMessage());
		}

		return view;
	}

	public String actualizarInmueble() {
		String view = "";
		try {

			inmuebleBusiness.update(inmueble);
			Message.messageInfo("Registro actualizado exitosamente");
			mostrarInmueble();
			limpiarFormulario();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Actualizar :" + e.getStackTrace());
		}

		return view;
	}

	public void consultarInmueblePorId() {
		try {

			inmuebles = inmuebleBusiness.getCitaById(idFiltro);
			limpiarFormulario();
			if (inmuebles.isEmpty()) {
				Message.messageInfo("No se encontraron citas con el id ingresado");
				mostrarInmueble();
			}

		} catch (Exception e) {
			Message.messageError("Error Consultar :" + e.getMessage());
		}
	}

	public String nuevoInmueble() {

		try {
			this.arrendadores = arrendadorBusiness.getAll();
			limpiarFormulario();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";

	}

	public String regresarInmueble() {
		limpiarFormulario();
		return "list.xhtml";
	}

	public void limpiarFormulario() {
		this.inmueble = new Inmueble();
	}

	public void seleccionarInmueble(SelectEvent e) {
		this.inmuebleSeleccionado = (Inmueble) e.getObject();
	}

	public InmuebleBusiness getInmuebleBusiness() {
		return inmuebleBusiness;
	}

	public void setInmuebleBusiness(InmuebleBusiness inmuebleBusiness) {
		this.inmuebleBusiness = inmuebleBusiness;
	}

	public ArrendadorBusiness getArrendadorBusiness() {
		return arrendadorBusiness;
	}

	public void setArrendadorBusiness(ArrendadorBusiness arrendadorBusiness) {
		this.arrendadorBusiness = arrendadorBusiness;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
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

	public Inmueble getInmuebleSeleccionado() {
		return inmuebleSeleccionado;
	}

	public void setInmuebleSeleccionado(Inmueble inmuebleSeleccionado) {
		this.inmuebleSeleccionado = inmuebleSeleccionado;
	}

	public Long getIdFiltro() {
		return idFiltro;
	}

	public void setIdFiltro(Long idFiltro) {
		this.idFiltro = idFiltro;
	}

}