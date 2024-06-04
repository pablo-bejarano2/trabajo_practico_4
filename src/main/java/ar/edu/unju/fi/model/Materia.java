package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	private Integer codigo;
	private String nombre;
	private Integer cantidadHoras;
	private String curso;
	private Boolean modalidad;
	private Docente docente;
	private Carrera carrera;
	
	public Materia() {
		
	}
	
	public Materia(Integer codigo, String nombre, Integer cantidadHoras, String curso, Boolean modalidad,
			Docente docente, Carrera carrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadHoras = cantidadHoras;
		this.curso = curso;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidadHoras() {
		return cantidadHoras;
	}
	public void setCantidadHoras(Integer cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Boolean getModalidad() {
		return modalidad;
	}
	public void setModalidad(Boolean modalidad) {
		this.modalidad = modalidad;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	@Override
	public String toString() {
		return "Materia [codigo=" + codigo + ", nombre=" + nombre + ", cantidadHoras=" + cantidadHoras + ", curso="
				+ curso + ", modalidad=" + modalidad + ", docente=" + docente + ", carrera=" + carrera + "]";
	}
	
	
}
