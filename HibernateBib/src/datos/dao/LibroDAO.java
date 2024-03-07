package datos.dao;

import datos.Libro;

public interface LibroDAO {

	void insertar(Libro l);
	Libro leer(int id);
	void modificar(int id, Libro l2);
	void eliminar(int id);
}
