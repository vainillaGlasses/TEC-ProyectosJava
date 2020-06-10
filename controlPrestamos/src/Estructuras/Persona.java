package Estructuras;

/**
 * Clase Persona
 * Crea una persona 
 * 
 * @author Adrian Soto
 *
 */
public class Persona 
{
	// Atributos
	/**
	* Nombre de la persona
	*/
	private String nombre;
	/**
	 * Primer apellido de la persona
	 */
	private String apellido1;
	/**
	 * Segundo Apellido de la persona
	 */
	private String apellido2;
	/**
	 * N�mero de c�dula de la persona
	 */
	private String cedula;	
	/**
	 * N�mero de tel�fono m�vil/fijo de la persona
	 */
	private String telefono;
	/**
	 * Direcci�n de correo electr�nico
	 */
	private String correoE;
	/**
	 * Categor�a de la persona
	 */
	private int categoria;
	
	// M�todos
	/**
	* Contructor de la persona
	* @param pNombre    : nobmre
	* @param pApellido1 : 1er apellido
	* @param pApellido2 : 2do apellido
	* @param pCedula    :  n�mero de c�dula
	* @param pTelefono  :  n�mero de tel�fono
	* @param pCorreoE   : direcci�n de correo electr�nico
	* @param pCategoria : categor�a de la persona
	*/
	public Persona(String pNombre, String pApellido1, String pApellido2,
			String pCedula, String pTelefono, String pCorreoE, int pCategoria)
	{
		super();
		this.setNombre(pNombre);;
		this.setApellido1(pApellido1);
		this.setApellido2(pApellido2);
		this.setCedula(pCedula);
		this.setTelefono(pTelefono);
		this.setCorreoE(pCorreoE);
		this.setCategoria(pCategoria);
	}

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	/**
	 * Get & Set
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoE() {
		return correoE;
	}

	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}	
}
