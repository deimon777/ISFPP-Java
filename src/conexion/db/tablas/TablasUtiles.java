package conexion.db.tablas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;

public class TablasUtiles {

	/**
	 * Crea la Tabla en la Base de datos
	 * @param table
	 * @param param
	 */
	public static void creatTable(String table, String param) {
		DB_Connection c = null;
		Connection myConect = null;
		Statement myStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect!=null) {
				myStmt = c.getStatement(myConect);
				myStmt.execute("CREATE TABLE IF NOT EXISTS " + table + "(" + param + ") ENGINE=INNODB");
				System.out.println("Tabla "+table+" creada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myStmt);
			c.closeConnect(myConect);
		}
	}

	/**
	 * Borra la tabla en la Base de Datos
	 * @param table
	 */
	public static void deleteTable(String table) {
		DB_Connection c = null;
		Connection myConect = null;
		Statement myStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect!=null) {
				myStmt = c.getStatement(myConect);
				myStmt.execute("DROP TABLE IF EXISTS " + table);
				System.out.println("Tabla "+table+" borrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myStmt);
			c.closeConnect(myConect);
		}
	}

	/**
	 * Vacia la tabla en la Base de Datos
	 * @param table
	 */
	public static void emptyTable(String table) {
//		checkForeign(0);
		String sql = "TRUNCATE table "+table;

		DB_Connection c = null;
		Connection myConect = null;
		PreparedStatement myPreStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect!=null) {
				myPreStmt = myConect.prepareStatement(sql);
				myPreStmt.executeUpdate();
				System.out.println("Tabla "+table+" vacia");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
			checkForeign(1);
		}		
	}
	
	private static void checkForeign(int n) {
		String sql = "SET FOREIGN_KEY_CHECKS=?;";

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
				myPrepStmt.setInt(1, n);
				myPrepStmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}		
	}
}
