/**
 * 
 */
package Entity;

import java.io.Serializable;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 * @author CHNG QIHON <LCHNG002@e.ntu.edu.sg>
 * @author JIANG YUNJUN <YJIANG035@e.ntu.edu.sg>
 * @author NEO SUNWEN <SNEO020@e.ntu.edu.sg>
 * @author ZAKI BIN ZAINUDIN <ZAKI003@e.ntu.edu.sg>
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
     * Constructor for CreditCard
     * Initialising a few variables.
     *
     * @param name 
     * @param country 
     * @param address 
     * @param cType 
     * @param cardNo 
     * @param cvv 
     * @param exp
     */
    public CreditCard(String name, String country, String address, CardType cType, long cardNo, int cvv, String exp) {
        // TODO implement here
	this.name = name;
	this.country = country;
	this.address = address;
	this.cType = cType;
	this.cardNo = cardNo;
	this.cvv = cvv;
	this.exp = exp;
    }

    /**
     * @param cardNo 
     * @return
     */
    public void setCardNo(long cardNo) {
        // TODO implement here
	this.cardNo = cardNo;
        return;
    }

    /**
     * @param cvv 
     * @return
     */
    public void setCVV(int cvv) {
        // TODO implement here
	this.cvv = cvv;
        return;
    }

    /**
     * @param cType 
     * @return
     */
    public void setCardType(CardType cType) {
        // TODO implement here
	this.cType = cType;
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
     * @param exp 
     * @return
     */
    public void setExpiry(String exp) {
        // TODO implement here
        this.exp = exp;
	return;
    }

    /**
     * @return
     */
    public long getCardNo() {
        // TODO implement here
        return cardNo;
    }

    /**
     * @return
     */
    public int getCVV() {
        // TODO implement here
        return cvv;
    }

    /**
     * @return
     */
    public CardType getCardType() {
        // TODO implement here
        return cType;
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
    public String getExpiry() {
        // TODO implement here
        return exp;
    }
}