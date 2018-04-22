package conexion.db.entidades;

public class DB_Usuarios extends Entidades{
	private String table_name = "usuarios";

	public void crearTablaUsuario() {
		String sql = "id INT NOT NULL AUTO_INCREMENT,"
				+ "nombre VARCHAR(50) NOT NULL," 
				+ "apellido VARCHAR(50) NOT NULL," 
				+ "email VARCHAR(20)," 
				+ "clave VARCHAR(20)," 
				+ "activo BIT(1) DEFAULT FALSE," 
				+ "PRIMARY KEY (id)," 
				+ "tipo_usuario_id INT NOT NULL," 
				+ "CONSTRAINT fk_usuarios FOREIGN KEY (tipo_usuario_id) "
				+ " REFERENCES tipo_usuario (id) ON DELETE CASCADE ON UPDATE CASCADE";
		Entidades.creatTable(table_name, sql);
	}

	public void borrarTablaUsuario() {
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
