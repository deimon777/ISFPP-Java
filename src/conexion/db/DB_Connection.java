package conexion.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DB_Connection {
	Connection myConect = null;
	Statement myStmt = null;
	/* --------------------------------------------------------------------------------------------- */
	public Connection getConection(String url, String user, String password) {
		String urlBase = "jdbc:mysql://localhost:3306/";
		try { 
			// Class.forName("com.mysql.jdbc.Driver");
			myConect = DriverManager.getConnection(urlBase+url, user, password);
			if(myConect != null) {
				System.out.println("Conexion establecida!");				
			}
		} catch (SQLException e) {			
			// e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Error en el Servidor. Controlar que este prendido");
			alert.showAndWait();

		} finally {
			if(myConect != null) {
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
			if(c != null) {
				c.close();
				System.out.println("Conexion cerrada!");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* --------------------------------------------------------------------------------------------- */
	public Statement getStatement(Connection conex) {
		try {
			if(myStmt != null) {
				myStmt = conex.createStatement();
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
			if(s != null) {
				s.close();
				System.out.println("Statement cerrada!");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
