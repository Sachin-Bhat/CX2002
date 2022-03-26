/**
 * 
 */
package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

import entity.MenuItem;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class MenuItemManager {
	/**
     * Default constructor
     */
    public MenuItemManager() {
    }

    /**
     * 
     */
    private ArrayList<Guest> guestList;

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
    public void MenuItemManager(Scanner sc) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void addMenuItem() {
        // TODO implement here
        return;
    }

    /**
     * @param name 
     * @return
     */
    public MenuItem searchMenuItem(String name) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    private void updateMenu() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void listMenuItems() {
        // TODO implement here
        return;
    }

    /**
     * @param name 
     * @return
     */
    public void removeMenuItem(String name) {
        // TODO implement here
        return;
    }

    /**
     * @param name 
     * @return
     */
    public void updateMenuItem(String name) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public ArrayList<MenuItem> selectMenuItem() {
        // TODO implement here
        return null;
    }

    /**
     * @param price 
     * @param input 
     * @return
     */
    private float verifyPrice(float price, String input) {
        // TODO implement here
        return 0.0f;
    }
}
