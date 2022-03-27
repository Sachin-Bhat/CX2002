/**
 * 
 */
package Entity;

import java.util.ArrayList;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class CheckOutBill extends Bill {
	/**
     * Default constructor
     */
    public CheckOutBill() {
    }

    /**
     * 
     */
    private int noWeekdays;

    /**
     * 
     */
    private int noWeekends;

    /**
     * 
     */
    private double roomCost;

    /**
     * 
     */
    private double discount;

    /**
     * 
     */
    private double taxAmt;

    /**
     * @param rsList 
     * @param pay
     */
    public void CheckOutBill(ArrayList<RoomService> rsList, Payment pay) {
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
