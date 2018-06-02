package gui.menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import gui.utils.TextoGUI;

public class JFX_Menu_public {

	MenuBar menu = new MenuBar();

	public JFX_Menu_public() {
		EventHandler<ActionEvent> action = new MenuAction().setAction();		

		/*
		 * Creando las secciones del menú
		 */
		Menu archivo = new Menu(TextoGUI.MENU_ARCHIVO); // el _ hace que se pueda abrir con alt+LETRA		
		MenuItem archivoSesion = new MenuItem(TextoGUI.MENU_ARCHIVO_SESION);
		MenuItem archivoSalir = new MenuItem(TextoGUI.MENU_ARCHIVO_SALIR);

		Menu sistema = new Menu(TextoGUI.MENU_SISTEMA);
		MenuItem sistemaTema = new MenuItem(TextoGUI.MENU_SISTEMA_TEMA);

		Menu ayuda = new Menu(TextoGUI.MENU_AYUDA);
		MenuItem ayudaAcerca = new MenuItem(TextoGUI.MENU_AYUDA_ACERCA);
		MenuItem ayudaAyuda = new MenuItem(TextoGUI.MENU_AYUDA_AYUDA);

		/*
		 * Creando los Submenus
		 */
		archivo.getItems().addAll(archivoSesion,archivoSalir);
		sistema.getItems().addAll(sistemaTema);
		ayuda.getItems().addAll(ayudaAcerca,ayudaAyuda);

		/*
		 * Agregando los Atajos de teclado
		 */
		archivoSalir.setAccelerator(new KeyCodeCombination(KeyCode.Q,KeyCombination.SHORTCUT_DOWN));
		archivoSesion.setAccelerator(new KeyCodeCombination(KeyCode.N,KeyCombination.SHORTCUT_DOWN));

		ayudaAyuda.setAccelerator(new KeyCodeCombination(KeyCode.F1));
		/*
		 * Agregando los menus
		 */
		menu.getMenus().addAll(archivo,ayuda);

		/*
		 * Agregando las acciones
		 */
		archivoSesion.setOnAction(action);
		archivoSalir.setOnAction(action);

		ayudaAcerca.setOnAction(action);
		ayudaAyuda.setOnAction(action);
	}

	public MenuBar getMenu() {
		return this.menu;

	}
}
