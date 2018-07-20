package com.deimon.entidades.camino;

public class TipoCamino {
	private int id;
	private String nombre;
	
	public TipoCamino() {
	}
	
	public TipoCamino(String nombre) {
		this.nombre = nombre;
	}
	
	public TipoCamino(String nombre, boolean activo) {
		this.nombre = nombre;
	}
	/*
	 * Getter y Setter
	 */
	public int getIDd() {
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
