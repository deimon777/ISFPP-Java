package conexion.db.entidades;

public class DB_Caminos extends Entidades{
	private String table_name = "caminos";

	public void crearTablaCaminos() {
		String sql = "id INT NOT NULL AUTO_INCREMENT,"
				+ "nombre VARCHAR(50) NOT NULL,"
				+ "distancia INT(20),"
				+ "peso_camino INT(5),"
				+ "activo BIT(1) DEFAULT TRUE,"
				+ "PRIMARY KEY (id),"
				+ "tipo_camino_id INT NOT NULL,"
				+ "CONSTRAINT fk_tipo_camino FOREIGN KEY (tipo_camino_id)"
				+ " REFERENCES tipo_camino (id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "estado_camino_id INT NOT NULL,"
				+ "CONSTRAINT fk_estado_camino FOREIGN KEY (estado_camino_id)"
				+ " REFERENCES estado_camino (id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "trafico_id INT NOT NULL,"
				+ "CONSTRAINT fk_trafico FOREIGN KEY (trafico_id)"
				+ " REFERENCES trafico (id) ON DELETE CASCADE ON UPDATE CASCADE";
		Entidades.creatTable(table_name, sql);
	}

	public void borrarTablaCaminos() {
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
