package conexion.db.entidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.deimon.entidades.camino.EstadoCamino;
import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Rec_EstadoCamino extends EntidadesUtils{
	private String tableName = TablesName.ESTADO_CAMINO;

	/**
	 * Tiene el codigo SQL para crear la tabla estado_camino, y llama a la funcion para crear la misma
	 */
	public void crearTablaEstadoCamino() {
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE,"
				+ "nombre VARCHAR(50) NOT NULL UNIQUE,"
				+ "peso INT(5),"
				+ "PRIMARY KEY (id)";
		TablasUtiles.creatTable(tableName, sql);
	}
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaEstadoCamino() {
		TablasUtiles.deleteTable(tableName);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaEstadoCamino() {
		TablasUtiles.emptyTable(tableName);		
	}

	/*******************************************************************/
	
	/*
	 * INSERTAR
	 */
	public void insertar(String nombre, int peso) {
//		String sql = "INSERT INTO " + tableName + "(`id`, `nombre`, ) VALUES (NULL, ?)";
		String sql = "INSERT INTO " + tableName + "(id, nombre, peso) VALUES (NULL, ?, ?)";

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
				myPrepStmt.setInt(2, peso);
				myPrepStmt.executeUpdate();
				System.out.println("Estado Camino creado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myPrepStmt);
			c.closeConnect(myConect);
		}
	}
	
	public void cargarValores(String valorSql) {
		String sql = "INSERT INTO "+tableName+" (id, nombre, peso) "
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
				System.out.println("Estado Camino Cargado!");
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

	
	
	/*
	 * ACTUALIZAR
	 */
	public void actualizar(int id, String nombre, int peso) {
		String sql = "UPDATE "+tableName+" "
				+ "SET nombre = ?, "
				+ "peso = ? "
				+ "WHERE "+tableName+".id = ?";
		
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
				myPrepStmt.setInt(2, peso);
				myPrepStmt.setInt(3, id);
				myPrepStmt.executeUpdate();
				System.out.println("Estado Camino Modificado!");
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
	 * BUSCAR
	 */
	public ObservableList<String> getEstadoCaminoNombre() {
		return EntidadesUtils.getLista("SELECT nombre from "+tableName);
	}
	public ObservableList<EstadoCamino> getListaEstadoCamino() {
		String sql = "SELECT * from "+tableName;

		DB_Connection conec = null;
		Connection myConect = null;
		PreparedStatement myPrepStmt = null;
		ResultSet rs = null;
		ObservableList<EstadoCamino> lista = FXCollections.observableArrayList();
		try {
			conec = new DB_Connection();
			myConect = conec.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect != null) {
				myPrepStmt = myConect.prepareStatement(sql);
				rs = myPrepStmt.executeQuery();	
				while (rs.next()) {
					EstadoCamino selec = new EstadoCamino();
					selec.setID(rs.getInt("id"));
					selec.setNombre(rs.getString("nombre"));
					selec.setPeso(rs.getInt("peso"));
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
	 * Trae el ID de un Estado segun su nombre
	 * @param nombre
	 * @return El ID del estado.
	 */
	public int getEstadoCaminoID(String nombre) {
		int id = EntidadesUtils.getItemFromNombre(tableName, "id", nombre);
		return id;
	}
}
