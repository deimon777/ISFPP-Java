package conexion.db.entidades;

import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;
import javafx.collections.ObservableList;

public class Usuarios extends EntidadesUtils{
	private String table_name = TablesName.USUARIOS;

	/**
	 * Tiene el codigo SQL para crear la tabla usuarios, y llama a la funcion para crear la misma
	 */
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
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaUsuario() {
		TablasUtiles.deleteTable(table_name);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaUsuario() {
		TablasUtiles.emptyTable(table_name);		
	}

	/*******************************************************************/

	/*
	 * INSERTAR
	 */
	
	/*
	 * BORRAR
	 */

	/*
	 * ACTUALIZAR
	 */

	/*
	 * BUSCAR
	 */
	public ObservableList<String> getUsuarios() {
		return EntidadesUtils.getLista("SELECT nombre from "+table_name);
	}
}
