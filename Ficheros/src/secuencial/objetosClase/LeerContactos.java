package secuencial.objetosClase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerContactos {

	String nombreFichero;
	FileInputStream fis;
	ObjectInputStream ois;

	/**
	 * En este constructor abro ya los streams
	 * 
	 * @param nombreFichero nombre del fichero que va a leer
	 */
	public LeerContactos(String nombreFichero) {
		super();
		this.nombreFichero = nombreFichero;
		
		
	}
	
	/**
	 * Abre y prepara el fichero para leer objetos
	 * @return false si algo sale mal
	 */
	public boolean abreFichero() {
		try {
			fis = new FileInputStream(nombreFichero);
			ois = new ObjectInputStream(fis);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Lee el contacto que le toca
	 * IMPORTANTE, antes ha de haber abierto el fichero para lectura y los streams
	 * @return	contacto el contacto del fichero o null si no hay nada 
	 */
	public Contacto leerContacto() {
		//Ahora lo leemos
		Contacto a1 = null;
		try{
			a1 = (Contacto) ois.readObject();//El método readObject() recupera el objeto
		} catch (java.io.EOFException e) {
			System.out.println("Llegue al final");
		} catch(IOException e){
			  e.printStackTrace();
		}catch(ClassNotFoundException e){
			  e.printStackTrace();
		}
		return a1;
	}
	
	/**
	 * Cierra el fichero que hemos abierto para leer
	 */
	public void cierraLectura() {
	    
		if (ois == null || fis == null) return;
		try {
			ois.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
	/**
	 * @return the nombreFichero
	 */
	public String getNombreFichero() {
		return nombreFichero;
	}

	/**
	 * @param nombreFichero the nombreFichero to set
	 */
	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	
}
