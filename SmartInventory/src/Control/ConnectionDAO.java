package Control;

import java.sql.*;

/**
 * Base class for establishing Database connection
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public abstract class ConnectionDAO {
    /**
     * Instances from Java.Sql for iterating through the table's values
     */
    Connection con; //Connection
    PreparedStatement pst; //prepared SQL Query
    Statement st; //SQL Query
    ResultSet rs; //DB response

    /**
     * Here comes the database connection data and the JDBC connector
     */
    String database = "smart_inventory";//DB name
    String user = "root";
    String password = "root";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

    /**
     * Function to stablish the dabase connection using the previous variables data
     */
    public void connectToDB() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão deu certo!");
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        }
    }
}
