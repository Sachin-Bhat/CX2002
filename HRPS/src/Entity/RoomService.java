/**
 * 
 */
package Entity;

import java.io.Serializable;

import java.util.ArrayList;

import java.time.LocalDate;

import Entity.OrderStatus;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class RoomService implements Serializable {
	
	/**
     * Default constructor
     */
    public RoomService() {
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1234L;

    /**
     * 
     */
    private ArrayList<MenuItem> mList;

    /**
     * 
     */
    private LocalDate dateTime = null;

    /**
     * 
     */
    private String remarks;

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private OrderStatus orderStatus;

    /**
     * @param id 
     * @param remarks 
     * @param mList 
     * @return
     */
    public void placeOrder(int id, String remarks, ArrayList<MenuItem> mList) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void printOrderReceipt() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public ArrayList<MenuItem> getMenuItems() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public LocalDate getDateTime() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public float getMenuItemGrandTotal() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public String getRemarks() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public int getId() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public OrderStatus getOrderStatus() {
        // TODO implement here
        return null;
    }

    /**
     * @param remarks 
     * @return
     */
    public void setRemarks(String remarks) {
        // TODO implement here
        return;
    }

    /**
     * @param orderStatus 
     * @return
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        // TODO implement here
        return;
    }

}
