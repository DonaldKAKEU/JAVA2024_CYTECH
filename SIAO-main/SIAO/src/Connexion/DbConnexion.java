package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


/*
* Cette class me permet d'eatblir la connexion avec la base donnée
* */
public class DbConnexion {
  private final String url = "jdbc:mysql://localhost:3306/siao-db";
  private final String userName = "root";
  private final String password = "";
  Connection connection;

  public void DbConnexion() {

  }

  /*
  methode de la classe qui permet de faire la connexion à la base de donné : utile pour creer et executer les fonction métiers
   */
  public void openConnexion() {
    try {
      connection = DriverManager.getConnection(this.url, this.userName, this.password);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Connexion error");
    }

  }

  /*
   * creer la structure de la bd
   * */
  public void createDateBaseStructure() throws SQLException {
    DbConnexion dbConnexion = new DbConnexion();
    dbConnexion.openConnexion();

    Statement statement = connection.createStatement();

    try {
      statement.execute("CREATE TABLE `Centers` (\n" +
              "  `idCenter` int PRIMARY KEY AUTO_INCREMENT,\n" +
              "  `name` varchar(255),\n" +
              "  `Adress` varchar(255)\n" +
              ");\n" +
              "\n" +
              "CREATE TABLE `CentersAdmin` (\n" +
              "  `idCenterAdmin` int PRIMARY KEY AUTO_INCREMENT,\n" +
              "  `idCenter` int,\n" +
              "  `email` varchar(255),\n" +
              "  `password` varchar(255)\n" +
              ");\n" +
              "\n" +
              "CREATE TABLE `Rooms` (\n" +
              "  `idRoom` int PRIMARY KEY AUTO_INCREMENT,\n" +
              "  `idCenter` int,\n" +
              "  `numero` int UNIQUE,\n" +
              "  `sumOfBeds` int\n" +
              ");\n" +
              "\n" +
              "CREATE TABLE `Beds` (\n" +
              "  `idBed` int PRIMARY KEY AUTO_INCREMENT,\n" +
              "  `idCenter` int,\n" +
              "  `idRoom` int,\n" +
              "  `restriction` varchar(255),\n" +
              "  `state` boolean\n" +
              ");\n" +
              "\n" +
              "CREATE TABLE `PeoplesInNeed` (\n" +
              "  `idPeopleInNeed` int PRIMARY KEY AUTO_INCREMENT,\n" +
              "  `idCenter` int,\n" +
              "  `idRoom` int,\n" +
              "  `idBed` int,\n" +
              "  `name` varchar(255),\n" +
              "  `surname` varchar(255),\n" +
              "  `gender` varchar(255),\n" +
              "  `age` int,\n" +
              "  `numberOfSocialSecurity` varchar(255)\n" +
              ");\n" +
              "\n" +
              "CREATE TABLE `Occupations` (\n" +
              "  `idOccupation` int PRIMARY KEY AUTO_INCREMENT,\n" +
              "  `idBed` int,\n" +
              "  `idPeopleInNeed` int,\n" +
              "  `idRoom` int,\n" +
              "  `startDate` date,\n" +
              "  `endDate` date\n" +
              ");\n" +
              "\n" +
              "ALTER TABLE `CentersAdmin` ADD FOREIGN KEY (`idCenter`) REFERENCES `Centers` (`idCenter`);\n" +
              "\n" +
              "ALTER TABLE `Rooms` ADD FOREIGN KEY (`idCenter`) REFERENCES `Centers` (`idCenter`);\n" +
              "\n" +
              "ALTER TABLE `Beds` ADD FOREIGN KEY (`idCenter`) REFERENCES `Centers` (`idCenter`);\n" +
              "\n" +
              "ALTER TABLE `Beds` ADD FOREIGN KEY (`idRoom`) REFERENCES `Rooms` (`idRoom`);\n" +
              "\n" +
              "ALTER TABLE `PeoplesInNeed` ADD FOREIGN KEY (`idCenter`) REFERENCES `Centers` (`idCenter`);\n" +
              "\n" +
              "ALTER TABLE `PeoplesInNeed` ADD FOREIGN KEY (`idRoom`) REFERENCES `Rooms` (`idRoom`);\n" +
              "\n" +
              "ALTER TABLE `PeoplesInNeed` ADD FOREIGN KEY (`idBed`) REFERENCES `Beds` (`idBed`);\n" +
              "\n" +
              "ALTER TABLE `Occupations` ADD FOREIGN KEY (`idBed`) REFERENCES `Beds` (`idBed`);\n" +
              "\n" +
              "ALTER TABLE `Occupations` ADD FOREIGN KEY (`idPeopleInNeed`) REFERENCES `PeoplesInNeed` (`idPeopleInNeed`);\n" +
              "\n" +
              "ALTER TABLE `Occupations` ADD FOREIGN KEY (`idRoom`) REFERENCES `Rooms` (`idRoom`);\n");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }



}