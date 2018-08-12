package conexion.db.tablas;

import conexion.db.entidades.Caminos;
import conexion.db.entidades.Vertices;
import conexion.db.entidades.Rec_Alojamientos;
import conexion.db.entidades.Rec_EstadoCamino;
import conexion.db.entidades.Rec_SitiosTuristicos;
import conexion.db.entidades.Rec_TipoCamino;
import conexion.db.entidades.Rec_Trafico;
import conexion.db.entidades.Roles;
import conexion.db.entidades.TipoVertice;
import conexion.db.entidades.Usuarios;

public class DB_Tablas {

	private Roles roles = new Roles();
	private Usuarios usuario = new Usuarios();
	
	private Rec_TipoCamino tipoCamino = new Rec_TipoCamino();
	private Rec_EstadoCamino estadoCamino = new Rec_EstadoCamino();
	private Rec_Trafico trafico = new Rec_Trafico();
	private Caminos caminos = new Caminos();
	
	private Vertices vertices = new Vertices();
	private TipoVertice tipoVertices = new TipoVertice();
	private Rec_Alojamientos alojamientos = new Rec_Alojamientos();
	private Rec_SitiosTuristicos sitiosTuristicos = new Rec_SitiosTuristicos();
	
//	private Ciudades_Caminos ciudades_caminos = new Ciudades_Caminos();
	
	public void crearTodasLasTablas() {
		roles.crearTablaRoles();
		usuario.crearTablaUsuario();		
		tipoCamino.crearTablaTipoCamino();
		estadoCamino.crearTablaEstadoCamino();
		trafico.crearTablaTrafico();
		tipoVertices.crearTablaTipoVertice();
		vertices.crearTablaVertice();
		caminos.crearTablaCaminos();		
		alojamientos.crearTablaAlojamientos();
		sitiosTuristicos.crearTablaSitiosTuristicos();		
	}
		
	public void borrarTodasLasTablas() {
		sitiosTuristicos.borrarTablaSitiosTuristicos();
		alojamientos.borrarTablaAlojamientos();
		caminos.borrarTablaCaminos();
		vertices.borrarTablaVertice();
		tipoVertices.borrarTablaTipoVertice();
		trafico.borrarTablaTrafico();
		estadoCamino.borrarTablaEstadoCamino();
		tipoCamino.borrarTablaTipoCamino();
		usuario.borrarTablaUsuario();
		roles.borrarTablaRoles();
	}	
	
	public void vaciarTodasLasTablas() {
		alojamientos.vaciarTablaAlojamientos();
		caminos.vaciarTablaCaminos();
		tipoVertices.vaciarTablaTipoVertice();
		vertices.vaciarTablaVertice();
		estadoCamino.vaciarTablaEstadoCamino();
		sitiosTuristicos.vaciarTablaSitiosTuristicos();
		tipoCamino.vaciarTablaTipoCamino();
		roles.vaciarTablaRoles();
		trafico.vaciarTablaTrafico();
		usuario.vaciarTablaUsuario();
	}	
}
