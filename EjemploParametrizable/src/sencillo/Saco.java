package sencillo;
import java.util.ArrayList;

/**
 * Clase que almacena un saco de cosas
 * 
 * @param <E> el tipo de cosas que va a almacenar este saco
 */
public class Saco <E>{
	
	/** Lugar donde voy a ir guardando las cosas */
	private ArrayList<E> elsaco;

	/**
	 * Creo un saco vacío
	 */
	public Saco() {
		elsaco = new ArrayList<E>();
	}
	
	/**
	 * Creo un saco de cosas, poniendo en primer lugar el elemento
	 * @param elemento
	 */
	public Saco(E elemento) {
		super();
		elsaco = new ArrayList<E>();
		elsaco.add(elemento);
	}


	/**
	 * Obtener la cosa que está almacenada en la posición i
	 * 
	 * @return the elemento
	 */
	public E getElemento(int i) {
		return elsaco.get(i);
	}

	/**
	 * Poner una cosa en el saco en la posición indicada
	 * 
	 * @param elemento the elemento to set
	 */
	public void setElemento(E elemento, int i) {
		elsaco.set(i, elemento);
	}
	
	/**
	 * Poner una cosa al final
	 * 
	 * @param elemento
	 */
	public void setElementoFinal(E elemento) {
		elsaco.add(elemento);
	}

	@Override
	public String toString() {
		return "Saco [elsaco=" + elsaco + "]";
	}
	
	
}
