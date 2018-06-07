/**
 * 
 */
package com.deimon.entidades.ciudad;

/**
 * @author deimon
 *
 */
public class SitioTuristico {
	private int id;
	private String nombre;
    private boolean activo;
	private Ciudad ciudad_id = null;
	
	public SitioTuristico() {		
	}
	
	public SitioTuristico(String nombre) {
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
	public Ciudad getCiudad_id() {
		return ciudad_id;
	}
	public void setCiudad_id(Ciudad ciudad_id) {
		this.ciudad_id = ciudad_id;
	}	
}
