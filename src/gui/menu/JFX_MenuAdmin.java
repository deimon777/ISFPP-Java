package gui.menu;

import gui.utiles.TextoGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class JFX_MenuAdmin {

	MenuBar menu = new MenuBar();

	public JFX_MenuAdmin() {
		EventHandler<ActionEvent> action = new MenuAction().setAction();

		/*
		 * Creando las secciones del menú
		 */
		Menu archivo = new Menu(TextoGUI.MENU_ARCHIVO); // el _ hace que se pueda abrir con alt+LETRA		
		MenuItem archivoSesion = new MenuItem(TextoGUI.MENU_ARCHIVO_SESION);
		MenuItem archivoSalir = new MenuItem(TextoGUI.MENU_ARCHIVO_SALIR);
		
		Menu ver = new Menu(TextoGUI.MENU_VER);
		MenuItem verPublico = new MenuItem(TextoGUI.MENU_PUBLICO);
		MenuItem verCiudades = new MenuItem(TextoGUI.MENU_VER_CIUDAD);
		MenuItem verCaminos = new MenuItem(TextoGUI.MENU_VER_CAMINO);
		MenuItem verRecursos = new MenuItem(TextoGUI.MENU_VER_RECURSO);
		
		Menu crear = new Menu(TextoGUI.MENU_CREAR);
		MenuItem crearCiudad = new MenuItem(TextoGUI.MENU_CREAR_CIUDAD);
		MenuItem crearCamino = new MenuItem(TextoGUI.MENU_CREAR_CAMINO);		
		Menu crearRecursos = new Menu(TextoGUI.MENU_CREAR_RECURSO);
		MenuItem crearRecursoAlojamiento = new MenuItem(TextoGUI.MENU_CREAR_RECURSO_ALOJAMIENTO);
		MenuItem crearRecursoTrafico = new MenuItem(TextoGUI.MENU_CREAR_RECURSO_TRAFICO);
		MenuItem crearRecursoSitioTuristico = new MenuItem(TextoGUI.MENU_CREAR_RECURSO_SITIO_TURISTICO);
		MenuItem crearRecursoTipoCamino = new MenuItem(TextoGUI.MENU_CREAR_RECURSO_TIPO_CAMINO);
		MenuItem crearRecursoEstadoCamino = new MenuItem(TextoGUI.MENU_CREAR_RECURSO_ESTADO_CAMINO);
		
		
		Menu sistema = new Menu(TextoGUI.MENU_SISTEMA);
//		MenuItem sistemaTema = new MenuItem(TextoGUI.MENU_SISTEMA_TEMA);
		MenuItem sistemaDB= new MenuItem(TextoGUI.MENU_SISTEMA_BASE_DE_DATOS);
		Menu sistemaAutomatizar = new Menu(TextoGUI.MENU_SISTEMA_AUTOMATIZAR);
		MenuItem sistemaAutoAuto= new MenuItem(TextoGUI.MENU_SISTEMA_AUTO_AUTO);
		MenuItem sistemaAutoCSV = new MenuItem(TextoGUI.MENU_SISTEMA_AUTO_CSV);

		Menu ayuda = new Menu(TextoGUI.MENU_AYUDA);
		MenuItem ayudaAcerca = new MenuItem(TextoGUI.MENU_AYUDA_ACERCA);
		MenuItem ayudaAyuda = new MenuItem(TextoGUI.MENU_AYUDA_AYUDA);

		/*
		 * Creando los Submenus
		 */
		archivo.getItems().addAll(archivoSesion,archivoSalir);
		ver.getItems().addAll(verPublico, verCiudades, verCaminos, verRecursos);
		crearRecursos.getItems().addAll(crearRecursoAlojamiento, crearRecursoTrafico, crearRecursoSitioTuristico, crearRecursoEstadoCamino, crearRecursoTipoCamino);
		crear.getItems().addAll(crearCiudad, crearCamino, crearRecursos);
		sistemaAutomatizar.getItems().addAll(sistemaAutoAuto,sistemaAutoCSV);
		sistema.getItems().addAll(sistemaDB,sistemaAutomatizar);
		ayuda.getItems().addAll(ayudaAcerca,ayudaAyuda);

		/*
		 * Agregando los Atajos de teclado
		 */
		archivoSalir.setAccelerator(new KeyCodeCombination(KeyCode.Q,KeyCombination.SHORTCUT_DOWN));
		archivoSesion.setAccelerator(new KeyCodeCombination(KeyCode.N,KeyCombination.SHORTCUT_DOWN));
		
		verPublico.setAccelerator(new KeyCodeCombination(KeyCode.P,KeyCombination.SHORTCUT_DOWN));

		ayudaAyuda.setAccelerator(new KeyCodeCombination(KeyCode.F1));
		
		/*
		 * Agregando los menus
		 */
		 menu.getMenus().addAll(archivo,ver,crear,sistema,ayuda);

		/*
		 * Agregando las acciones
		 */
		archivoSesion.setOnAction(action);
		archivoSalir.setOnAction(action);

		verPublico.setOnAction(action);
		verCiudades.setOnAction(action);
		verCaminos.setOnAction(action);
		verRecursos.setOnAction(action);

		crearCiudad.setOnAction(action);
		crearCamino.setOnAction(action);
		crearRecursoAlojamiento.setOnAction(action);
		crearRecursoTrafico.setOnAction(action);
		crearRecursoSitioTuristico.setOnAction(action);
		crearRecursoTipoCamino.setOnAction(action);
		crearRecursoEstadoCamino.setOnAction(action);

		sistemaDB.setOnAction(action);
		sistemaAutoAuto.setOnAction(action);
		sistemaAutoCSV.setOnAction(action);
		
		ayudaAcerca.setOnAction(action);
		ayudaAyuda.setOnAction(action);
	}

	public MenuBar getMenu() {
		return this.menu;
	}
}
