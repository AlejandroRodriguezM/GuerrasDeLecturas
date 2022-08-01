package Funcionamiento;

/**
 * Programa que permite el acceso a una base de datos de comics. Mediante JDBC
 * con mySql Las ventanas graficas se realizan con JavaFX. El programa permite:
 * - Conectarse a la base de datos. - Ver la base de datos completa o parcial
 * segun parametros introducidos. - Guardar el contenido de la base de datos en
 * un fichero .txt y .xlsx,CSV - Copia de seguridad de la base de datos en
 * formato .sql - Introducir comics a la base de datos.
 *
 * Esta clase permite darle forma a un comic
 *
 * Version Final
 *
 * Por Alejandro Rodriguez
 *
 * Twitter: @silverAlox
 */

public class Comic {

	protected String ID;
	protected String nombre;
	protected String numero;
	protected String editorial;
	protected String formato;
	protected String procedencia;
	protected String fecha;
	protected String totalLeido;
	protected String usuarioTwitter;
	protected String reto;

	// Constructor
	public Comic(String iD, String nombre, String numero, String editorial, String formato, String procedencia,
			String fecha, String totalLeido, String usuarioTwitter, String reto) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.numero = numero;
		this.editorial = editorial;
		this.formato = formato;
		this.procedencia = procedencia;
		this.fecha = fecha;
		this.totalLeido = totalLeido;
		this.usuarioTwitter = usuarioTwitter;
		this.reto = reto;
	}

	// Constructor
	public Comic() {
		this.ID = "";
		this.nombre = "";
		this.numero = "";
		this.editorial = "";
		this.formato = "";
		this.procedencia = "";
		this.fecha = "";
		this.totalLeido = "";
		this.usuarioTwitter = "";
		this.reto = "";
	}

	// Getters y setters

	public String getID() {
		return ID;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNumero() {
		return numero;
	}

	public String getEditorial() {
		return editorial;
	}

	public String getFormato() {
		return formato;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public String getFecha() {
		return fecha;
	}

	public String getTotalLeido() {
		return totalLeido;
	}

	public String getUsuarioTwitter() {
		return usuarioTwitter;
	}

	public String getReto() {
		return reto;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setTotalLeido(String totalLeido) {
		this.totalLeido = totalLeido;
	}

	public void setUsuarioTwitter(String usuarioTwitter) {
		this.usuarioTwitter = usuarioTwitter;
	}

	public void setReto(String reto) {
		this.reto = reto;
	}

	@Override
	public String toString() {
		return "\nNombre: " + nombre + "\nNumero: " + numero + "\nEditorial: " + editorial + "\nFormato: " + formato
				+ "\nProcedencia: " + procedencia + "\nFecha: " + fecha + "\nTotal leido: " + totalLeido;
	}

}
