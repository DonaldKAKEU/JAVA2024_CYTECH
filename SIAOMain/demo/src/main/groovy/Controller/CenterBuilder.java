package Controller;

import Model.*;

import java.util.ArrayList;

/**
 * The CenterBuilder class provides functionality for building a center and initializing its rooms and beds.
 */
public class CenterBuilder {

    /**
     * Builds a center with the configured parameters.
     *
     * @return the built Center object
     */
    public Center CenterBuilder() {
        return new Center(Configuration.name, Configuration.address, Configuration.roomNumber);
    }

    /**
     * Initializes the center by creating rooms and beds.
     *
     * @param center the Center object to initialize
     */
    public void initialization(Center center) {
        for (int i = 0; i < center.getRoomNumber(); i++) {
            Room room = new Room(i, 4);
            for (int j = 0; j < room.getNumberOfPlaces(); j++) {
                Bed bed = new Bed(j, room);
                room.addBed(bed);
            }
            center.addRoom(room);
        }
    }
}

