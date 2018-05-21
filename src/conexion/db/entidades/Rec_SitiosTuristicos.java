package conexion.db.entidades;

import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;

public class Rec_SitiosTuristicos extends EntidadesUtils{
	private String table_name = TablesName.SITIOS_TURISTICOS;

	public void crearTablaSitiosTuristicos() {
		String sql = "id INT NOT NULL AUTO_INCREMENT," 
				+ "nombre VARCHAR(50) NOT NULL," 
				+ "activo BIT(1) DEFAULT TRUE," 
				+ "PRIMARY KEY (id)," 
				+ "ciudades_id INT NOT NULL," 
				+ "CONSTRAINT fk_sitios_turisticos FOREIGN KEY (ciudades_id)" 
				+ " REFERENCES ciudades (id) ON DELETE CASCADE ON UPDATE CASCADE";
		TablasUtiles.creatTable(table_name, sql);
	}
	public void borrarTablaSitiosTuristicos() {
		TablasUtiles.deleteTable(table_name);		
	}
	public void vaciarTablaSitiosTuristicos() {
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
