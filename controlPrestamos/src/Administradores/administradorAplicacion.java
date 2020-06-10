package Administradores;
// Importar Librer�as y Classes
import java.util.ArrayList;

import Estructuras.Articulo;
import Estructuras.Libro;
import Estructuras.Otro;
import Estructuras.Pelicula;
import Estructuras.Persona;
import Estructuras.Prestamo;
import Estructuras.Usuario;
import Interfaces.IConstantes;

/**
 * Clase Administrador de Aplicaci�n
 * Administra el programa 
 * @author Adrian Soto
 *
 */
public class administradorAplicacion implements IConstantes
{
	// Atributos
	/**
	 *  Crea una instancia de administradorAplicaci�n
	 */
	private static administradorAplicacion miAdministrador;
	/**
	 * Crea un administrador de consultas
	 */
	private administradorConsulta miAdministradorConsultas = new administradorConsulta();
	/**
	 * Crea una lista de personas
	 */
	private ArrayList<ArrayList<Persona>> miListaPersonas = new ArrayList<ArrayList<Persona>>();
	/**
	 * Crea una instancia de un Administrador de archivos
	 */
	private administradorArchivos miAdministradorArchivos = new administradorArchivos();
	/**
	 * Crea  lista de categor�as
	 */
	private ArrayList<String> tiposCategorias = new ArrayList<String>();
	/**
	 * Crea  lista de tipos de categor�as
	 */
	private ArrayList<ArrayList<Articulo>> miListaCategorias = new ArrayList<ArrayList<Articulo>>();
	/**
	 * Crea una lista de prestamos
	 */
	private ArrayList<ArrayList<Prestamo>> miListaPrestamos = new ArrayList<ArrayList<Prestamo>>();
	
	private administradorCorreos miAdministradorCorreos = new administradorCorreos();
	/**
	 * Crea una instancia de usuario
	 */
	private Usuario usuario;
	/**
	 * Declarar los d�as de prestamo
	 */
	private int diasPrestamo = 20;
	/**
	 * Declarar los d�as de tolerancia de prestamo
	 */
	private int diasTolerancia = 5;
	
	// M�todos
	/**
	 * Gets & Sets
	 * @return  Lista de Prestamos actuales
	 */
	public ArrayList<ArrayList<Prestamo>> getMiListaPrestamos() {
		return miListaPrestamos;
	}

	public void setMiListaPrestamos(ArrayList<ArrayList<Prestamo>> miListaPrestamos) {
		this.miListaPrestamos = miListaPrestamos;
	}

	/**
	 * Constructor
	 */
	private administradorAplicacion()
	{
		tiposCategorias.add("Libro");
		tiposCategorias.add("Revista");
		tiposCategorias.add("Pelicula");
		for(int i = 0;i < tiposCategorias.size(); i++)
		{
			miListaCategorias.add(new ArrayList<Articulo>());
			miListaPrestamos.add(new ArrayList<Prestamo>());
		}
		for(int j = 0;j < cantCategoriasPersona; j++)
		{
			miListaPersonas.add(new ArrayList<Persona>());
		}
	}
	
	/**
	 * Instancia del administrador
	 * @return el admnistrador
	 */
	public static administradorAplicacion getInstance()
	{
		if(miAdministrador == null)
		{
			miAdministrador = new administradorAplicacion();
		}
		return miAdministrador;
	}
	/**
	 * Imprimir la lista de categor�as actuales
	 */
	public void imprimirListaCategorias()
	{
		int i,j;
		for(i=0;i<miListaCategorias.size();i++)
		{
			System.out.println("Categoria: "+tiposCategorias.get(i));
			for(j=0;j<miListaCategorias.get(i).size();j++)
			{
				System.out.println(miListaCategorias.get(i).get(j).getNombre());
			}
		}
	}
	/**
	 * Imprime la lista de personas registradas
	 */
	public void imprimirListaPersona()
	{
		int i,j;
		for(i=0;i<miListaPersonas.size();i++)
		{
			System.out.println("Indice: "+ i);
			for(j=0;j<miListaPersonas.get(i).size();j++)
			{
				System.out.println(miListaPersonas.get(i).get(j).getNombre());
			}
		}
		System.out.println("///////////////////////////////////////////////////");
	}
	/**
	 * Imprime la lista de objetos prestados
	 */
	public void imprimirListaPrestamos()
	{
		int i,j;
		for(i=0;i<miListaPrestamos.size();i++)
		{
			System.out.println("Categoria: "+tiposCategorias.get(i));
			for(j=0;j<miListaPrestamos.get(i).size();j++)
			{
				System.out.println("Fecha: "   +miListaPrestamos.get(i).get(j).getMiFecha().toString());
				System.out.println("Persona: " +miListaPrestamos.get(i).get(j).getMiPersona().getNombre());
				System.out.println("Articulo: "+miListaPrestamos.get(i).get(j).getMiArticulo().getNombre());
			}
		}
		//System.out.println("///////////////////////////////////////////////////");
	}
	
	/**
	 * Cargar Archivo .txt con datos de personas
	 * @param pPath
	 */
	public void cargarPersonas(String pPath)
	{
		miAdministradorArchivos.leerArchivoPersona(pPath);
	}
	
