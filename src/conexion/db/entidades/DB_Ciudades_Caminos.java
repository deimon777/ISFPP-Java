package conexion.db.entidades;

public class DB_Ciudades_Caminos extends Entidades{
	private String table_name = "ciudades_caminos";

	public void crearTablaCiudadesCaminos() {
		String sql = "id INT NOT NULL AUTO_INCREMENT,"
				+ "ciudades_id INT NOT NULL,"
				+ "CONSTRAINT fk_ciudades FOREIGN KEY (ciudades_id)"
				+ " REFERENCES ciudades (id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "caminos_id INT NOT NULL,"
				+ "CONSTRAINT fk_caminos FOREIGN KEY (caminos_id)"
				+ " REFERENCES caminos (id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "PRIMARY KEY (id , ciudades_id , caminos_id)";
		Entidades.creatTable(table_name, sql);
	}

	public void borrarTablaCiudadesCaminos() {
		Entidades.deleteTable(table_name);		
	}

	/*
	 * BORRAR
	 */
	public void deleteItemByID(int id) {
		Entidades.deleteItemByID(table_name, id);
	}
	
	public void deleteItemByNAME(String nombre) {
		Entidades.deleteItemByNAME(table_name, nombre);
	}
	/*
	 * ACTUALIZAR
	 */
	
	/*
	 * INSERTAR
	 */
}
