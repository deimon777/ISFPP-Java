package conexion.db.entidades;

public class DB_Entidades {

	private DB_TipoUsuarios tipo_usuario = new DB_TipoUsuarios();
	private DB_Usuarios usuario = new DB_Usuarios();
	
	private DB_Rec_TipoCamino tipo_camino = new DB_Rec_TipoCamino();
	private DB_Rec_EstadoCamino estado_camino = new DB_Rec_EstadoCamino();
	private DB_Rec_Trafico trafico = new DB_Rec_Trafico();
	private DB_Caminos caminos = new DB_Caminos();
	
	private DB_Ciudades ciudades = new DB_Ciudades();
	private DB_Rec_Alojamientos alojamientos = new DB_Rec_Alojamientos();
	private DB_Rec_SitiosTuristicos sitios_turisticos = new DB_Rec_SitiosTuristicos();
	
	private DB_Ciudades_Caminos ciudades_caminos = new DB_Ciudades_Caminos();
	
	public void crearTodasLasTablas() {
		tipo_usuario.crearTablaTipoUsuario();
		usuario.crearTablaUsuario();
		
		tipo_camino.crearTablaTipoCamino();
		estado_camino.crearTablaEstadoCamino();
		trafico.crearTablaTrafico();		
		caminos.crearTablaCaminos();
		
		ciudades.crearTablaCiudad();
		alojamientos.crearTablaAlojamientos();
		sitios_turisticos.crearTablaSitiosTuristicos();
		
		ciudades_caminos.crearTablaCiudadesCaminos();		
	}
		
	public void borrarTodasLasTablas() {
		ciudades_caminos.borrarTablaCiudadesCaminos();
		sitios_turisticos.borrarTablaSitiosTuristicos();
		alojamientos.borrarTablaAlojamientos();
		ciudades.borrarTablaCiudad();
		caminos.borrarTablaCaminos();
		trafico.borrarTablaTrafico();
		estado_camino.borrarTablaEstadoCamino();
		tipo_camino.borrarTablaTipoCamino();
		usuario.borrarTablaUsuario();
		tipo_usuario.borrarTablaTipoUsuario();
	}	

}