	/**
	 * Agregar personas al registro; futuros deudores en raz�n de los art�culos
	 * @param pNombre    : nombre del deudor
	 * @param pApellido1 : primer apellido 
	 * @param pApellido2 : segundo apellidos
	 * @param pCedula    : n�mero de c�dula
	 * @param pTelefono  : n�mero de tel�fono; m�vil o fijo
	 * @param pCorreoE   : direcci�n de correo electr�nico
	 * @param pCategoria : categor�a de la persona
	 */
	public void agregarPersona(String pNombre, String pApellido1, String pApellido2,
			String pCedula, String pTelefono, String pCorreoE, int pCategoria)
	{
		miListaPersonas.get(pCategoria).add(new Persona(pNombre, pApellido1, pApellido2, pCedula, pTelefono, pCorreoE, pCategoria));
		imprimirListaPersona();
		
	}
	
	/**
	 * Agrega un prestamos a la lista de prestamos
	 * @param pCategoria : categor�a de la persona
	 * @param pPrestamo  : art�culo prestado
	 */
	public void agregarPrestamo(int pCategoria,Prestamo pPrestamo)
	{
		miListaPrestamos.get(pCategoria).add(pPrestamo);
		imprimirListaPrestamos();
	}
	
	/**
	 * Cargar libros desde archivo .txt
	 * @param pPath : direcci�n en el sistema del archivo
	 */
	public void cargarLibros(String pPath)
	{
		miAdministradorArchivos.leerArchivoLibro(pPath,miListaCategorias.get(categoriaLibro));
		imprimirListaCategorias();
		//System.out.println(miListaCategorias.getCategorias().get(categoriaLibro).getnombreCategoria());
		//miListaCategorias.getCategorias().get(categoriaLibro).getArticulos().imprimir();
	}
	
	/**
	 * Cargar revistas desde archivo .txt
	 * @param pPath : direcci�n en el sistema del archivo
	 */
	public void cargarRevistas(String pPath)
	{
		miAdministradorArchivos.leerArchivoLibro(pPath,miListaCategorias.get(categoriaRevista));
		imprimirListaCategorias();
		//System.out.println(miListaCategorias.getCategorias().get(categoriaRevista).getnombreCategoria());
		//miListaCategorias.getCategorias().get(categoriaRevista).getArticulos().imprimir();
	}
	
	/**
	 * Cargar pel�culas desde archivo .txt
	 * @param pPath : direcci�n en el sistema del archivo
	 */
	public void cargarPeliculas(String pPath)
	{
		miAdministradorArchivos.leerArchivoPelicula(pPath,miListaCategorias.get(categoriaPelicula));
		imprimirListaCategorias();
		//System.out.println(miListaCategorias.getCategorias().get(categoriaPelicula).getnombreCategoria());
		//miListaCategorias.getCategorias().get(categoriaPelicula).getArticulos().imprimir();
	}
	
	/**
	 * Agregar una categor�a a la lista de categor�as de los art�culos
	 * @param pCategoria
	 */
	public void agregarCategoria(String pCategoria)
	{
		tiposCategorias.add(pCategoria);
		miListaCategorias.add(new ArrayList<Articulo>());
		miListaPrestamos.add(new ArrayList<Prestamo>());
		//miListaCategorias.agregarCategoria(new Categoria(pCategoria));
	} 
	
	/**
	 *  Agregar un libro al registro
	 * @param pTitulo       : t�tulo del libro
	 * @param pAutor        : autor
	 * @param pEditorial    : editorial
	 * @param pEdicion      : edici�n del libro (a�o)
	 * @param pCalificacion : calificaci�n dada por el usuario
	 * @param pImagen       : imagen para identificar el libro
	 */
	public void agregarLibro(String pTitulo ,String pAutor, String pEditorial, 
							 String pEdicion,int pCalificacion, String pImagen)
	{
		Libro nuevoLibro = new Libro(pTitulo ,pAutor, pEditorial, pEdicion, pCalificacion, pImagen);
		miListaCategorias.get(categoriaLibro).add(nuevoLibro);
	}
	
	/**
	 * Agregar una revista al registro
	 * @param pTitulo       : t�tulo de la revista
	 * @param pAutor        : autor
	 * @param pEditorial    : editorial
	 * @param pEdicion      : n�mero de edici�n
	 * @param pCalificacion : calificaci�n dada por el usuario
	 * @param pImagen       : imagen para identificar la revista
	 */
	public void agregarRevista(String pTitulo ,String pAutor, String pEditorial, 
			 				   String pEdicion,int pCalificacion, String pImagen)
	{
		Libro nuevaRevista = new Libro(pTitulo ,pAutor, pEditorial, pEdicion, pCalificacion, pImagen);
		miListaCategorias.get(categoriaRevista).add(nuevaRevista);
	}
	
