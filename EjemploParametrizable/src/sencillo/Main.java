package sencillo;

public class Main {

	public static void main(String[] args) {
		
		Saco<String> sacoCadenas = new Saco<String>();
		sacoCadenas.setElementoFinal("Pepito Pulgarcito");
		sacoCadenas.setElementoFinal("El lobo feroz");
		sacoCadenas.setElementoFinal("Blancanieves");
		
		Libro l1 = new Libro(11, "Blancanieves", "anónimo", 
				"Anaya", 2012, "BLN324", 3, 21);
		Saco<Libro> sacoLibros = new Saco<Libro>();
		sacoLibros.setElementoFinal(l1);

		System.out.println("Elemento primero del saco de cadenas= " + sacoCadenas.getElemento(0));
		System.out.println("Elemento primero del saco de libros= " + sacoLibros.getElemento(0));
	}
}
