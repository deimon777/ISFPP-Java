package conexion.db.entidades;

public class DB_TipoUsuarios extends Entidades{
	private String table_name = "tipo_usuario";

	public void crearTablaTipoUsuario() {
		String sql = "id INT NOT NULL AUTO_INCREMENT,"
				+ "nombre VARCHAR(50) NOT NULL,"
				+ "activo BIT(1) DEFAULT TRUE,"
				+ "PRIMARY KEY (id)";
		Entidades.creatTable(table_name, sql);
	}

	public void borrarTablaTipoUsuario() {
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
