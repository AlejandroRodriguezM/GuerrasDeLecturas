package Funcionamiento;

/**
 * Programa que permite el acceso a una base de datos de comics. Mediante JDBC
 * con mySql Las ventanas graficas se realizan con JavaFX. El programa permite:
 * - Conectarse a la base de datos. - Ver la base de datos completa o parcial
 * segun parametros introducidos. - Guardar el contenido de la base de datos en
 * un fichero .txt y .xlsx,CSV - Copia de seguridad de la base de datos en
 * formato .sql - Introducir comics a la base de datos.
 *
 * Esta clase permite dar formato a un fichero XLSX y CSV
 *
 * Version Final
 *
 * Por Alejandro Rodriguez
 *
 * Twitter: @silverAlox
 */

public class Excel {

	private String id;
	private String nombre;
	private String numero;
	private String editorial;
	private String formato;
	private String procedencia;
	private String fecha;
	private String nombreTwitter;
	private String reto;

	public Excel(String id, String nombre, String numero, String editorial, String formato, String procedencia,
			String fecha, String nombreTwitter, String reto) {
		this.id = id;
		this.nombre = nombre;
		this.numero = numero;
		this.editorial = editorial;
		this.formato = formato;
		this.procedencia = procedencia;
		this.fecha = fecha;
		this.nombreTwitter = nombreTwitter;
		this.reto = reto;
	}

	public Excel() {
		this.id = "";
		this.nombre = "";
		this.numero = "";
		this.editorial = "";
		this.formato = "";
		this.procedencia = "";
		this.fecha = "";
		this.nombreTwitter = "";
		this.reto = "";
	}

	// Getters y setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombreTwitter() {
		return nombreTwitter;
	}

	public void setNombreTwitter(String nombreTwitter) {
		this.nombreTwitter = nombreTwitter;
	}

	public String getReto() {
		return reto;
	}

	public void setReto(String reto) {
		this.reto = reto;
	}

	@Override
	public String toString() {
		return "\nNombre: " + nombre + "\nNumero: " + numero + "\nEditorial: " + editorial + "\nFormato: " + formato
				+ "\nProcedencia: " + procedencia + "\nFecha: " + fecha;
	}
}