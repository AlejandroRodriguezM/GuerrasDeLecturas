package Controladores;

/**
 * Programa que permite el acceso a una base de datos de comics. Mediante JDBC
 * con mySql Las ventanas graficas se realizan con JavaFX. El programa permite:
 * - Conectarse a la base de datos. - Ver la base de datos completa o parcial
 * segun parametros introducidos. - Guardar el contenido de la base de datos en
 * un fichero .txt y .xlsx,CSV - Copia de seguridad de la base de datos en
 * formato .sql - Introducir comics a la base de datos.
 *
 *  Esta clase permite acceder a la ventana de introducir datos a la base de datos.
 *
 *  Version Final
 *
 *  Por Alejandro Rodriguez
 *
 *  Twitter: @silverAlox
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Funcionamiento.BBDD;
import Funcionamiento.Comic;
import Funcionamiento.ConexionBBDD;
import Funcionamiento.Libreria;
import Funcionamiento.NavegacionVentanas;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class IntroducirDatosController {

	@FXML
	private Button botonLimpiarComic;

	@FXML
	private Button botonIntroducir;

	@FXML
	private Button botonMostrarParametro;

	@FXML
	private Button botonSalir;

	@FXML
	private Button botonVolver;

	@FXML
	private Button botonbbdd;

	@FXML
	private TextArea pantallaInformativa;

	@FXML
	private TextField idParametro;

	@FXML
	private TextField nombreParametro;

	@FXML
	private TextField numeroParametro;

	@FXML
	private TextField editorialParametro;

	@FXML
	private TextField formatoParametro;

	@FXML
	private TextField procedenciaParametro;

	@FXML
	private TextField fechaLectura;

	@FXML
	private TextField nombreAni;

	@FXML
	private TextField numeroAni;

	@FXML
	private TextField editorialAni;

	@FXML
	private TextField formatoAni;

	@FXML
	private TextField procedenciaAni;

	@FXML
	private TextField fechaLecturaAni;

	@FXML
	private TextField totalComicsAni;
	
	@FXML
	private TextField retoAni;

	@FXML
	private Label idMod;

	@FXML
	public TableView<Comic> tablaBBDD;

	@FXML
	private TableColumn<Comic, String> ID;

	@FXML
	private TableColumn<Comic, String> nombre;

	@FXML
	private TableColumn<Comic, String> numero;

	@FXML
	private TableColumn<Comic, String> editorial;

	@FXML
	private TableColumn<Comic, String> formato;

	@FXML
	private TableColumn<Comic, String> procedencia;

	@FXML
	private TableColumn<Comic, String> fecha;

	@FXML
	private TableColumn<Comic, String> totalLeido;

	private Connection conn = ConexionBBDD.conexion();

	private NavegacionVentanas nav = new NavegacionVentanas();

	private Libreria libreria = new Libreria();

	private BBDD db = new BBDD();

	/**
	 * Limpia todos los datos de los textField que hay en pantalla
	 * 
	 * @param event
	 */
	@FXML
	void limpiarDatos(ActionEvent event) {

		// Campos de busqueda por parametro
		idParametro.setText("");

		nombreParametro.setText("");

		numeroParametro.setText("");

		editorialParametro.setText("");

		formatoParametro.setText("");

		procedenciaParametro.setText("");

		// Campos de datos a modificar

		nombreAni.setText("");

		numeroAni.setText("");

		nombreAni.setText("");

		editorialAni.setText("");

		formatoAni.setText("");

		procedenciaAni.setText("");

		pantallaInformativa.setText(null);

		pantallaInformativa.setOpacity(0);
	}

	/**
	 * Aniade datos a la base de datos segun los parametros introducidos en los
	 * textField
	 *
	 * @param event
	 */
	@FXML
	public void agregarDatos(ActionEvent event) {

		introducirDatos();
		libreria.ordenarBBDD();
		libreria.reiniciarBBDD();
	}

	/**
	 *
	 */
	public void introducirDatos() {
		ConexionBBDD.loadDriver();

		String sentenciaSQL = "INSERT INTO guerraDeLectura(nomComic, numComic, nomEditorial, formato,procedencia, fechaLectura, totalLeido, reto)"
				+ " values (?,?,?,?,?,?,?,?)";

		String datos[] = camposComicIntroducir();

		try {
			PreparedStatement statement = conn.prepareStatement(sentenciaSQL);

			statement.setString(1, datos[0]);

			statement.setString(2, datos[1]);

			statement.setString(3, datos[2]);

			statement.setString(4, datos[3]);

			statement.setString(5, datos[4]);

			statement.setString(6, datos[5]);

			statement.setString(7, datos[6]);

			statement.setString(8, datos[7]);

			if (statement.executeUpdate() == 1) { // Sie el resultado del executeUpdate es 1, mostrara el mensaje
													// correcto.
				if (nav.alertaInsertar()) {
					pantallaInformativa.setOpacity(1);
					pantallaInformativa.setStyle("-fx-background-color: #A0F52D");
					pantallaInformativa.setText("Comic introducido correctamente!" + "\nNombre del comic: " + datos[0]
							+ "\nNumero: " + datos[1] + "\nEditorial: " + datos[2] + "\nFormato: " + datos[3]
							+ "\nProcedencia: " + datos[4] + "\nFecha de lectura: " + datos[5] + "\nTotal de comics: "
							+ datos[6]);
					statement.close();
				} else { // Si se cancela el borra del comic, saltara el siguiente mensaje.
					pantallaInformativa.setOpacity(1);
					pantallaInformativa.setStyle("-fx-background-color: #F53636");
					pantallaInformativa.setText("Insertado cancelado..");
				}

			} else { // En caso de no haber sido posible Introducir el comic, se vera el siguiente
						// mensaje.
				pantallaInformativa.setOpacity(1);
				pantallaInformativa.setStyle("-fx-background-color: #F53636");
				pantallaInformativa.setText(
						"Se ha encontrado un error. No ha sido posible introducir el comic a la base de datos.");
			}
		} catch (SQLException ex) {
			nav.alertaException(ex.toString());
			ex.printStackTrace();
		}
	}

	/**
	 * Mostrara los comics o comic buscados por parametro
	 * 
	 * @param event
	 */
	@FXML
	void mostrarPorParametro(ActionEvent event) {

		nombreColumnas(); // Llamada a funcion
		listaPorParametro(); // Llamada a funcion
	}

	/**
	 * Muestra toda la base de datos.
	 *
	 * @param event
	 */
	@FXML
	void verTodabbdd(ActionEvent event) {

		nombreColumnas(); // Llamada a funcion
		tablaBBDD(libreriaCompleta()); // Llamada a funcion

	}

	/**
	 * Muestra los comics que coincidan con los parametros introducidos en los
	 * textField
	 * 
	 * @return
	 */
	public void listaPorParametro() {
		String datosComic[] = camposComicActuales();

		Comic comic = new Comic(datosComic[0], datosComic[1], datosComic[2], datosComic[3], datosComic[4],
				datosComic[5], datosComic[6], "", "", "");

		tablaBBDD(busquedaParametro(comic));
	}

	/**
	 * Funcion que busca en el arrayList el o los comics que tengan coincidencia con
	 * los datos introducidos en el TextField
	 * 
	 * @param comic
	 * @return
	 */
	public List<Comic> busquedaParametro(Comic comic) {
		List<Comic> listComic = FXCollections.observableArrayList(libreria.filtadroBBDD(comic));

		if (listComic.size() == 0) {
			pantallaInformativa.setOpacity(1);
			pantallaInformativa.setStyle("-fx-background-color: #F53636");
			pantallaInformativa.setText("ERROR. No hay ningun dato en la base de datos");
		}
		return listComic;
	}

	/**
	 * Muestra todos los comics de la base de datos
	 * 
	 * @return
	 */
	public List<Comic> libreriaCompleta() {
		List<Comic> listComic = FXCollections.observableArrayList(libreria.verLibreria());

		if (listComic.size() == 0) {
			pantallaInformativa.setOpacity(1);
			pantallaInformativa.setStyle("-fx-background-color: #F53636");
			pantallaInformativa.setText("ERROR. No hay ningun dato en la base de datos");
		}

		return listComic;
	}

	/**
	 * Obtiene los datos de los comics de la base de datos y los devuelve en el
	 * textView
	 * 
	 * @param listaComic
	 */
	@SuppressWarnings("unchecked")
	public void tablaBBDD(List<Comic> listaComic) {
		tablaBBDD.getColumns().setAll(ID, nombre, numero, editorial, formato, procedencia, fecha, totalLeido);
		tablaBBDD.getItems().setAll(listaComic);
	}

	/**
	 * Devuelve un array con los datos de los TextField correspondientes a la los
	 * comics que se encuentran en la bbdd
	 * 
	 * @return
	 */
	public String[] camposComicActuales() {
		String campos[] = new String[7];

		campos[0] = idParametro.getText();

		campos[1] = nombreParametro.getText();

		campos[2] = numeroParametro.getText();

		campos[3] = editorialParametro.getText();

		campos[4] = formatoParametro.getText();

		campos[5] = procedenciaParametro.getText();

		campos[6] = fechaLectura.getText();

		return campos;
	}

	/**
	 * Devuelve un array con los datos de los TextField del comic a Introducir
	 * 
	 * @return
	 */
	public String[] camposComicIntroducir() {
		String campos[] = new String[8];

		campos[0] = nombreAni.getText();

		campos[1] = numeroAni.getText();

		campos[2] = editorialAni.getText();

		campos[3] = formatoAni.getText();

		campos[4] = procedenciaAni.getText();

		campos[5] = fechaLecturaAni.getText();

		campos[6] = totalComicsAni.getText();
		
		campos[7] = retoAni.getText();
		
		return comaPorGuion(campos);
	}

	/**
	 * Cambia una ',' por un guion '-'
	 * 
	 * @param campos
	 * @return
	 */
	public String[] comaPorGuion(String[] campos) {
		
		for (int i = 0; i < campos.length; i++) {

			if (campos[i].contains(",")) {
				campos[i] = campos[i].replace(",", "-");
			}
		}
		return campos;
	}

	/**
	 * Permite dar valor a las celdas de la TableView
	 */
	private void nombreColumnas() {
		ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		editorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
		formato.setCellValueFactory(new PropertyValueFactory<>("formato"));
		procedencia.setCellValueFactory(new PropertyValueFactory<>("procedencia"));
		fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		totalLeido.setCellValueFactory(new PropertyValueFactory<>("totalLeido"));
	}

	/**
	 * Permite volver al menu de conexion a la base de datos.
	 *
	 * @param event
	 */
	@FXML
	void volverMenu(ActionEvent event) {

		nav.verMenuPrincipal();

		Stage myStage = (Stage) this.botonVolver.getScene().getWindow();
		myStage.close();
	}

	/**
	 * Permite salir completamente del programa.
	 *
	 * @param event
	 */
	@FXML
	public void salirPrograma(ActionEvent event) {

		if (nav.salirPrograma(event)) {
			Stage myStage = (Stage) this.botonSalir.getScene().getWindow();
			myStage.close();
		}
	}

	/**
	 * Al cerrar la ventana, se cargara la ventana de verBBDD
	 *
	 */
	public void closeWindows() {

		nav.verMenuPrincipal();

		Stage myStage = (Stage) this.botonVolver.getScene().getWindow();
		myStage.close();

	}
}