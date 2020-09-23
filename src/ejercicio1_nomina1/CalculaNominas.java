package ejercicio1_nomina1;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculaNominas {

	public static void main(String[] args) throws DatosNoCorrectosException {
	
	Empleado empleado1=new Empleado("James Cosling","32000032G",'M',4,7);
	Empleado empleado2=new Empleado("Ada Lovelace", "32000031R", 'F');
	//LLAMADA AL MÉTODO escribe por primera vez
	System.out.println("DATOS DEL EMPLEADO 1 Y 2, SIN MODIFICAR");
	System.out.println();
	escribe(empleado1,empleado2);
	System.out.println();
	System.out.println("*=-------------------------------------------=*");
	System.out.println();
	/*MODIFICAR AÑOS TRABAJADOS DEL EMPLEADO 2*/
	empleado2.setAnyos(empleado2.increAnyos(empleado2.getAnyos()));
	
	//MODIFICAR CATEGORIA DEL EMPLEADO 1 A: 9
	empleado1.setCategoria(9);
	//LLAMADA A METODO CONTROL EXCEPCIONES DNI
	
	System.out.println("PRUEBAS CONTROL EXCEPCIONES EN EMPLEADO 2");
	System.out.println("*****--1. DNI--*****");
	controlDNI(empleado2);
	System.out.println("*****--2.CATEGORIA--*****");
	//controlCategoria(empleado2);
	System.out.println("*=-------------------------------------------=*");
	
	//LLAMADA AL MÉTODO escribe por segunda vez
	System.out.println("DATOS DEL EMPLEADO 1 Y 2 TRAS MODIFICAR AÑOS Y CATEGORÍA, y probar el control excepciones DNI");
	System.out.println();
	escribe(empleado1,empleado2);
	}

	private static void escribe(Empleado empleado1,Empleado empleado2) {
		//sueldo = sueldoBase + 5000*años trabajados
		System.out.println("EMPLEADO 1");
		empleado1.imprime(empleado1.getNombre(), empleado1.getDni(), empleado1.getSexo(), empleado1.getCategoria(), empleado1.anyos);
		Nomina nomina1=new Nomina();
		//nomina1.cargarSueldoBase(empleado1);
		System.out.println("Por tanto su sueldo base es: "+nomina1.cargarSueldoBase(empleado1) +
				" y su sueldo real de "+nomina1.sueldo(empleado1));
		System.out.println("-------------------");
		System.out.println("EMPLEADO 2");
		empleado2.imprime(empleado2.getNombre(), empleado2.getDni(), empleado2.getSexo(), empleado2.getCategoria(), empleado2.getAnyos());
		Nomina nomina2=new Nomina();
		System.out.println("Por tanto su sueldo base es: "+nomina2.cargarSueldoBase(empleado2) +
			" y su sueldo real de "+nomina2.sueldo(empleado2));
	}
	
	
	//PRUEBAS CONTROL EXCEPCIONES
	public static void controlDNI(Empleado empleado2) {
		System.out.println("Modifica el dni del empleado 2");

	    Scanner miScanner = new Scanner(System.in);
	    Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
	    System.out.print("Introduce un DNI correcto: ");
	    empleado2.setDni(miScanner.nextLine());
	    Matcher mat = patron.matcher(empleado2.getDni());
	    while(!mat.matches()){
	       System.out.println("El DNI introducido es incorrecto, por favor introduzca un DNI válido.");
	       System.out.print("Introduce un DNI correcto: ");
	       empleado2.setDni(miScanner.nextLine());
	       mat = patron.matcher(empleado2.getDni());
	    }
	    System.out.println("El DNI " + empleado2.getDni() + " es válido.");
	}
	
	/*public static void controlCategoria(Empleado empleado2) {
		System.out.println("Modifica la categoria del empleado 2");
		boolean excepcion=false;
	    Scanner miScanner = new Scanner(System.in);
	    System.out.println("Introduce una categoria:");
	    //empleado2.setCategoria(miScanner.nextInt());
	 
	    	try {
	    		 System.out.println("Introduce una categoria valida:");
	 		    empleado2.setCategoria(miScanner.nextInt());
	 		    if(empleado2.getCategoria()>=0 || empleado2.getCategoria()<=10) {
	 		    	 excepcion=false;
	 		    }
	 		   
			} catch (InputMismatchException e) {

	 		    e.printStackTrace();
	 		    System.out.println("numero incorrecto");
	 		
			}
		   

	    	System.out.println("Categoria modificada");

	    
	}*/
	
	
	
	
	/*public static String controlDNI2(Empleado empleado2) {
		System.out.println("Modifica el dni del empleado 2");
		boolean excepcion = false;
	    Scanner miScanner = new Scanner(System.in);
	    Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
	    try {
		    
		    System.out.print("Introduce un DNI correcto: ");
		    empleado2.setDni(miScanner.nextLine());
		    Matcher mat = patron.matcher(empleado2.getDni());
		    excepcion = false;
		} catch (Exception e) {
		       System.out.println("El DNI introducido es incorrecto, por favor introduzca un DNI válido.");
		       System.out.print("Introduce un DNI correcto: ");
		       empleado2.setDni(miScanner.nextLine());
		       Matcher mat = patron.matcher(empleado2.getDni());
		       excepcion = true;
		}

	    while(excepcion){

	    }
	    System.out.println("El DNI " + empleado2.getDni() + " es válido.");
		return empleado2.getDni();
	}*/
	

}
