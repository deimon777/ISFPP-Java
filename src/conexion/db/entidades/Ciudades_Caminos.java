package conexion.db.entidades;

import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;

public class Ciudades_Caminos extends EntidadesUtils{
	private String table_name = TablesName.CIUDADES_CAMINOS;

	public void crearTablaCiudadesCaminos() {
		String sql = "id INT NOT NULL AUTO_INCREMENT,"
				+ "ciudades_id INT NOT NULL,"
				+ "CONSTRAINT fk_ciudades FOREIGN KEY (ciudades_id)"
				+ " REFERENCES ciudades (id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "caminos_id INT NOT NULL,"
				+ "CONSTRAINT fk_caminos FOREIGN KEY (caminos_id)"
				+ " REFERENCES caminos (id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "PRIMARY KEY (id , ciudades_id , caminos_id)";
		TablasUtiles.creatTable(table_name, sql);
	}
	public void borrarTablaCiudadesCaminos() {
		TablasUtiles.deleteTable(table_name);		
	}	
	public void vaciarTablaCiudadesCaminos() {
		TablasUtiles.emptyTable(table_name);
	}

	/*
	 * BORRAR
	 */
	public void deleteItemByID(int id) {
		EntidadesUtils.deleteItemByID(table_name, id);
	}
	
	public void deleteItemByNAME(String nombre) {
		EntidadesUtils.deleteItemByNAME(table_name, nombre);
	}	
	
	/*
	 * ACTUALIZAR
	 */
	
	/*
	 * INSERTAR
	 */
}
