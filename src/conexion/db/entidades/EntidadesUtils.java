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
		String sql = "DELETE FROM "+table+" WHERE "+table+".id = ?";
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
		String sql = "DELETE FROM "+table+" WHERE "+table+"id = ?";
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

	public static int getItemFromNombre(String table, String columna,String nombre) {
		String sql = "SELECT "+columna+" FROM "+table+" WHERE nombre = '"+nombre+"'";
		
		DB_Connection c = null;
		Connection myConect = null;
		PreparedStatement myPreStmt = null;
		ResultSet rs = null;
		int data = -1;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect!=null) {
				myPreStmt = myConect.prepareStatement(sql);
				rs = myPreStmt.executeQuery(sql);
				while(rs.next()){
					data = rs.getInt("id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myPreStmt);
			c.closeConnect(myConect);
		}
		return data;
	}
}
