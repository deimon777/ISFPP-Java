package com.deimon.isfpp.junit;

import com.sothawo.mapjfx.Coordinate;
import com.sothawo.mapjfx.CoordinateLine;
import com.sothawo.mapjfx.Extent;
import com.sothawo.mapjfx.MapLabel;
import com.sothawo.mapjfx.MapType;
import com.sothawo.mapjfx.MapView;
import com.sothawo.mapjfx.Marker;
import com.sothawo.mapjfx.WMSParam;
import com.sothawo.mapjfx.event.MapLabelEvent;
import com.sothawo.mapjfx.event.MapViewEvent;
import com.sothawo.mapjfx.event.MarkerEvent;
import com.sothawo.mapjfx.offline.OfflineCache;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Collections;
import java.util.logging.Level;

/**
* Test application.
*
* @author P.J. Meisch (pj.meisch@sothawo.com).
*/
public class TestMapJFX extends Application {
//------------------------------ FIELDS ------------------------------

   /** some coordinates from around town */
   private static final Coordinate coordKarlsruheCastle = new Coordinate(49.013517, 8.404435);
   private static final Coordinate coordKarlsruheHarbour = new Coordinate(49.015511, 8.323497);
   private static final Coordinate coordKarlsruheStation = new Coordinate(48.993284, 8.402186);
   private static final Extent extentAll =
           Extent.forCoordinates(coordKarlsruheHarbour, coordKarlsruheCastle, coordKarlsruheStation);

   private static final CoordinateLine coordinateLine =
           new CoordinateLine(coordKarlsruheCastle, coordKarlsruheHarbour, coordKarlsruheStation).setVisible(true)
                   .setColor(Color.DODGERBLUE).setWidth(7);

//   private static final Marker marker = null;
//   private static final MapLabel mapLabel = null;

   private static final WMSParam wmsParam;

   static {

//       marker = Marker.createProvided(Marker.Provided.BLUE).setPosition(coordKarlsruheCastle).setVisible(true);
//       mapLabel = new MapLabel("blau!")
//               .setCssClass("blue-label")
//               .setPosition(coordKarlsruheCastle)
//               .setVisible(true);
//
//       marker.attachLabel(mapLabel);

//       wmsParam = new WMSParam()
//               .setUrl("http://irs.gis-lab.info/?")
//               .addParam("layers", "landsat")
//               .addParam("REQUEST", "GetTile");

       wmsParam = new WMSParam()
               .setUrl("http://geonode.wfp.org:80/geoserver/ows")
               .addParam("layers", "geonode:admin_2_gaul_2015");
   }

   /** the MapView */
   private MapView mapView;

//-------------------------- OTHER METHODS --------------------------

