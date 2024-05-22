package Controller;

import Model.PersonInNeed;
import Model.Room;
import groovyjarjarantlr4.v4.codegen.model.SrcOp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class PersonInNeedController {
    /**
     * Checks if a person is already housed.
     *
     * @param idp the ID of the person
     * @return true if the person is housed, false otherwise
     * @throws SQLException if an error occurs during the database operation
     */
    public static boolean isHoused(int idp) throws SQLException {
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        ArrayList<Integer> idps = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT idp FROM occupations");

        while (resultSet.next()) {
            idps.add(resultSet.getInt("idp"));
        }

        return idps.contains(idp);
    }

    /**
     * Registers a new person in need.
     *
     * @param idp        the ID of the person (initially set to null to create the object)
     * @param age        the age of the person
     * @param firstName  the first name of the person
     * @param lastName   the last name of the person
     * @param gender     the gender of the person
     * @param ssNumber   the social security number of the person
     * @param startDate  the start date
     * @param endDate    the end date
     */
    public static void registerPerson(int idp, int age, String firstName, String lastName, String gender, String ssNumber, Date startDate, Date endDate) {
        PersonInNeed personInNeed = new PersonInNeed(idp, age, firstName, lastName, gender, ssNumber, startDate, endDate);

        try {
            personInNeed.save();
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    /**
     * Deletes a person from the database.
     *
     * @param idp the ID of the person
     * @throws SQLException if an error occurs during the database operation
     */
    public static void deletedPerson(int idp) throws SQLException {
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = connection.createStatement();

        try {
            statement.execute("DELETE FROM personinNeed WHERE idp =" + idp);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves all persons in need from the database.
     *
     * @return a list of persons in need
     * @throws SQLException if an error occurs during the database operation
     */
    public static ArrayList<PersonInNeed> getAllPersons() throws SQLException {
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = connection.createStatement();
        ArrayList<PersonInNeed> persons = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM personinneed;");

            while (resultSet.next()) {
                PersonInNeed personInNeed = new PersonInNeed(resultSet.getInt("idp"),
                        resultSet.getInt("age"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("gender"),
                        resultSet.getString("ssNumber"),
                        resultSet.getDate("startDate"),
                        resultSet.getDate("endDate")
                );
                persons.add(personInNeed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }

    /**
     * Retrieves a person from the database.
     *
     * @return a dummy person object
     * @throws SQLException if an error occurs during the database operation
     */
    public static PersonInNeed getFalsePerson() throws SQLException {
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = connection.createStatement();

        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT idp, firstName, lastName FROM personinneed WHERE idp = MAX(idp);");

        PersonInNeed personInNeed = new PersonInNeed(
                resultSet.getInt("idp"),
                0,
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                null,
                null,
                null,
                null
        );

        return personInNeed;
    }
}

