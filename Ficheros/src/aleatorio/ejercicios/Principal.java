package aleatorio.ejercicios;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal {

	
	public static void main(String[] args) {

		ConjuntoDepartamentos universidad = new ConjuntoDepartamentos("src//aleatorio//ejercicios//departamentos.dat");
		
		Departamento dep1 = new Departamento("Informatica", "Zaragoza", 34);
		Departamento dep2 = new Departamento("Electronica", "Huesca", 2);
		Departamento dep3 = new Departamento("Matemáticas", "Huesca", 5);
		Departamento dep4 = new Departamento("Electronica", "Zaragoza", 1);
		Departamento dep5 = new Departamento("Ingles", "Teruel", 4);

		
		try {
			universidad.abrir();
		
			universidad.agnadir(dep1, dep1.getNumDepartamento());
			universidad.agnadir(dep2, dep2.getNumDepartamento());
			universidad.agnadir(dep3, dep3.getNumDepartamento());
			universidad.agnadir(dep4, dep4.getNumDepartamento());
			universidad.agnadir(dep5, dep5.getNumDepartamento());
			
			System.out.println(universidad.leer(dep3.getNumDepartamento()));
			System.out.println(universidad.leer(dep5.getNumDepartamento()));
				
			universidad.cerrar();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada salida");
			e.printStackTrace();
		}
		
	}

}
