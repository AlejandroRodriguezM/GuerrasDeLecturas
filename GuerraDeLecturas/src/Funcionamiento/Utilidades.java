package Funcionamiento;

/**
 * Programa que permite el acceso a una base de datos de comics. Mediante JDBC
 * con mySql Las ventanas graficas se realizan con JavaFX. El programa permite:
 * - Conectarse a la base de datos. - Ver la base de datos completa o parcial
 * segun parametros introducidos. - Guardar el contenido de la base de datos en
 * un fichero .txt y .xlsx,CSV - Copia de seguridad de la base de datos en
 * formato .sql - Introducir comics a la base de datos.
 *
 *  Esta clase permite comprobar si el sistema operativo es linux, windows o mac
 *
 *  Version Final
 *
 *  Por Alejandro Rodriguez
 *
 *  Twitter: @silverAlox
 */

import java.util.Locale;

public class Utilidades {

	public static String os = System.getProperty("os.name", "unknown").toLowerCase(Locale.ROOT);

	public static boolean isWindows() {
		return os.contains("win");
	}

	public static boolean isMac() {
		return os.contains("mac");
	}

	public static boolean isUnix() {
		return os.contains("nux");
	}

}
