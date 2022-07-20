package Principal;
import Vistas.*;
import Modelo.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Login login = new Login();
        login.setVisible(true);
        Conexion conexion = new Conexion();
        conexion.getConnection();
        
    }
    
}
