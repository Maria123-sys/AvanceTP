package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.CitaBusiness;
import org.example.business.ArrendadorBusiness;
import org.example.business.ArrendatarioBusiness;
import org.example.entities.Cita;
import org.example.entities.Arrendador;
import org.example.entities.Arrendatario;
import org.example.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class CitaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CitaBusiness citaBusiness;

	@Inject
	private ArrendadorBusiness arrendadorBusiness;

	@Inject
	private ArrendatarioBusiness arrendatarioBusiness;

	private Cita cita;
	private List<Cita> citas;
	private Arrendador arrendador;
	private List<Arrendador> arrendadores;
	private Arrendatario arrendatario;
	private List<Arrendatario> arrendatarios;

	private Cita citaSeleccionada;

	private Long idFiltro;

	@PostConstruct
	public void init() {
		cita = new Cita();
		citas = new ArrayList<Cita>();
		citaSeleccionada = new Cita();

		arrendador = new Arrendador();
		arrendadores = new ArrayList<Arrendador>();

		arrendatario = new Arrendatario();
		arrendatarios = new ArrayList<Arrendatario>();

		mostrarCita();
	}

	public void mostrarCita() {
		try {
			citas = citaBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de arrendadores :" + e.getMessage());
		}
	}

	public String guardarCita() {
		String view = "";
		
		try {
			cita.setArrendador(arrendador);
			cita.setArrendatario(arrendatario);
			citaBusiness.insert(cita);
			Message.messageInfo("Registro guardado exitosamente");
			mostrarCita();
			limpiarFormulario();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Guardar :" + e.getStackTrace());
		}

		return view;

	}

	public String editarCita() {
		String view = "";
		try {
			if (this.citaSeleccionada != null) {
				this.cita = citaSeleccionada;

				view = "/cita/update";
			} else {
				Message.messageInfo("Debe seleccionar una cita de la lista");
			}
		} catch (Exception e) {
			Message.messageError("Error Editar cita :" + e.getMessage());
		}

		return view;
	}

	public String actualizarCita() {
		String view = "";
		try {

			citaBusiness.update(cita);
			Message.messageInfo("Registro actualizado exitosamente");
			mostrarCita();
			limpiarFormulario();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Actualizar :" + e.getStackTrace());
		}

		return view;
	}

	public void consultarCitaPorId() {
		try {

			citas = citaBusiness.getCitaById(idFiltro);
			limpiarFormulario();
			if (citas.isEmpty()) {
				Message.messageInfo("No se encontraron citas con el id ingresado");
				mostrarCita();
			}

		} catch (Exception e) {
			Message.messageError("Error Consultar :" + e.getMessage());
		}
	}

	public String nuevaCita() {

		try {
			this.arrendadores = arrendadorBusiness.getAll();
			this.arrendatarios = arrendatarioBusiness.getAll();
			limpiarFormulario();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";

	}

	public String regresarCita() {
		limpiarFormulario();
		return "list.xhtml";
	}

	public void limpiarFormulario() {
		this.cita = new Cita();
	}

	public void seleccionarCita(SelectEvent e) {
		this.citaSeleccionada = (Cita) e.getObject();
	}

	public CitaBusiness getCitaBusiness() {
		return citaBusiness;
	}

	public void setCitaBusiness(CitaBusiness citaBusiness) {
		this.citaBusiness = citaBusiness;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita getCitaSeleccionada() {
		return citaSeleccionada;
	}

	public void setCitaSeleccionada(Cita citaSeleccionada) {
		this.citaSeleccionada = citaSeleccionada;
	}

	public Long getIdFiltro() {
		return idFiltro;
	}

	public void setIdFiltro(Long idFiltro) {
		this.idFiltro = idFiltro;
	}

	public Arrendador getArrendador() {
		return arrendador;
	}

	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}

	public Arrendatario getArrendatario() {
		return arrendatario;
	}

	public void setArrendatario(Arrendatario arrendatario) {
		this.arrendatario = arrendatario;
	}

	public ArrendadorBusiness getArrendadorBusiness() {
		return arrendadorBusiness;
	}

	public void setArrendadorBusiness(ArrendadorBusiness arrendadorBusiness) {
		this.arrendadorBusiness = arrendadorBusiness;
	}

	public ArrendatarioBusiness getArrendatarioBusiness() {
		return arrendatarioBusiness;
	}

	public void setArrendatarioBusiness(ArrendatarioBusiness arrendatarioBusiness) {
		this.arrendatarioBusiness = arrendatarioBusiness;
	}

	public List<Arrendador> getArrendadores() {
		return arrendadores;
	}

	public void setArrendadores(List<Arrendador> arrendadores) {
		this.arrendadores = arrendadores;
	}

	public List<Arrendatario> getArrendatarios() {
		return arrendatarios;
	}

	public void setArrendatarios(List<Arrendatario> arrendatarios) {
		this.arrendatarios = arrendatarios;
	}

}