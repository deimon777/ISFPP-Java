/**
 * 
 */
package com.deimon.entidades.ciudad;

/**
 * @author deimon
 *
 */
public class TipoVertice {
	private int id;
	private String nombre;
    private boolean activo;
	
	public TipoVertice() {
	}	
	public TipoVertice(String nombre) {
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
}
