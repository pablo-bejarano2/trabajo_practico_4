package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Alumno {
	private Integer dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private LocalDate fnacimiento;
	private String domicilio;
	private Integer libretaUniversitaria;
	
	public Alumno() {
		
	}
	public Alumno(Integer dni, String nombre, String apellido, String email, String telefono, LocalDate fnacimiento,
			String domicilio, Integer libretaUniversitaria) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fnacimiento = fnacimiento;
		this.domicilio = domicilio;
		this.libretaUniversitaria = libretaUniversitaria;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public LocalDate getFnacimiento() {
		return fnacimiento;
	}
	public void setFnacimiento(LocalDate fnacimiento) {
		this.fnacimiento = fnacimiento;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Integer getLibretaUniversitaria() {
		return libretaUniversitaria;
	}
	public void setLibretaUniversitaria(Integer libretaUniversitaria) {
		this.libretaUniversitaria = libretaUniversitaria;
	}
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", fnacimiento=" + fnacimiento + ", domicilio=" + domicilio
				+ ", libretaUniversitaria=" + libretaUniversitaria + "]";
	}
	
	
}
