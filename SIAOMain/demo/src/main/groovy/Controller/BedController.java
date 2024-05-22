package Controller;

import Model.Bed;
import Model.Room;

/**
 * The BedController class provides functionality related to bed operations.
 */
public class BedController {

    /**
     * Checks the availability of a bed.
     *
     * @param bed the bed to check
     * @return true if the bed is available, false otherwise
     */
    public static boolean isAvailable(Bed bed){
        return bed.getState();
    }

    /**
     * Returns the details of a bed.
     *
     * @param bed the bed to show details of
     * @return the bed object
     */
    public static Bed showBed(Bed bed){
        return bed;
    }
}

