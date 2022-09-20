package aleatorio.ejercicios;

/**
 * Clase que representa la información necesario para cada departamento
 * Representa un registro para introducir en el fichero aleatorio
 * @author Eva Royo
 *
 */
public class Departamento {

	private String nombre;
	private String localidad;
	private int numDepartamento;
	
	
	@Override
	public String toString() {
		return "Departamento [nombre=" + nombre + ", localidad=" + localidad + ", numDepartamento=" + numDepartamento
				+ "]";
	}

	/**
	 * Constructor vacío
	 */
	public Departamento() {
		super();
	}

	/**
	 * Constructor de departamento con sus campos
	 * @param nombre Nombre del departamento
	 * @param localidad Localidad del departamento
	 * @param numDepartamento	Número identificativo del departamento
	 */
	public Departamento(String nombre, String localidad, int numDepartamento) {
		super();
		this.nombre = nombre;
		this.localidad = localidad;
		this.numDepartamento = numDepartamento;
	}
	
	/**
	 * @return El nombre del departamento
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre Nombre a asignar al departamento
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return La localidad donde está el departamento
	 */
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * @param localidad La localidad a actualizar
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	/**
	 * @return El número de departamento
	 */
	public int getNumDepartamento() {
		return numDepartamento;
	}
	/**
	 * @param numDepartamento El número de departamento a asginar
	 */
	public void setNumDepartamento(int numDepartamento) {
		this.numDepartamento = numDepartamento;
	}
	
}
