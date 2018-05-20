package conexion.db.entidades;

public class DB_Rec_SitiosTuristicos extends Entidades{
	private String table_name = TablesName.SITIOS_TURISTICOS;

	public void crearTablaSitiosTuristicos() {
		String sql = "id INT NOT NULL AUTO_INCREMENT," 
				+ "nombre VARCHAR(50) NOT NULL," 
				+ "activo BIT(1) DEFAULT TRUE," 
				+ "PRIMARY KEY (id)," 
				+ "ciudades_id INT NOT NULL," 
				+ "CONSTRAINT fk_sitios_turisticos FOREIGN KEY (ciudades_id)" 
				+ " REFERENCES ciudades (id) ON DELETE CASCADE ON UPDATE CASCADE";
		Entidades.creatTable(table_name, sql);
	}

	public void borrarTablaSitiosTuristicos() {
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
