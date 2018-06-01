package conexion.db.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.deimon.ciudad.Ciudad;
import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ciudades extends EntidadesUtils{
	private static String table_name = TablesName.CUIDADES;

	public void crearTablaCiudad() {
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE,"
				+ "nombre VARCHAR(50) NOT NULL UNIQUE,"
				+ "habitantes INT(10),"
				+ "historia VARCHAR(300),"
				+ "latitud DOUBLE(10,6),"
				+ "longitud DOUBLE(10,6),"
				+ "activo BIT(1) DEFAULT TRUE,"
				+ "PRIMARY KEY (id)";
		TablasUtiles.creatTable(table_name, sql);
	}
	public void borrarTablaCiudad() {
		TablasUtiles.deleteTable(table_name);		
	}
	public void vaciarTablaCiudad() {
		TablasUtiles.emptyTable(table_name);
	}

	/*
	 * BORRAR
	 */
	public void deleteItemByID(int id) {
		EntidadesUtils.deleteItemByID(table_name, id);
	}

	public void deleteItemByNAME(String nombre) {
		EntidadesUtils.deleteItemByNAME(table_name, nombre);
	}
	/*
	 * ACTUALIZAR
	 */
	public void updateItemBy(String donde, String que,int id) {
		EntidadesUtils.updateItem(table_name, donde, que,id);
	}

	public void modificarActivo(Boolean activo) {
		System.out.println("Modificar activo");	
	}
	public void activarCiudad(int id) {
		EntidadesUtils.activarItem(table_name,id);
	}

	public void desactivarCiudad(int id) {
		EntidadesUtils.desactivarItem(table_name,id);
	}

	/*
	 * INSERTAR
	 */
	public void insertar(String nombre) {
		String sql = "INSERT INTO "+table_name+" (id, nombre) VALUES (NULL,?)";

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
				System.out.println("Ciudad Creada!");
			}
		} catch (SQLException e) {
			//revisar posibles errores, salir de una manera elegante, o poner ventana de error!! 
			//EJ: entrada duplicada
			//    error en la conec

			// com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure

			// com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 'Madryn' for key 'nombre
			System.out.println("oh oh, entrada duplcada");
			e.printStackTrace();
		}finally {
			c.closeConnect(myConect);
		}
	}

	public void insertar(String nombre, Integer habitantes, String historia, Double latitud, Double longitud, Boolean activo) {
		String sql = "INSERT INTO "+table_name+" (id, nombre, habitantes, historia, latitud, longitud, activo) "
				+ "VALUES (NULL, ?,?,?,?,?,?)";

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
				if (habitantes == null) {
					myPrepStmt.setNull(2, java.sql.Types.INTEGER);				
				}
				else {
					myPrepStmt.setInt(2, habitantes);
				}
				myPrepStmt.setString(3, historia);

				if (latitud == null) {
					myPrepStmt.setNull(4, java.sql.Types.DOUBLE);				
				}
				else {
					myPrepStmt.setDouble(4, latitud);
				}

				if (longitud == null) {
					myPrepStmt.setNull(5, java.sql.Types.DOUBLE);				
				}
				else {
					myPrepStmt.setDouble(5, longitud);
				}

				myPrepStmt.setBoolean(6, activo);
				myPrepStmt.executeUpdate();
				System.out.println("Ciudad Creada!");
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
	public ObservableList<String> getCiudadesNombre() {
		return EntidadesUtils.getLista("SELECT nombre from "+table_name);
	}

	public ObservableList<Ciudad> getCiudades() {
		String sql = "SELECT * from "+table_name;

		DB_Connection conec = null;
		Connection myConect = null;
		Statement myStmt = null;
		ResultSet rs = null;
		ObservableList<Ciudad> lista = FXCollections.observableArrayList();
		try {
			conec = new DB_Connection();
			myConect = conec.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect != null) {
				myStmt = conec.getStatement(myConect);
				rs = myStmt.executeQuery(sql);
				while (rs.next()) {
					Ciudad ciudad = new Ciudad();
					ciudad.setID(rs.getInt("id"));
					ciudad.setNombre(rs.getString("nombre"));
					ciudad.setHabitantes(rs.getInt("habitantes"));
					ciudad.setHistoria(rs.getString("historia"));
					ciudad.setLatitud(rs.getDouble("latitud"));
					ciudad.setLongitud(rs.getDouble("longitud"));
					ciudad.setActivo(rs.getBoolean("activo"));
					lista.add(ciudad);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conec.closeStatement(myStmt);
			conec.closeConnect(myConect);
		}
		return lista;
	}
}
