package gui.utiles;

import javafx.collections.ObservableList;

import grafo.grafo.Graph;
import grafo.grafo.Vertex;
import grafo.grafo.Edge;
import grafo.utiles.AdjacencyMapGraph;
import grafo.utiles.GraphAlgorithms;
import grafo.utiles.Map;
import grafo.utiles.ProbeHashMap;

import com.deimon.entidades.ciudad.Ciudad;

import com.deimon.entidades.camino.Camino;

import conexion.db.entidades.Ciudades;
import conexion.db.entidades.Caminos;

public class CrearGrafo{
	private Graph<Ciudad, Camino> g = new AdjacencyMapGraph<>(false);

	ObservableList<Ciudad> listaCiudad;
	ObservableList<Camino> listaCamino;
	
	public void cargarVertices() {
		System.out.println("---------- V");
		System.out.println("Vertice");
		Ciudades ciudades = new Ciudades();
		listaCiudad = ciudades.getListaCiudades();
//		System.out.println(listaCiudad.toString());
		listaCiudad.forEach(node ->{			
//			System.out.println(node.getNombre());
			g.insertVertex(node);
		});
			
//		Vertex<Ciudad> vPM = grafo.insertVertex(madryn);	
		System.out.println(listaCiudad.get(0).getNombre());	
		System.out.println("La cantidad de ciudades son: "+g.numVertices());	
		System.out.println("---------- V");
	}
	
	public void cargarAristas() {		
		System.out.println("----------- A");
		System.out.println("Arista");
		Caminos caminos = new Caminos();
		listaCamino = caminos.getListaCaminos();	
//		System.out.println(listaCamino.toString());
		listaCamino.forEach(node ->{			
//			System.out.println(node.getNombre());
//			g.insertEdge(g.insertVertex(node.getCiudadInicio()), g.insertVertex(node.getCiudadFin()), node);
//			grafo.insertEdge(node.getCiudadInicioNombre(), node.getCiudadFinNombre(), node);

			System.out.print(node.getCiudadInicio()+"     ");
			System.out.print(listaCiudad.get(0)+"     ");
			System.out.println(listaCiudad.contains(node.getCiudadInicio()));
		});
		System.out.println("La cantidad de caminos son: "+g.numEdges());
		System.out.println("----------- A");
	}
	
	public void mostrarCamino() {
//		Map<Vertex<Ciudad>, Integer> res = GraphAlgorithms.shortestPathLengths(
//				g, listaCiudad.get(1));
//
//		for (Vertex<String> result : res.keySet())
//			System.out.println(result.getElement() + "  -->  "
//					+ res.get(result));
//
//		Map<Vertex<String>, Edge<Integer>> tree;
//
//		tree = GraphAlgorithms.spTree(g, v1, res);
//
//		for (Vertex<String> ver : tree.keySet())
//			System.out.println(ver.getElement() + "  ----->  "
//					+ tree.get(ver).getElement());
//
//		Edge<Integer> arc;
//		Vertex<String> ver = v4;
//		
//		while (ver != v1) {
//			System.out.println(ver.getElement());
//			arc = tree.get(ver);
//			ver = g.opposite(ver, arc);
//		}
	}
}
