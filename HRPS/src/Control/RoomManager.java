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
     * @param sc
     */
    public RoomManager(Scanner sc) {
        // TODO implement here
    }

    /**
     * @param rType 
     * @param bType 
     * @return
     */
    private float assignRate(RoomType rType, BedType bType) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    private void roomTypeMenu() {
        // TODO implement here
        return;
    }

    /**
     * @param sc 
     * @return
     */
    private RoomType chooseRoomType(Scanner sc) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    private void bedTypeMenu() {
        // TODO implement here
        return;
    }

    /**
     * @param sc 
     * @return
     */
    private BedType chooseBedType(Scanner sc) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    private void availabilityStatusMenu() {
        // TODO implement here
        return;
    }

    /**
     * @param sc 
     * @return
     */
    private AvailabilityStatus chooseAvailabilityStatus(Scanner sc) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    private void wifiMenu() {
        // TODO implement here
        return;
    }

    /**
     * @param sc 
     * @return
     */
    private boolean chooseWifi(Scanner sc) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    private void smokingMenu() {
        // TODO implement here
        return;
    }

    /**
     * @param sc 
     * @return
     */
    private boolean chooseSmoking(Scanner sc) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    private void updateRoomMenu() {
        // TODO implement here
        return;
    }

    /**
     * @param r 
     * @return
     */
    private void listRoomDetails(Room r) {
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
     * @param rLevel 
     * @param rNo 
     * @return
     */
    private Room verifyRoom(int rLevel, int rNo) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void addRoom() {
        // TODO implement here
        return;
    }

    /**
     * @param str 
     * @return
     */
    private boolean isStringInt(String str) {
        // TODO implement here
        return false;
    }

    /**
     * @param room 
     * @return
     */
    public void updateRoom(String room) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void listRoomsByOccupancyRate() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void listRoomsByRoomStatus() {
        // TODO implement here
        return;
    }

    /**
     * @param room 
     * @return
     */
    public Room returnVacantRoom(String room) {
        // TODO implement here
        return null;
    }

    /**
     * @param oldR 
     * @param newR 
     * @return
     */
    public void shiftRoom(Room oldR, Room newR) {
        // TODO implement here
        return;
    }

    /**
     * @param id 
     * @return
     */
    public Room getRoomById(int id) {
        // TODO implement here
        return null;
    }

    /**
     * @param rNum 
     * @return
     */
    public void listRoomDetailsByRNo(String rNum) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void writeToFile() {
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
     * @param rate 
     * @param input 
     * @return
     */
    private float verifyRate(float rate, String input) {
        // TODO implement here
        return 0.0f;
    }
}
