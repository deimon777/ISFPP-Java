package com.deimon.entidades.camino;

public class EstadoCamino {
	private int id;
	private String nombre;;
	private int peso;
	
	public EstadoCamino() {
	}
	
	public EstadoCamino(String nombre) {
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
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
}
