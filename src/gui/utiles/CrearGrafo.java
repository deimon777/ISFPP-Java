package gui.utiles;

import javafx.collections.ObservableList;

import grafo.grafo.Graph;
import grafo.grafo.Vertex;
import grafo.grafo.Edge;
import grafo.utiles.AdjacencyMapGraph;
import grafo.utiles.PositionalList;
import grafo.utiles.GraphAlgorithms;
import grafo.utiles.Map;
import grafo.utiles.ProbeHashMap;

import com.deimon.entidades.ciudad.Vertice;

import java.util.ArrayList;

import com.deimon.entidades.camino.Camino;

import conexion.db.entidades.Vertices;
import conexion.db.entidades.Caminos;

public class CrearGrafo{
	private Graph<Vertice, Integer> g = new AdjacencyMapGraph<>(false);

	ObservableList<Vertice> listaCiudad;
	ObservableList<Camino> listaCamino;
	ArrayList<Vertex<Vertice>> listaVertices = new ArrayList<>();

	private void listaCiudades() {
		Vertices ciudades = new Vertices();
		listaCiudad = ciudades.getListaVertices();
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

	Vertex<Vertice> vert = null;
	private Vertex<Vertice> buscarCiudadEnLista(String nCiudad) {
		listaVertices.forEach( ciudad -> {
			if(ciudad.getElement().getNombre().equals(nCiudad)){
				vert = ciudad;
			}
		});
		return vert;
	}

	public void buscarCamino(String ciudad1, String ciudad2) {
		Vertex<Vertice> c1 = buscarCiudadEnLista(ciudad1);
		Vertex<Vertice> c2 = buscarCiudadEnLista(ciudad2);
		PositionalList<Vertex<Vertice>> pl = GraphAlgorithms.shortestPathList(g, c1, c2);

		for (Vertex<Vertice> v: pl)
			System.out.println(v.getElement().getNombre());	
	}
	
	
	
	private void todasLasDistancias(Map<Vertex<Vertice>, Integer> res) {
		System.out.println("-----------------------");
		System.out.println("Muestra todas las ciudades y distancia desde "+vert.getElement().getNombre());
		for (Vertex<Vertice> result : res.keySet())
			System.out.println(result.getElement()+"  -->  "+ res.get(result)+"km");
		System.out.println("-----------------------");
		
	}
}
