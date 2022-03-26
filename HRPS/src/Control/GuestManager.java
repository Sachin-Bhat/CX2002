/**
 * 
 */
package Control;

import java.util.ArrayList;
import java.util.Scanner;

import entity.CreditCard;
import entity.Guest;

/**
 * @author BHAT SACHIN <SACHIN008@ntu.edu.sg>
 *
 */
public class GuestManager {
	/**
     * Default constructor
     */
    public GuestManager() {
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
    public void GuestManager(Scanner sc) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Guest addGuest() {
        // TODO implement here
        return null;
    }

    /**
     * @param name 
     * @return
     */
    public Guest searchGuest(String name) {
        // TODO implement here
        return null;
    }

    /**
     * @param name 
     * @return
     */
    public void listDetailsGuest(String name) {
        // TODO implement here
        return;
    }

    /**
     * @param g 
     * @return
     */
    public void printDetailsGuest(Guest g) {
        // TODO implement here
        return;
    }

    /**
     * @param g 
     * @return
     */
    public void updateDetailsGuest(Guest g) {
        // TODO implement here
        return;
    }

    /**
     * @param name 
     * @return
     */
    public void updateDetailsGuest(String name) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    private void updateMenuGuest() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    private void updateMenuCreditCard() {
        // TODO implement here
        return;
    }

    /**
     * @param g 
     * @return
     */
    private void updateCreditCard(Guest g) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    private CardType getCardType() {
        // TODO implement here
        return null;
    }

    /**
     * @param guestId 
     * @return
     */
    private Guest getGuestById(int guestId) {
        // TODO implement here
        return null;
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
     * @param cardNum 
     * @param input 
     * @return
     */
    private long verifyCard(long cardNum, String input) {
        // TODO implement here
        return 0;
    }

    /**
     * @param expiry 
     * @param input 
     * @return
     */
    private String verifyExpiry(String expiry, String input) {
        // TODO implement here
        return "";
    }

    /**
     * @param input 
     * @return
     */
    private int isInt(String input) {
        // TODO implement here
        return 0;
    }
}
