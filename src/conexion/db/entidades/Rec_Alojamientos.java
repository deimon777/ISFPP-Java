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

public class Rec_Alojamientos extends EntidadesUtils{
	private String table_name = TablesName.ALOJAMIENTOS;

	/**
	 * Tiene el codigo SQL para crear la tabla alojamiento, y llama a la funcion para crear la misma
	 */
	public void crearTablaAlojamientos() {		
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE," 
				+ "nombre VARCHAR(50) NOT NULL," 
				+ "activo BIT(1) DEFAULT TRUE," 
				+ "PRIMARY KEY (id)," 
				+ "ciudades_id INT NOT NULL," 
				+ "CONSTRAINT fk_alojamientos FOREIGN KEY (ciudades_id)" 
				+ " REFERENCES ciudades (id) ON DELETE CASCADE ON UPDATE CASCADE";
		TablasUtiles.creatTable(table_name, sql);
	}
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaAlojamientos() {
		TablasUtiles.deleteTable(table_name);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaAlojamientos() {
		TablasUtiles.emptyTable(table_name);		
	}
	
	/*******************************************************************/

	/*
	 * INSERTAR
	 */
	public void insertar(String nombre, Boolean activo, int ciudad_id) {
		String sql = "INSERT INTO "+table_name+" (id, nombre, activo, ciudades_id) VALUES (NULL, ?,?,?)";
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
	
	/*
	 * BORRAR
	 */
	
	
	/*
	 * ACTUALIZAR
	 */
	
	
	/*
	 * BUSCAR
	 */
	
	/**
	 * Trae un alojamiento, con si ciudad
	 * @param alojamientoId
	 * @return Un alojamiento
	 */
	public Alojamiento getAlojamiento(int alojamientoId) {
		String sql = "SELECT "
				+ table_name+".*, "
				+ "ciudades.nombre AS ciudad_nombre, "
				+ "ciudades.habitantes, "
				+ "ciudades.historia, "
				+ "ciudades.latitud, "
				+ "ciudades.longitud, "
				+ "ciudades.activo AS ciudad_activa "
				+ "FROM "+table_name+" JOIN `ciudades` "
						+ "ON "+table_name+".ciudades_id=ciudades.id WHERE "+table_name+".id = ?";

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
