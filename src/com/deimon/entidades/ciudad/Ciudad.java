/**
 * 
 */
package com.deimon.entidades.ciudad;

import java.util.List;

/**
 * @author deimon
 *
 */
public class Ciudad {
	private int id;
	private String nombre;
	private int habitantes;
    private String historia;
    private double latitud;
    private double longitud;
    private boolean activo;

	private List<Alojamiento> alojamientos;
	private List<SitioTuristico> sitios_turisticos;

	public Ciudad() {		
	}
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
//		return "Ciudad [ID=" + ID + ", nombre=" + nombre + ", habitantes=" + habitantes + ", historia=" + historia
//				+ ", latitud=" + latitud + ", longitud=" + longitud + ", activo=" + activo + "]";

		return nombre;
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
	
	
	public List<Alojamiento> getListaAlojamientos() {
		return alojamientos;
	}
	public void setAlojamientos(List<Alojamiento> alojamientos) {
		this.alojamientos = alojamientos;
	}

	public List<SitioTuristico> getListaSitiosTuristicos() {
		return sitios_turisticos;
	}

	public void setSitiosTuristicos(List<SitioTuristico> sitios_turisticos) {
		this.sitios_turisticos = sitios_turisticos;
	}
}
