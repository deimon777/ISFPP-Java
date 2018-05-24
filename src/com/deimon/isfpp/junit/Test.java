package com.deimon.isfpp.junit;

import com.deimon.isfpp.configuracion.Constantes;
import com.deimon.isfpp.configuracion.ConstantesPropierties;
import com.deimon.isfpp.configuracion.UtilProperties;
import com.deimon.ciudad.Ciudad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.deimon.camino.*;

import conexion.db.entidades.*;

import grafo.grafo.Edge;
import grafo.grafo.Graph;
import grafo.grafo.Vertex;
import grafo.utils.AdjacencyMapGraph;
import grafo.utils.GraphAlgorithms;
import grafo.utils.Map;
import grafo.utils.ProbeHashMap;

public class Test {

	public static void main(String[] args) {
		/*Propeties*/
//		String name_properties = "db.properties";
//		UtilProperties app = new UtilProperties();
//		app.setDBProperties(name_properties,"isfpp","isfpp","isfpp");
//		System.out.println("Properties");
//		System.out.println(app.getDBProperties(name_properties,Constantes.DB_KEY));
//		System.out.println(app.getDBProperties(name_properties,Constantes.DB_KEY_USER));
//		System.out.println(app.getDBProperties(name_properties,Constantes.DB_KEY_PASS));
//		System.out.println("------------");
//		ConstantesPropierties constantes = new ConstantesPropierties();
//		constantes.setDB_URL(app.getDBProperties(name_properties,Constantes.DB_KEY));
//		constantes.setDB_USER(app.getDBProperties(name_properties,Constantes.DB_KEY_USER));
//		constantes.setDB_PASS(app.getDBProperties(name_properties,Constantes.DB_KEY_PASS));


		/*DB*/			
//		DB_Entidades entidades = new DB_Entidades();
//		entidades.borrarTodasLasTablas();
//		entidades.crearTodasLasTablas();
//		Ciudades db_ciudad = new Ciudades();
//		db_ciudad.insertItem("Madryn", 100000, "", 0.0, 0.0, 1);
//		db_ciudad.insertItem("Madryn", 100000);
//		db_ciudad.deleteItemByNAME("Madryn");
//		db_ciudad.desactivarCiudad(1);
//		db_ciudad.activarCiudad(1);
		
//		db_ciudad.updateItemBy("nombre", "comodoro",1);
//		db_ciudad.updateItemBy("historia", "algo de info",1);
//		DB_Alojamientos db_alojamiento = new DB_Alojamientos();
//		db_alojamiento.insertItem("Rayentray", 1, 1);
//		db_alojamiento.deleteItemByID(1);
				

		/* tipo camino */
		//		TipoCamino asfalto = new TipoCamino("Asfalto");
		//		TipoCamino ripio = new TipoCamino("Ripo");

		/* estado camino */
		//		EstadoCamino muyBueno = new EstadoCamino("Muy bueno");
		//		EstadoCamino bueno = new EstadoCamino("Bueno");
		//		EstadoCamino regular = new EstadoCamino("Regular");
		//		EstadoCamino malo = new EstadoCamino("Malo");
		//		EstadoCamino muyMalo = new EstadoCamino("Muy Malo");

		/* ciudades*/
		//		Ciudad madryn = new Ciudad("Puerto Madryn");
		//		Ciudad trelew = new Ciudad("Trelew");
		//		Ciudad comodoro = new Ciudad("Comodoro Rivadavia");
		//		Ciudad rawson = new Ciudad("Rawson");
		//		Ciudad piramides = new Ciudad("Pto. Piramides");
		//
		//
		//		Graph<Ciudad, Camino> grafo = new AdjacencyMapGraph<>(false);
		//		Graph<String, Integer> grafoDos = new AdjacencyMapGraph<>(false);		
		//		
		//		Vertex<Ciudad> vPM = grafo.insertVertex(madryn);
		//		Vertex<Ciudad> vTW = grafo.insertVertex(trelew);
		//		Vertex<Ciudad> vCR = grafo.insertVertex(comodoro);
		//		Vertex<Ciudad> vRW = grafo.insertVertex(rawson);
		//		Vertex<Ciudad> vPI = grafo.insertVertex(piramides);
		//
		//		Edge<Camino> pm_tw = grafo.insertEdge(vPM, vTW, new Camino("Ruta 3",70));
		//		Edge<Camino> pm_rw = grafo.insertEdge(vPM, vRW, new Camino("Ruta 1",80));
		//		Edge<Camino> pm_pi = grafo.insertEdge(vPM, vPI, new Camino("Ruta 20",90));
		//		Edge<Camino> tw_cr = grafo.insertEdge(vTW, vCR, new Camino("Ruta 3",410));
		//		Edge<Camino> tw_rw = grafo.insertEdge(vTW, vRW, new Camino("Ruta 7",20));
		//		Edge<Camino> tw_pi = grafo.insertEdge(vTW, vPI, new Camino("Ruta 3",100));
		//
		//		System.out.println("La cantidad de ciudades son: "+grafo.numVertices());
		//		System.out.println("La cantidad de caminos son: "+grafo.numEdges());
		//		System.out.println("------------");
		//
		//		String ciudad = madryn.getNombre();
		//		System.out.println("Partiendo de \""+ciudad+"\" la distancia maxima es:");
		//		
		//		Map<String, Vertex<String>> res = new ProbeHashMap<>();
		//		for (Vertex<Ciudad> result : grafo.vertices())
		//			res.put(result.getElement().getNombre(), grafoDos.insertVertex(result.getElement().getNombre()));
		//
		//		Vertex<Ciudad>[] vert;
		//		for (Edge<Camino> result : grafo.edges()) {
		//			vert = grafo.endVertices(result);
		//			grafoDos.insertEdge(res.get(vert[0].getElement().getNombre()), res.get(vert[1]
		//					.getElement().getNombre()), result.getElement().getDistancia());
		//		}
		//		
		//		Map<Vertex<String>, Integer> mapa = GraphAlgorithms.shortestPathLengths(grafoDos, res.get(ciudad));
		//
		//		for (Vertex<String> result : mapa.keySet())
		//			System.out.println(result.getElement() + "  -->  "+ mapa.get(result)+"km");
	}
}