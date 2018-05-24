package conexion.db.tablas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;

public class TablasUtiles {

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
				myStmt.execute("CREATE TABLE IF NOT EXISTS " + table + "(" + param + ")ENGINE=INNODB");
				System.out.println("Tabla "+table+" creada");
			}
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
			if(myConect!=null) {
				myStmt = c.getStatement(myConect);
				myStmt.execute("DROP TABLE " + table);
				System.out.println("Tabla "+table+" borrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myStmt);
			c.closeConnect(myConect);
		}
	}

	public static void emptyTable(String table) {
		String sql = "TRUNCATE TABLE "+table;

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
		}		
	}

}