	/**
	 * Agregar una pel�cula al registro
	 * @param pNombre      : nombre 
	 * @param pCalificacion: calificaci�n dada por el usuario
	 * @param pImagen      : imagen para identificar la pel�cula
	 * @param pDirector    : director de la pel�cula
	 * @param pCategoria   : g�nero de la pel�cula
	 */
	public void agregarPelicula(String pNombre, int pCalificacion, String pImagen,
			String pDirector, String pCategoria)
	{
		Pelicula nuevaPelicula = new Pelicula(pNombre, pCalificacion, pImagen, pDirector, pCategoria);
		miListaCategorias.get(categoriaPelicula).add(nuevaPelicula);
	}
	
	/**
	 * Agregar un art�culo cualquiera
	 * @param pNombre         : nombre
	 * @param pCalificacion   : calificaci�n dada por el usuario
	 * @param pIimagen        : imagen para identificar la pel�cula
	 * @param pDescripcion    : descripci�n del estado y caracter�sticas del objeto
	 * @param pIndiceCategoria: �ndice de la nueva categor�a
	 */
	public void agregarOtro(String pNombre, int pCalificacion, String pIimagen,
							String pDescripcion, int pIndiceCategoria)
	{
		Otro nuevoArticulo = new Otro(pNombre, pCalificacion, pIimagen, pDescripcion);
		miListaCategorias.get(pIndiceCategoria).add(nuevoArticulo);
	}
	
	/**
	 * Validar si el usuario existe y si son correctos los datos
	 * @param pNickName   : seud�nimo del usuario
	 * @param pContrase�a : contrase�a de usuario
	 * @return True  : Si es correcta la validaci�n
	 * 		   False : Cuando no coincide la contrase�a y nickname o no existe el usuario
	 */
	public boolean validarUsuario(String pNickName ,String pContrase�a)
	{
		boolean esUsuario = false;
		if(usuario.getNikname().compareTo(pNickName) == 0 && usuario.getContrase�a().compareTo(pContrase�a) == 0)
		{
			esUsuario = true;
		}
		return esUsuario;
	}
	
	/**
	 * Lista de personas del registro
	 * @return lista con personas
	 */
	public ArrayList<ArrayList<Persona>> getPersonas()
	{
		return miListaPersonas;
	}
	
	/**
	 * Ingresa uns lista de personas al registro
	 * @param pMiListaPersonas
	 */
	public void setPersonas(ArrayList<ArrayList<Persona>> pMiListaPersonas) 
	{
		miListaPersonas = pMiListaPersonas;
	}
	
	/**
	 * Acceder al administrador de archivos
	 * @return una instancia del administrador de archivos
	 */
	public administradorArchivos getMiAdministradorArchivos() {
		return miAdministradorArchivos;
	}
	
	/**
	 * Acceder al administrador de archivos 
	 * @param miAdministradorArchivos : extrae datos de un archivo .txt
	 */
	public void setMiAdministradorArchivos(administradorArchivos miAdministradorArchivos) {
		this.miAdministradorArchivos = miAdministradorArchivos;
	}
	
	/**
	 * Get de la lista de categor�as
	 * @return una lista de categor�as
	 */
	public ArrayList<ArrayList<Articulo>> getMiListaCategorias() {
		return miListaCategorias;
	}
	
	/**
	 * Set lista de categor�as
	 * @param miListaCategorias : recibe una lista de categor�as
	 */
	public void setMiListaCategorias(ArrayList<ArrayList<Articulo>> miListaCategorias) {
		this.miListaCategorias = miListaCategorias;
	}

	/**
	 * Get usuario
	 * @return retorna un usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * Set usuario
	 * @param usuario : se ingresa un usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Get  tipos de categor�a 
	 * @return una lista con  tipos de categor�a
	 */
	public ArrayList<String> getTiposCategorias() {
		return tiposCategorias;
	}
	
	/**
	 * Set tipos de categor�as
	 * @param tiposCategorias : ingresa una lista con tipos de categor�a
	 */
	public void setTiposCategorias(ArrayList<String> tiposCategorias) {
		this.tiposCategorias = tiposCategorias;
	}
	
	/**
	 * Get & Set  MiAdministradorConsultas
	 */
	public administradorConsulta getMiAdministradorConsultas() {
		return miAdministradorConsultas;
	}

	public void setMiAdministradorConsultas(administradorConsulta miAdministradorConsultas) {
		this.miAdministradorConsultas = miAdministradorConsultas;
	}
	
	/**
	 * Get & Set  DiasPrestamo
	 */
	public int getDiasPrestamo() {
		return diasPrestamo;
	}

	public void setDiasPrestamo(int diasPrestamo) {
		this.diasPrestamo = diasPrestamo;
	}
	
	/**
	 * Get & Set DiasTolerancia
	 */
	public int getDiasTolerancia() {
		return diasTolerancia;
	}

	public void setDiasTolerancia(int diasTolerancia) {
		this.diasTolerancia = diasTolerancia;
	}
	
	/**
	 * Get & Set tMiAdministradorCorreos
	 * @return
	 */
	public administradorCorreos getMiAdministradorCorreos() {
		return miAdministradorCorreos;
	}

	public void setMiAdministradorCorreos(administradorCorreos miAdministradorCorreos) {
		this.miAdministradorCorreos = miAdministradorCorreos;
	}

}
