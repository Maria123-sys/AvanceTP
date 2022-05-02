package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arrendatarios")
public class Arrendatario  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 80, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 80, nullable = false)
	private String apellido;

	@Column(name = "dni", length = 8, nullable = false)
	private String dni;

	@Column(name = "edad", nullable = false)
	private int edad;

	@Column(name = "fecha_nacimiento", length = 15, nullable = false)
	private String fechaNacimiento;

	@Column(name = "carrera", length = 80, nullable = false)
	private String carrera;

	@Column(name = "situacion_laboral", length = 80, nullable = false)
	private String situacionLaboral;

	@Column(name = "telefono", length = 9, nullable = false)
	private String telefono;

	@Column(name = "ciudad", length = 120, nullable = false)
	private String ciudad;

	@Column(name = "correo", length = 50, nullable = false)
	private String correo;

	@Column(name = "sexo", length = 15, nullable = false)
	private String sexo;

	@Column(name = "sede_upc", length = 50, nullable = false)
	private String sedeUpc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getSituacionLaboral() {
		return situacionLaboral;
	}

	public void setSituacionLaboral(String situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSedeUpc() {
		return sedeUpc;
	}

	public void setSedeUpc(String sedeUpc) {
		this.sedeUpc = sedeUpc;
	}

}