package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public Connection connectionDB(){
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String user = "root";
            String password = "210410";

            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro de conexão no SQL: "+e.getMessage());
        }// catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }

}
