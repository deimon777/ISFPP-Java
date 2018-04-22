package conexion.db.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;

public class Entidades {

	public static void creatTable(String table, String param) {
		DB_Connection c = null;
		Connection myConect = null;
		Statement myStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			myStmt = c.getStatement(myConect);			

			myStmt.execute("CREATE TABLE IF NOT EXISTS " + table + "(" + param + ")ENGINE=INNODB");
			System.out.println("Tabla "+table+" creada");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myStmt);
			c.closeConnect(myConect);
		}
	}

	public static void deleteTable(String table) {
		DB_Connection c = null;
		Connection myConect = null;
		Statement myStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			myStmt = c.getStatement(myConect);	

			myStmt.execute("DROP TABLE " + table);
			System.out.println("Tabla "+table+" borrada");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myStmt);
			c.closeConnect(myConect);
		}
	}

	public static void executeSQL(String sql) {
		DB_Connection c = null;
		Connection myConect = null;
		PreparedStatement myPreStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			myPreStmt = myConect.prepareStatement(sql);
			myPreStmt.executeQuery();
			System.out.println("Ejecutada la QUERY!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}

	/*
	 * BORRAR
	 */
	public static void deleteItemByID(String table_name, int id) {
		String sql = "DELETE FROM "+table_name+" WHERE id = ?";
		DB_Connection c = null;
		Connection myConect = null;
		PreparedStatement myPreStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			myPreStmt = myConect.prepareStatement(sql);
			myPreStmt.setInt(1, id);
			myPreStmt.executeUpdate();
			System.out.println("Item Borrado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}

	public static void deleteItemByNAME(String table_name, String nombre) {
		String sql = "DELETE FROM "+table_name+" WHERE id = ?";
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
			myPreStmt.executeUpdate();
			System.out.println("Item Borrado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}

	/*
	 * ACTUALIZAR
	 */
	public static void updateItem(String table_name, String where, String what, int id) {
		String sql = "UPDATE "+table_name+" SET "+where+" = ? WHERE id = ?";
		DB_Connection c = null;
		Connection myConect = null;
		PreparedStatement myPreStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			myPreStmt = myConect.prepareStatement(sql);
			myPreStmt.setString(1, what);
			myPreStmt.setInt(2, id);

			myPreStmt.executeUpdate();
			System.out.println("Item Actualizado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}		
	}

	public static void activarItem(String table_name, int id) {
		activar(table_name,"activo",1,id);
		System.out.println("Item Activado!");
	}
	public static void desactivarItem(String table_name, int id) {
		activar(table_name,"activo",0,id);
		System.out.println("Item Desactivado!");
	}

	/*
	 * Propias de la clase
	 */
	private static void activar(String table_name, String where, int what, int id) {
		String sql = "UPDATE "+table_name+" SET "+where+" = ? WHERE id = ?";
		DB_Connection c = null;
		Connection myConect = null;
		PreparedStatement myPreStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			myPreStmt = myConect.prepareStatement(sql);
			myPreStmt.setInt(1, what);
			myPreStmt.setInt(2, id);

			myPreStmt.executeUpdate();
			System.out.println("Item Actualizado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}
}
