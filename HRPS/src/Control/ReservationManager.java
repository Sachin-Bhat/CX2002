/**
 * 
 */
package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

import entity.Reservation;
import entity.Room;
import entity.RoomService;
import entity.Guest;
import entity.ReservationStatus;

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
     * @param gMgr 
     * @param rMgr 
     * @param rsMgr 
     * @param sc
     */
    public void ReservationManager(GuestManager gMgr, RoomManager rMgr, RoomServiceManager rsMgr, Scanner sc) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void newReservation() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public Reservation searchReservation() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void updateReservation() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    private void updateReservationMenu() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void removeReservation() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void printReservation() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void printAllReservations() {
        // TODO implement here
        return;
    }

    /**
     * @param rez 
     * @param rs 
     * @return
     */
    public void addRoomService(Reservation rez, RoomService rs) {
        // TODO implement here
        return;
    }

    /**
     * @param option 
     * @param input 
     * @return
     */
    private int verifyOption(int option, String input) {
        // TODO implement here
        return 0;
    }

    /**
     * @param room 
     * @return
     */
    private int verifyRoom(String room) {
        // TODO implement here
        return 0;
    }

    /**
     * @param input 
     * @return
     */
    private int isInt(String input) {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public void removeRoomService() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void updateRoomService() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void printRoomService() {
        // TODO implement here
        return;
    }

    /**
     * @param time 
     * @param date 
     * @param input
     */
    private void verifyTime(String time, DateTimeFormatter date, String input) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void checkIn() {
        // TODO implement here
        return;
    }

    /**
     * @param rez 
     * @return
     */
    public void checkIn(Reservation rez) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void expireReservation() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public Reservation checkOut() {
        // TODO implement here
        return null;
    }
}
