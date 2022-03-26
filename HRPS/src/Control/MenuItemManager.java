/**
 * 
 */
package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;
import Entity.MenuItem;
import Entity.Guest;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class MenuItemManager {

    private ArrayList<Guest> guestList;
    private FileIOHandler fileIO;
    private int count = 1;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<MenuItem> menu;

    public MenuItemManager() {
    	
    }
    public MenuItemManager(Scanner sc) {
        // TODO implement here
    }

    public void addMenuItem() {
        MenuItem newItem;
        String name;
        String description;
        float price;
        System.out.println("Enter name of item: ");
        name = sc.nextLine();
        System.out.println("Enter description of item: ");
        description = sc.nextLine();
        System.out.println("Enter price of item: ");
        price = sc.nextFloat();
        newItem = new MenuItem(this.menu.size(), name, description, price);
        this.menu.add(newItem);
        System.out.println("Item: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println("Assigned itemID of " + this.menu.indexOf(newItem));
        return;
    }

    public MenuItem searchMenuItem(String name) {
    	MenuItem cur;
        for(int i=0;i<this.menu.size();i++) {
        	cur = menu.get(i);
        	if(cur.getName()==name) {
        		return cur;
        	}
        }
        return null;
    }

    private void updateMenu() {
    	MenuItem cur;
    	for(int i=0;i<this.menu.size();i++) {
    		cur = menu.get(i);
    		cur.setId(i);
    		menu.set(i, cur);
    	}
        return;
    }

    public void listMenuItems() {
    	MenuItem cur;
    	for(int i=0;i<this.menu.size();i++) {
    		cur = menu.get(i);
        	System.out.println("Name: " + cur.getName());
        	System.out.println("Description: " + cur.getDescription());
        	System.out.println("Price: " + cur.getPrice());
        }
        return;
    }

    public void removeMenuItem(String name) {
    	MenuItem toDelete = searchMenuItem(name);
    	MenuItem cur;
    	int deleteID = toDelete.getId();
    	menu.remove(deleteID);
    	for(int i=deleteID;i<this.menu.size();i++) {
    		cur = menu.get(i);
    		cur.setId(i);
    		menu.set(i, cur);
    	}
        return;
    }

    public void updateMenuItem(String name) {
        int choice;
        MenuItem toUpdate = searchMenuItem(name);
        System.out.println("What would you like to update about " + name + "?");
        System.out.println("1. Name");
        System.out.println("2. Description");
        System.out.println("3. Price");
        choice = sc.nextInt();
        
        switch(choice) {
        	case 1:
        		String newName = " ";
        		System.out.println("Please enter a new name for this item: ");
        		newName = sc.nextLine();
        		toUpdate.setName(newName);
        		break;
        	case 2:
        		String newDesc = " ";
        		System.out.println("Please enter a new description for this item: ");
        		newDesc = sc.nextLine();
        		toUpdate.setDescription(newDesc);
        		break;
        	case 3:
        		float newPrice;
        		System.out.println("Please enter a new price for this item: ");
        		newPrice = sc.nextFloat();
        		toUpdate.setPrice(newPrice);
        		break;
        	default:
        		System.out.println("You have entered an invalid choice.");
        		break;
        }
        
        return;
    }
    
    public ArrayList<MenuItem> selectMenuItem() {
        // TODO implement here
        return null;
    }
    
    private float verifyPrice(float price, String input) {
        // TODO implement here
        return 0.0f;
    }
}
