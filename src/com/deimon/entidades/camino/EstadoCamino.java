package com.deimon.entidades.camino;

public class EstadoCamino {
	private int id;
	private String nombre;
	
	public EstadoCamino() {
	}
	
	public EstadoCamino(String nombre) {
		this.nombre = nombre;
	}
	
	public EstadoCamino(String nombre, boolean activo) {
		this.nombre = nombre;
	}
	
	/*
	 * Getter y Setter
	 */
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
