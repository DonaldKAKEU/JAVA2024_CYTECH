package Model;

import Controller.DbConnexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The Room class represents a room in a center.
 */
public class Room {
    private int idr;
    private int numberOfPlaces;
    private ArrayList<Bed> listBed;
    private boolean state;
    private int occupiedBeds;

    /**
     * Constructs a Room object with the specified ID and number of places.
     *
     * @param idr              the room ID
     * @param numberOfPlaces   the number of places in the room
     */
    public Room(int idr, int numberOfPlaces) {
        this.idr = idr;
        this.numberOfPlaces = numberOfPlaces;
        state = false;
        listBed = new ArrayList<>();
        this.listBed = listBed;
    }

    /**
     * Returns the room ID.
     *
     * @return the room ID
     */
    public int getIdr() {
        return idr;
    }

    /**
     * Returns the number of places in the room.
     *
     * @return the number of places
     */
    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    /**
     * Sets the number of places in the room.
     *
     * @param numberOfPlaces the number of places
     */
    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    /**
     * Returns the state of the room.
     *
     * @return the state (false if there are still places available, true if all places are occupied)
     */
    public boolean getState() {
        return state;
    }

    /**
     * Sets the state of the room.
     *
     * @param state the state (false if there are still places available, true if all places are occupied)
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * Returns the number of occupied beds in the room.
     *
     * @return the number of occupied beds
     */
    public int getOccupiedBeds() {
        return occupiedBeds;
    }

    /**
     * Sets the number of occupied beds in the room.
     *
     * @param occupiedBeds the number of occupied beds
     */
    public void setOccupiedBeds(int occupiedBeds) {
        this.occupiedBeds = occupiedBeds;
    }

    /**
     * Adds a bed to the room.
     *
     * @param bed the bed to add
     */
    public void addBed(Bed bed){
        listBed.add(bed);
    }

    /**
     * Returns the number of beds in the room.
     *
     * @return the number of beds
     */
    public int getNumberBeds() {
        return listBed.size();
    }

    /**
     * Returns the list of beds in the room.
     *
     * @return the list of beds
     */
    public List<Bed> getBeds() {
        return listBed;
    }

    /**
     * Returns the list of available rooms (rooms with available places).
     *
     * @param rooms the list of all rooms
     * @return the list of available rooms
     */
    public static List<Room> getAvailableRooms(List<Room> rooms) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.getState()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    /**
     * Returns the string representation of the room.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "Room ID: " + idr + ", Number of Places: " + numberOfPlaces + ", State: " + (state ? "Occupied" : "Vacant");
    }

    /**
     * Saves the room data to the database.
     *
     * @throws SQLException if a database error occurs
     */
    public void save() throws SQLException {
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();

        Statement statement = connection.createStatement();
        try {
            statement.execute("INSERT INTO rooms VALUES (" + this.idr + "," + this.numberOfPlaces +  "," + this.state + ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes the room record from the database.
     *
     * @throws SQLException if a database error occurs
     */
    public void delete() throws SQLException{
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = connection.createStatement();

        try{
            statement.execute("DELETE FROM rooms WHERE idr =" + this.idr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



// on peut aussi rajouter la méthode qui va nous retourner le nombre de place libre(à discuter on peut la mettre dans controller)

