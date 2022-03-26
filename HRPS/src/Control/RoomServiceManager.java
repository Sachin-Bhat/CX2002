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
     * @param sc
     */
    public void RoomServiceManager(Scanner sc) {
        // TODO implement here
    }

    /**
     * @param mList 
     * @return
     */
    public RoomService orderRoomService(ArrayList<MenuItem> mList) {
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

    /**
     * @param rs 
     * @return
     */
    public void updateRoomService(RoomService rs) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    private void updateRoomServiceMenu() {
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
     * @param id 
     * @return
     */
    public RoomService getRoomServiceById(int id) {
        // TODO implement here
        return null;
    }
}
