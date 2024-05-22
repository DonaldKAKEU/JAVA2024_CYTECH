/**
 * This class represents a bed in the system
 */
package Model;

import Controller.DbConnexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Constructor for creating a Bed object.
 * @param idb  The ID of the bed.
 * @param room The room where the bed is located
 */
public class Bed {
    private int idb;
    private Room room;
    private boolean state;  // false if the bed is empty, true if the bed is occupied


    public Bed(int idb, Room room) {
        this.idb = idb;
        this.room = room;
        state = false;  // as a new bed is created, it is initially vacant
    }

    //getters et setters

    /**
     * Retrieves the ID of the bed
     * @return The ID of the bed
     */
    public int getIdb() {
        return idb;
    }

    /**
     * Retrieves the room where the bed is located
     * @return The room where the best is located
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Retrieves the state of the bed
     *
     * @return The state of the bed( true if occupied, false if vacant)
     */
    public boolean getState() {
        return state;
    }

    /**
     * Sets the state of the bed.
     * @param state The state of the bed to set (true if occupied, false if vacant)
     */

    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * Retrieves the ID of the room where the bed is located
     * @return the ID of the room where the bed is located.
     */

    public int getIdRoom() {    // cette méthode pour retourner juste l'id du chambre où il existe notre lit
        return room.getIdr();
    }


    /**
     * Retrieves the list of available beds
     * This method can be defined in the controller (CenterManager.java)
     * @param beds The list of beds to check for availability
     * @return The list of available beds
     */
    public static List<Bed> getAvailablePlaces(List<Bed> beds) {
        List<Bed> availableBeds = new ArrayList<>();
        for (Bed bed : beds) {
            if (!bed.getState()) {
                availableBeds.add(bed);
            }
        }
        return availableBeds;
    }

    /**
     * Returns the status of the bed as a string
     * This method can be moved to CenterManager.java
     *
     * @return  The status of the bed ("occupied" if occupied, "vacant" if vacant)
     */

    public String showBed() {
        if (state) {
            return "Occupied";
        } else {
            return "Vacant";
        }
    }

    /**
     * S
     */
    public void save() throws SQLException {

        /**
         * etablir la connexion avant d'exécuter la requete sql
         */
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();

        Statement statement = connection.createStatement();
        try {
            statement.execute("INSERT INTO beds VALUES (" + this.state + "," + this.idb + "," + room.getIdr() + ");");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @throws SQLException if an error occrus during database operation
     */

    public void delete() throws SQLException{

        /**
         * Establish the database connection before executing the SQL query.
         */

        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();

        Statement statement = connection.createStatement();
        try{
            statement.execute("DELETE FROM beds WHERE  idb =" +  this.idb );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}