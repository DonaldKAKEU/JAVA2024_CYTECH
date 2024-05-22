package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The CenterAdministratorController class provides functionality related to center administrator operations.
 */
public class CenterAdministratorController {

    /**
     * Connects to the center administration system.
     *
     * @param login    the login credentials of the center administrator
     * @param password the password credentials of the center administrator
     * @return true if the connection is successful, false otherwise
     */
    public static boolean toConnect(String login, String password) {

        Boolean result = false;
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT login, password FROM centersAdmin WHERE ida =" + 1);
            String logined = resultSet.getString("login");
            String passworded = resultSet.getString("password");

            result = logined.equals(login) && passworded.equals(password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
