package Entity;

import java.util.ArrayList;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class Bill {

    protected double grandTotal;
    protected ArrayList<?> itemList;
    
    /**
     * @param items 
     * @param total
     */
    public Bill() {}
    
    public Bill(ArrayList<?> items, double total) {
        // TODO implement here
    	this.grandTotal = total;
    	this.itemList = items;
    }

    /**
     * prints grandTotal
     */
    public void printReceipt() {
        // TODO implement here
        System.out.println("Receipt: $" + String.format("%.2f", this.grandTotal));
    }

    /**
     * @return this.grandTotal
     */
    public double getGrandTotal() {
        // TODO implement here
        return this.grandTotal;
    }

    /**
     * @return this.itemList
     */
    public ArrayList<?> getItemList() {
        // TODO implement here
        return this.itemList;
    }

}
