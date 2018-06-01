package com.deimon.camino;

public class Trafico {
	private String nombre;
	private boolean activo;
	
	public Trafico() {
	}
	
	public Trafico(String nombre) {
		this.nombre = nombre;
	}
	
	public Trafico(String nombre, boolean activo) {
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
