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
	
    private static final long serialVersionUID = 1234L;
    public long cardNo;
    public int cvv;
    public CardType cType;
    public String name;
    public String country;
    public String address;
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
    public CreditCard() {
    	
    }
    
    public CreditCard(long cardNo, int cvv, CardType cType, String name, String country, String address, String exp) {
		super();
		this.cardNo = cardNo;
		this.cvv = cvv;
		this.cType = cType;
		this.name = name;
		this.country = country;
		this.address = address;
		this.exp = exp;
	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public CardType getcType() {
		return cType;
	}

	public void setcType(CardType cType) {
		this.cType = cType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExpiry() {
		return exp;
	}

	public void setExpiry(String exp) {
		this.exp = exp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
