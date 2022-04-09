/**
 * 
 */
package Entity;

import java.io.Serializable;

import java.util.Objects;
import java.util.ArrayList;

import java.time.LocalDate;

import Entity.OrderStatus;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class Reservation implements Serializable {
	/**
     * Default constructor
     */
    public Reservation() {
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1234L;

    /**
     * 
     */
    private int rezCode;

    /**
     * 
     */
    private Guest guest;

    /**
     * 
     */
    private Room room;

    /**
     * 
     */
    private LocalDate checkIn;

    /**
     * 
     */
    private LocalDate checkOut;

    /**
     * 
     */
    private int noAdults;

    /**
     * 
     */
    private int noKids;

    /**
     * 
     */
    private ReservationStatus rezStatus;

    /**
     * 
     */
    private ArrayList<RoomService> rsList;

    /**
     * @param count
     */
    public Reservation(int count) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getRezCode() {
        // TODO implement here
        return 0;
    }

    /**
     * @param guest 
     * @return
     */
    public void setGuest(Guest guest) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public Guest getGuest() {
        // TODO implement here
        return null;
    }

    /**
     * @param room 
     * @return
     */
    public void setRoom(Room room) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public Room getRoom() {
        // TODO implement here
        return null;
    }

    /**
     * @param checkIn 
     * @return
     */
    public void setCheckIn(LocalDate checkIn) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public LocalDate getCheckIn() {
        // TODO implement here
        return null;
    }

    /**
     * @param checkOut 
     * @return
     */
    public void setCheckOut(LocalDate checkOut) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public LocalDate getCheckOut() {
        // TODO implement here
        return null;
    }

    /**
     * @param noAdults 
     * @return
     */
    public void setNoAdults(int noAdults) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public int getNoAdults() {
        // TODO implement here
        return 0;
    }

    /**
     * @param noKids 
     * @return
     */
    public void setNoKids(int noKids) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public int getNoKids() {
        // TODO implement here
        return 0;
    }

    /**
     * @param rezStatus
     */
    public void setRezStatus(ReservationStatus rezStatus) {
        // TODO implement here
    }

    /**
     * @return
     */
    public ReservationStatus getRezStatus() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void printRezDetails() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void checkOut() {
        // TODO implement here
        return;
    }

    /**
     * @param response 
     * @return
     */
    private String booleanToString(boolean response) {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public void removeRoomOccupancy() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void listRoomServices() {
        // TODO implement here
        return;
    }

    /**
     * @param rs 
     * @return
     */
    public void addRoomService(RoomService rs) {
        // TODO implement here
        return;
    }

    /**
     * @param rs 
     * @return
     */
    public void addRoomServiceWithoutPrintOrder(RoomService rs) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public ArrayList<RoomService> getRSList() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void clearRSList() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public double getRSPrice() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @param rsList 
     * @return
     */
    public static double calcRoomService(ArrayList<RoomService> rsList) {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @param id 
     * @return
     */
    public RoomService getRSById(int id) {
        // TODO implement here
        return null;
    }

    /**
     * @param rs 
     * @return
     */
    public void removeRoomService(RoomService rs) {
        // TODO implement here
        return;
    }

}