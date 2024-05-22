package Model;

import Controller.DbConnexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * The PersonInNeed class represents a person in need.
 */
public class PersonInNeed {
    private int idp;
    private int age;
    private String firstName;
    private String lastName;
    private String gender;
    private String ssNumber;
    private Date startDate;
    private Date endDate;

    /**
     * Constructs a PersonInNeed object with the specified ID, age, first name, last name, gender, social security number, start date, and end date.
     *
     * @param idp        the person ID
     * @param age        the age
     * @param firstName  the first name
     * @param lastName   the last name
     * @param gender     the gender
     * @param ssNumber   the social security number
     * @param startDate  the start date
     * @param endDate    the end date
     */
    public PersonInNeed(int idp, int age, String firstName, String lastName, String gender, String ssNumber, Date startDate, Date endDate) {
        this.idp = idp;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.ssNumber = ssNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Returns the person ID.
     *
     * @return the person ID
     */
    public int getIdp() {
        return idp;
    }

    /**
     * Returns the age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns the social security number.
     *
     * @return the social security number
     */
    public String getSsNumber() {
        return ssNumber;
    }

    /**
     * Sets the social security number.
     *
     * @param ssNumber the social security number
     */
    public void setSsNumber(String ssNumber) {
        this.ssNumber = ssNumber;
    }

    /**
     * Returns the start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns the end date.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate the end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Saves the person in need data to the database.
     *
     * @throws SQLException if a database error occurs
     */
    public void save() throws SQLException {
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();

        Statement statement = connection.createStatement();
        try {
            statement.execute("INSERT INTO personinNeed (age, firstName, lastName, gender, ssNumber, startDate, endDate) VALUES ('"
                    + this.getAge() +  "','"
                    + this.getFirstName() + "','"
                    + this.getLastName() + "','"
                    + this.getGender() + "','"
                    + this.getSsNumber() + "','"
                    + this.getStartDate() + "','"
                    + this.getEndDate() + "');");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes the person in need record from the database.
     *
     * @throws SQLException if a database error occurs
     */
    public void delete() throws SQLException{
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = connection.createStatement();

        try{
            statement.execute("DELETE FROM personinNeed WHERE  idp =" +  this.getIdp());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
