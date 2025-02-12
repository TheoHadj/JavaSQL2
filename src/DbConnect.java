import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/gestionTaches";
    private String username = "root";
    private String password = "";



    DbConnect() {
        try {
            Connection dbConnection = DriverManager.getConnection(url, username,password);
            this.connection = dbConnection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Connection getConnection() {
        return connection;
    }

}
