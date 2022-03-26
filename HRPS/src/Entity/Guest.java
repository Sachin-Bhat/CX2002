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
        // TODO implement here
    }

    /**
     * @param guestId 
     * @return
     */
    public void setGuestId(int guestId) {
        // TODO implement here
        return;
    }

    /**
     * @param id 
     * @return
     */
    public void setId(String id) {
        // TODO implement here
        return;
    }

    /**
     * @param name 
     * @return
     */
    public void setName(String name) {
        // TODO implement here
        return;
    }

    /**
     * @param card 
     * @return
     */
    public void setCreditCard(CreditCard card) {
        // TODO implement here
        return;
    }

    /**
     * @param address 
     * @return
     */
    public void setAddress(String address) {
        // TODO implement here
        return;
    }

    /**
     * @param country 
     * @return
     */
    public void setCountry(String country) {
        // TODO implement here
        return;
    }

    /**
     * @param gender 
     * @return
     */
    public void setGender(char gender) {
        // TODO implement here
        return;
    }

    /**
     * @param nationality 
     * @return
     */
    public void setNationality(String nationality) {
        // TODO implement here
        return;
    }

    /**
     * @param contactNo 
     * @return
     */
    public void setContactNo(long contactNo) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public int getGuestId() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getId() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public CreditCard getCreditCard() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getAddress() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getCountry() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public char getGender() {
        // TODO implement here
        return '0';
    }

    /**
     * @return
     */
    public String getNationality() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public long getContactNo() {
        // TODO implement here
        return 0;
    }
}
