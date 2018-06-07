package com.deimon.entidades.camino;

public class Camino {

	private int id;
	private String nombre;
	private int distancia;
	private int peso_camino;
	private TipoCamino tipo = null;
	private EstadoCamino estado = null;
	private Trafico trafico = null;
    private boolean activo;
    
	private Camino ciudad_inicio = null;
	private Camino ciudad_fin = null;

	public Camino() {
	}
	
	public Camino(String nombre) {
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
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public int getPesoCamino() {
		return peso_camino;
	}

	public void setPesoCamino(int peso_camino) {
		this.peso_camino = peso_camino;
	}
	public TipoCamino getTipoCamino() {
		return tipo;
	}
	public void setTipoCamino(TipoCamino tipo) {
		this.tipo = tipo;
	}
	public EstadoCamino getEstadoCamino() {
		return estado;
	}
	public void setEstadoCamino(EstadoCamino estado) {
		this.estado = estado;
	}
	public Trafico getTrafico() {
		return trafico;
	}
	public void setTrafico(Trafico trafico) {
		this.trafico = trafico;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

	public Camino getCiudadInicio() {
		return ciudad_inicio;
	}
	public void setCiudadInicio(Camino nombre) {
		this.ciudad_inicio = nombre;
	}

	public Camino getCiudadFin() {
		return ciudad_fin;
	}
	public void setCiudadFin(Camino nombre) {
		this.ciudad_fin = nombre;
	}
}
