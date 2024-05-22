package Model;

import Controller.DbConnexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Occupation class represents the occupation of a bed by a person in need.
 */
public class Occupation {
    private int ido;
    private PersonInNeed person;
    private Bed bed;

    /**
     * Constructs an Occupation object with the specified person in need, bed, and ID.
     *
     * @param person the person in need
     * @param bed    the bed
     * @param ido    the occupation ID
     */
    public Occupation(PersonInNeed person, Bed bed, int ido) {
        this.ido = ido;
        this.person = person;
        this.bed = bed;
    }

    /**
     * Returns the person in need associated with the occupation.
     *
     * @return the person in need
     */
    public PersonInNeed getPerson() {
        return person;
    }

    /**
     * Sets the person in need associated with the occupation.
     *
     * @param person the person in need
     */
    public void setPerson(PersonInNeed person) {
        this.person = person;
    }

    /**
     * Returns the bed associated with the occupation.
     *
     * @return the bed
     */
    public Bed getBed() {
        return bed;
    }

    /**
     * Sets the bed associated with the occupation.
     *
     * @param bed the bed
     */
    public void setBed(Bed bed) {
        this.bed = bed;
    }

    /**
     * Returns the room associated with the bed.
     *
     * @return the room
     */
    public Room getRoom() {
        return bed.getRoom();
    }

    /**
     * Calculates the duration of the occupation in days.
     *
     * @return the duration of the occupation in days
     */
    public int occupationTime() {
        long startTime = person.getStartDate().getTime();
        long endTime = person.getEndDate().getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (24 * 60 * 60 * 1000);
        return (int) diffDays;
    }

    /**
     * Changes the state of the bed and updates room information after the new assignment.
     * Prints the assignment details if the bed is successfully assigned, otherwise prints a message indicating that the bed is already occupied.
     */
    public void affectationBed() {
        if (!bed.getState()) {
            bed.setState(true);
            bed.getRoom().setOccupiedBeds(bed.getRoom().getOccupiedBeds() + 1);
            System.out.println("Person " + person.getFirstName() + " " + person.getLastName() + " assigned to Bed " + bed.getIdb() + " in Room " + bed.getRoom().getIdr());
        } else {
            System.out.println("Bed " + bed.getIdb() + " is already occupied.");
        }
    }

    /**
     * Deletes the occupation, marking the bed as vacant and updating room information.
     * Prints a message indicating that the occupation is successfully deleted.
     */
    public void deleteOccupation() {
        bed.setState(false);
        bed.getRoom().setOccupiedBeds(bed.getRoom().getOccupiedBeds() - 1);
        System.out.println("Occupation deleted successfully. Bed " + bed.getIdb() + " in Room " + bed.getRoom().getIdr() + " is now vacant.");
    }

/**
 * Saves the occupation data to the database.
 *
 * @throws SQLException if a database error occurs

