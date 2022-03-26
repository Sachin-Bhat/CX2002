/**
 * 
 */
package Entity;

import java.io.Serializable;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class CreditCard implements Serializable {
	/**
     * Default constructor
     */
    public CreditCard() {
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1234L;

    /**
     * 
     */
    public long cardNo;

    /**
     * 
     */
    public int cvv;

    /**
     * 
     */
    public CardType cType;

    /**
     * 
     */
    public String name;

    /**
     * 
     */
    public String country;

    /**
     * 
     */
    public String address;

    /**
     * 
     */
    public String exp;

    /**
     * @param name 
     * @param country 
     * @param address 
     * @param cType 
     * @param cardNo 
     * @param cvv 
     * @param exp
     */
    public void CreditCard(String name, String country, String address, CardType cType, long cardNo, int cvv, String exp) {
        // TODO implement here
    }

    /**
     * @param cardNo 
     * @return
     */
    public void setCardNo(long cardNo) {
        // TODO implement here
        return;
    }

    /**
     * @param cvv 
     * @return
     */
    public void setCVV(int cvv) {
        // TODO implement here
        return;
    }

    /**
     * @param cType 
     * @return
     */
    public void setCardType(CardType cType) {
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
     * @param exp 
     * @return
     */
    public void setExpiry(String exp) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public long getCardNo() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getCVV() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public CardType getCardType() {
        // TODO implement here
        return null;
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
    public String getExpiry() {
        // TODO implement here
        return "";
    }
}
