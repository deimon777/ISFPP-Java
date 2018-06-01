package com.deimon.camino;

public class Camino {

	private int ID;
	private String nombre;
	private int distancia;
	private int peso_camino;
	private TipoCamino tipo = null;
	private EstadoCamino estado = null;
	private Trafico trafico = null;
    private boolean activo;
    
	private Camino inicio = null;
	private Camino fin = null;

	public Camino() {
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
}
