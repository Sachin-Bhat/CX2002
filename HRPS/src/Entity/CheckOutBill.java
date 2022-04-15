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
    	this.discount = pay.getDiscountRate();
    	this.discount = pay.calcDiscount();
    	this.taxAmt = pay.calcTax();
    }

    /**
     * print receipt
     */
    public void printReceipt() {
        // TODO implement here
        System.out.println("Checkout Receipt: ");
        System.out.println("Weekdays stayed: " + noWeekdays);
        System.out.println("Weekends stayed: " + noWeekends);
        System.out.println("Room Cost: " + String.format("%.2f", roomCost));
        if (this.itemList.size() != 0) {
			System.out.println("Room Service Charge:");
			
			float rsTotal = 0;
			for(Object o: this.itemList) {
				if(o instanceof RoomService) {
					RoomService rs = (RoomService) o;
					RoomServiceBill rsBill = new RoomServiceBill(rs.getmList(), (RoomService)o);
					rsTotal += rs.getMenuItemGrandTotal();
					rsBill.printReceipt();		
				}
			}
			System.out.printf("Total Room Service Charge: + $SGD%.2f\n",rsTotal);
		}
        if(discount != 0)
        	System.out.println("Discount: " + String.format("%.2f", discount));
        System.out.println("Tax Amt: " + String.format("%.2f", taxAmt));
        System.out.println("Grand Total: " + String.format("%.2f", super.getGrandTotal()));
    }
}