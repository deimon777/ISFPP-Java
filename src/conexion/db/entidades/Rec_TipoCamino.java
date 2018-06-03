package conexion.db.entidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
//import com.mysql.jdbc.PreparedStatement;

import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;
import javafx.collections.ObservableList;

public class Rec_TipoCamino extends EntidadesUtils{
	private String table_name = TablesName.TIPO_CAMINO;

	/**
	 * Tiene el codigo SQL para crear la tabla tipo_camino, y llama a la funcion para crear la misma
	 */
	public void crearTablaTipoCamino() {
		String sql = "id INT NOT NULL AUTO_INCREMENT UNIQUE,"
				+ "nombre VARCHAR(50) NOT NULL UNIQUE,"
				+ "activo BIT(1) DEFAULT TRUE,"
				+ "PRIMARY KEY (id)";
		TablasUtiles.creatTable(table_name, sql);
	}
	/**
	 * Borra (DELETE) la tabla.
	 */
	public void borrarTablaTipoCamino() {
		TablasUtiles.deleteTable(table_name);		
	}
	/**
	 * Vacia (DROP) la tabla.
	 */
	public void vaciarTablaTipoCamino() {
		TablasUtiles.emptyTable(table_name);
	}

	/*******************************************************************/

	/*
	 * INSERTAR
	 */
	public void insertar(String nombre, Boolean activo) {
		String sql = "INSERT INTO " + table_name + "(`id`, `nombre`, `activo`) VALUES (NULL, ?, ?)";

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
				myPrepStmt.executeUpdate();
				System.out.println("Tipo Camino creado");
			}
		} catch (SQLException e) {
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
	public ObservableList<String> getTipoCaminoNombre() {
		return EntidadesUtils.getLista("SELECT nombre from "+table_name);
	}

	/**
	 * Trae el ID de una TipoCamino segun su nombre
	 * @param nombre
	 * @return El ID del tipo camino.
	 */
	public int getTipoCaminoID(String nombre) {
		int id = EntidadesUtils.getItemFromNombre(table_name, "id", nombre);
		return id;
	}
}
