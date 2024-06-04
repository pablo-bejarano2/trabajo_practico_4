package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {
	private Integer codigo;
	private String nombre;
	private Byte cantidadAnios;
	private Boolean estado;
	public Integer getCodigo() {
		return codigo;
	}
	public Carrera() {
		
	}
	public Carrera(Integer codigo, String nombre, Byte cantidadAnios, Boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAnios = cantidadAnios;
		this.estado = estado;
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
	public Byte getCantidadAnios() {
		return cantidadAnios;
	}
	public void setCantidadAnios(Byte cantidadAnios) {
		this.cantidadAnios = cantidadAnios;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + ", cantidadAnios=" + cantidadAnios + ", estado="
				+ estado + "]";
	}
	
	
}
