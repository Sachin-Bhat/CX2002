/**
 * 
 */
package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

import Entity.Room;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class RoomManager {
	/**
     * Default constructor
     */
    public RoomManager() {
    }

    /**
     * 
     */
    private ArrayList<Room> roomList;

    /**
     * 
     */
    private FileIOHandler fileIO = new FileIOHandler();

    /**
     * 
     */
    private int count = 1;

    /**
     * 
     */
    private Scanner sc;

    /**
     * Overloaded constructor for RoomManager
     * initialisation of a few variables (including setting the hotel layout and status/type initialisation logic)
     * is able to recreate the 48 rooms (assumptions from pdf guide) and
     * writes it back to file if empty or 
     * recreate rooms and write back to file
     * 
     * @param sc
     */
    public RoomManager(Scanner sc) {
        // TODO implement here
    }

    /**
     * logic in auto setting rate by room type and bed type
     * @param rType 
     * @param bType 
     * @return
     */
    private float assignRate(RoomType rType, BedType bType) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * menu for updating room type
     * @return
     */
    private void roomTypeMenu() {
        // TODO implement here
        return;
    }

    /**
     * returns room type based on user's choice
     * @param sc 
     * @return
     */
    private RoomType chooseRoomType(Scanner sc) {
        // TODO implement here
        return null;
    }

    /**
     * menu for updating bed type
     * @return
     */
    private void bedTypeMenu() {
        // TODO implement here
        return;
    }

    /**
     * returns bed type based on user's choice
     * @param sc 
     * @return
     */
    private BedType chooseBedType(Scanner sc) {
        // TODO implement here
        return null;
    }

    /**
     * menu for updating the availability status
     * @return
     */
    private void availabilityStatusMenu() {
        // TODO implement here
        return;
    }

    /**
     * returns availability status based on user's choice
     * @param sc 
     * @return
     */
    private AvailabilityStatus chooseAvailabilityStatus(Scanner sc) {
        // TODO implement here
        return null;
    }

    /**
     * menu for updating enable/disable wifi
     * @return
     */
    private void wifiMenu() {
        // TODO implement here
        return;
    }

    /**
     * returns a boolean whether wifi is enabled based on user's choice
     * @param sc 
     * @return
     */
    private boolean chooseWifi(Scanner sc) {
        // TODO implement here
        return false;
    }

    /**
     * menu for updating allow/prohibit smoking
     * @return
     */
    private void smokingMenu() {
        // TODO implement here
        return;
    }

    /**
     * returns a boolean whether smoking is allowed based on user's choice
     * @param sc 
     * @return
     */
    private boolean chooseSmoking(Scanner sc) {
        // TODO implement here
        return false;
    }

    /**
     * menu for updating the room details
     * @return
     */
    private void updateRoomMenu() {
        // TODO implement here
        return;
    }

    /**
     * lists the room details
     * @param r 
     * @return
     */
    private void listRoomDetails(Room r) {
        // TODO implement here
        return;
    }

    /**
     * returns a String based on the boolean
	 * returns Yes if true
	 * returns No if false
	 * 
     * @param response 
     * @return
     */
    private String booleanToString(boolean response) {
        // TODO implement here
        return "";
    }

    /**
     * return room if room is found
	 * return null otherwise
     * @param rLevel 
     * @param rNo 
     * @return
     */
    private Room verifyRoom(int rLevel, int rNo) {
        // TODO implement here
        return null;
    }

    /**
     * create and add a room to list of rooms and
     * update to file
     * 
     * @return
     */
    public void addRoom() {
        // TODO implement here
        return;
    }

    /**
     * checks if a string is an int
     * @param str 
     * @return
     */
    private boolean isStringInt(String str) {
        // TODO implement here
        return false;
    }

    /**
     * allow user to update room details after providing updateRoomMenu() and
     * update to file
     * 
     * @param room 
     * @return
     */
    public void updateRoom(String room) {
        // TODO implement here
        return;
    }

    /**
     * lists rooms by the occupancy rate
     * @return
     */
    public void listRoomsByOccupancyRate() {
        // TODO implement here
        return;
    }

    /**
     * list rooms by the room status
     * @return
     */
    public void listRoomsByRoomStatus() {
        // TODO implement here
        return;
    }

    /**
     * return room if vacant
     * null otherwise
     * 
     * @param room 
     * @return
     */
    public Room returnVacantRoom(String room) {
        // TODO implement here
        return null;
    }

    /**
     * provision to change availability status of 2 rooms if
     * guest needs to switch rooms
     * new room gets old room status
	 * old room status is now vacant
	 * 
     * @param oldR 
     * @param newR 
     * @return
     */
    public void shiftRoom(Room oldR, Room newR) {
        // TODO implement here
        return;
    }

    /**
     * return room based on room id
	 * useful in ReservationManager to set room object
	 * 
     * @param id 
     * @return
     */
    public Room getRoomById(int id) {
        // TODO implement here
        return null;
    }

    /**
     * lists room details by room number
     * 
     * @param rNum 
     * @return
     */
    public void listRoomDetailsByRNo(String rNum) {
        // TODO implement here
        return;
    }

    /**
     * convinient method to write to file
     * nothing much, just a short hand of a method from FileIOHandler really
     * 
     * @return
     */
    public void writeToFile() {
        // TODO implement here
        return;
    }

    /**
     * assures that user enters an int
     * 
     * @param option 
     * @param input 
     * @return
     */
    private int verifyOption(int option, String input) {
        // TODO implement here
        return 0;
    }

    /**
     * assures that rate is entered and formatted properly (i.e. 2dp)
     * 
     * @param rate 
     * @param input 
     * @return
     */
    private float verifyRate(float rate, String input) {
        // TODO implement here
        return 0.0f;
    }
}
