package secuencial.objetos;

import java.io.*;

public class TestAgenda {
	

	public static void main(String[] args){
		
		String nombreFichero = "src//secuencial//objetos//agenda.dat";
		
		Agenda a1 = new Agenda("Ana", "Mart�nez", "Fern�ndez");
		Agenda a2 = new Agenda("Ernesto", "Garc�a", "P�rez");
		try{
			FileOutputStream fs = new FileOutputStream(nombreFichero);//Creamos el archivo
			ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el m�todo writeObject() que necesitamos
			os.writeObject(a1);//El m�todo writeObject() serializa el objeto y lo escribe en el archivo
			os.writeObject(a2);
			os.close();//Hay que cerrar siempre el archivo
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

		/*
		//Ahora lo leemos
		try{
			  FileInputStream fis = new FileInputStream(nombreFichero);
			  ObjectInputStream ois = new ObjectInputStream(fis);
			  a1 = (Agenda) ois.readObject();//El m�todo readObject() recupera el objeto
			  System.out.println(a1);
			  a2 = (Agenda) ois.readObject();//El m�todo readObject() recupera el objeto
			  System.out.println(a2);
			  ois.close(); 
			  fis.close();
			}catch(FileNotFoundException e){
			  e.printStackTrace();
			}catch(IOException e){
			  e.printStackTrace();
			}catch(ClassNotFoundException e){
			  e.printStackTrace();
			}
		*/
	}
	
}
