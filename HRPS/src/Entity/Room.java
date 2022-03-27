/**
 * 
 */
package Entity;

import java.io.Serializable;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class Room implements Serializable {
	/**
     * Default constructor
     */
    public Room() {
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1234L;

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private int rLevel;

    /**
     * 
     */
    private int rNo;

    /**
     * 
     */
    private RoomType rType;

    /**
     * 
     */
    private float rate;

    /**
     * 
     */
    private BedType bType;

    /**
     * 
     */
    private AvailabilityStatus availStatus;

    /**
     * 
     */
    private boolean hasWifi;

    /**
     * 
     */
    private boolean isSmoking;

    /**
     * 
     */
    private String view;

    /**
     * @param id 
     * @param rType 
     * @param rate 
     * @param bType 
     * @param availStatus 
     * @param hasWifi 
     * @param isSmoking 
     * @param view 
     * @param rLevel 
     * @param rNo
     */
    public Room(int id, RoomType rType, float rate, BedType bType, AvailabilityStatus availStatus, boolean hasWifi, boolean isSmoking, String view, int rLevel, int rNo) {
        // TODO implement here
    }

    /**
     * @param id 
     * @return
     */
    public void setId(int id) {
        // TODO implement here
        return;
    }

    /**
     * @param rLevel 
     * @return
     */
    public void setRLevel(int rLevel) {
        // TODO implement here
        return;
    }

    /**
     * @param rNo 
     * @return
     */
    public void setRNo(int rNo) {
        // TODO implement here
        return;
    }

    /**
     * @param rType 
     * @return
     */
    public void setRType(RoomType rType) {
        // TODO implement here
        return;
    }

    /**
     * @param rate 
     * @return
     */
    public void setRate(float rate) {
        // TODO implement here
        return;
    }

    /**
     * @param bType 
     * @return
     */
    public void setBType(BedType bType) {
        // TODO implement here
        return;
    }

    /**
     * @param availStatus 
     * @return
     */
    public void setAvailStatus(AvailabilityStatus availStatus) {
        // TODO implement here
        return;
    }

    /**
     * @param hasWifi 
     * @return
     */
    public void setWifi(boolean hasWifi) {
        // TODO implement here
        return;
    }

    /**
     * @param isSmoking 
     * @return
     */
    public void setSmoking(boolean isSmoking) {
        // TODO implement here
        return;
    }

    /**
     * @param view 
     * @return
     */
    public void setView(String view) {
        // TODO implement here
        return;
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
    public int getRLevel() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getRNo() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public RoomType getRType() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public float getRate() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public BedType getBType() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public AvailabilityStatus getAvailStatus() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public boolean getWifi() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean getSmoking() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public String getView() {
        // TODO implement here
        return "";
    }

}
