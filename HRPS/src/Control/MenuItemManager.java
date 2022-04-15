/**
 * 
 */
package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;
import Entity.MenuItem;
//import Entity.Guest;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class MenuItemManager {

    //private ArrayList<Guest> guestList;
    private FileIOHandler fileIO;
    private int count = 1;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<MenuItem> mList;

    /**
     * Overloaded constructor for MenuItemManager
     * used to initialise a few variables 
     * and retrieve menuItems from the file
     * @param sc
     */

    public MenuItemManager(Scanner sc) {
        // TODO implement here
    	mList = new ArrayList<MenuItem>();
		this.sc = sc;
		fileIO = new FileIOHandler();
		
		Object[] objList = fileIO.readObject(MenuItem.class);
		for (Object o : objList) {
			MenuItem mi = (MenuItem) o;
			mList.add(mi);
		}
		count = mList.size() + 1;
    }

    /**
     * adds menu item into a list of menu items and update to file
     * @return
     */
  
    public void addMenuItem() {
    	String name; 
    	String description;
		float price = 0;
		System.out.print("Enter name: ");
		name = sc.nextLine();
		
		//checks if menu item of same name already exists.
		if(searchMenuItem(name) != null) {
			//if it does print out error message and exit.
			System.out.println("Menu Item already exists.");
			return;
		}
		
		
		System.out.print("Enter description: ");
		description = sc.nextLine();
		System.out.print("Enter price: $");
		price = verifyPrice(price, "Enter price: $");
		mList.add(new MenuItem(count, name, description, price));
		count++;
		
		fileIO.writeObject(mList.toArray(), MenuItem.class);
		
		System.out.println("New Menu Item added successfully!");
    }

    /**
     * search and returns menu item by name 
     * from a list of menu Items if found
     * null otherwise
     * @param name 
     * @return
     */
  
    public MenuItem searchMenuItem(String name) {
    	if (mList.size() == 0) {
			return null;
		}
		else {
			for (MenuItem item : mList) {
				if (name.equalsIgnoreCase(item.getName())) {
					return item;
				}
			}
			return null;
		}
    }

    /**
     * shows a menu for updating menu items
     * @return
     */
  
    private void updateMenu() {
    	System.out.println("\n~---------------------------------~");
		System.out.println("! What needs to be updated:       !");
		System.out.println("! 0. Nothing                      !");
		System.out.println("! 1. Name                         !");
		System.out.println("! 2. Description                  !");
		System.out.println("! 3. Price                        !");
		System.out.println("! 4. All                          !");
		System.out.println("~---------------------------------~");
		System.out.print("Enter an option: ");
        return;
    }

    /**
     * lists menu item details
     * @return
     */
    public void listMenuItems() {
    	if (mList.size() == 0) {
			System.out.println("Menu is empty");
		}
		else {
			for (MenuItem item : mList) {
				System.out.println("+----------------------------------------------+");
				System.out.println("ID: " + item.getId());
				System.out.println("Name: " + item.getName());
				System.out.println("Description: " + item.getDescription());
				System.out.printf("Price: $SGD%.2f\n" , item.getPrice() + "\n");
			}
		}
        return;
    }

    /**
     * searches and removes menu item by name and updates to file
     * @param name 
     * @return
     */
    public void removeMenuItem(String name) {
    	MenuItem item = searchMenuItem(name);
		if (item == null) {
			System.out.println("Menu item does not exist");
		}
		else {
			mList.remove(item);
			fileIO.writeObject(mList.toArray(), MenuItem.class);
			System.out.println("Menu item removed successfully!");
		}
    }

    /**
     * updates a menu item in the list and updates to file
     * @param name 
     * @return
     */
    public void updateMenuItem(String name) {
    	MenuItem item = searchMenuItem(name);
		int option = 1;
		float price = 0;
		if (item == null) {
			System.out.println("The menu item does not exist");
		}
		else {
			do {
				updateMenu();
				option = sc.nextInt();
				sc.nextLine();	// clear "\n" in the buffer
				switch (option) {
					case 0:
						System.out.println("Going back...");
						break;
					case 1:
						System.out.print("Enter new name: ");
						item.setName(sc.nextLine());
						System.out.println("Menu Item updated");
						fileIO.writeObject(mList.toArray(), MenuItem.class);
						break;
					case 2:
						System.out.print("Enter new description: ");
						item.setDescription(sc.nextLine());
						System.out.println("Menu Item updated");
						fileIO.writeObject(mList.toArray(), MenuItem.class);
						break;
					case 3:
						System.out.print("Enter new price: $");
						price = verifyPrice(price, "Enter new price: $");
						item.setPrice(price);
						sc.nextLine();	// clear the "\n" in the buffer
						System.out.println("Menu Item updated");
						fileIO.writeObject(mList.toArray(), MenuItem.class);
						break;
					case 4:
						System.out.print("Enter new name: ");
						item.setName(sc.nextLine());
						System.out.print("Enter new description: ");
						item.setDescription(sc.nextLine());
						System.out.print("Enter new price: $");
						price = verifyPrice(price, "Enter new price: $");
						item.setPrice(price);
						sc.nextLine();	// clear the "\n" in the buffer
						System.out.println("Menu Item updated");
						fileIO.writeObject(mList.toArray(), MenuItem.class);
					default: 
						System.out.println("No such option");
						break;
				}
			} while (option < 0 || option > 4);
		}
        return;
    }

    /**
     * to select a menu item from a list of menu items (i.e. listMenuItems())
     * searches for it and adds it
     * also have an option to exit out of this method
     * 
     * @return
     */
    public ArrayList<MenuItem> selectMenuItem() {
        // TODO implement here
    	ArrayList<MenuItem> mList = new ArrayList<MenuItem>();
		MenuItem item = null;
		String name = "";
		int option = 1;
		int tmp = 1;
		
		this.listMenuItems();
		
		while (option != 0) {
			System.out.println("Press 0 to quit");
			System.out.print("Enter menu item name: ");
			if (sc.hasNextInt()) {
				tmp = sc.nextInt();
				sc.nextLine();	// clear the "\n" in the buffer
				if (tmp == 0) {
					option = tmp;
				}
				else {
					System.out.println("Invalid integer");
				}
			}
			else {
				name = sc.nextLine();
				item = searchMenuItem(name);
				if (Objects.equals(item, null)) {
					System.out.println("Menu Item doesn't exist");
				}
				else {
					mList.add(item);
					System.out.println("Menu Item added successfully");
					item = null;
				}
			}
		}
		
		return mList;
    }

    /**
     * verifies if the user enters a float value 
     * 
     * 
     * @param price 
     * @param input 
     * @return price
     */
    private float verifyPrice(float price, String input) {
        // TODO implement here
        boolean invalid = true;
		
		while (invalid) {
			if (!sc.hasNextFloat()) {
				System.out.println("Invalid Price. Please enter a price");
				sc.nextLine();	// clear the input in the buffer
				System.out.print(input);
			}
			else {
				invalid = false;
				price = sc.nextFloat();
				sc.nextLine();	// clear the "\n" in the buffer
			}
		}
		
		return price;
    }
}