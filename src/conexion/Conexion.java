package conexion;

import java.sql.*;

public class Conexion {

	public static void main(String[] args) {
		String urlBase = "jdbc:mysql://localhost:3306/";
		String url = urlBase+"isfpp";
		String user = "isfpp";
		String password = "isfpp";

		try {
			Conexion driver = new Conexion();
			Connection myConec = driver.conect(url, user, password);
			Statement myStmt = driver.statement(myConec);
			ResultSet myRes = driver.searchTable(myStmt,"ciudad");
			driver.show(myRes, "nombre");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Connection conect(String url, String user, String password) {
		Connection myConect = null;
		try { 
			myConect = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return myConect;
	}

	public Statement statement(Connection conex) {
		Statement myStmt = null;
		try {
			myStmt = conex.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myStmt;
	}

	public ResultSet searchTable(Statement statement, String tabla){
		String sql = "select * from "+tabla;
		ResultSet myRes = null;
		try {
			myRes = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myRes;
	}

	public void show(ResultSet result, String columna) {
		try {
			while(result.next()){
				System.out.println(result.getString(columna));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
