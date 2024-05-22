package Connexion;
import java.sql.*;
public class DbManager {

        String url = "jdbc:mysql://localhost:3306/siao-db";
        String userName = "root";
        String password = "";

   /*     try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE USERS (id INT PRIMARY KEY, nom VARCHAR(255), age INT);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

*/
    public void createTableUser() {
    }
}
