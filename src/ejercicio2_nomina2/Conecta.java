package ejercicio2_nomina2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class Conecta {
	public void consulta(){
		
		
		try {
			//1.Crear conexion
			Connection conn=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/nominas2", "root","");
			//2.Preparar la consulta
			PreparedStatement miSentencia=conn.prepareStatement("select * from empleado");
			
						
			//Eje. y recorrer
			ResultSet rs = miSentencia.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1) + " "+rs.getString(2)+ " "+rs.getString(3)+ " "+rs.getString(4)+ " "+rs.getString(5));
				
			}
			rs.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	



	public void altaEmpleado(Empleado empleado) {

		try {
			//1.Crear conexion
			Connection conn=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/nominas2", "root","");
			PreparedStatement ps = conn
                    .prepareStatement("INSERT INTO empleado VALUES ('" + empleado.nombre + "','" + empleado.dni
                            + "','" + empleado.sexo + "','" + empleado.getCategoria() + "','" + empleado.anyos + "')");
            ps.executeUpdate();
            conn.close();
        } catch (SQLIntegrityConstraintViolationException j) {
            System.out.println("ERROR: Ya existe el empleado: " + empleado.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
	public void altaEmpleado(ArrayList<Empleado> empleado) {
        Connection conn;
        for (Empleado posicionEmpleado : empleado) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/empleados", "root", "");
                PreparedStatement ps = conn.prepareStatement("INSERT INTO empleado VALUES ('" + posicionEmpleado.nombre
                        + "','" + posicionEmpleado.dni + "','" + posicionEmpleado.sexo + "','"
                        + posicionEmpleado.getCategoria() + "','" + posicionEmpleado.anyos + "')");
                ps.executeUpdate();
                conn.close();
            } catch (SQLIntegrityConstraintViolationException j) {
                System.out.println("ERROR: Ya existe el empleado: "+posicionEmpleado.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
}
