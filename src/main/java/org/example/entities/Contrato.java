package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contratos")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_inicio", length = 20, nullable = false)
	private String fechaInicio;

	@Column(name = "fecha_fin", length = 20, nullable = false)
	private String fechaFin;

	@Column(name = "monto_acordado", nullable = false)
	private double monto;

	@Column(name = "comentario_arrendador", length = 200, nullable = true)
	private String comentarioArrendador;

	@Column(name = "comentario_arrendatario", length = 200, nullable = true)
	private String comentarioArrendatario;

	@ManyToOne
	@JoinColumn(name = "arrendador_id", nullable = false)
	private Arrendador arrendador;

	@ManyToOne
	@JoinColumn(name = "arrendatario_id", nullable = false)
	private Arrendatario arrendatario;

	@ManyToOne
	@JoinColumn(name = "inmueble_id", nullable = false)
	private Inmueble inmueble;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getComentarioArrendador() {
		return comentarioArrendador;
	}

	public void setComentarioArrendador(String comentarioArrendador) {
		this.comentarioArrendador = comentarioArrendador;
	}

	public String getComentarioArrendatario() {
		return comentarioArrendatario;
	}

	public void setComentarioArrendatario(String comentarioArrendatario) {
		this.comentarioArrendatario = comentarioArrendatario;
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

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

}
