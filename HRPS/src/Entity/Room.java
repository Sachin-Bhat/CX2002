package Entity;

import java.io.Serializable;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 * @author CHNG QIHON <LCHNG002@e.ntu.edu.sg>
 * @author JIANG YUNJUN <YJIANG035@e.ntu.edu.sg>
 * @author NEO SUNWEN <SNEO020@e.ntu.edu.sg>
 * @author ZAKI BIN ZAINUDIN <ZAKI003@e.ntu.edu.sg>
 */
public class Room implements Serializable {
	/**
     * Default constructor
     */
    public Room() {}

    private static final long serialVersionUID = 1234L;

    private int id;
    private int rLevel;
    private int rNo;
    private RoomType rType;
    private float rate;
    private BedType bType;
    private AvailabilityStatus availStatus;
    private boolean hasWifi;
    private boolean isSmoking;
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

    //CONSTRUCTOR
    public Room(int id, RoomType rType, float rate, BedType bType, AvailabilityStatus availStatus, boolean hasWifi, boolean isSmoking, String view, int rLevel, int rNo) {
        this.id = id;
        this.rType = rType;
        this.rate = rate;
        this.bType = bType;
        this.availStatus = availStatus;
        this.hasWifi = hasWifi;
        this.isSmoking = isSmoking;
        this.view = view;
        this.rLevel = rLevel;
        this.rNo = rNo;
    }

    //SETTER METHODS
    /**
     * @param id 
     * @return
     */
    public void setId(int id) {this.id = id;}
    /**
     * @param rLevel 
     * @return
     */
    public void setRLevel(int rLevel) {this.rLevel = rLevel;}
    /**
     * @param rNo 
     * @return
     */
    public void setRNo(int rNo) {this.rNo = rNo;}
    /**
     * @param rType 
     * @return
     */
    public void setRType(RoomType rType) {this.rType = rType;}
    /**
     * @param rate 
     * @return
     */
    public void setRate(float rate) {this.rate = rate;}
    /**
     * @param bType 
     * @return
     */
    public void setBType(BedType bType) {this.bType = bType;}
    /**
     * @param availStatus 
     * @return
     */
    public void setAvailStatus(AvailabilityStatus availStatus) {this.availStatus = availStatus;}
    /**
     * @param hasWifi 
     * @return
     */
    public void setWifi(boolean hasWifi) {this.hasWifi = hasWifi;}
    /**
     * @param isSmoking 
     * @return
     */
    public void setSmoking(boolean isSmoking) {this.isSmoking = isSmoking;}
    /**
     * @param view 
     * @return
     */
    public void setView(String view) {this.view = view;}

    //GETTER METHODS
    /**
     * @return
     */
    public int getId() {return this.id;}
    /**
     * @return
     */
    public int getRLevel() {return this.rLevel;}
    /**
     * @return
     */
    public int getRNo() {return this.rNo;}
    /**
     * @return
     */
    public RoomType getRType() {return this.rType;}
    /**
     * @return
     */
    public float getRate() {return this.rate;}
    /**
     * @return
     */
    public BedType getBType() {return this.bType;}
    /**
     * @return
     */
    public AvailabilityStatus getAvailStatus() {return availStatus;}
    /**
     * @return
     */
    public boolean getWifi() {return this.hasWifi;}
    /**
     * @return
     */
    public boolean getSmoking() {return this.isSmoking;}
    /**
     * @return
     */
    public String getView() {return this.view;}
}