
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {
    
    Connection connection;
    String driver="com.mysql.cj.jdbc.Driver";
    String cadenaConexion="jdbc:mysql://localhost:3306/retosmintic";
    String usuario="root";
    String contrasena="";

    public Conexion(){
        try {
          Class.forName(driver);
          
          connection= DriverManager.getConnection(cadenaConexion,usuario,contrasena);
          if(connection !=null){
              System.out.println("Conexion exitosa con la base de datos");
          
          }else{
            System.out.println("Conexion exitosa");
          }  
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("no se pudo conectar");
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
}
