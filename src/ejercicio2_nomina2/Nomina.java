package ejercicio2_nomina2;

import java.util.Scanner;

public class Nomina{

	private static final int SUELDO_BASE[]={50000, 70000, 90000, 110000, 130000,150000, 170000, 190000, 210000, 230000};
	
	//METODO QUE MUESTRA UNA TABLA DE SUELDOS BASE SEGÚN CATEGORIA
	public int cargarSueldoBase(Empleado empleado) {
	
		/*for (int i = 0; i <= SUELDO_BASE.length-1; i++) {
			
			//System.out.println("El empleado cuya categoria es la "+(i+1)+" tiene "+SUELDO_BASE[i]+" de sueldo base");
			
		}*/
		System.out.println("Al tener una categoria "+empleado.getCategoria()+" ,le corresponde "+SUELDO_BASE[empleado.getCategoria()-1]+" de sueldo base");
		int sueldoBase=SUELDO_BASE[empleado.getCategoria()-1];
		return sueldoBase;
	}

	public int sueldo(Empleado empleado) {
		//Scanner sc =new Scanner(System.in);
		//sueldo = sueldoBase + 5000*años trabajados
		
		int sueldo = SUELDO_BASE[empleado.getCategoria()-1]+ 5000 * empleado.anyos;
	
		//int sueldo = sueldoBase + 5000*años trabajados
		//System.out.println("su sueldo es de:"+sueldo);
		return sueldo;
	}



	public static int[] getSueldoBase() {
		return SUELDO_BASE;
	}




	
//	public int sueldoObtenido(Empleado empleado,SUEL) {
//		
//		int sueldo= 
//		return 0;
//		
//		
//	}
	

}
