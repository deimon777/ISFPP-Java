package conexion.db.tablas;

import conexion.db.entidades.Caminos;
import conexion.db.entidades.Ciudades;
import conexion.db.entidades.Ciudades_Caminos;
import conexion.db.entidades.Rec_Alojamientos;
import conexion.db.entidades.Rec_EstadoCamino;
import conexion.db.entidades.Rec_SitiosTuristicos;
import conexion.db.entidades.Rec_TipoCamino;
import conexion.db.entidades.Rec_Trafico;
import conexion.db.entidades.TipoUsuarios;
import conexion.db.entidades.Usuarios;

public class DB_Tablas {

	private TipoUsuarios tipo_usuario = new TipoUsuarios();
	private Usuarios usuario = new Usuarios();
	
	private Rec_TipoCamino tipo_camino = new Rec_TipoCamino();
	private Rec_EstadoCamino estado_camino = new Rec_EstadoCamino();
	private Rec_Trafico trafico = new Rec_Trafico();
	private Caminos caminos = new Caminos();
	
	private Ciudades ciudades = new Ciudades();
	private Rec_Alojamientos alojamientos = new Rec_Alojamientos();
	private Rec_SitiosTuristicos sitios_turisticos = new Rec_SitiosTuristicos();
	
//	private Ciudades_Caminos ciudades_caminos = new Ciudades_Caminos();
	
	public void crearTodasLasTablas() {
		tipo_usuario.crearTablaTipoUsuario();
		usuario.crearTablaUsuario();		
		tipo_camino.crearTablaTipoCamino();
		estado_camino.crearTablaEstadoCamino();
		trafico.crearTablaTrafico();
		ciudades.crearTablaCiudad();
		caminos.crearTablaCaminos();		
		alojamientos.crearTablaAlojamientos();
		sitios_turisticos.crearTablaSitiosTuristicos();		
//		ciudades_caminos.crearTablaCiudadesCaminos();		
	}
		
	public void borrarTodasLasTablas() {
//		ciudades_caminos.borrarTablaCiudadesCaminos();
		sitios_turisticos.borrarTablaSitiosTuristicos();
		alojamientos.borrarTablaAlojamientos();
		caminos.borrarTablaCaminos();
		ciudades.borrarTablaCiudad();
		trafico.borrarTablaTrafico();
		estado_camino.borrarTablaEstadoCamino();
		tipo_camino.borrarTablaTipoCamino();
		usuario.borrarTablaUsuario();
		tipo_usuario.borrarTablaTipoUsuario();
	}	
	
	public void vaciarTodasLasTablas() {
		alojamientos.vaciarTablaAlojamientos();
		caminos.vaciarTablaCaminos();
		ciudades.vaciarTablaCiudad();
//		ciudades_caminos.vaciarTablaCiudadesCaminos();
		estado_camino.vaciarTablaEstadoCamino();
		sitios_turisticos.vaciarTablaSitiosTuristicos();
		tipo_camino.vaciarTablaTipoCamino();
		tipo_usuario.vaciarTablaTipoUsuario();
		trafico.vaciarTablaTrafico();
		usuario.vaciarTablaUsuario();
	}	
}
