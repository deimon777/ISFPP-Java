package conexion.db.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deimon.entidades.ciudad.Vertice;
import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Vertices extends EntidadesUtils{
	private static String tableName = TablesName.VERTICES;

	/**
	 * Tiene el codigo SQL para crear la tabla ciudades, y llama a la funcion para crear la misma
	 */
	public void crearTablaVertice() {
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE,"
				+ "nombre VARCHAR(50) NOT NULL UNIQUE,"
				+ "habitantes INT(10),"
				+ "historia VARCHAR(300),"
				+ "latitud DOUBLE(10,6),"
				+ "longitud DOUBLE(10,6),"
				+ "activo BIT(1) DEFAULT TRUE,"
				+ "PRIMARY KEY (id),"
				+ "tipo_vertice_id INT NOT NULL,"
				+ "CONSTRAINT fk_tipo_vertice FOREIGN KEY (tipo_vertice_id)"
				+ "		REFERENCES tipo_vertice (id)";
		TablasUtiles.creatTable(tableName, sql);
	}
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaVertice() {
		TablasUtiles.deleteTable(tableName);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaVertice() {
		TablasUtiles.emptyTable(tableName);
	}

	/*******************************************************************/

	/*
	 * INSERTAR
	 */
	/** 
	 * Crea un item en la base de datos.
	 * @param nombre
	 * @param habitantes
	 * @param historia
	 * @param latitud
	 * @param longitud
	 * @param activo
	 */
	public void insertar( String nombre, Integer habitantes, String historia, Double latitud, Double longitud, Boolean activo, Integer tipo_vertice) {
		String sql = "INSERT INTO "+tableName+" (id, nombre, habitantes, historia, latitud, longitud, activo, tipo_vertice_id) "
				+ "VALUES (NULL,?,?,?,?,?,?,?)";

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
				
				if (tipo_vertice == null) {
					myPrepStmt.setNull(7, java.sql.Types.INTEGER);				
				}
				else {
					myPrepStmt.setInt(7, tipo_vertice);
				}

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

	/**
	 * Inserta los valores a la tabla
	 * @param valorSql
	 */
	public void cargarValores(String valorSql) {
		String sql = "INSERT INTO "+tableName+" (id, nombre, habitantes, historia, latitud, longitud, activo, tipo_vertice_id) "
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
				System.out.println("Ciudad Cargada!");
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
	/**
	 * Actualiza la informacion de un item en la base de datos.
	 * @param id
	 * @param nombre
	 * @param distancia
	 * @param peso
	 * @param tipo
	 * @param estado
	 * @param trafico
	 * @param activo
	 */	
	public void actualizar(int id, String nombre, Integer habitantes, String historia, Double latitud, Double longitud, boolean activo) {
		String sql = "UPDATE "+tableName+" "
				+ "SET nombre = ?, "
				+ "habitantes = ?, "
				+ "historia = ?, "
				+ "latitud = ?, "
				+ "longitud = ?, "
				+ "activo = ? "
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
				myPrepStmt.setInt(7, id);

				myPrepStmt.executeUpdate();
				System.out.println("Ciudad Modificada!");
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
	/**
	 * Trae todos las ciudades (Objetos), con toda la informacion que esta en la base de datos.
	 * @return Una lista de objetos tipo Ciudad
	 */
	public ObservableList<Vertice> getListaVertices() {
		String sql = "SELECT * from "+tableName;

		DB_Connection conec = null;
		Connection myConect = null;
		PreparedStatement myPrepStmt = null;
		ResultSet rs = null;
		ObservableList<Vertice> lista = FXCollections.observableArrayList();
		try {
			conec = new DB_Connection();
			myConect = conec.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect != null) {
				myPrepStmt = myConect.prepareStatement(sql);
				rs = myPrepStmt.executeQuery();	
				while (rs.next()) {
					Vertice ciudad = new Vertice();
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
			conec.closeConnect(myConect);
		}
		return lista;
	}
	/**
	 * Crea una lista con los nombres de las ciudades
	 * @return Una lista con nombres de ciudades
	 */
	public ObservableList<String> getVerticesNombre() {
		return EntidadesUtils.getLista("SELECT nombre from "+tableName);
	}

	/**
	 * Crea una lista con los nombres de las ciudades activas
	 * @return Una lista con nombres de ciudades
	 */
	public ObservableList<String> getVerticesActivas() {
		return EntidadesUtils.getLista("SELECT nombre from "+tableName+" WHERE activo = 1");
	}

	/**
	 * Trae el ID de una ciudad segun su nombre
	 * @param nombre
	 * @return El ID de la ciudad.
	 */
	public int getVerticesID(String nombre) {
		int id = EntidadesUtils.getItemFromNombre(tableName, "id", nombre);
		return id;
	}
}
