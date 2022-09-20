package secuencial.ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Escribe un programa en Java que lea el fichero datos.txt y los guarde en otro fichero
 * llamado tarjetas.txt con los datos de los clientes formateados
 * 
 * @author eroyo
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		
		Ejercicio1 ej1 = new Ejercicio1();
		
		//1- Leo línea del fichero
		File mifichero = new File ("src\\secuencial\\ejercicios\\datos.txt");
		try {
			FileReader lector = new FileReader(mifichero);
			BufferedReader cestaTemporal = new BufferedReader(lector);
			
			String lineaLectura = cestaTemporal.readLine();
			while (lineaLectura != null) {
				// tratamiento de la línea
				String campos[] = lineaLectura.split(",");
				String lineaEscritura = ej1.convierteTarjeta1(campos);
				ej1.escribeLinea(lineaEscritura, "src\\secuencial\\ejercicios\\tarjetas.txt");

				//leo la siguinte línea
				lineaLectura = cestaTemporal.readLine();
			}
	
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error al leer en el fichero");
		}
	}

	/**
	 * Escribe la línea equivalente a una tarjeta en el destino
	 * @param lineaEscritura
	 */
	private void escribeLinea(String lineaEscritura, String nombreFichero) {
		//System.out.println(lineaEscritura);
		File mifichero = new File(nombreFichero);

		try {
			FileWriter escritor=new FileWriter(mifichero,true); 
			BufferedWriter cestaEscritura=new BufferedWriter(escritor);
			
			cestaEscritura.newLine();
			cestaEscritura.write(lineaEscritura);
			cestaEscritura.close();  
			escritor.close();

		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("Error al escribir en el fichero");
		}
	}


	/**
	 * Convierte en una línea (con saltos de línea incluidos) los campos
	 * especificados en los campos 
	 * @param campos
	 * @return
	 */
	private String convierteTarjeta1(String[] campos) {
		// TODO Auto-generated method stub
		String salida = "Nombre: " + campos[0] + "\n";
		salida = salida + "Apellidos: " + campos[1]+ "\n";
		salida = salida + "Fecha nacimiento: " + campos[3]+ "\n";
		salida = salida + "Teléfono: " + campos[4]+ "\n";
		
		return salida;
	}
}
