package Controller;

import Model.Center;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The CenterController class provides functionality for retrieving information about the center.
 */
public class CenterController {

    /**
     * Retrieves the information of the center.
     *
     * @return the Center object with the retrieved information
     * @throws SQLException if an SQL exception occurs
     */
    public static Center getCenter() throws SQLException {
        Center center = null;
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM centers WHERE idc = 1");

        if (resultSet.next()) {
            center = new Center();
            center.setName(resultSet.getString("name"));
            center.setAddress(resultSet.getString("Adresse"));
            center.setRoomNumber(resultSet.getInt("roomsNumber"));
        }

        return center;
    }
}
