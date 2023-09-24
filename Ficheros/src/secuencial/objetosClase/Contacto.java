package secuencial.objetosClase;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contacto implements Serializable{
	  private String nombre;
	  private String p_Apellido;
	  private transient String s_Apellido; // no lo hace serializable
	  private int edad;
	
	  
	/** Constructor 
	 * @param nombre
	 * @param p_Apellido
	 * @param s_Apellido
	 */
	public Contacto(String nombre, String p_Apellido, String s_Apellido, int edad) {
		super();
		this.nombre = nombre;
		this.p_Apellido = p_Apellido;
		this.s_Apellido = s_Apellido;
		this.edad = edad;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the p_Apellido
	 */
	public String getP_Apellido() {
		return p_Apellido;
	}


	/**
	 * @param p_Apellido the p_Apellido to set
	 */
	public void setP_Apellido(String p_Apellido) {
		this.p_Apellido = p_Apellido;
	}


	/**
	 * @return the s_Apellido
	 */
	public String getS_Apellido() {
		return s_Apellido;
	}


	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}


	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}


	/**
	 * @param s_Apellido the s_Apellido to set
	 */
	public void setS_Apellido(String s_Apellido) {
		this.s_Apellido = s_Apellido;
	}


	@Override
	public String toString() {
		return "Agenda [nombre=" + nombre + ", p_Apellido=" + p_Apellido +
				", s_Apellido=" + s_Apellido + ", edad=" + edad + "]";
	}



}
