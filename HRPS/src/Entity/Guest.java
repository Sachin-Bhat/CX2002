package Entity;

import java.io.Serializable;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class Guest implements Serializable {

	/**
     * Default constructor
     */
    public Guest() {}
    private static final long serialVersionUID = 1234L;
    private int guestId;
    private String id;
    private String name;
    private CreditCard card;
    private String address;
    private String country;
    private char gender;
    private String nationality;
    private long contactNo;

    /**
     * @param guestId 
     * @param id 
     * @param name 
     * @param address 
     * @param country 
     * @param gender 
     * @param nationality 
     * @param contactNo
     */
    public void Guest(int guestId, String id, String name, String address, String country, char gender, String nationality, long contactNo) {
        this.guestId = guestId;
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.gender = gender;
        this.nationality = nationality;
        this.contactNo = contactNo;
    }
    //SETTER METHODS
    /**
     * @param guestId 
     * @return
     */
    public void setGuestId(int guestId) {this.guestId = guestId;}
    /**
     * @param id 
     * @return
     */
    public void setId(String id) {this.id = id;}
    /**
     * @param name 
     * @return
     */
    public void setName(String name) {this.name = name;}
    /**
     * @param card 
     * @return
     */
    public void setCreditCard(CreditCard card) {this.card = card;}
    /**
     * @param address 
     * @return
     */
    public void setAddress(String address) {this.address = address;}
    /**
     * @param country 
     * @return
     */
    public void setCountry(String country) {this.country = country;}
    /**
     * @param gender 
     * @return
     */
    public void setGender(char gender) {this.gender = gender;}
    /**
     * @param nationality 
     * @return
     */
    public void setNationality(String nationality) {this.nationality = nationality;}
    /**
     * @param contactNo 
     * @return
     */
    public void setContactNo(long contactNo) {this.contactNo = contactNo;}

    //GETTER METHODS
    /**
     * @return
     */
    public int getGuestId() {return guestId;}
    /**
     * @return
     */
    public String getId() {return id;}
    /**
     * @return
     */
    public String getName() {return name;}
    /**
     * @return
     */
    public CreditCard getCreditCard() {return card;}
    /**
     * @return
     */
    public String getAddress() {return address;}
    /**
     * @return
     */
    public String getCountry() {return country;}
    /**
     * @return
     */
    public char getGender() {return gender;}
    /**
     * @return
     */
    public String getNationality() {return nationality;}
    /**
     * @return
     */
    public long getContactNo() {return contactNo;}
}
