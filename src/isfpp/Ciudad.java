/**
 * 
 */
package isfpp;

/**
 * @author deimon
 *
 */
public class Ciudad {
	private String nombre;
	private int habitantes;
    //private String reseña_histórica;
	//private int alojamientos; //falta el tipo (lista)
	//private String sitios_turisticos; //falta el tipo (lista)
	
	public Ciudad(String nombre, int habitantes) {
		//super();
		this.nombre = nombre;
		this.habitantes = habitantes;
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

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	
	
}
