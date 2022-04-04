/**
 * 
 */
package Entity;

import java.io.Serializable;

import java.util.ArrayList;

import Control.MenuItemManager;

import java.time.LocalDate;

import Entity.OrderStatus;

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

    /**
     * @param id 
     * @param remarks 
     * @param mList 
     * @return
     */
    public RoomService() {
    	
    }
    public RoomService(ArrayList<MenuItem> mList, LocalDate dateTime, String remarks, int id) {
		super();
		this.mList = mList;
		this.dateTime = dateTime;
		this.remarks = remarks;
		this.id = id;
		this.orderStatus = OrderStatus.CONFIRMED;
	}


	public void placeOrder(int id, String remarks, ArrayList<MenuItem> mList) {
        System.out.println("Order has been placed.");
        System.out.println("Order id: " + id);
        this.setId(id);
        this.setRemarks(remarks);
        this.setmList(mList);
        return;
    }
	
    public void printOrderReceipt() {
    	System.out.println("Order Receipt:");
    	MenuItem cur;
    	float total=0;
    	for(int i=0; i<this.mList.size();i++) {
    		cur = this.mList.get(i);
        	System.out.println("Name: " + cur.getName());
        	System.out.println("Price: " + cur.getPrice());
        	System.out.println("");
        	total = total + cur.getPrice();
    	}
    	System.out.println("Total Price: " + total);
        return;
    }
    
    public float getMenuItemGrandTotal() {
    	MenuItem cur;
    	float total=0;
    	for(int i=0; i<this.mList.size();i++) {
    		cur = this.mList.get(i);
        	total = total + cur.getPrice();
    	}
        return total;
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
