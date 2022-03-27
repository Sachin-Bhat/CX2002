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
     * Overloaded constructor for MenuItemManager
     * used to initialise a few variables 
     * and retrieve menuItems from the file
     * @param sc
     */
    public MenuItemManager(Scanner sc) {
        // TODO implement here
    }

    /**
     * adds menu item into a list of menu items and update to file
     * @return
     */
    public void addMenuItem() {
        // TODO implement here
        return;
    }

    /**
     * search and returns menu item by name 
     * from a list of menu Items if found
     * null otherwise
     * @param name 
     * @return
     */
    public MenuItem searchMenuItem(String name) {
        // TODO implement here
        return null;
    }

    /**
     * shows a menu for updating menu items
     * @return
     */
    private void updateMenu() {
        // TODO implement here
        return;
    }

    /**
     * lists menu item details
     * @return
     */
    public void listMenuItems() {
        // TODO implement here
        return;
    }

    /**
     * searches and removes menu item by name and updates to file
     * @param name 
     * @return
     */
    public void removeMenuItem(String name) {
        // TODO implement here
        return;
    }

    /**
     * updates a menu item in the list and updates to file
     * @param name 
     * @return
     */
    public void updateMenuItem(String name) {
        // TODO implement here
        return;
    }

    /**
     * to select a menu item from a list of menu items (i.e. listMenuItems())
     * searches for it and adds it
     * also have an option to exit out of this method
     * 
     * @return
     */
    public ArrayList<MenuItem> selectMenuItem() {
        // TODO implement here
        return null;
    }

    /**
     * verifies if the user enters a float value of 2dp
     * if is a float (but not 2dp) round to 2dp
     * if not error check
     * @param price 
     * @param input 
     * @return price
     */
    private float verifyPrice(float price, String input) {
        // TODO implement here
        return 0.0f;
    }
}
