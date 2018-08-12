package conexion.db.entidades;

import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;
import javafx.collections.ObservableList;

public class Roles extends EntidadesUtils{
	private String table_name = TablesName.ROLES;

	/**
	 * Tiene el codigo SQL para crear la tabla tipo_usuario, y llama a la funcion para crear la misma
	 */
	public void crearTablaRoles() {
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE,"
				+ "nombre VARCHAR(50) NOT NULL UNIQUE,"
				+ "activo BIT(1) DEFAULT TRUE,"
				+ "PRIMARY KEY (id)";
		TablasUtiles.creatTable(table_name, sql);
	}
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaRoles() {
		TablasUtiles.deleteTable(table_name);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaRoles() {
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
	public ObservableList<String> getRoles() {
		return EntidadesUtils.getLista("SELECT nombre from "+table_name);
	}
}
