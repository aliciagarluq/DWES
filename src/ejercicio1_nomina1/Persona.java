/**
 * 
 */
package ejercicio1_nomina1;

/**
 * @author Alicia
 *	@version 21/09
 */
public class Persona {
	/*ATRIBUTOS*/
	public String nombre;
	public String dni;
	public char sexo;
	
	/*
	 * CONSTRUCTORES:
	 * - SEXO Y NOMBRE
	 * - TODOS LOS ATRIBUTOS
	 */
	public Persona (String nombre, char sexo) {
		this.nombre= nombre;
		this.sexo =sexo;
	}
	
	public Persona (String nombre,String dni, char sexo) {
		this.nombre= nombre;
		this.dni = dni;
		this.sexo =sexo;
	}

	/**
	 * MÉTODOS PÚBLICOS
	 * -------
	 * 1. setDni para modificar el valor del dni de una persona.
	 * @return parámetros a modificar
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	/*--------
	 * 2. MÉTODO PUBLICO PARA IMPRIMIR NOMBRE Y DNI*/
	@Override
	public String toString() {
		return "Esta persona se llama " + nombre + ", y tiene como dni el " + dni ;
	}
	
}
