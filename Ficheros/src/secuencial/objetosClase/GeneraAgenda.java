package secuencial.objetosClase;

import java.io.*;

public class GeneraAgenda {
	

	public static void main(String[] args){
		
		String nombreFichero = "src//secuencial//objetos//agenda.dat";
		
		Contacto a1 = new Contacto("Ana", "Martínez", "Fernández", 23);
		Contacto a2 = new Contacto("Ernesto", "García", "Pérez",21);
		try{
			FileOutputStream fs = new FileOutputStream(nombreFichero);//Creamos el archivo
			ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
			os.writeObject((Contacto)a1);//El método writeObject() serializa el objeto y lo escribe en el archivo
			os.writeObject((Contacto)a2);
			os.close();//Hay que cerrar siempre el archivo
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

		LeerContactos lc = new LeerContactos(nombreFichero);
		if (lc.abreFichero()) {
			Contacto c = lc.leerContacto();
			while (c != null) {
				System.out.println(c);
				c = lc.leerContacto();
			}
			lc.cierraLectura();
		} else {
			System.out.println("No se ha podido abrir el fichero");
		}
		
	}
	
}
