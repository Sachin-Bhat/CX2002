/**
 * 
 */
package Entity;

import java.io.Serializable;

import java.util.ArrayList;

import java.time.LocalDate;

//import Entity.OrderStatus;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class RoomService implements Serializable {
	
    private static final long serialVersionUID = 1234L;
    private ArrayList<MenuItem> mList;
    private LocalDate dateTime = null;
    private String remarks;
    private int id;
    private OrderStatus orderStatus;
    
    public RoomService(ArrayList<MenuItem> mList, LocalDate dateTime, String remarks, int id) {
    	this.mList = new ArrayList<MenuItem>();
		this.orderStatus = OrderStatus.PREPARING;
	}
    
    
    public RoomService() {
		// TODO Auto-generated constructor stub
	}


	/**
     * order with time stamp
     * @param id 
     * @param remarks 
     * @param mList 
     * @return
     */ 
	public void placeOrder(int id, String remarks, ArrayList<MenuItem> mList) {
        // TODO implement here
		this.dateTime = LocalDate.now();
		this.id = id; // room service id
		this.remarks = remarks;
		this.mList = mList;
        return;
    }

    /**
     * print order receipt
     * @return
     */
    public void printOrderReceipt() {
        // TODO implement here
    	System.out.println("---------------Order Summary------------------");
		System.out.println("Room Service Id: " + this.id);
		System.out.println("Ordered on: " + this.dateTime.toString());
		System.out.println("Order status: " + this.getOrderStatus().toString());
		for (MenuItem item : mList) {
			System.out.println("Item Ordered: " + item.getName());
			System.out.printf("Item Price: $SGD%.2f\n", item.getPrice());
		}
		System.out.println("---------------End of Order-------------------");
		Bill bill = new RoomServiceBill(mList, this); 
		bill.printReceipt();
        return;
    }
    
    public float getMenuItemGrandTotal() {
        // TODO implement here
    	float mTotal = 0;
		for (MenuItem item : mList) {
			mTotal += item.getPrice();
		}
		return mTotal;
        
    }
	public ArrayList<MenuItem> getmList() {
		return mList;
	}
	public void setmList(ArrayList<MenuItem> mList) {
		this.mList = mList;
	}
	public LocalDate getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}