package conexion.db.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;

public class Rec_Alojamientos extends EntidadesUtils{
	private String table_name = TablesName.ALOJAMIENTOS;

	/**
	 * Tiene el codigo SQL para crear la tabla alojamiento, y llama a la funcion para crear la misma
	 */
	public void crearTablaAlojamientos() {		
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE," 
				+ "nombre VARCHAR(50) NOT NULL," 
				+ "activo BIT(1) DEFAULT TRUE," 
				+ "PRIMARY KEY (id)," 
				+ "ciudades_id INT NOT NULL," 
				+ "CONSTRAINT fk_alojamientos FOREIGN KEY (ciudades_id)" 
				+ " REFERENCES ciudades (id) ON DELETE CASCADE ON UPDATE CASCADE";
		TablasUtiles.creatTable(table_name, sql);
	}
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaAlojamientos() {
		TablasUtiles.deleteTable(table_name);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaAlojamientos() {
		TablasUtiles.emptyTable(table_name);		
	}
	
	/*******************************************************************/

	/*
	 * INSERTAR
	 */
	public void insertar(String nombre, Boolean activo, int ciudad_id) {
		String sql = "INSERT INTO "+table_name+" (id, nombre, activo, ciudades_id) VALUES (NULL, ?,?,?)";
		DB_Connection c = null;
		Connection myConect = null;
		PreparedStatement myPrepStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect!=null) {
				myPrepStmt = myConect.prepareStatement(sql);
				myPrepStmt.setString(1, nombre);
				myPrepStmt.setBoolean(2, activo);
				myPrepStmt.setInt(3, ciudad_id);
				myPrepStmt.executeUpdate();			
				System.out.println("ALojamiento Creada!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}
	
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
