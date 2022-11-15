package Control;

import java.sql.*;

/**
 * Base class for establishing Database connection
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */

public abstract class ConnectionDAO {

    Connection con; //Connection
    PreparedStatement pst; //prepared SQL Query
    Statement st; //SQL Query
    ResultSet rs; //DB response

    String database = "smart-inventory";//DB name
    String user = "root";
    String password = "root";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

    public void connectToDB() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao deu certo!");
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        }
    }
}
