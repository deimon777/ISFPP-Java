/**
 * 
 */
package com.deimon.ciudad;

/**
 * @author deimon
 *
 */
public class Ciudad {
	private int ID;
	private String nombre = "Falto el nombre";
	private int habitantes = 0;
    private String historia;
    private double latitud;
    private double longitud;
    private boolean activo;

	//private int alojamientos; //falta el tipo (lista)
	//private String sitios_turisticos; //falta el tipo (lista)
	
	public Ciudad() {		
	}
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
	}
	
	/*
	 * Getter y Setter
	 */
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
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
