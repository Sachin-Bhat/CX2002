/**
 * 
 */
package Entity;

import java.io.Serializable;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class MenuItem implements Serializable {
	
    
    
    private static final long serialVersionUID = 1234L;
    private String name;
    private String description;
    private int id;
    private float price;
    
    /**
     *  default constructor utilises super class
     */
    public MenuItem() {
    	super();
    }
    /**
     * @param id 
     * @param name 
     * @param description 
     * @param price
     */
    public MenuItem(int id, String name, String description, float price) {
        // TODO implement here
    	this.id = id;
  	  	this.name = name;
  	  	this.description = description;
  	  	this.price = price;
    }
    // accessors and mutators
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