   public static void main(String[] args) {
       launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception {
//       logger.info("starting devtest program...");
       BorderPane borderPane = new BorderPane();

       // MapView in the center with an initial coordinate (optional)
       // the MapView is created first as the other elements reference it
       mapView = new MapView();
       // animate pan and zoom with 500ms
       mapView.setAnimationDuration(500);
       borderPane.setCenter(mapView);

       // add WMSParam
       mapView.setWMSParam(wmsParam);

       // listen to MapViewEvent MAP_CLICKED
//       mapView.addEventHandler(MapViewEvent.MAP_CLICKED, event -> {
//           event.consume();
//           if (marker.getVisible()) {
//               marker.setPosition(event.getCoordinate());
//           }
//           if (mapLabel.getVisible()) {
//               mapLabel.setPosition(event.getCoordinate());
//           }
//       });

       // listen to MapViewEvent MAP_RIGHTCLICKED
//       mapView.addEventHandler(MapViewEvent.MAP_RIGHTCLICKED, event -> {
//           event.consume();
//       });
//
//       // listen to MapViewEvent MAP_EXTENT
//       mapView.addEventHandler(MapViewEvent.MAP_EXTENT, event -> {
//           mapView.setExtent(event.getExtent());
//           event.consume();
//       });

       // listen to MapViewEvent MAP_BOUNDING_EXTENT
//       mapView.addEventHandler(MapViewEvent.MAP_BOUNDING_EXTENT, event -> {
//           logger.info(() -> "MAP_BOUNDING_EXTENT event: " + event.getExtent());
//           event.consume();
//       });

       // listen to MARKER_CLICKED event.
//       mapView.addEventHandler(MarkerEvent.MARKER_CLICKED, event -> {
//           event.consume();
//       });
//       // listen to MARKER_MOUSEDOWN event.
//       mapView.addEventHandler(MarkerEvent.MARKER_MOUSEDOWN, event -> {
//           event.consume();
//       });
//       // listen to MARKER_MOUSEUP event.
//       mapView.addEventHandler(MarkerEvent.MARKER_MOUSEUP, event -> {
//           event.consume();
//       });
//       // listen to MARKER_DOUBLECLICKED event.
//       mapView.addEventHandler(MarkerEvent.MARKER_DOUBLECLICKED, event -> {
//           event.consume();
//       });
//       // listen to MARKER_RIGHTCLICKED event.
//       mapView.addEventHandler(MarkerEvent.MARKER_RIGHTCLICKED, event -> {
//           event.consume();
//       });
//       // listen to MARKER_ENTERED event.
//       mapView.addEventHandler(MarkerEvent.MARKER_ENTERED, event -> {
//           event.consume();
//       });
//       // listen to MARKER_EXITED event.
//       mapView.addEventHandler(MarkerEvent.MARKER_EXITED, event -> {
//           event.consume();
//       });
//       // listen to MAPLABEL_MOUSEDOWN event.
//       mapView.addEventHandler(MapLabelEvent.MAPLABEL_MOUSEDOWN, event -> {
//    	   event.consume();
//       });
//       // listen to MAPLABEL_MOUSEUP event.
//       mapView.addEventHandler(MapLabelEvent.MAPLABEL_MOUSEUP, event -> {
//           event.consume();
//       });
//       // listen to MAPLABEL_CLICKED event.
//       mapView.addEventHandler(MapLabelEvent.MAPLABEL_CLICKED, event -> {
//           event.consume();
//       });
//       // listen to MAPLABEL_RIGHTCLICKED event.
//       mapView.addEventHandler(MapLabelEvent.MAPLABEL_RIGHTCLICKED, event -> {
//           event.consume();
//       });
//       // listen to MAPLABEL_DOUBLECLICKED event.
//       mapView.addEventHandler(MapLabelEvent.MAPLABEL_DOUBLECLICKED, event -> {
//           event.consume();
//       });
//       // listen to MAPLABEL_ENTERED event.
//       mapView.addEventHandler(MapLabelEvent.MAPLABEL_ENTERED, event -> {
//           event.consume();
//           event.getMapLabel().setCssClass("green-label");
//       });
//       // listen to MAPLABEL_EXITED event.
//       mapView.addEventHandler(MapLabelEvent.MAPLABEL_EXITED, event -> {
//           event.consume();
//           event.getMapLabel().setCssClass("blue-label");
//       });


//       final OfflineCache offlineCache = mapView.getOfflineCache();
//       offlineCache.setCacheDirectory(FileSystems.getDefault().getPath("tmpdata/cache"));
//       offlineCache.setActive(false);
//       offlineCache.setNoCacheFilters(Collections.singletonList(".*\\.sothawo\\.com/.*"));
//       // add listener for mapView initialization state
       mapView.initializedProperty().addListener((observable, oldValue, newValue) -> {
           if (newValue) {
               // a map is only displayed when an initial coordinate is set
               mapView.setCenter(coordKarlsruheHarbour);
               mapView.setExtent(extentAll);
//               mapView.setZoom(0);

               // add two markers without keeping a ref to them, they should disappear from the map when gc'ed
               mapView.addMarker(Marker.createProvided(Marker.Provided.GREEN).setPosition(coordKarlsruheHarbour)
                       .setVisible(true));
               mapView.addMarker(
                       Marker.createProvided(Marker.Provided.ORANGE).setPosition(coordKarlsruheStation).setVisible(
                               true));

               // add a coordinate line to be gc'ed
               mapView.addCoordinateLine(
                       new CoordinateLine(coordKarlsruheHarbour, coordKarlsruheStation, coordKarlsruheCastle)
                               .setVisible(true)
                               .setColor(Color.FUCHSIA).setWidth(5));

               // add a label to be gc'ed
               mapView.addLabel(new MapLabel("clean me up").setPosition(coordKarlsruheStation)
                       .setVisible(true));
           }
       });

       // set custom css url
//       mapView.setCustomMapviewCssURL(getClass().getResource("/custom_mapview.css"));

       // now initialize the mapView
       mapView.initialize();

       // show the whole thing
       Scene scene = new Scene(borderPane, 1200, 800);

       primaryStage.setTitle("sothawo mapjfx devtest program");
       primaryStage.setScene(scene);
       primaryStage.show();
   }
}