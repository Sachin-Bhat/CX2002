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
	/**
     * Default constructor
     */
    public MenuItem() {
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1234L;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private float price;

    /**
     * @param id 
     * @param name 
     * @param description 
     * @param price
     */
    public MenuItem(int id, String name, String description, float price) {
        // TODO implement here
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
    public String getDescription() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public float getPrice() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public int getId() {
        // TODO implement here
        return 0;
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
     * @param description 
     * @return
     */
    public void setDescription(String description) {
        // TODO implement here
        return;
    }

    /**
     * @param price 
     * @return
     */
    public void setPrice(float price) {
        // TODO implement here
        return;
    }

}
