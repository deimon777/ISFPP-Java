package conexion.db.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;

public class Ciudades extends EntidadesUtils{
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
		TablasUtiles.creatTable(table_name, sql);
	}
	public void borrarTablaCiudad() {
		TablasUtiles.deleteTable(table_name);		
	}
	public void vaciarTablaCiudad() {
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
	 * ACTUALIZAR
	 */
	public void updateItemBy(String donde, String que,int id) {
		EntidadesUtils.updateItem(table_name, donde, que,id);
	}

	public void modificarActivo(Boolean activo) {
		System.out.println("Modificar activo");	
	}
	public void activarCiudad(int id) {
		EntidadesUtils.activarItem(table_name,id);
	}

	public void desactivarCiudad(int id) {
		EntidadesUtils.desactivarItem(table_name,id);
	}

	/*
	 * INSERTAR
	 */
	public void insertar(String nombre) {
		String sql = "INSERT INTO "+table_name+" (id, nombre) VALUES (NULL,?)";

		DB_Connection c = null;
		Connection myConect = null;
		PreparedStatement myPrepStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			myPrepStmt = myConect.prepareStatement(sql);
			myPrepStmt.setString(1, nombre);
			myPrepStmt.executeUpdate();

			System.out.println("Ciudad Creada!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}

	public void insertar(String nombre, int habitantes, String historia, double latitud, double longitud, Boolean activo) {
		String sql = "INSERT INTO "+table_name+" (id, nombre, habitantes, historia, latitud, longitud, activo) "
				+ "VALUES (NULL, ?,?,?,?,?,?)";

		DB_Connection c = null;
		Connection myConect = null;
		PreparedStatement myPrepStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			myPrepStmt = myConect.prepareStatement(sql);
			myPrepStmt.setString(1, nombre);
			myPrepStmt.setInt(2, habitantes);
			myPrepStmt.setString(3, historia);
			myPrepStmt.setDouble(4, latitud);
			myPrepStmt.setDouble(5, longitud);
			myPrepStmt.setBoolean(6, activo);
			myPrepStmt.executeUpdate();

			System.out.println("Ciudad Creada!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myPrepStmt);
			c.closeConnect(myConect);
		}
	}

	/*
	 * BUSCAR
	 */
	public ArrayList<String> getCiudades() {
		return EntidadesUtils.getListaByNAME(table_name);
	}
}
