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
				+ " REFERENCES trafico (id) ON DELETE CASCADE ON UPDATE CASCADE";
		TablasUtiles.creatTable(table_name, sql);
	}
	public void borrarTablaCaminos() {
		TablasUtiles.deleteTable(table_name);		
	}
	public void vaciarTablaCaminos() {
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
	
	public void insertar(String nombre, Integer distancia, Integer peso, String tipo, String estado, String trafico, Boolean activo) {
		String sql = "INSERT INTO "+table_name+" (id, nombre, distancia, peso_camino, tipo_camino_id, estado_camino_id, trafico_id, activo) "
				+ "VALUES (NULL, ?,?,?,?,?,?,?)";

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
				if (distancia == null) {
					myPrepStmt.setNull(2, java.sql.Types.INTEGER);				
				}
				else {
					myPrepStmt.setInt(2, distancia);
				}
//				if (peso == null) {
//					myPrepStmt.setNull(3, java.sql.Types.INTEGER);				
//				}
//				else {
//					myPrepStmt.setInt(3, peso);
//				}
				myPrepStmt.setString(3, null); //peso
				myPrepStmt.setString(4, null); //tipo
				myPrepStmt.setString(5, null); //estado
				myPrepStmt.setString(6, null); //trafico

				myPrepStmt.setBoolean(7, activo);
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
