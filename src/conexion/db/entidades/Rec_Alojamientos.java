package conexion.db.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deimon.entidades.ciudad.Alojamiento;
import com.deimon.entidades.ciudad.Ciudad;
import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Rec_Alojamientos extends EntidadesUtils{
	private String tableName = TablesName.ALOJAMIENTOS;

	/**
	 * Tiene el codigo SQL para crear la tabla alojamiento, y llama a la funcion para crear la misma
	 */
	public void crearTablaAlojamientos() {		
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE," 
				+ "nombre VARCHAR(50) NOT NULL," 
				+ "activo BIT(1) DEFAULT TRUE," 
				+ "PRIMARY KEY (id)," 
				+ "vertice_id INT NOT NULL," 
				+ "CONSTRAINT fk_alojamientos FOREIGN KEY (vertice_id)" 
				+ " 	REFERENCES vertices (id)";
		TablasUtiles.creatTable(tableName, sql);
	}
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaAlojamientos() {
		TablasUtiles.deleteTable(tableName);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaAlojamientos() {
		TablasUtiles.emptyTable(tableName);		
	}
	
	/*******************************************************************/

	/*
	 * INSERTAR
	 */
	public void insertar(String nombre, Boolean activo, int vertice_id) {
		String sql = "INSERT INTO "+tableName+" (id, nombre, activo, vertice_id) VALUES (NULL, ?,?,?)";
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
				myPrepStmt.setBoolean(2, activo);
				myPrepStmt.setInt(3, vertice_id);
				myPrepStmt.executeUpdate();			
				System.out.println("ALojamiento Creada!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}
	
	public void cargarValores(String valorSql) {
		String sql = "INSERT INTO "+tableName+" (id, nombre, activo, vertice_id) "
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
				System.out.println("Alojamiento Cargado!");
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
	
	
	/*
	 * BUSCAR
	 */
	public ObservableList<Alojamiento> getListaAlojamiento() {
		String sql = "SELECT * from "+tableName;

		DB_Connection conec = null;
		Connection myConect = null;
		PreparedStatement myPrepStmt = null;
		ResultSet rs = null;
		ObservableList<Alojamiento> lista = FXCollections.observableArrayList();
		try {
			conec = new DB_Connection();
			myConect = conec.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect != null) {
				myPrepStmt = myConect.prepareStatement(sql);
				rs = myPrepStmt.executeQuery();	
				while (rs.next()) {
					Alojamiento selec = new Alojamiento();
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
	 * Trae un alojamiento, con si ciudad
	 * @param alojamientoId
	 * @return Un alojamiento
	 */
	public Alojamiento getAlojamiento(int alojamientoId) {
		String sql = "SELECT "
				+ tableName+".*, "
				+ "ciudades.nombre AS ciudad_nombre, "
				+ "ciudades.habitantes, "
				+ "ciudades.historia, "
				+ "ciudades.latitud, "
				+ "ciudades.longitud, "
				+ "ciudades.activo AS ciudad_activa "
				+ "FROM "+tableName+" JOIN `ciudades` "
						+ "ON "+tableName+".ciudades_id=ciudades.id WHERE "+tableName+".id = ?";

		DB_Connection conec = null;
		Connection myConect = null;
		PreparedStatement myPrepStmt = null;
		ResultSet rs = null;
		Alojamiento alojamiento = null;
		try {
			conec = new DB_Connection();
			myConect = conec.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect != null) {
				myPrepStmt = myConect.prepareStatement(sql);
				myPrepStmt.setInt(1, alojamientoId);
				rs = myPrepStmt.executeQuery();				
				while (rs.next()) {
					alojamiento = new Alojamiento();
					alojamiento.setID(rs.getInt("id"));
					alojamiento.setNombre(rs.getString("nombre"));
					alojamiento.setActivo(rs.getBoolean("activo"));
					Ciudad c = new Ciudad();
					c.setID(rs.getInt("ciudades_id"));
					c.setNombre(rs.getString("ciudad_nombre"));
					c.setHabitantes(rs.getInt("habitantes"));
					c.setHistoria(rs.getString("historia"));
					c.setLatitud(rs.getDouble("latitud"));
					c.setLongitud(rs.getDouble("longitud"));
					c.setActivo(rs.getBoolean("ciudad_activa"));
					alojamiento.setCiudad(c);
				}
				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conec.closeConnect(myConect);
		}
		return alojamiento;
	}
}
