package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

import datos.Libro;
import datos.Prestamo;
import datos.dao.imp.LibroImpHibernate;

public class MainUsaDao {

	public static void main(String[] args) throws IOException {

		// insertar un libro nuevo-----------------------------
		HashSet<Prestamo> losprestamos = new HashSet<Prestamo>();
		Libro elibro = new Libro(152, "Uno", "AutorUno", "Ed Uno", new Integer(1111),
				"ISBN1",new Integer(1), new Integer(111), null);
		
		LibroImpHibernate trabajaconlibro = new LibroImpHibernate();
		trabajaconlibro.insertar(elibro);
		
		// para que pueda ver la información en la base de datos
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
		dataIn.readLine();

		
		// modificar ese libro-----------------------------
		Libro l2 = new Libro();
		l2.setAutor("DOS");
		trabajaconlibro.modificar(152, l2);
		
		// para que pueda ver la información en la base de datos
		dataIn.readLine();
		
		// eliminando ese libro nuevo
		trabajaconlibro.eliminar(152);
	}

}
