/**
 * 
 */
package com.deimon.entidades.ciudad;

/**
 * @author deimon
 *
 */
public class Alojamiento {
	private int id;
	private String nombre;
    private boolean activo;
	private Vertice ciudad;
	
	public Alojamiento() {
	}	
	public Alojamiento(String nombre) {
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Vertice getCiudad() {
		return ciudad;
	}
	public void setCiudad(Vertice ciudad) {
		this.ciudad = ciudad;
	}	
}
