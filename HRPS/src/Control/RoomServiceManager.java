/**
 * 
 */
package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

import Entity.RoomService;
import Entity.MenuItem;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class RoomServiceManager {
	/**
     * Default constructor
     */
    public RoomServiceManager() {
    }

    /**
     * 
     */
    private ArrayList<RoomService> rsList;

    /**
     * 
     */
    private FileIOHandler fileIO;

    /**
     * 
     */
    private int count = 1;

    /**
     * 
     */
    private Scanner sc;

    /**
     * Overloaded constructor for RoomServiceManager
     * some initialisation of few variables and
     * read room services from file
     * 
     * @param sc
     */
    public RoomServiceManager(Scanner sc) {
        // TODO implement here
    }

    /**
     * allows for placing orders for room service and
     * is added to list of room services and updated to file
     *  
     * @param mList 
     * @return
     */
    public RoomService orderRoomService(ArrayList<MenuItem> mList) {
        // TODO implement here
        return null;
    }

    /**
     * finds and removes room service if it exists and
     * updates it to file
     * 
     * @param rs 
     * @return
     */
    public void removeRoomService(RoomService rs) {
        // TODO implement here
        return;
    }

    /**
     * updates room service using the updateRoomServiceMenu() and
     * writes to file
     * @param rs 
     * @return
     */
    public void updateRoomService(RoomService rs) {
        // TODO implement here
        return;
    }

    /**
     * menu for updating room service details
     * @return
     */
    private void updateRoomServiceMenu() {
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
     * return room service based on room id
     * @param id 
     * @return
     */
    public RoomService getRoomServiceById(int id) {
        // TODO implement here
        return null;
    }
}
