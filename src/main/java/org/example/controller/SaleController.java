package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.SaleBusiness;
import org.example.entities.Sale;
import org.example.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class SaleController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private SaleBusiness precioVentaBusiness;

	private Sale precioVenta;
	private List<Sale> precioVentas;
	private Sale precioVentaSeleccionado;

	private int claveFiltro;

	@PostConstruct
	public void init() {
		precioVenta = new Sale();
		precioVentas = new ArrayList<Sale>();
		precioVentaSeleccionado = new Sale();

		mostrarPreciosVenta();
	}

	public void mostrarPreciosVenta() {
		try {
			precioVentas = precioVentaBusiness.listarPreciosVenta();
		} catch (Exception e) {
			Message.messageError("Error Carga de Precios de Venta :" + e.getMessage());
		}
	}

	public String guardarPrecioVenta() {
		String view = "";
		try {

			precioVentaBusiness.registrarCalculoPrecioVenta(precioVenta);
			Message.messageInfo("Registro guardado exitosamente");
			mostrarPreciosVenta();
			limpiarFormulario();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Guardar :" + e.getStackTrace());
		}

		return view;
	}
	
	public String editarPrecioVenta() {
		String view = "";
		try {
			if (this.precioVentaSeleccionado != null) {
				this.precioVenta = precioVentaSeleccionado;

				view = "/precioventa/update";
			} else {
				Message.messageInfo("Debe seleccionar un precio de venta de la lista");
			}
		} catch (Exception e) {
			Message.messageError("Error Editar Precio Venta :" + e.getMessage());
		}

		return view;
	}
	
	public String actualizarPrecioVenta() {
		String view = "";
		try {

			precioVentaBusiness.actualizarCalculoPrecioVenta(precioVenta);
			Message.messageInfo("Registro actualizado exitosamente");
			mostrarPreciosVenta();
			limpiarFormulario();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Actualizar :" + e.getStackTrace());
		}

		return view;
	}

	public void consultarPrecioVentaPorClave() {
		try {

			precioVentas = precioVentaBusiness.listarPreciosVentaPorClave(claveFiltro);
			limpiarFormulario();
			if (precioVentas.isEmpty()) {
				Message.messageInfo("No se encontraron precios de venta con la clave de articulo ingresado");
				mostrarPreciosVenta();
			}

		} catch (Exception e) {
			Message.messageError("Error Consultar :" + e.getMessage());
		}
	}

	
	public String nuevoPrecioVenta() {
		limpiarFormulario();
		return "insert.xhtml";
	}
	
	public String regresarPrecioVenta() {
		limpiarFormulario();
		return "list.xhtml";
	}

	public void limpiarFormulario() {
		this.precioVenta = new Sale();
	}

	
	public void seleccionarPrecioVenta(SelectEvent e) {
		this.precioVentaSeleccionado = (Sale) e.getObject();
	}
	
	
	public Sale getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Sale precioVenta) {
		this.precioVenta = precioVenta;
	}

	public List<Sale> getPrecioVentas() {
		return precioVentas;
	}

	public void setPrecioVentas(List<Sale> precioVentas) {
		this.precioVentas = precioVentas;
	}

	public Sale getPrecioVentaSeleccionado() {
		return precioVentaSeleccionado;
	}

	public void setPrecioVentaSeleccionado(Sale precioVentaSeleccionado) {
		this.precioVentaSeleccionado = precioVentaSeleccionado;
	}

	public int getClaveFiltro() {
		return claveFiltro;
	}

	public void setClaveFiltro(int claveFiltro) {
		this.claveFiltro = claveFiltro;
	}

	
}
