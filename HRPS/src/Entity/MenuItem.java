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
     * @param id 
     * @param name 
     * @param description 
     * @param price
     */
    public MenuItem() {
    	
    }
    public MenuItem(int id, String name, String description, float price) {
        // TODO implement here
    }
    
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
