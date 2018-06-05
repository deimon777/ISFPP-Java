package conexion.db.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.deimon.camino.*;
import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Caminos extends EntidadesUtils{
	private String table_name = TablesName.CAMINOS;

	/**
	 * Tiene el codigo SQL para crear la tabla caminos, y llama a la funcion para crear la misma
	 */
	public void crearTablaCaminos() {
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE,"
				+ "nombre VARCHAR(50) NOT NULL,"
				+ "distancia INT(20),"
				+ "peso_camino INT(5),"
				+ "activo BIT(1) DEFAULT TRUE,"
				+ "PRIMARY KEY (id),"
				+ "tipo_camino_id INT NOT NULL,"
				+ "CONSTRAINT fk_tipo_camino FOREIGN KEY (tipo_camino_id)"
				+ " REFERENCES tipo_camino (id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "estado_camino_id INT NOT NULL,"
				+ "CONSTRAINT fk_estado_camino FOREIGN KEY (estado_camino_id)"
				+ " REFERENCES estado_camino (id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "trafico_id INT NOT NULL,"
				+ "CONSTRAINT fk_trafico FOREIGN KEY (trafico_id)"
				+ " REFERENCES trafico (id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "ciudad_inicial_id INT NOT NULL," 
				+ "CONSTRAINT fk_ciudad_inicial FOREIGN KEY (ciudad_inicial_id)" 
				+ " REFERENCES ciudades (id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "ciudad_final_id INT NOT NULL," 
				+ "CONSTRAINT fk_ciudad_final FOREIGN KEY (ciudad_final_id)" 
				+ " REFERENCES ciudades (id) ON DELETE CASCADE ON UPDATE CASCADE";
		TablasUtiles.creatTable(table_name, sql);
	}
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaCaminos() {
		TablasUtiles.deleteTable(table_name);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaCaminos() {
		TablasUtiles.emptyTable(table_name);		
	}
	
	/*******************************************************************/
	
	/*
	 * INSERTAR
	 */
	/**
	 * Crea un item en la base de datos.
	 * @param nombre
	 * @param distancia
	 * @param peso
	 * @param tipo
	 * @param estado
	 * @param trafico
	 * @param activo
	 */
	public void insertar(String nombre, Integer distancia, Integer peso, Boolean activo, int tipo_id, int estado_id, int trafico_id, int ciudad_inicio_id, int ciudad_fin_id) {
		String sql = "INSERT INTO "+table_name+" (id, nombre, distancia, peso_camino, activo, tipo_camino_id, estado_camino_id, trafico_id, ciudad_inicial_id, ciudad_final_id) "
				+ "VALUES (NULL, ?,?,?,?,?,?,?,?,?)";

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
				myPrepStmt.setInt(2, distancia);
				myPrepStmt.setInt(3, peso);
				myPrepStmt.setBoolean(4, activo);
				myPrepStmt.setInt(5, tipo_id);
				myPrepStmt.setInt(6, estado_id);
				myPrepStmt.setInt(7, trafico_id);
				myPrepStmt.setInt(8, ciudad_inicio_id);
				myPrepStmt.setInt(9, ciudad_fin_id);
				
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
	 * BORRAR
	 */
	/**
	 * Borra un elemento de la tabla segun el ID
	 * @param Recive el id del item a ser borrado
	 */	
	public void deleteItemByID(int id) {
		EntidadesUtils.deleteItemByID(table_name, id);
	}
	
	/**
	 * Borra un elemento de la tabla segun el nombre
	 * @param Recive el nombre del item a ser borrado
	 */	
	public void deleteItemByNAME(String nombre) {
		EntidadesUtils.deleteItemByNAME(table_name, nombre);
	}

	/*
	 * ACTUALIZAR
	 */
	
	
	/*
	 * BUSCAR
	 */
	/**
	 * Crea una lista con los nombres de los caminos.
	 * @return Lista con nombres de caminos
	 */
	public ObservableList<String> getCaminosNombre() {
		return EntidadesUtils.getLista("SELECT nombre from "+table_name);
	}
	/**
	 * Crea una lista con los nombres de los caminos activos
	 * @return Lista con nombres de caminos
	 */
	public ObservableList<String> getCaminosActivos() {
		return EntidadesUtils.getLista("SELECT nombre from "+table_name+" WHERE activo = 1");
	}
	/**
	 * Trae todos los caminos (Objetos), con toda la informacion que esta en la base de datos.
	 * @return Una lista de objetos tipo Caminos
	 */
	public ObservableList<Camino> getCaminos() {
		String sql = "SELECT * from "+table_name;

		DB_Connection conec = null;
		Connection myConect = null;
		Statement myStmt = null;
		ResultSet rs = null;
		ObservableList<Camino> lista = FXCollections.observableArrayList();
		try {
			conec = new DB_Connection();
			myConect = conec.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
			if(myConect != null) {
				myStmt = conec.getStatement(myConect);
				rs = myStmt.executeQuery(sql);
				while (rs.next()) {
					Camino ciudad = new Camino();
					ciudad.setID(rs.getInt("id")); //poner los campos en el txt
					ciudad.setNombre(rs.getString("nombre"));
					ciudad.setDistancia(rs.getInt("distancia"));
					ciudad.setPesoCamino(rs.getInt("peso_camino"));
					ciudad.setTipoCamino((TipoCamino) rs.getObject("tipo_camino"));
					ciudad.setEstadoCamino((EstadoCamino) rs.getObject("estado_camino"));
					ciudad.setTrafico((Trafico) rs.getObject("trafico"));
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
