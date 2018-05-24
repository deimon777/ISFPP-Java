package conexion.db.entidades;

import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;

public class TipoUsuarios extends EntidadesUtils{
	private String table_name = TablesName.TIPO_USUARIO;

	public void crearTablaTipoUsuario() {
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE,"
				+ "nombre VARCHAR(50) NOT NULL UNIQUE,"
				+ "activo BIT(1) DEFAULT TRUE,"
				+ "PRIMARY KEY (id)";
		TablasUtiles.creatTable(table_name, sql);
	}
	public void borrarTablaTipoUsuario() {
		TablasUtiles.deleteTable(table_name);		
	}
	public void vaciarTablaTipoUsuario() {
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
