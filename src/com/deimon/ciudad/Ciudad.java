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
    private String historia;
    private double latitud;
    private double longitud;
    private boolean activo;

	//private int alojamientos; //falta el tipo (lista)
	//private String sitios_turisticos; //falta el tipo (lista)
    
//	private Ciudad ciudadAnt = null;
//	private Ciudad ciudadSig = null;
	
	public Ciudad() {
		
	}
	
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
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}	
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}	
}
