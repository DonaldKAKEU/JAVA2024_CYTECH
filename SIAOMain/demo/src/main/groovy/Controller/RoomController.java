package Controller;

import Model.Bed;
import Model.Room;

import java.sql.*;
import java.util.ArrayList;

public class RoomController {
    /**
     * Adds a bed to a room in the database.
     *
     * @param bed  the bed to be added
     * @param room the room where the bed is added
     * @throws SQLException if an error occurs during the database operation
     */
    public static void addBedOnRoom(Bed bed, Room room) throws SQLException {
        bed.save(); // save the bed in the database
        room.addBed(bed); // save the bed in the object
    }

    /**
     * Retrieves the beds in a room.
     *
     * @param room the room
     * @return the list of beds in the room
     */
    public static ArrayList<Bed> getBedsOfRoom(Room room) {
        ArrayList<Bed> beds = new ArrayList<>(); // array of beds to store all the beds

        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM beds WHERE idr =" + room.getIdr());
            /**
             * Iterate through the list of beds obtained and add each object to the list of beds
             */
            while (resultSet.next()) {
                Bed bed = new Bed(resultSet.getInt("idr"), room);
                bed.setState(resultSet.getBoolean("state"));
                beds.add(bed);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error executing query");
        }

        return beds;
    }

    /**
     * Retrieves the number of available beds in a room.
     *
     * @param room the room
     * @return the number of available beds
     */
    public static int getNumberOfAvailablePlace(Room room) {
        int c = 0;
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM beds WHERE idr =" + room.getIdr() + "AND state=" + false);
            c = resultSet.getInt("idb");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    /**
     * Defines the display of a room with its attributes.
     *
     * @param room the room to be displayed
     * @return the displayed room
     */
    public static Room showRoom(Room room) {
        return room;
    }

    /**
     * Retrieves all rooms in the center.
     *
     * @return the list of all rooms
     */
    public static ArrayList<Room> getAllRooms() {
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        ArrayList<Room> rooms = new ArrayList<>();

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM rooms;");

            while (resultSet.next()) {
                Room room = new Room(resultSet.getInt("idr"),
                        resultSet.getInt("numberOfPlaces")
                );
                room.setState(resultSet.getBoolean("state"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }
}

