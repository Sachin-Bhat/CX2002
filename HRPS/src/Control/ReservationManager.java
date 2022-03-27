/**
 * 
 */
package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

import Entity.Reservation;
import Entity.Room;
import Entity.RoomService;
import Entity.Guest;
import Entity.ReservationStatus;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class ReservationManager {
	/**
     * Default constructor
     */
    public ReservationManager() {
    }

    /**
     * 
     */
    private ArrayList<Reservation> rezList;

    /**
     * 
     */
    private FileIOHandler fileIO;

    /**
     * 
     */
    private GuestManager gMgr;

    /**
     * 
     */
    private RoomManager rMgr;

    /**
     * 
     */
    private RoomServiceManager rsMgr;

    /**
     * 
     */
    private int count = 1;

    /**
     * 
     */
    private Scanner sc;

    /**
     * Overloaded constructor for ReservationManager
     * used to initialise variables and 
     * retrieve reservations from the file
     * 
     * @param gMgr 
     * @param rMgr 
     * @param rsMgr 
     * @param sc
     */
    public ReservationManager(GuestManager gMgr, RoomManager rMgr, RoomServiceManager rsMgr, Scanner sc) {
        // TODO implement here
    }

    /**
     * creates and adds a new reservation to a reservation list and
     * writes to file
     * @return
     */
    public void newReservation() {
        // TODO implement here
        return;
    }

    /**
     * searches and returns reservation if found
     * null otherwise
     * @return
     */
    public Reservation searchReservation() {
        // TODO implement here
        return null;
    }

    /**
     * updates guest's details or room number based on reservation and
     * writes to file
     * @return
     */
    public void updateReservation() {
        // TODO implement here
        return;
    }

    /**
     * menu for update reservation
     * @return
     */
    private void updateReservationMenu() {
        // TODO implement here
        return;
    }

    /**
     * removes a reservation from the reservation list if found and
     * writes/updates to file
	 * prints error message otherwise
     * @return
     */
    public void removeReservation() {
        // TODO implement here
        return;
    }

    /**
     * prints the reservation details if found
     * error message otherwise
     * @return
     */
    public void printReservation() {
        // TODO implement here
        return;
    }

    /**
     * prints all reservation which are currently not expired
     * @return
     */
    public void printAllReservations() {
        // TODO implement here
        return;
    }

    /**
     * adds room service to reservation and 
     * writes to file
     * @param rez 
     * @param rs 
     * @return
     */
    public void addRoomService(Reservation rez, RoomService rs) {
        // TODO implement here
        return;
    }

    /**
     * assures user enters an int
     * @param option 
     * @param input 
     * @return
     */
    private int verifyOption(int option, String input) {
        // TODO implement here
        return 0;
    }

    /**
     * if valid room number is entered -> 1
     * else -> 0
     * thus assuring user always enters right room number
     * @param room 
     * @return
     */
    private int verifyRoom(String room) {
        // TODO implement here
        return 0;
    }

    /**
     * checks if input is an int
     * @param input 
     * @return
     */
    private int isInt(String input) {
        // TODO implement here
        return 0;
    }

    /**
     * remove a valid room service from reservation and room service manager and
     * updates to file
     * @return
     */
    public void removeRoomService() {
        // TODO implement here
        return;
    }

    /**
     * allow user to update room service status
     * @return
     */
    public void updateRoomService() {
        // TODO implement here
        return;
    }

    /**
     * searches a reservation and print all the room services for that reservation
     * @return
     */
    public void printRoomService() {
        // TODO implement here
        return;
    }

    /**
     * assures that user enters a valid time and according to the format specified
     * @param time 
     * @param date 
     * @param input
     * @return time
     */
    private void verifyTime(String time, DateTimeFormatter date, String input) {
        // TODO implement here
    }

    /**
     * allows the guest to check in without a reservation and
     * updates to file
     * @return
     */
    public void checkIn() {
        // TODO implement here
        return;
    }

    /**
     * guest check in using a valid reservation and
     * updates to file
     * @param rez 
     * @return
     */
    public void checkIn(Reservation rez) {
        // TODO implement here
        return;
    }

    /**
     * sets reservation status to expired 
     * @return
     */
    public void expireReservation() {
        // TODO implement here
        return;
    }

    /**
     * check out the guest from the hotel and
     * update to file
     * @return
     */
    public Reservation checkOut() {
        // TODO implement here
        return null;
    }
}
