import Connexion.DbConnexion;

import java.sql.SQLException;

public class siaoAppli {
    public static void main(String[] args) throws SQLException {
        DbConnexion dbConnexion = new DbConnexion();
        dbConnexion.openConnexion();
    }
}
