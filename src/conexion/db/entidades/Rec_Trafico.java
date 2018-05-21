package conexion.db.entidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import com.deimon.isfpp.configuracion.ConstantesPropierties;

import conexion.db.DB_Connection;
import conexion.db.tablas.TablasUtiles;
import conexion.db.tablas.TablesName;

public class Rec_Trafico extends EntidadesUtils{
	private String table_name = TablesName.TRAFICO;

	public void crearTablaTrafico() {
		String sql = "id INT NOT NULL AUTO_INCREMENT,"
				+ "nombre VARCHAR(50) NOT NULL,"
				+ "activo BIT(1) DEFAULT TRUE,"
				+ "PRIMARY KEY (id)";
		TablasUtiles.creatTable(table_name, sql);
	}
	public void borrarTablaTrafico() {
		TablasUtiles.deleteTable(table_name);		
	}
	public void vaciarTablaTrafico() {
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
	 * MODIFICAR
	 */
	public void modificarMombre(String nombre) {
		System.out.println("Modificar nombre");	
	}

	public void modificarActivo(Boolean activo) {
		System.out.println("Modificar activo");	
	}
	
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
			myPrepStmt = myConect.prepareStatement(sql);
			myPrepStmt.setString(1, nombre);
			myPrepStmt.setBoolean(2, activo);
			myPrepStmt.executeUpdate(); 			
			
			System.out.println("Trafico creado");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myPrepStmt);
			c.closeConnect(myConect);
		}
	}
	
	/*
	 * BUSCAR
	 */
	public ArrayList<String> getTrafico() {
		return EntidadesUtils.getListaByNAME(table_name);
	}
}
