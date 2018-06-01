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
	/**
	 * Crea la conexion con la base de datos (DB) y retorna la misma.
	 * 
	 * @param url	Nombre de la DB
	 * @param user	Usuario de la DB
	 * @param password	Contraseña del usuario de la DB
	 * @return una conexion
	 */
	public Connection getConection(String url, String user, String password) {
		String urlBase = "jdbc:mysql://localhost:3306/";
		try { 
			Class.forName("com.mysql.jdbc.Driver");
			myConect = DriverManager.getConnection(urlBase+url, user, password);
			if(myConect != null) {
				System.out.println("Conexion establecida!");				
			}
		} catch (SQLException | ClassNotFoundException e) {			
			 e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Error en el Servidor. Controlar que este prendido");
			alert.showAndWait();

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

	/**
	 * Cierra la conexion creada con el metodo "getConection"
	 * @param c		una conexion
	 * @return si lo logro o no
	 */
	public boolean closeConnect(Connection c) {
		boolean t = false;
		try {
			if(c != null) {
				c.close();
				System.out.println("Conexion cerrada!");	
				t = true;			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	/* --------------------------------------------------------------------------------------------- */
	/**
	 * Crea una declaración, que se usa para el acceso de un propósito general a la base de datos.
	 * @param Una conexion
	 * @return La declaracion
	 */
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

	/**
	 * Cierra la declaracion
	 * @param un Statement
	 * @return Retorna si lo logro o no.
	 */
	public boolean closeStatement(Statement s) {
		boolean t = false;
		try {
			if(s != null) {
				s.close();
				System.out.println("Statement cerrada!");	
				t = true;			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}


}
