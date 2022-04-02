/**
 * 
 */
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
    public Guest() {
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1234L;

    /**
     * 
     */
    private int guestId;

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private CreditCard card;

    /**
     * 
     */
    private String addresss;

    /**
     * 
     */
    private String country;

    /**
     * 
     */
    private char gender;

    /**
     * 
     */
    private String nationality;

    /**
     * 
     */
    private long contactNo;

    /**
     * Constructor for Guest
     * Initialise a few variables
     * Initialise card with constructor from CreditCard
     *
     * @param guestId 
     * @param id 
     * @param name 
     * @param address 
     * @param country 
     * @param gender 
     * @param nationality 
     * @param contactNo
     */
    public Guest(int guestId, String id, String name, String address, String country, char gender, String nationality, long contactNo) {
        // TODO implement here
	this.guestId = guestId;
	this.id = id;
	this.name = name;
	this.gender = gender;
	this.nationality = nationality;
	this.contactNo = contactNo;
	
	card = new CreditCard(name, address, country, cType, cardNo, cvv, exp);
    }

    /**
     * @param guestId 
     * @return
     */
    public void setGuestId(int guestId) {
        // TODO implement here
	this.guestId = guestId;
        return;
    }

    /**
     * @param id 
     * @return
     */
    public void setId(String id) {
        // TODO implement here
	this.id = id;
        return;
    }

    /**
     * @param name 
     * @return
     */
    public void setName(String name) {
        // TODO implement here
	this.name = name;
        return;
    }

    /**
     * @param card 
     * @return
     */
    public void setCreditCard(CreditCard card) {
        // TODO implement here
	this.card = card;
        return;
    }

    /**
     * @param address 
     * @return
     */
    public void setAddress(String address) {
        // TODO implement here
	this.address = address;
        return;
    }

    /**
     * @param country 
     * @return
     */
    public void setCountry(String country) {
        // TODO implement here
	this.country = country;
        return;
    }

    /**
     * @param gender 
     * @return
     */
    public void setGender(char gender) {
        // TODO implement here
	this.gender = gender;
        return;
    }

    /**
     * @param nationality 
     * @return
     */
    public void setNationality(String nationality) {
        // TODO implement here
	this.nationality = nationality;
        return;
    }

    /**
     * @param contactNo 
     * @return
     */
    public void setContactNo(long contactNo) {
        // TODO implement here
        this.contactNo = contactNo;
	return;
    }

    /**
     * @return
     */
    public int getGuestId() {
        // TODO implement here
        return guestId;
    }

    /**
     * @return
     */
    public String getId() {
        // TODO implement here
        return id;
    }

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return name;
    }

    /**
     * @return
     */
    public CreditCard getCreditCard() {
        // TODO implement here
        return card;
    }

    /**
     * @return
     */
    public String getAddress() {
        // TODO implement here
        return address;
    }

    /**
     * @return
     */
    public String getCountry() {
        // TODO implement here
        return country;
    }

    /**
     * @return
     */
    public char getGender() {
        // TODO implement here
        return gender;
    }

    /**
     * @return
     */
    public String getNationality() {
        // TODO implement here
        return nationality;
    }

    /**
     * @return
     */
    public long getContactNo() {
        // TODO implement here
        return contactNo;
    }
}
