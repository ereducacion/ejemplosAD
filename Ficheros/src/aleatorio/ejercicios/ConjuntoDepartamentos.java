package aleatorio.ejercicios;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Clase que gestiona un conjunto de departamentos en un fichero
 * de acceso aleatorio o directo
 * @author Eva Royo
 *
 */
public class ConjuntoDepartamentos {

	private static int TAMAGNONOMBRE = 32; // son los carácteres 32*2 = 64 bytes
	private static int TAMAGNOLOCALIDAD = 20; // son los carácteres 20*2 = 40 bytes
	// para almacenar el número de departamento usamos un entero = 4 bytes
	private static int TAMAGNOREGISTO = TAMAGNONOMBRE*4 + TAMAGNOLOCALIDAD*4 + 4; // son los bytes 64 + 40 + 4(int)
	
	private String nombreFichero = "departamentos.dat";
	private RandomAccessFile fichero ;

	/* ***** CONSTRUCTORES *****/
	/**
	 * Constructor
	 * @param nombreFichero	Nombre del fichero que contendrá los departamentos
	 */
	public ConjuntoDepartamentos(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	/* *************************/
	

	/**
	 * Devuelve el nombre del fichero con el que estamos a trabajando
	 * @return the nombreFichero
	 */
	public String getNombreFichero() {
		return nombreFichero;
	}


	/**
	 * Cambia el nombre del fichero con el que estamos trabajando, así que
	 * TIENE QUE CERRAR EL FICHERO QUE TENÍA ACTIVO ANTERIORMENTE
	 * @param nombreFichero the nombreFichero to set
	 */
	public void setNombreFichero(String nombreFichero) {
		if (fichero != null)
			try {
				fichero.close();
			} catch (IOException e) {
				System.err.println("Error cuando cierro el fichero anterior, al cambiar de fichero");
				e.printStackTrace();
			}
		this.nombreFichero = nombreFichero;
	}


	/**
	 * Añade un departamente en la posición indicada
	 * @param dep	El departamento que va a incluir en la posicion pos
	 * @param pos	La posición dentro del fichero
	 * @throws IOException	Excepción producida al intentar escribir en el fichero
	 */
	public void agnadir(Departamento dep, int pos) throws IOException {
		
		// comprobaciones de error
		if (fichero != null) {
			// posicionar el cursor en el lugar adecuado
			fichero.seek(calculaPosicion(pos));
			
			// PARA ESCRIBIR UNA CADENA
			// primero escribo las cosas en un buffer
			StringBuffer bufferNombre= new StringBuffer();
			if (dep.getNombre() != null ) {
				bufferNombre.append(dep.getNombre());
			}
			bufferNombre.setLength(TAMAGNONOMBRE); // fijo un tamaño al buffer, para que todos los nombres tengan el mismo tamaño
			
			StringBuffer bufferLocalidad= new StringBuffer();
			if (dep.getLocalidad() != null ) {
				bufferLocalidad.append(dep.getLocalidad());
			}
			bufferLocalidad.setLength(TAMAGNOLOCALIDAD);

			// escribir el identificador
			fichero.writeInt(dep.getNumDepartamento());
			// escribir el nombre
			fichero.writeChars(bufferNombre.toString());
			// escribir el localidad
			fichero.writeChars(bufferLocalidad.toString());
		}

		
	}

	/**
	 * Lee el departamento que está en la posición indicada
	 * @param pos Posición en la que se encuentra el departamento que quiere leerse
	 * @return	El departamento leido o @NULL si el fichero no está abierto
	 * @throws IOException	Si se podruce algún error de entrada/salida al leer
	 */
	public Departamento leer(int pos) throws IOException {
			
		Departamento dep = null;
		
		if (fichero != null) {
			dep = new Departamento();
			
			// situar el cursor donde quiero leer
			fichero.seek(calculaPosicion(pos));
			
			try {
				// ya sé que el departamento tiene 3 campos y SU ORDEN
				
				// leer el identificador (numDepartamento)
				int numDepartamento = fichero.readInt();
						
				// leo carácter a carácter el nombre
				char campoNombre[] = new char[TAMAGNONOMBRE];
				for (int i = 0; i < TAMAGNONOMBRE; i++) {
					campoNombre[i] = fichero.readChar();
				}			
				
				// leo carácter a carácter la localidad
				char campoLocalidad[] = new char[TAMAGNOLOCALIDAD];
				for (int i = 0; i < TAMAGNOLOCALIDAD; i++) {
					campoLocalidad[i] = fichero.readChar();
				}			
				
				dep.setNumDepartamento(numDepartamento);		
				dep.setNombre(new String(campoNombre));
				dep.setLocalidad(new String(campoLocalidad));				
				
			} catch (EOFException e) {
				// entrará aquí cuando haya llegado al final del fichero
				dep = null;
			}
		}
				
		return dep;
	}

	/**
	 * Abrir el fichero con los contactos para leer y escribir
	 * @throws FileNotFoundException	Lanza la excepción al intentar abrir en lectura/escritura
	 */
	public void abrir() throws FileNotFoundException {
		fichero = new RandomAccessFile(nombreFichero, "rw");
	}
	
	/**
	 * Cerrar el fichero de los contactos
	 * @throws IOException	Lanza excepción al intentar cerrar el fichero
	 */
	public void cerrar() throws IOException {
		if (fichero != null) {
			fichero.close();
		}
	}
	
	/**
	 * Calcula el byte en el que tiene que situarse según la posición deseada
	 * @param pos Posición dentro del fichero
	 * @return El byte en el que ha de situarse el fichero
	 */
	public int calculaPosicion(int pos) {
		return (pos-1)*TAMAGNOREGISTO;
	}

}
