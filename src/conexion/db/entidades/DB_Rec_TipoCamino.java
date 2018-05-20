package conexion.db.entidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.deimon.isfpp.configuracion.ConstantesPropierties;
import com.mysql.jdbc.PreparedStatement;

import conexion.db.DB_Connection;

public class DB_Rec_TipoCamino extends Entidades{
	private String table_name = TablesName.TIPO_CAMINO;

	public void crearTablaTipoCamino() {
		String sql = "id INT NOT NULL AUTO_INCREMENT,"
				+ "nombre VARCHAR(50) NOT NULL,"
				+ "activo BIT(1) DEFAULT TRUE,"
				+ "PRIMARY KEY (id)";
		Entidades.creatTable(table_name, sql);
	}

	public void borrarTablaTipoCamino() {
		Entidades.deleteTable(table_name);		
	}

	/*
	 * BORRAR
	 */
	public void deleteItemByID(int id) {
		Entidades.deleteItemByID(table_name, id);
	}
	
	public void deleteItemByNAME(String nombre) {
		Entidades.deleteItemByNAME(table_name, nombre);
	}
	
	/*
	 * MODIFICAR
	 */
	
	/*
	 * INSERTAR
	 */
	public void insertar(String nombre, Boolean activo) {

		System.out.println("Nombre: "+nombre);
		System.out.println("Activo: "+activo);
		
		int act = 1;
		if(!activo)
			act = 0;
		
		DB_Connection c = null;
		Connection myConect = null;
		PreparedStatement myPrepStmt = null;
		try {
			c = new DB_Connection();
			myConect = c.getConection(ConstantesPropierties.DB_NAME_URL,
					ConstantesPropierties.DB_NAME_USER,
					ConstantesPropierties.DB_NAME_PASS);
//			myStmt = c.getStatement(myConect);	
			myPrepStmt = (PreparedStatement) myConect.prepareStatement("INSERT INTO " + table_name + "(`id`, `nombre`, `activo`) VALUES (NULL, ?, ?)");
			myPrepStmt.setString(1, nombre);
			myPrepStmt.setInt(2, act);
			myPrepStmt.executeUpdate(); 
			
			
			System.out.println("Tipo Camino creado");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeStatement(myPrepStmt);
			c.closeConnect(myConect);
		}
		
		//INSERT INTO `tipo_camino` (`id`, `nombre`, `activo`) VALUES (NULL, 'Ripio', b'1');
	}
}
