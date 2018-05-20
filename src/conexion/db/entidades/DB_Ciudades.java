package conexion.db.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;

public class DB_Ciudades extends Entidades{
	private static String table_name = TablesName.CUIDADES;

	public void crearTablaCiudad() {
		String sql = "id INT NOT NULL AUTO_INCREMENT,"
				+ "nombre VARCHAR(50) NOT NULL,"
				+ "habitantes INT(10),"
				+ "historia VARCHAR(300),"
				+ "latitud DOUBLE(10,6),"
				+ "longitud DOUBLE(10,6),"
				+ "activo BIT(1) DEFAULT TRUE,"
				+ "PRIMARY KEY (id)";
		Entidades.creatTable(table_name, sql);
	}

	public void borrarTablaCiudad() {
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
	public void updateItemBy(String donde, String que,int id) {
		Entidades.updateItem(table_name, donde, que,id);
	}
	public void activarCiudad(int id) {
		Entidades.activarItem(table_name,id);
	}
	public void desactivarCiudad(int id) {
		Entidades.desactivarItem(table_name,id);
	}

	/*
	 * INSERTAR
	 */
	public void insertItem(String nombre, int habitantes) {
		String sql = "INSERT INTO "+table_name+" (id, nombre, habitantes) "
				+ "VALUES (NULL,?,?)";
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
			myPreStmt.setInt(2, habitantes);
			myPreStmt.executeUpdate();
			System.out.println("Ciudad Creada!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}

	public void insertItem(String nombre, int habitantes, String historia, double latitud, double longitud, int activo) {
		String sql = "INSERT INTO "+table_name+" (id, nombre, habitantes, historia, latitud, longitud, activo) "
				+ "VALUES (NULL, ?,?,?,?,?,?)";

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
			myPreStmt.setInt(2, habitantes);
			myPreStmt.setString(3, historia);
			myPreStmt.setDouble(4, latitud);
			myPreStmt.setDouble(5, longitud);
			myPreStmt.setInt(6, activo);
			myPreStmt.executeUpdate();
			System.out.println("Ciudad Creada!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}
}
