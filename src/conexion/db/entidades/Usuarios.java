package conexion.db.entidades;

import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;

public class Usuarios extends EntidadesUtils{
	private String table_name = TablesName.USUARIOS;

	public void crearTablaUsuario() {
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE,"
				+ "nombre VARCHAR(50) NOT NULL," 
				+ "apellido VARCHAR(50) NOT NULL," 
				+ "nombre_usuario VARCHAR(50) NOT NULL UNIQUE," 
				+ "email VARCHAR(20) UNIQUE," 
				+ "clave VARCHAR(20)," 
				+ "activo BIT(1) DEFAULT FALSE," 
				+ "PRIMARY KEY (id)," 
				+ "tipo_usuario_id INT NOT NULL," 
				+ "CONSTRAINT fk_usuarios FOREIGN KEY (tipo_usuario_id) "
				+ " REFERENCES tipo_usuario (id) ON DELETE CASCADE ON UPDATE CASCADE";
		TablasUtiles.creatTable(table_name, sql);
	}
	public void borrarTablaUsuario() {
		TablasUtiles.deleteTable(table_name);		
	}
	public void vaciarTablaUsuario() {
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
	 * MODIFICAR
	 */
	
	/*
	 * INSERTAR
	 */
}
