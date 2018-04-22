package conexion.db.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;

public class DB_Alojamientos extends Entidades{
	private String table_name = "alojamientos";

	public void crearTablaAlojamientos() {		
		String sql = "id INT NOT NULL AUTO_INCREMENT," 
				+ "nombre VARCHAR(50) NOT NULL," 
				+ "activo BIT(1) DEFAULT TRUE," 
				+ "PRIMARY KEY (id)," 
				+ "ciudades_id INT NOT NULL," 
				+ "CONSTRAINT fk_alojamientos FOREIGN KEY (ciudades_id)" 
				+ " REFERENCES ciudades (id) ON DELETE CASCADE ON UPDATE CASCADE";
		Entidades.creatTable(table_name, sql);
	}

	public void borrarTablaAlojamientos() {
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
	public void insertItem(String nombre, int activo, int ciudad_id) {
		String sql = "INSERT INTO "+table_name+" (id, nombre, activo, ciudad_id) "
				+ "VALUES (NULL, ?,?,?)";
		DB_Connection c = null;
		Connection myConect = null;
		PreparedStatement myPreStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			myPreStmt = myConect.prepareStatement(sql);
			myPreStmt.setString(1, nombre);
			myPreStmt.setInt(2, activo);
			myPreStmt.setInt(3, ciudad_id);
			myPreStmt.executeUpdate();
			System.out.println("Ciudad Creada!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}
}
