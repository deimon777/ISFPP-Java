package com.deimon.entidades.camino;

public class TipoCamino {
	private int id;
	private String nombre;
	private boolean activo;
	
	public TipoCamino() {
	}
	
	public TipoCamino(String nombre) {
		this.nombre = nombre;
	}
	
	public TipoCamino(String nombre, boolean activo) {
		this.nombre = nombre;
		this.activo = activo;
	}
	/*
	 * Getter y Setter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
