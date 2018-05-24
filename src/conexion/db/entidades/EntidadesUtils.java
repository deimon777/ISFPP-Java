package conexion.db.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EntidadesUtils {
	/*
	 * BORRAR
	 */
	public static void deleteItemByID(String table, int id) {
		String sql = "DELETE FROM "+table+" WHERE id = ?";
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
				myPreStmt.setInt(1, id);
				myPreStmt.executeUpdate();
				System.out.println("Item Borrado!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}

	public static void deleteItemByNAME(String table, String nombre) {
		String sql = "DELETE FROM "+table+" WHERE id = ?";
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
				myPreStmt.setString(1, nombre);
				myPreStmt.executeUpdate();
				System.out.println("Item Borrado!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}

	/*
	 * ACTUALIZAR
	 */
	public static void updateItem(String table, String where, String what, int id) {
		String sql = "UPDATE "+table+" SET "+where+" = ? WHERE id = ?";
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
				myPreStmt.setString(1, what);
				myPreStmt.setInt(2, id);
				myPreStmt.executeUpdate();
				System.out.println("Item Actualizado!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}		
	}

	public static void activarItem(String table, int id) {
		activar(table,"activo",1,id);
		System.out.println("Item Activado!");
	}

	public static void desactivarItem(String table, int id) {
		activar(table,"activo",0,id);
		System.out.println("Item Desactivado!");
	}

	/*
	 * Propias de la clase
	 */
	private static void activar(String table, String where, int what, int id) {
		String sql = "UPDATE "+table+" SET "+where+" = ? WHERE id = ?";
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
				myPreStmt.setInt(1, what);
				myPreStmt.setInt(2, id);
				myPreStmt.executeUpdate();
				System.out.println("Item Actualizado!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}

	/*
	 * BUSCAR
	 */
	public static <T> ObservableList<T> getLista(String sql) {
		DB_Connection c = null;
		Connection myConect = null;
		Statement myStmt = null;
		ResultSet rs = null;
		ObservableList<T> data = FXCollections.observableArrayList();
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect!=null) {
				myStmt = c.getStatement(myConect);
				rs = myStmt.executeQuery(sql);
				while(rs.next()){
					ObservableList<T> row = FXCollections.observableArrayList();
					for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
						row.add((T) rs.getString(i));
					}
					data.addAll(row);
				}			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myStmt);
			c.closeConnect(myConect);
		}
		return data;
	}

}
