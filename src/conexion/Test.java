
package conexion;
import java.sql.SQLException;

public class Test {
    public static void main (String [] args) throws SQLException{
        
        CreateConnection conexion = new CreateConnection();
        conexion.getConnection();
    }
    
}
