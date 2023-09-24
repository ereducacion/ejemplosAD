package secuencial.lectura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeoFicheroTextoBuffer {

	/**
	 * @return 
	 * @paramargsthecommand line arguments
	 */
	// Fichero del que queremos leer
	public static void main(String[] args) {		

		File mifichero = new File ("saludo.txt");
		try {
			FileReader lector = new FileReader(mifichero);
			
			// ahora voy a leer utilizando un buffer
			BufferedReader cestaTemporal = new BufferedReader(lector);
			
			String linea = cestaTemporal.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = cestaTemporal.readLine();
			}
			
			cestaTemporal.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
