/**
 * This class represents a Center in the system.
 */
package Model;

import java.util.ArrayList;

public class Center {
    private String name;
    private String adresse;
    private int roomNumber;
    private ArrayList<Room> listRoom;   // juste la liste des chambres dans notres chambre de type Room

    /**
     * Constructor for creating a Center object
     * @param name
     * @param adresse
     * @param roomNumber
     */
    public Center(String name, String adresse, int roomNumber) {
        this.name = name;
        this.adresse = adresse;
        this.roomNumber = roomNumber;
        listRoom = new ArrayList<>();   // initialize the list of rooms (empty list) and it will be filled
        // based on the construction of the center
    }


    /**
     * Retrieves the name of the center
     * @return The name of the center
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the center
     * @param name The name of the center
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the address of the center
     * @return The adress of the center
     */

    public String getAdresse() {
        return adresse;
    }

    /**
     * Retrieves the number of rooms in the center
     * @return The number of rooms in the center
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Set the adress of the center
     * @param adresse
     */
    public void setAdresse(String adresse){ this.adresse = adresse;}

    /**
     * Sets the number of rooms in the center
     * @param roomNumber
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Retrieves the list of rooms in the center
     * @return The list of rooms in the center
     */
    public ArrayList<Room> getRooms() {
        return listRoom;
    }

    /**
     * Retrieves a room by its ID
     * @param idr the ID of the room
     * @return The room with the specified ID, or null if not found.     */
    public Room getRoomById(int idr) {
        for (Room room : listRoom) {
            if (room.getIdr() == idr) {
                return room;
            }
        }
        return null;
    }

    /**
     * Adds a room to the center
     * @param room The room to add
     */
    public void addRoom(Room room) {
        listRoom.add(room);
    }

    /**
     * Returns the details of the center as a string
     * @return The details of the center
     */
    public String showCenter() {
        StringBuilder centerInfo = new StringBuilder();
        centerInfo.append("Center Name: ").append(name).append("\n");
        centerInfo.append("Address: ").append(adresse).append("\n");
        centerInfo.append("Room Count: ").append(roomNumber).append("\n");

        for (Room room : listRoom) {
            centerInfo.append("\nRoom ID: ").append(room.getIdr()).append("\n");
            centerInfo.append("Number of Beds: ").append(room.getNumberBeds()).append("\n");
            centerInfo.append("Room State: ").append(room.showRoom()).append("\n");
        }

        return centerInfo.toString();
    }
}