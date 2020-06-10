package Estructuras;
/**
 * Clase Usuario
 * Crea una persona con caracter�sticas para manejar una cuenta
 * @author Samantha Arburola
 *
 */
public class Usuario extends Persona
{
	// Atributos
	/**
	* Contrase�a del usuario
	*/
	private String contrase�a;
	/**
	 * nickname del usuario
	 */
	private String nikname;

	/**
	 * Construcci�n de usuario
	 * @param nombre      : nombre
	 * @param pNickName   : nickname o seud�nimo
	 * @param pContrase�a : contrase�a del usuario
	 */
	public Usuario(String nombre, String pNickName ,String pContrase�a) 
	{
		super(nombre);
		this.setContrase�a(pContrase�a);
		this.setNikname(pNickName);
	}

	/**
	 * Get & Set
	 */
	public String getContrase�a() 
	{
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) 
	{
		this.contrase�a = contrase�a;
	}

	public String getNikname() {
		return nikname;
	}

	public void setNikname(String nikname) {
		this.nikname = nikname;
	}

}
