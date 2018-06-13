package gui.panels;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import conexion.db.entidades.Caminos;
import conexion.db.entidades.Ciudades;
import conexion.db.entidades.Rec_Alojamientos;
import conexion.db.entidades.Rec_EstadoCamino;
import conexion.db.entidades.Rec_SitiosTuristicos;
import conexion.db.entidades.Rec_TipoCamino;
import conexion.db.entidades.Rec_Trafico;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class JFX_Sistema_Auto {
	VBox panel = new VBox();

	public JFX_Sistema_Auto() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Cargar Datos");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		GridPane gpAuto = new GridPane();
		gpAuto.setAlignment(Pos.CENTER);
		gpAuto.setHgap(10);		
		gpAuto.setVgap(10);

		Button btnCiudades = new Button("Cargar Ciudades");
		Button btnAlojamientos = new Button("Cargar Alojamientos");
		Button btnSitios = new Button("Cargar Sitios Turisticos");		
		Button btnCaminos = new Button("Cargar Caminos");
		Button btnTipo = new Button("Cargar Tipo Camino");
		Button btnEstados = new Button("Cargar Estados Camino");
		Button btnTrafico = new Button("Cargar Trafico");		
		Button btnTodo = new Button("Cargar Todo");

		gpAuto.add(btnCiudades, 0, 0);
		gpAuto.add(btnCaminos, 1, 0);
		gpAuto.add(btnAlojamientos, 0, 1);
		gpAuto.add(btnSitios, 1, 1);
		gpAuto.add(btnTipo, 0, 2);
		gpAuto.add(btnEstados, 1, 2);
		gpAuto.add(btnTrafico, 2, 2);
		gpAuto.add(btnTodo, 0, 3);

		btnCiudades.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String csvFile = "/home/deimon/Programacion/Java/ISFPP-Java/src/gui/resource/CSV/Ciudades.csv"; //poner relativo

				if (csvFile != null) {					
					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ",";					
					String valoresSQL = "";
					try {

						br = new BufferedReader(new FileReader(csvFile));
						br.readLine(); //quito la primer linea ya que se usa para referenciar en el SCV
						while ((line = br.readLine()) != null) {
							String[] ciudad = line.split(cvsSplitBy);
							valoresSQL += "(NULL, '"+ciudad[0]+"', '"+ciudad[1]+"', '"+ciudad[2]+"', '"+ciudad[3]+"', '"+ciudad[4]+"', b'"+ciudad[5]+"'),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma
						Ciudades record = new Ciudades();
						// // record.vaciarTablaCiudad();
						record.cargarValores(valoresSQL);
					} catch (FileNotFoundException e11) {
						e11.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					} finally {
						if (br != null) {
							try {
								br.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			};
		});

		btnCaminos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String csvFile = "/home/deimon/Programacion/Java/ISFPP-Java/src/gui/resource/CSV/Caminos.csv"; //poner relativo

				if (csvFile != null) {					
					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ",";					
					String valoresSQL = "";
					try {

						br = new BufferedReader(new FileReader(csvFile));
						br.readLine(); //quito la primer linea ya que se usa para referenciar en el SCV
						while ((line = br.readLine()) != null) {
							String[] camino = line.split(cvsSplitBy);
							valoresSQL += "(NULL, '"+camino[0]+"', '"+camino[1]+"', '"+camino[2]+"', b'"+camino[3]+"', '"+camino[4]+"', '"+camino[5]+"', '"+camino[6]+"', '"+camino[7]+"', '"+camino[8]+"'),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma
						Caminos record = new Caminos();
						// record.vaciarTablaCaminos();
						record.cargarValores(valoresSQL);
					} catch (FileNotFoundException e11) {
						e11.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					} finally {
						if (br != null) {
							try {
								br.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			};
		});

		btnAlojamientos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String csvFile = "/home/deimon/Programacion/Java/ISFPP-Java/src/gui/resource/CSV/Alojamientos.csv"; //poner relativo

				if (csvFile != null) {					
					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ",";					
					String valoresSQL = "";
					try {

						br = new BufferedReader(new FileReader(csvFile));
						br.readLine(); //quito la primer linea ya que se usa para referenciar en el SCV
						while ((line = br.readLine()) != null) {
							String[] alojamiento = line.split(cvsSplitBy);
							valoresSQL += "(NULL, '"+alojamiento[0]+"', b'"+alojamiento[1]+"', '"+alojamiento[2]+"'),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma	
						Rec_Alojamientos record = new Rec_Alojamientos();
						// record.vaciarTablaAlojamientos();
						record.cargarValores(valoresSQL);
					} catch (FileNotFoundException e11) {
						e11.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					} finally {
						if (br != null) {
							try {
								br.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			};
		});

		btnSitios.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String csvFile = "/home/deimon/Programacion/Java/ISFPP-Java/src/gui/resource/CSV/SitiosTuristicos.csv"; //poner relativo

				if (csvFile != null) {					
					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ",";					
					String valoresSQL = "";
					try {

						br = new BufferedReader(new FileReader(csvFile));
						br.readLine(); //quito la primer linea ya que se usa para referenciar en el SCV
						while ((line = br.readLine()) != null) {
							String[] sitios = line.split(cvsSplitBy);
							valoresSQL += "(NULL, '"+sitios[0]+"', b'"+sitios[1]+"', '"+sitios[2]+"'),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma	
						Rec_SitiosTuristicos record = new Rec_SitiosTuristicos();
						// record.vaciarTablaSitiosTuristicos();
						record.cargarValores(valoresSQL);
					} catch (FileNotFoundException e11) {
						e11.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					} finally {
						if (br != null) {
							try {
								br.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			};
		});

		btnTipo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String csvFile = "/home/deimon/Programacion/Java/ISFPP-Java/src/gui/resource/CSV/TipoCaminos.csv"; //poner relativo

				if (csvFile != null) {					
					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ",";					
					String valoresSQL = "";
					try {

						br = new BufferedReader(new FileReader(csvFile));
						//						br.readLine(); //quito la primer linea ya que se usa para referenciar en el SCV
						while ((line = br.readLine()) != null) {
							String[] tipo = line.split(cvsSplitBy);
							valoresSQL += "(NULL, '"+tipo[0]+"'),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma	
						Rec_TipoCamino record = new Rec_TipoCamino();
						// record.vaciarTablaTipoCamino();
						record.cargarValores(valoresSQL);
					} catch (FileNotFoundException e11) {
						e11.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					} finally {
						if (br != null) {
							try {
								br.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			};
		});

		btnEstados.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String csvFile = "/home/deimon/Programacion/Java/ISFPP-Java/src/gui/resource/CSV/EstadoCamino.csv"; //poner relativo

				if (csvFile != null) {					
					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ",";					
					String valoresSQL = "";
					try {

						br = new BufferedReader(new FileReader(csvFile));
						//						br.readLine(); //quito la primer linea ya que se usa para referenciar en el SCV
						while ((line = br.readLine()) != null) {
							String[] estado = line.split(cvsSplitBy);
							valoresSQL += "(NULL, '"+estado[0]+"'),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma	
						Rec_EstadoCamino record = new Rec_EstadoCamino();
						// record.vaciarTablaEstadoCamino();
						record.cargarValores(valoresSQL);
					} catch (FileNotFoundException e11) {
						e11.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					} finally {
						if (br != null) {
							try {
								br.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			};
		});	

		btnTrafico.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String csvFile = "/home/deimon/Programacion/Java/ISFPP-Java/src/gui/resource/CSV/Trafico.csv"; //poner relativo

				if (csvFile != null) {					
					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ",";					
					String valoresSQL = "";
					try {

						br = new BufferedReader(new FileReader(csvFile));
						//						br.readLine(); //quito la primer linea ya que se usa para referenciar en el SCV
						while ((line = br.readLine()) != null) {
							String[] trafico = line.split(cvsSplitBy);
							valoresSQL += "(NULL, '"+trafico[0]+"'),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma	
						Rec_Trafico record = new Rec_Trafico();
						// record.vaciarTablaTrafico();
						record.cargarValores(valoresSQL);
					} catch (FileNotFoundException e11) {
						e11.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					} finally {
						if (br != null) {
							try {
								br.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			};
		});	

		btnTodo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {				
				btnTipo.fire();
				btnEstados.fire();
				btnTrafico.fire();
				btnCiudades.fire();
				btnAlojamientos.fire();
				btnSitios.fire();
				btnCaminos.fire();
			};
		});	


		panel.getStyleClass().add("spacing-medio");
		panel.getChildren().addAll(hbox_titulo,gpAuto);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
