package gui.panels;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import conexion.db.entidades.Caminos;
import conexion.db.entidades.Vertices;
import conexion.db.entidades.Rec_Alojamientos;
import conexion.db.entidades.Rec_EstadoCamino;
import conexion.db.entidades.Rec_SitiosTuristicos;
import conexion.db.entidades.Rec_TipoCamino;
import conexion.db.entidades.Rec_Trafico;
import conexion.db.entidades.TipoVertice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class JFX_SistemaAutomatico {
	VBox panel = new VBox();

	public JFX_SistemaAutomatico() {
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

		Button btnTipoVertices = new Button("Cargar Tipo de Vertices");
		Button btnVertices = new Button("Cargar Vertices");
		Button btnAlojamientos = new Button("Cargar Alojamientos");
		Button btnSitios = new Button("Cargar Sitios Turisticos");
		Button btnTipo = new Button("Cargar Tipo Camino");
		Button btnEstados = new Button("Cargar Estados Camino");
		Button btnTrafico = new Button("Cargar Trafico");
		Button btnCaminos = new Button("Cargar Caminos");
		Button btnTodo = new Button("Cargar Todo");

		gpAuto.add(btnTipoVertices, 0, 0);
		gpAuto.add(btnVertices, 1, 0);		
		
		gpAuto.add(btnAlojamientos, 0, 1);
		gpAuto.add(btnSitios, 1, 1);
		
		gpAuto.add(btnTipo, 0, 2);
		gpAuto.add(btnEstados, 1, 2);
		gpAuto.add(btnTrafico, 2, 2);

		gpAuto.add(btnCaminos, 0, 3);
		
		gpAuto.add(btnTodo, 0, 4);

		btnTipoVertices.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String csvFile = "/home/deimon/Programacion/Java/ISFPP-Java/src/gui/resource/CSV/TipoVertices.csv"; //poner relativo

				if (csvFile != null) {					
					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ",";					
					String valoresSQL = "";
					try {

						br = new BufferedReader(new FileReader(csvFile));
						br.readLine(); //quito la primer linea ya que se usa para referenciar en el SCV
						while ((line = br.readLine()) != null) {
							String[] tipoVertice = line.split(cvsSplitBy);
							valoresSQL += "(NULL, '"+tipoVertice[0]+"', "+tipoVertice[1]+"),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma
						TipoVertice record = new TipoVertice();
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
		
		btnVertices.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String csvFile = "/home/deimon/Programacion/Java/ISFPP-Java/src/gui/resource/CSV/Vertices.csv"; //poner relativo

				if (csvFile != null) {					
					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ",";					
					String valoresSQL = "";
					try {

						br = new BufferedReader(new FileReader(csvFile));
						br.readLine(); //quito la primer linea ya que se usa para referenciar en el SCV
						while ((line = br.readLine()) != null) {
							String[] vertice = line.split(cvsSplitBy);
							valoresSQL += "(NULL, '"+vertice[0]+"', '"+vertice[1]+"', '"+vertice[2]+"', '"+vertice[3]+"', '"+vertice[4]+"', b'"+vertice[5]+"', "+vertice[6]+"),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma
						Vertices record = new Vertices();
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
							valoresSQL += "(NULL, '"+camino[0]+"', '"+camino[1]+"', b'"+camino[2]+"', '"+camino[3]+"', '"+camino[4]+"', '"+camino[5]+"', '"+camino[6]+"', '"+camino[7]+"'),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma
						Caminos record = new Caminos();
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
							valoresSQL += "(NULL, '"+tipo[0]+"','"+tipo[1]+"'),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma	
						Rec_TipoCamino record = new Rec_TipoCamino();
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
							valoresSQL += "(NULL, '"+estado[0]+"','"+estado[1]+"'),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma	
						Rec_EstadoCamino record = new Rec_EstadoCamino();
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
							valoresSQL += "(NULL, '"+trafico[0]+"','"+trafico[1]+"'),";
						}
						valoresSQL = valoresSQL.substring(0, valoresSQL.length() - 1);//quita la ultima coma	
						Rec_Trafico record = new Rec_Trafico();
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
				btnTipoVertices.fire();
				btnVertices.fire();
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
