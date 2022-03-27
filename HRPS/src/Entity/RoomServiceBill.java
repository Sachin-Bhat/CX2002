/**
 * 
 */
package Entity;

import java.util.ArrayList;

import java.time.LocalDate;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class RoomServiceBill extends Bill {
	/**
     * Default constructor
     */
    public RoomServiceBill() {
    }

    /**
     * 
     */
    private int rsId;

    /**
     * 
     */
    private LocalDate dateTime;

    /**
     * 
     */
    private OrderStatus orderStatus;

    /**
     * @param list 
     * @param rs
     */
    public RoomServiceBill(ArrayList<MenuItem> list, RoomService rs) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void printReceipt() {
        // TODO implement here
        return;
    }

}
