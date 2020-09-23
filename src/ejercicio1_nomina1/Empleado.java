package ejercicio1_nomina1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Empleado extends Persona{
	/*ATRIBUTOS*/
	private int categoria;
	public int anyos;
	/*
	 * CONSTRUCTORES:
	 * - TODOS
	 * - Persona, + atributos definidos en 1(categoria) y 0 (anyos)
	 */
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) {
		super(nombre, dni, sexo);
		this.categoria=categoria;
		this.anyos= anyos;
	}
	
	public Empleado(String nombre, String dni, char sexo) {
		super(nombre, dni, sexo);
		this.categoria=1;
		this.anyos= 0;
	}
	/**
	 * GETTER Y SETTER CATEGORIA
	 * @return Modifica el nombre de la categoria
	 */
	public int getCategoria() {
		return categoria;
	}
	//cambios y excepciones
	public void setCategoria(int categoria) throws DatosNoCorrectosException {
		
		if(categoria>=0 && categoria<=10) {
			this.categoria = categoria;
		}else {
			throw new DatosNoCorrectosException("Datos No correctos");
		}
		
	}
	/**
	 * MÉTODO incrAnyo que incrementa en uno el número de años trabajados.
	 * @param anyos es el parametro que necesitas que meta el usuario
	 * @return lo introduce y le suma 1
	 */
	public int increAnyos(int anyos) {
		return anyos+1;
	}
	
	public int getAnyos() {
		return anyos;
	}

	public void setAnyos(int anyos) throws DatosNoCorrectosException {
		if(anyos>=0) {
			this.anyos = anyos;
		}else {
			throw new DatosNoCorrectosException("Datos no correctos");
		}
		
	}

	/**
	 * MÉTODO IMPRIME TODOS LOS DATOS DEL EMPLEADO
	 */
	@Override
	public String toString() {
		return "Empleado [categoria=" + categoria + ", anyos=" + anyos + ", nombre=" + nombre + ", dni=" + dni
				+ ", sexo=" + sexo + "]";
	}
	
	//imprime forma 2
	
	public void imprime(String nombre, String dni, char sexo, int categoria, int anyos) {
		System.out.println("El empleado que se llama:"+nombre+",con dni "+dni+", cuyo sexo es "+sexo+" ,está en la categoría llamada "+categoria+", y lleva "+anyos+" años trabajados en la empresa");
	}
	

	
}
