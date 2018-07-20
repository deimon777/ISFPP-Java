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

import java.util.ArrayList;

import com.deimon.entidades.camino.Camino;

import conexion.db.entidades.Ciudades;
import conexion.db.entidades.Caminos;

public class CrearGrafo{
	private Graph<Ciudad, Integer> g = new AdjacencyMapGraph<>(false);

	ObservableList<Ciudad> listaCiudad;
	ObservableList<Camino> listaCamino;
	ArrayList<Vertex<Ciudad>> listaVertices = new ArrayList<>();

	private void listaCiudades() {
		Ciudades ciudades = new Ciudades();
		listaCiudad = ciudades.getListaCiudades();
	}

	private void listaCamino() {		
		Caminos caminos = new Caminos();
		listaCamino = caminos.getListaCaminos();
	}


	private void cargarListaVertices() {
		for(int i=0; i<listaCiudad.size(); i++){
			listaVertices.add(i,g.insertVertex(listaCiudad.get(i)));
		};

	}

	private void cargarAristas() {
		int cInicial = 0;
		int cFinal = 0;
		int j, i;
		for(i=0; i<listaCamino.size(); i++){
			for(j=0; j<listaCiudad.size(); j++){
				if(listaCiudad.get(j).getNombre().equals(listaCamino.get(i).getCiudadInicio().getNombre())) {
					cInicial = j;
				}
				if(listaCiudad.get(j).getNombre().equals(listaCamino.get(i).getCiudadFin().getNombre())) {
					cFinal = j;
				}
			}
			g.insertEdge(listaVertices.get(cInicial), listaVertices.get(cFinal), listaCamino.get(i).getDistancia());
		}  
	}

	public void cargarGrafo() {
		listaCiudades();
		listaCamino();
		cargarListaVertices();
		cargarAristas();
	}

	Vertex<Ciudad> vert = null;
	private Vertex<Ciudad> buscarCiudadEnLista(String nCiudad) {
		listaVertices.forEach( ciudad -> {
			if(ciudad.getElement().getNombre().equals(nCiudad)){
				vert = ciudad;
			}
		});
		return vert;
	}

	public void buscarCamino(String ciudad1, String ciudad2) {
		Vertex<Ciudad> c1 = buscarCiudadEnLista(ciudad1);
		Vertex<Ciudad> c2 = buscarCiudadEnLista(ciudad2);
		Map<Vertex<Ciudad>, Integer> res = GraphAlgorithms.shortestPathLengths(g, c1);
		
		todasLasDistancias(res);


//		Map<Vertex<Ciudad>, Edge<Integer>> tree;
//		tree = GraphAlgorithms.spTree(g, c1, res);
//		System.out.println("Muestra los caminos hacia una ciudad cada");
//		System.out.println("Ciudad: "+c1.getElement().getNombre());
//		for (Vertex<Ciudad> ver : tree.keySet())
//			System.out.println(ver.getElement() + "  ----->  " + tree.get(ver).getElement()+"km");
//		System.out.println("-----------------------");
//		System.out.println("-----------------------");
//		System.out.println("-----------------------");
//		System.out.println("-----------------------");
//		
//		tree = GraphAlgorithms.spTree(g, c2, res);
//		System.out.println("Ciudad: "+c2.getElement().getNombre());
//		for (Vertex<Ciudad> ver : tree.keySet())
//			System.out.println(ver.getElement() + "  ----->  " + tree.get(ver).getElement()+"km");
//		System.out.println("-----------------------");

		//		System.out.println("Partiendo de \""+c1.getElement().getNombre()+"\" la distancia maxima es:");
		//		Map<String, Vertex<Ciudad>> res2 = new ProbeHashMap<>();
		//		for (Vertex<Ciudad> result : g.vertices())
		//			res2.put(result.getElement().getNombre(), g.insertVertex(result.getElement()));

//		Edge<Integer> arc;
//		Vertex<Ciudad> ver = c2;
//
//		while (ver != c1) {
//			System.out.println(ver.getElement());
//			arc = tree.get(ver);
//			ver = g.opposite(ver, arc);
//		}

	}
	
	private void todasLasDistancias(Map<Vertex<Ciudad>, Integer> res) {
		System.out.println("-----------------------");
		System.out.println("Muestra todas las ciudades y distancia desde "+vert.getElement().getNombre());
		for (Vertex<Ciudad> result : res.keySet())
			System.out.println(result.getElement()+"  -->  "+ res.get(result)+"km");
		System.out.println("-----------------------");
		
	}
}
