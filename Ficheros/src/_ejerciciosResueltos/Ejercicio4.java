package _ejerciciosResueltos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio4 {

	/**
	 * Escribe un programa Java que pida una serie de frases por teclado hasta que se inserte como
frase la palabra “fin”. Dichas frases deberán guardarse en un fichero de texto. A continuación,
el programa visualizará el contenido del fichero, frase por frase. Cada vez que se ejecute el
programa, se tienen que descartar las frases que ya estaban escritas en el fichero. Realiza este
ejercicio sin usar la clase BufferedReader

	 * @param args
	 */
	public static void main(String[] args) {
		
		Ejercicio4 ej4 = new Ejercicio4();
		
		File mifichero = new File ("tmp.txt");
		if (!mifichero.exists()) {
			// si no existe el fichero, lo creo
			ej4.escribir(mifichero, "");
		}
		Scanner sc = new Scanner(System.in);
		
		// leyendo de teclado hasta encontrar la palabra "fin"
		System.out.println("Introduce frases hasta la linea \"fin\"");
		String frase = sc.nextLine();
		while (!frase.equals("fin")) {
			// comprobar que la frase no está ya en el fichero
			if (!ej4.enFichero2(mifichero, frase)) {
				// escribir la frase
				ej4.escribir(mifichero, frase);
			} else {
				System.out.println("La frase ya está en el fichero");
			}		
			frase = sc.nextLine();
		}

		// mostrando el contenido del fichero
		ej4.leerFichero(mifichero);
	}

	/**
	 * Escribe en el fichero que se pasa por parámetro la frase
	 * @param mifichero
	 * @param frase
	 */
	private void escribir(File mifichero, String frase) {
		FileWriter escritor;
		try {
			escritor = new FileWriter(mifichero, true);
			escritor.write(frase + "\n");
			escritor.flush();
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Comprueba si la frase que se pasa como parámetro está dentro del fichero
	 * ESTA FUNCIÓN UTILIZA BUFFERREADER
	 * 
	 * @param mifichero	Fichero donde buscará
	 * @param frase	Frase que ha de buscar dentro del fichero
	 * @return
	 */
	private boolean enFichero(File mifichero, String frase) {
		FileReader lector;
		try {
			lector = new FileReader(mifichero);
		// ahora voy a leer utilizando un buffer
			BufferedReader cestaTemporal = new BufferedReader(lector);
			
			String linea = cestaTemporal.readLine();
			while (linea != null) {
				if (linea.equals(frase)) return true;
				linea = cestaTemporal.readLine();
			}			
			cestaTemporal.close();
			lector.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * Comprueba si la frase que se pasa como parámetro está dentro del fichero
	 * ESTA FUNCIÓN NO UTILIZA BUFFERREADER
	 * 
	 * @param mifichero	Fichero donde buscará
	 * @param frase	Frase que ha de buscar dentro del fichero
	 * @return
	 */
	private boolean enFichero2(File mifichero, String frase) {
		FileReader lector;
		try {
			lector = new FileReader(mifichero);
			String linea = leerLinea(lector);
			while (linea != null) {
				if (linea.equals(frase)) return true;
				linea =  leerLinea(lector);
			}			
			lector.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Lee los bytes hasta que encuentra fin de línea, a partir de la posición donde
	 * se ha quedado el cursor.
	 * 
	 * @param lector
	 * @return  La linea leida, null en caso de llegar al fin de fichero
	 * @throws IOException
	 */
	private String leerLinea(FileReader lector) throws IOException {
		int caracter = lector.read();
		// si ha llegado al fin del fichero devuelve null
		if (caracter < 0 ) return null;
		String cadena = "";
		while (caracter != '\n') {
			cadena = cadena + (char)caracter;
			caracter = lector.read();
		}
		//System.out.println(cadena);
		return cadena;
	}

	/**
	 * Lee byte a byte un fichero de texto y lo muestra por pantalla
	 * @param mifichero
	 * @throws IOException 
	 */
	
	private void leerFichero(File mifichero) {
		FileReader lector;
		try {
			lector = new FileReader(mifichero);
			int caracter = lector.read();
			while (caracter > 0) {
				System.out.print((char)caracter);
				caracter = lector.read();
			}
			lector.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
