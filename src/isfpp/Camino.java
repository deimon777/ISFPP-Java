/**
 * 
 */
package isfpp;

/**
 * @author deimon
 *
 */
public class Camino {
	private String nombre; 
	private int distancia; 
	//private tipo_camino; //falta el tipo
	//private estado_camin  //falta el tipoo;  
	//private boolean trafico;
	
	public Camino(String nombre, int distancia) {
		//super();
		this.nombre = nombre;
		this.distancia = distancia;
	}
	
	/*
	 * Getter y Setter
	 */
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
	
}
