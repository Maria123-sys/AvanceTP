package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Sale;
import org.example.repository.SalesRepository;
import org.example.util.Formatos;

@Named
public class SaleBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private SalesRepository precioVentaRepository;
	
	@Transactional
	public Long registrarCalculoPrecioVenta(Sale precioVenta) throws Exception {

		precioVenta.setPrecio(calcularPrecioVenta(precioVenta));

		return precioVentaRepository.insert(precioVenta);

	}

	@Transactional
	public Long actualizarCalculoPrecioVenta(Sale precioVenta) throws Exception {

		precioVenta.setPrecio(calcularPrecioVenta(precioVenta));

		return precioVentaRepository.update(precioVenta);

	}
	
	public List<Sale> listarPreciosVenta() throws Exception {
		return precioVentaRepository.findAll();
	}


	public List<Sale> listarPreciosVentaPorClave(int clave) throws Exception {
		return precioVentaRepository.findByClave(clave);
	}

	private double calcularPrecioVenta(Sale precioVenta) {

		double resultadoPrecioVenta;
		double resultadoManoObra;
		double resultadoGastoFabricacion;
		double resultadoCostoProduccion;

		if (precioVenta.getClave() == 3 || precioVenta.getClave() == 4) {
			resultadoManoObra = precioVenta.getCostoMateriaPrima() * 0.75;
		} else if (precioVenta.getClave() == 1 || precioVenta.getClave() == 5) {
			resultadoManoObra = precioVenta.getCostoMateriaPrima() * 0.80;
		} else {
			resultadoManoObra = precioVenta.getCostoMateriaPrima() * 0.85;
		}

		if (precioVenta.getClave() == 2 || precioVenta.getClave() == 5) {
			resultadoGastoFabricacion = precioVenta.getCostoMateriaPrima() * 0.30;
		} else if (precioVenta.getClave() == 3 || precioVenta.getClave() == 6) {
			resultadoGastoFabricacion = precioVenta.getCostoMateriaPrima() * 0.35;
		} else {
			resultadoGastoFabricacion = precioVenta.getCostoMateriaPrima() * 0.28;
		}

		resultadoCostoProduccion = precioVenta.getCostoMateriaPrima() + resultadoManoObra + resultadoGastoFabricacion;
		resultadoPrecioVenta = resultadoCostoProduccion + resultadoCostoProduccion * 0.45;

		return Formatos.formatearDecimales(resultadoPrecioVenta, 2);
	}
	

}
