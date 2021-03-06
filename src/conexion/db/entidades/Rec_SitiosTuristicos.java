package conexion.db.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deimon.entidades.ciudad.SitioTuristico;
import com.deimon.entidades.ciudad.Vertice;
import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;

public class Rec_SitiosTuristicos extends EntidadesUtils{
	private String tableName = TablesName.SITIOS_TURISTICOS;

	/**
	 * Tiene el codigo SQL para crear la tabla sitios_turisticos, y llama a la funcion para crear la misma
	 */
	public void crearTablaSitiosTuristicos() {
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE," 
				+ "nombre VARCHAR(50) NOT NULL," 
				+ "activo BIT(1) DEFAULT TRUE," 
				+ "PRIMARY KEY (id)," 
				+ "vertice_id INT NOT NULL," 
				+ "CONSTRAINT fk_sitios_turisticos FOREIGN KEY (vertice_id)" 
				+ "		REFERENCES vertices (id)";
		TablasUtiles.creatTable(tableName, sql);
	}
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaSitiosTuristicos() {
		TablasUtiles.deleteTable(tableName);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaSitiosTuristicos() {
		TablasUtiles.emptyTable(tableName);		
	}

	/*******************************************************************/

	/*
	 * INSERTAR
	 */
	public void insertar(String nombre, Boolean activo, int ciudad_id) {
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
				myPrepStmt.setInt(3, ciudad_id);
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
				System.out.println("Sitios Turisticos Cargado!");
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
	public SitioTuristico getSitioTuristico(int sitioTuristicoId) {
		String sql = "SELECT "
				+ tableName+".*, "
				+ "ciudades.nombre AS ciudad_nombre, "
				+ "ciudades.habitantes, "
				+ "ciudades.historia, "
				+ "ciudades.latitud, "
				+ "ciudades.longitud, "
				+ "ciudades.activo AS ciudad_activa "
				+ "FROM "+tableName+" "
				+ "JOIN `ciudades` "
				+ "ON "+tableName+".ciudades_id=ciudades.id "
				+ "WHERE "+tableName+".id = ?";

		DB_Connection conec = null;
		Connection myConect = null;
		PreparedStatement myPrepStmt = null;
		ResultSet rs = null;
		SitioTuristico sitio_turistico = null;
		try {
			conec = new DB_Connection();
			myConect = conec.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect != null) {
				myPrepStmt = myConect.prepareStatement(sql);
				myPrepStmt.setInt(1, sitioTuristicoId);
				rs = myPrepStmt.executeQuery();				
				while (rs.next()) {
					sitio_turistico = new SitioTuristico();
					sitio_turistico.setID(rs.getInt("id"));
					sitio_turistico.setNombre(rs.getString("nombre"));
					sitio_turistico.setActivo(rs.getBoolean("activo"));
					Vertice c = new Vertice();
					c.setID(rs.getInt("ciudades_id"));
					c.setNombre(rs.getString("ciudad_nombre"));
					c.setHabitantes(rs.getInt("habitantes"));
					c.setHistoria(rs.getString("historia"));
					c.setLatitud(rs.getDouble("latitud"));
					c.setLongitud(rs.getDouble("longitud"));
					c.setActivo(rs.getBoolean("ciudad_activa"));
					sitio_turistico.setCiudad(c);
				}
				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conec.closeConnect(myConect);
		}
		return sitio_turistico;
	}
}
