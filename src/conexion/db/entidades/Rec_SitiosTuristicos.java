package conexion.db.entidades;

import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;

public class Rec_SitiosTuristicos extends EntidadesUtils{
	private String table_name = TablesName.SITIOS_TURISTICOS;

	/**
	 * Tiene el codigo SQL para crear la tabla sitios_turisticos, y llama a la funcion para crear la misma
	 */
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
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaSitiosTuristicos() {
		TablasUtiles.deleteTable(table_name);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaSitiosTuristicos() {
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
}
