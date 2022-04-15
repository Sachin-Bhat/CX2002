/**
 * 
 */
package Entity;

import java.util.ArrayList;

import java.time.LocalDate;

//import java.io.File;
//import java.io.IOException;
//import java.io.FileNotFoundException;
//import java.io.FileInputStream;
//import java.io.ObjectInputStream;

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
    	super(list,rs.getMenuItemGrandTotal());
		rsId = rs.getId();
		dateTime = rs.getDateTime();
		orderStatus = rs.getOrderStatus();
    }

    /**
     * @return
     */
    public void printReceipt() {
        // TODO implement here
    	System.out.println("---------------Order Summary-------------------");
		System.out.println("Room Service Id: " + this.rsId);
		System.out.println("Ordered on: " + this.dateTime.toString());
		System.out.println("Order status: " + this.orderStatus.toString());
	
		
		for (Object o : this.itemList) {
			try {
				MenuItem item = (MenuItem) o;
				System.out.println("Menu Item Ordered: " + item.getName());
				System.out.printf("Price: $SGD%.2F\n", item.getPrice());
				System.out.println("------------------------------------------");
			} 
			
			catch (Exception exception) {
				if(exception.getMessage() != null) {
					System.out.println("Error: " + exception.getMessage());
				}
			}
	
		}
		System.out.printf("Grand Total: $SGD%.2f\n", this.grandTotal);
		System.out.println("------------------End of Order--------------------\n");
        return;
    }

}