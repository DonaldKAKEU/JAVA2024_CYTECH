package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 * The DbConnexion class handles the database connection for the entire project.
 */
public class DbConnexion {
    private final String url = "jdbc:mysql://localhost:3306/siao";
    private final String userName = "root";
    private final String password = "";
    private Connection connection;

    /**
     * Creates a new instance of the DbConnexion class.
     */
    public void DbConnexion() {

    }

    /**
     * Opens a database connection.
     *
     * @return the Connection object for the database connection
     */
    public Connection openConnexion() {
        try {
            connection = DriverManager.getConnection(this.url, this.userName, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connexion error");
        }

        return connection;
    }

}
