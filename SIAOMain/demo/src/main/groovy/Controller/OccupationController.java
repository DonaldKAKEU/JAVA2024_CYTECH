package Controller;

import Model.Bed;
import Model.Occupation;
import Model.PersonInNeed;

import java.sql.SQLException;

public class OccupationController {
    /**
     * Registers a person in need to a bed.
     *
     * @param ido           the ID of the occupation
     * @param bed           the bed to assign
     * @param personInNeed  the person in need to register
     * @throws SQLException if an error occurs during the database operation
     */
    public static void registerPersonInBed(int ido, Bed bed, PersonInNeed personInNeed) throws SQLException {
        Occupation occupation = new Occupation(personInNeed, bed, ido);

        occupation.save();
    }

    /**
     * Deletes the registration of a person in a bed.
     *
     * @param occupation the occupation to delete
     * @throws SQLException if an error occurs during the database operation
     */
    public static void deletedPersonInBed(Occupation occupation) throws SQLException {
        occupation.deleteOccupation();
        occupation.delete();
    }
}
