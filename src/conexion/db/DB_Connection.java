package conexion.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {
	Connection myConect = null;
	Statement myStmt = null;
	/* --------------------------------------------------------------------------------------------- */
	public Connection getConection(String url, String user, String password) {
		String urlBase = "jdbc:mysql://localhost:3306/";
		try { 
			//			Class.forName("com.mysql.jdbc.Driver");
			myConect = DriverManager.getConnection(urlBase+url, user, password);
			if(myConect != null) {
				System.out.println("Conexion establecida!");				
			}
		} catch (Exception e) {
			//SQLException
			e.printStackTrace();
		} finally {
			if(myConect == null) {
				try {
					myConect.close();
					System.out.println("Conexion nula, cerrando!");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return myConect;
	}

	public void closeConnect(Connection c) {
		try {
			c.close();
			if(c != null) {
				System.out.println("Conexion cerrada!");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* --------------------------------------------------------------------------------------------- */
	public Statement getStatement(Connection conex) {
		try {
			myStmt = conex.createStatement();
			if(myStmt != null) {
				System.out.println("Statement logrado!");				
			}
		} catch (Exception e) {
			//SQLException
			e.printStackTrace();
		}finally {
			if(myStmt == null) {
				try {
					myStmt.close();
					System.out.println("Statement cerrado!");		
				} catch (SQLException e) {
					e.printStackTrace();
				}		
			}
		}
		return myStmt;
	}

	public void closeStatement(Statement s) {
		try {
			s.close();
			if(s != null) {
				System.out.println("Statement cerrada!");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
