package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	public static Connection getConnection() {
	try { 
        Class.forName("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/SistemaVentas";
        String usuario = "root";
        String password ="123456789";
        
        Connection conexion = DriverManager.getConnection(url,usuario, password);
        
        Statement stmt = conexion.createStatement();
        String consultaSQL = "SELECT * FROM clientes"; // Reemplaza 'tabla' con el nombre real de tu tabla
        ResultSet rs = stmt.executeQuery(consultaSQL);
        
        while (rs.next()) {
            int id_cliente = rs.getInt("id_cliente");
            String nombre = rs.getString("nombre");
            System.out.println("ID: " + id_cliente + ", Nombre: " + nombre);
        }
        
        rs.close();
        stmt.close();
        conexion.close();
        
    } catch (ClassNotFoundException e) {
        System.out.println("Error: No se encontró el controlador JDBC.");
        e.printStackTrace();
    } catch (SQLException e) {
        System.out.println("Error de SQL:");
        e.printStackTrace();
    }
	return null;


}
}
