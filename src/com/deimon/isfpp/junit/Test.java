package com.deimon.isfpp.junit;

import com.deimon.ciudad.Ciudad;
import com.deimon.camino.*;

import grafo.grafo.Edge;
import grafo.grafo.Graph;
import grafo.grafo.Vertex;
import grafo.utils.AdjacencyMapGraph;
import grafo.utils.GraphAlgorithms;
import grafo.utils.Map;
import grafo.utils.ProbeHashMap;

public class Test {

	public static void main(String[] args) {
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
		Ciudad madryn = new Ciudad("Puerto Madryn");
		Ciudad trelew = new Ciudad("Trelew");
		Ciudad comodoro = new Ciudad("Comodoro Rivadavia");
		Ciudad rawson = new Ciudad("Rawson");
		Ciudad piramides = new Ciudad("Pto. Piramides");


		Graph<Ciudad, Camino> grafo = new AdjacencyMapGraph<>(false);
		Graph<String, Integer> grafoDos = new AdjacencyMapGraph<>(false);		
		
		Vertex<Ciudad> vPM = grafo.insertVertex(madryn);
		Vertex<Ciudad> vTW = grafo.insertVertex(trelew);
		Vertex<Ciudad> vCR = grafo.insertVertex(comodoro);
		Vertex<Ciudad> vRW = grafo.insertVertex(rawson);
		Vertex<Ciudad> vPI = grafo.insertVertex(piramides);

		Edge<Camino> pm_tw = grafo.insertEdge(vPM, vTW, new Camino("Ruta 3",70));
		Edge<Camino> pm_rw = grafo.insertEdge(vPM, vRW, new Camino("Ruta 1",80));
		Edge<Camino> pm_pi = grafo.insertEdge(vPM, vPI, new Camino("Ruta 20",90));
		Edge<Camino> tw_cr = grafo.insertEdge(vTW, vCR, new Camino("Ruta 3",410));
		Edge<Camino> tw_rw = grafo.insertEdge(vTW, vRW, new Camino("Ruta 7",20));
		Edge<Camino> tw_pi = grafo.insertEdge(vTW, vPI, new Camino("Ruta 3",100));

		System.out.println("La cantidad de ciudades son: "+grafo.numVertices());
		System.out.println("La cantidad de caminos son: "+grafo.numEdges());
		System.out.println("------");

		String ciudad = madryn.getNombre();
		System.out.println("Partiendo de \""+ciudad+"\" la distancia maxima es:");
		
		Map<String, Vertex<String>> res = new ProbeHashMap<>();
		for (Vertex<Ciudad> result : grafo.vertices())
			res.put(result.getElement().getNombre(), grafoDos.insertVertex(result.getElement().getNombre()));

		Vertex<Ciudad>[] vert;
		for (Edge<Camino> result : grafo.edges()) {
			vert = grafo.endVertices(result);
			grafoDos.insertEdge(res.get(vert[0].getElement().getNombre()), res.get(vert[1]
					.getElement().getNombre()), result.getElement().getDistancia());
		}
		
		Map<Vertex<String>, Integer> mapa = GraphAlgorithms.shortestPathLengths(grafoDos, res.get(ciudad));

		for (Vertex<String> result : mapa.keySet())
			System.out.println(result.getElement() + "  -->  "+ mapa.get(result)+"km");
		
		
		
	}
}