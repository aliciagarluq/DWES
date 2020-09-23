package ejercicio2_nomina2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author Alicia
 *@version Nóminas parte 2
 */
public class CalculaNominas {
	//private static final String path = "D:\\GIT-PROYECTOS\\DesarrolloWebServidor\\AplicacionNominas_parte2\\empleados.txt";
	
	public static void main(String[] args) throws DatosNoCorrectosException {
	//Empleados creados
	Empleado empleado1=new Empleado("James Cosling","32000032G",'M',4,7);
	Empleado empleado2=new Empleado("Ada Lovelace", "32000031R", 'F');
	Empleado empleado3=new Empleado("Ada Maritrini", "32000431R", 'F',4,8);
	
	File fichero=new File("D:\\eclipseWorkspace2020\\Nom2\\empleados.txt");
	//llamada a metodo escribe
	writeContentBW(empleado1,empleado2,fichero);	
	//llamada a leer
	readFileBR(fichero);
	
	//Incremente los años trabajados del segundo empleado y haga que la categoría del primero sea 9.
	//MODIFICAR CATEGORIA DEL EMPLEADO 1 A: 9
		empleado1.setCategoria(9);
	//Incremente los años trabajados del segundo empleado
		empleado2.setAnyos(empleado2.increAnyos(empleado2.getAnyos()));
	
	
	//llamada a metodo escribe por segunda vez
	writeContentBW(empleado1,empleado2,fichero);	
	//llamada a leer por segunda vez
	readFileBR(fichero);
	
	//1.3. Definir el fichero de texto de salida “sueldos.txt” con el formato más adecuado
	//para almacenar el dni y el sueldo resultante para cada empleado.
	
	File fichero2=new File("D:\\eclipseWorkspace2020\\Nom2\\sueldos.txt");
	//llamada a metodo escribe
	writeContentBWSueldos(empleado1,empleado2,fichero2);	
	//llamada a leer
	readFileBRSueldos(fichero2);
	
	
	
	Conecta conexion=new Conecta();
	conexion.altaEmpleado(empleado3);
	
	}
	
	//Escribir datos del empleado 1 y 2
	private static void writeContentBW(Empleado empleado1,Empleado empleado2,File fichero) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			System.out.println("Abriendo el fichero...");
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);
			System.out.println("Escribiendo el contenido...");
			
				bw.write("nombre: "+ empleado1.getNombre()+" DNI: "+empleado1.getDni()+" Sexo: "
						+empleado1.getSexo()+" Categoria: "+empleado1.getCategoria()+" Anyos Trabajados "+empleado1.getAnyos());
				
				bw.newLine();
				
				bw.write("nombre: "+ empleado2.getNombre()+" DNI: "+empleado2.getDni()+" Sexo: "
						+empleado2.getSexo()+" Categoria: "+empleado2.getCategoria()+" Anyos Trabajados "+empleado2.getAnyos());		
				bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
						
	}
	//Escribir datos sueldos
	private static void writeContentBWSueldos(Empleado empleado1,Empleado empleado2,File fichero2) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			System.out.println("Abriendo el fichero sueldos.txt...");
			fw = new FileWriter(fichero2);
			bw = new BufferedWriter(fw);
			System.out.println("Escribiendo el contenido en sueldos.txt...");
			Nomina nomina1=new Nomina();
				bw.write(" DNI del empleado 1: "+empleado1.getDni()+" , y su sueldo: "+nomina1.sueldo(empleado1));
				bw.newLine();
			Nomina nomina2=new Nomina();
				bw.write(" DNI del empleado 2: "+empleado2.getDni()+" , y su sueldo: "+nomina2.sueldo(empleado2));	
				bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}					
	}
	//Leer Datos sueldos
	private static void readFileBRSueldos(File fichero2) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fichero2);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
				if (null != br) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

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
	
	
	private static void readFileBR(File fichero) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
				if (null != br) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

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
	

}
