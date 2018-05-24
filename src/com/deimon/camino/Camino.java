package com.deimon.camino;

import com.deimon.ciudad.Ciudad;

public class Camino {

	private String nombre;
	private int distancia;
	private TipoCamino tipo = null;
	private EstadoCamino estado = null;
	private Ciudad inicio = null;
	private Ciudad fin = null;

	public Camino(String nombre, int distancia) {
		this.nombre = nombre;
		this.distancia = distancia;
	}

	public Camino(String nombre, int distancia, TipoCamino tipo) {
		this.nombre = nombre;
		this.distancia = distancia;
		this.tipo = tipo;
	}

	public Camino(String nombre, int distancia, TipoCamino tipo, EstadoCamino estado) {
		this.nombre = nombre;
		this.distancia = distancia;
		this.tipo = tipo;
		this.estado = estado;
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
	public TipoCamino getTipo() {
		return tipo;
	}
	public void setTipo(TipoCamino tipo) {
		this.tipo = tipo;
	}
	public EstadoCamino getEstado() {
		return estado;
	}
	public void setEstado(EstadoCamino estado) {
		this.estado = estado;
	}

}
