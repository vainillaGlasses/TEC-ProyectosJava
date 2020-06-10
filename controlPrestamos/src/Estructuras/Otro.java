package Estructuras;

/**
 * Clase Otro
 * Crea un art�culo de cualquier categor�a
 * 
 * @author Samantha Arburola
 */
public class Otro extends Articulo {
	
	// Atributos
		/**
		 * Descripci�n del estado � caracter�sticas del art�culo
		 */
	private String descripcion;

	// M�todos
		/**
		 * Constructor
		 * @param nombre       : nombre el art�culo
		 * @param calificacion : calificaci�n para el art�culo
		 * @param imagen       : imagen para identificar el art�culo
		 * @param descripcion  : Descripci�n del estado � caracter�sticas del art�culo
		 */
	public Otro(String nombre, int calificacion, String imagen,
			String descripcion) {
		super(nombre, calificacion, imagen);
		this.descripcion = descripcion;
	}
	
	/**
	 * Art�culo otro
	 * @param nombre       : nombre el art�culo
	 * @param calificacion : alificaci�n para el art�culo
	 * @param imagen       : imagen para identificar el art�culo
	 */
	public Otro(String nombre, int calificacion, String imagen) {
		super(nombre, calificacion, imagen);
	}
	
	/**
	 * Get &Set
	 */
	public String getDescripcion() 
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
