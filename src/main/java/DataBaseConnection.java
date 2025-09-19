import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    protected static Connection initailisedDatabase() throws SQLException, ClassNotFoundException {
        String dbDriver = "com.mysql.cj.jdbc.Driver"; // Updated driver class for newer versions
        String dbURL = "jdbc:mysql://localhost:3306/";
        String dbname ="pbl24";// Use utf8mb4
        String dbUserName = "root";
        String dbPassword = "";
        
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL+dbname, dbUserName, dbPassword);
        return con;
    }
}
