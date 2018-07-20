package conexion.db.entidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.deimon.entidades.camino.Trafico;
import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Rec_Trafico extends EntidadesUtils{
	private String tableName = TablesName.TRAFICO;

	/**
	 * Tiene el codigo SQL para crear la tabla trafico, y llama a la funcion para crear la misma
	 */
	public void crearTablaTrafico() {
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE,"
				+ "nombre VARCHAR(50) NOT NULL UNIQUE,"
				+ "PRIMARY KEY (id)";
		TablasUtiles.creatTable(tableName, sql);
	}
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaTrafico() {
		TablasUtiles.deleteTable(tableName);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaTrafico() {
		TablasUtiles.emptyTable(tableName);		
	}

	/*******************************************************************/

	/*
	 * INSERTAR
	 */
	public void insertar(String nombre) {
		String sql = "INSERT INTO " + tableName + "(`id`, `nombre`) VALUES (NULL, ?)";

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
				myPrepStmt.setString(1, nombre);
				myPrepStmt.executeUpdate();
				System.out.println("Trafico creado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myPrepStmt);
			c.closeConnect(myConect);
		}
	}

	public void cargarValores(String valorSql) {
		String sql = "INSERT INTO "+tableName+" (id, nombre) "
				+ "VALUES "+valorSql;

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
				myPrepStmt.executeUpdate();
				System.out.println("Trafico Cargado!");
			}
		} catch (SQLException e) {
			//com.mysql.jdbc.MysqlDataTruncation: Data truncation: Out of range value for column 'latitud' at row 1
			e.printStackTrace();
		}finally {
			c.closeStatement(myPrepStmt);
			c.closeConnect(myConect);
		}
	}

	/*
	 * BORRAR
	 */
	/**
	 * Borra un elemento de la tabla segun el ID
	 * @param Recive el id del item a ser borrado
	 */	
	public void deleteItemByID(int id) {
		EntidadesUtils.deleteItemByID(tableName, id);
	}

	/**
	 * Borra un elemento de la tabla segun el nombre
	 * @param Recive el nombre del item a ser borrado
	 */	
	public void deleteItemByNAME(String nombre) {
		EntidadesUtils.deleteItemByNAME(tableName, nombre);
	}

	/*
	 * ACTUALIZAR
	 */

	/*
	 * BUSCAR
	 */
	public ObservableList<String> getTraficoNombre() {
		return EntidadesUtils.getLista("SELECT nombre from "+tableName);
	}
	public ObservableList<Trafico> getListaTrafico() {
		String sql = "SELECT * from "+tableName;

		DB_Connection conec = null;
		Connection myConect = null;
		PreparedStatement myPrepStmt = null;
		ResultSet rs = null;
		ObservableList<Trafico> lista = FXCollections.observableArrayList();
		try {
			conec = new DB_Connection();
			myConect = conec.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect != null) {
				myPrepStmt = myConect.prepareStatement(sql);
				rs = myPrepStmt.executeQuery();	
				while (rs.next()) {
					Trafico selec = new Trafico();
					selec.setID(rs.getInt("id"));
					selec.setNombre(rs.getString("nombre"));
					lista.add(selec);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conec.closeConnect(myConect);
		}
		return lista;
	}
	/**
	 * Trae el ID de un Trafico segun su nombre
	 * @param nombre
	 * @return El ID del trafico.
	 */
	public int getTraficoID(String nombre) {
		int id = EntidadesUtils.getItemFromNombre(tableName, "id", nombre);
		return id;
	}
}
