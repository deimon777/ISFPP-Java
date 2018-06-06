package gui.panels.ver;

import com.deimon.isfpp.configuracion.Constantes;
import com.sothawo.mapjfx.Coordinate;
import com.sothawo.mapjfx.CoordinateLine;
import com.sothawo.mapjfx.MapLabel;
import com.sothawo.mapjfx.MapView;
import com.sothawo.mapjfx.Marker;
import com.sothawo.mapjfx.WMSParam;
import com.sothawo.mapjfx.offline.OfflineCache;

import conexion.db.entidades.Ciudades;

import java.nio.file.FileSystems;
import java.util.Collections;

import org.controlsfx.control.textfield.TextFields;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;



public class JFX_Ver_Publico{
	VBox panel = new VBox();

	private static WMSParam wmsParam = null;
	private MapView mapa = null;
	private static final Coordinate chubut = new Coordinate(-44.038186, -68.705483);

	public JFX_Ver_Publico() {
		/*
		 * Mapa de los caminos
		 */

		wmsParam = new WMSParam()
				.setUrl("http://geonode.wfp.org:80/geoserver/ows")
				.addParam("layers", "geonode:admin_2_gaul_2015");

		mapa = new MapView();
		mapa.setAnimationDuration(500);
		mapa.setCenter(chubut);
		mapa.setZoom(6);
		mapa.setWMSParam(wmsParam);
		
//		final OfflineCache offlineCache = mapa.getOfflineCache();
//		offlineCache.setCacheDirectory(FileSystems.getDefault().getPath("tmp"));
//		offlineCache.setActive(false);
//		offlineCache.setNoCacheFilters(Collections.singletonList(".*\\.sothawo\\.com/.*"));
		
//		mapa.initializedProperty().addListener((observable, oldValue, newValue) -> {
//			if (newValue) {
//				mapa.setCenter(chubut);
//				mapa.setZoom(7);
//			}
//		});
		
		mapa.initialize();
		BorderPane josm = new BorderPane();
		josm.setPrefHeight(450); //Tamaño
		//		josm.setAlignment(Pos.TOP_CENTER);
		josm.setCenter(mapa);
		//		josm.getChildren().add(mapa);
		josm.getStyleClass().add("josm");

		/*
		 * Seccion de busqueda de caminos
		 */
		// Izquierda
		HBox buscar_ruta = new HBox();
		buscar_ruta.setPrefHeight(150); //Tamaño		
		//		buscar_ruta.setAlignment(Pos.CENTER);
		buscar_ruta.setId("buscador_ruta");

		VBox busqueda = new VBox();
		busqueda.setPrefWidth(Constantes.ANCHO/2);
		busqueda.getStyleClass().add("padding-medio");
		busqueda.getStyleClass().add("spacing-medio");

		TextField ruta_inicio = new TextField();
		ruta_inicio.setPromptText("Ruta inicial"); //placeholder		
		TextField ruta_fin = new TextField();
		ruta_fin.setPromptText("Ruta final");

		TextFields.bindAutoCompletion(ruta_inicio,new Ciudades().getCiudadesActivas());
		TextFields.bindAutoCompletion(ruta_fin,new Ciudades().getCiudadesActivas());

		Button btn_ruta_buscar = new Button("Buscar Camino");
		btn_ruta_buscar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("La ruta va de'"+ruta_inicio.getText()+"' a '"+ruta_fin.getText()+"'");
			}
		});

		busqueda.getChildren().addAll(ruta_inicio, ruta_fin, btn_ruta_buscar);

		// Derecha
		GridPane funciones_extras = new GridPane();
		//		funciones_extras.setGridLinesVisible(true);
		funciones_extras.setPrefWidth(Constantes.ANCHO/2);
		funciones_extras.getStyleClass().add("padding-medio");
		funciones_extras.getStyleClass().add("spacing-medio");
		funciones_extras.setAlignment(Pos.TOP_CENTER);
		funciones_extras.setHgap(10);
		funciones_extras.setVgap(10);

		Button camino_corto = new Button("Camino mas corto");
		Button camino_mejor = new Button("Camino mejor");
		Button camino_rapido = new Button("Camino mas rapido");

		funciones_extras.add(camino_corto, 1, 0);
		funciones_extras.add(camino_mejor, 2, 0);
		funciones_extras.add(camino_rapido, 3, 0);

		buscar_ruta.getChildren().addAll(busqueda, funciones_extras);

		panel.getStyleClass().add("spacing-medio");
		panel.getChildren().addAll(josm,buscar_ruta);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
