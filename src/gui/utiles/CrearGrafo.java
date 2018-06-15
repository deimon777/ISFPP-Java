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
	private Graph<Ciudad, Camino> g = new AdjacencyMapGraph<>(false);

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
					//					System.out.println("inicial: "+listaCiudad.get(j).getNombre()+" => "+j);
					cInicial = j;
				}
				if(listaCiudad.get(j).getNombre().equals(listaCamino.get(i).getCiudadFin().getNombre())) {
					//					System.out.println("final  : "+listaCiudad.get(j).getNombre()+" => "+j);
					cFinal = j;
				}
			}

			//			System.out.println("Cargando el arco");
			//			System.out.println("inicial " + cInicial + " final "+ cFinal);
			//			System.out.println("c inicial " + listaVertices.get(cInicial));
			//			System.out.println("c final   " + listaVertices.get(cFinal));
			//			System.out.println("j "+j);
			//			System.out.println("size "+listaCamino.size());
			//			System.out.println("i "+i);
			//			System.out.println("camino    " + listaCamino.get(i).getNombre());
			g.insertEdge(listaVertices.get(cInicial), listaVertices.get(cFinal), listaCamino.get(i));
		}  
	}

	public void cargarGrafo() {
		listaCiudades();
		listaCamino();
		cargarListaVertices();
		cargarAristas();
	}

	public void buscarCamino(String ciudad1, String ciudad2) {
		Vertex<Ciudad> c1 = listaVertices.get(0);
		Vertex<Ciudad> c2 = listaVertices.get(1);
		
//		Map<Vertex<Ciudad>, Ciudad> res = GraphAlgorithms.shortestPathLengths(g, c1);

//		for (Vertex<Ciudad> result : res.keySet())
//			System.out.println(result.getElement() + "  -->  " + result.getElement().getNombre());

//		Map<Vertex<String>, Edge<Integer>> tree;
//
//		tree = GraphAlgorithms.spTree(g, c2, res);
//
//		for (Vertex<String> ver : tree.keySet())
//			System.out.println(ver.getElement() + "  ----->  " + tree.get(ver).getElement());
//
//		Edge<Integer> arc;
//		Vertex<String> ver = c2.getElement().getNombre();

//		while (ver != c1) {
//			System.out.println(ver.getElement());
//			arc = tree.get(ver);
//			ver = g.opposite(ver, arc);
//		}

	}
}