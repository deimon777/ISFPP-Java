package com.deimon.camino;

public class EstadoCamino {
	private String nombre;
	private boolean activo;
	
	public EstadoCamino() {
	}
	
	public EstadoCamino(String nombre) {
		this.nombre = nombre;
	}
	
	public EstadoCamino(String nombre, boolean activo) {
		this.nombre = nombre;
		this.activo = activo;
	}
	
	/*
	 * Getter y Setter
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
