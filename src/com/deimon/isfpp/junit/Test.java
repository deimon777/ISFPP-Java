package com.deimon.isfpp.junit;

import com.deimon.entidades.camino.Camino;
import com.deimon.entidades.ciudad.Alojamiento;

import conexion.db.entidades.Caminos;
import conexion.db.entidades.Rec_Alojamientos;
import com.deimon.entidades.ciudad.SitioTuristico;
import conexion.db.entidades.Rec_SitiosTuristicos;

public class Test {

	public static void main(String[] args) {
		Alojamiento a = new Alojamiento();
		Rec_Alojamientos aa = new Rec_Alojamientos();
		a = aa.getAlojamiento(2);
		System.out.println("-------");
		System.out.println(a.getNombre());
		System.out.println(a.getCiudad().getNombre());
		System.out.println("-------");
		

		SitioTuristico st = new SitioTuristico();
		Rec_SitiosTuristicos stst = new Rec_SitiosTuristicos();
		st = stst.getSitioTuristico(1);
		System.out.println("-------");
		System.out.println(st.getNombre());
		System.out.println(st.getCiudad().getNombre());
		System.out.println("-------");
		
		
		Camino c = new Camino();
		Caminos cc = new Caminos();
		c = cc.getCaminos(1);
		System.out.println("-------");
		System.out.println(c.getNombre());
		System.out.println(c.getTipoCamino().getNombre());
		System.out.println(c.getEstadoCamino().getNombre());

		System.out.println(c.getCiudadInicio().getNombre());
		System.out.println(c.getCiudadFin().getNombre());
		System.out.println("-------");
		
		
	}

}
