/**
 * 
 */
package Entity;

import java.util.ArrayList;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class Bill {
	
	/**
     * Default constructor
     */
    public Bill() {
    }

    /**
     * 
     */
    protected double grandTotal;

    /**
     * 
     */
    protected ArrayList<?> itemList;

    /**
     * @param items 
     * @param total
     */
    public void Bill(ArrayList<?> items, double total) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void printReceipt() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public double getGrandTotal() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return
     */
    public ArrayList<?> getItemList() {
        // TODO implement here
        return null;
    }

}
