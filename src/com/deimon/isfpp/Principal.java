/**
 * 
 */
package com.deimon.isfpp;

import com.deimon.ciudad.Ciudad;

/**
 * @author deimon
 *
 */
public class Principal {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* Crear las ciudades */
		Ciudad madryn = new Ciudad("Puerto Madryn",100000);
		//Ciudad trelew = new Ciudad("Trelew",250000);
		//Ciudad comodoro = new Ciudad("Comodoro",400000);

		/* Crear las rutas y relaciones */
		
		
		/* Test */
		System.out.println(madryn.getNombre());
		System.out.println(madryn.getHabitantes());
	}

}