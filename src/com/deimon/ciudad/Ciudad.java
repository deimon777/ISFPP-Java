/**
 * 
 */
package com.deimon.ciudad;

/**
 * @author deimon
 *
 */
public class Ciudad {
	private String nombre = "Falto el nombre";
	private int habitantes = 0;
    //private String reseña_histórica;
	//private int alojamientos; //falta el tipo (lista)
	//private String sitios_turisticos; //falta el tipo (lista)
	private Ciudad ciudadAnt = null;
	private Ciudad ciudadSig = null;
	
	
	public Ciudad(String nombre) {
		//super();
		this.nombre = nombre;
	}
	
	public Ciudad(String nombre, int habitantes) {
		//super();
		this.nombre = nombre;
		this.habitantes = habitantes;
		//this.ciudadAnt = null;
		//this.ciudadSig = null;
	}
	
	public Ciudad(String nombre, int habitantes, Ciudad anterior, Ciudad siguiente) {
		//super();
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.ciudadSig = anterior;
		this.ciudadAnt = siguiente;
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

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	
	public Ciudad getCiudadAnterior() {
		return ciudadAnt;
	}

	public void setCiudadAnterior(Ciudad anterior) {
		this.ciudadAnt = anterior;
	}

	public Ciudad getCiudadSiguiente() {
		return ciudadSig;
	}

	public void setCiudadSiguiente(Ciudad siguiente) {
		this.ciudadSig = siguiente;
	}
	
}
