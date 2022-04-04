package Entity;

import java.util.ArrayList;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class CheckOutBill extends Bill {

    private int noWeekdays;
    private int noWeekends;
    private double roomCost;
    private double discount;
    private double taxAmt;

    public CheckOutBill() {}
    
    /**
     * @param rsList 
     * @param pay
     */
    public CheckOutBill(ArrayList<RoomService> rsList, Payment pay) {
        // TODO implement here
    	super(rsList, pay.calcGrandTotal());
    	this.noWeekdays = pay.calcWeekdays();
    	this.noWeekends = pay.calcWeekends();
    	this.roomCost = pay.calcRoomCost();
    	this.discount = pay.calcDiscount();
    	this.taxAmt = pay.calcTax();
    }

    /**
     * print receipt
     */
    public void printReceipt() {
        // TODO implement here
        System.out.println("Receipt: ");
        System.out.println("Weekdays stayed: " + noWeekdays);
        System.out.println("Weekends stayed: " + noWeekends);
        System.out.println("Room Cost: " + String.format("%.2f", roomCost));
        System.out.println("Discount: " + String.format("%.2f", discount));
        System.out.println("Tax Amt: " + String.format("%.2f", taxAmt));
        System.out.println("Grand Total: " + String.format("%.2f", super.getGrandTotal()));
    }
}
