/**
 * 
 */
package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

import Entity.RoomService;
import Entity.MenuItem;
import Entity.OrderStatus;

/**
 *
 */
public class RoomServiceManager {
	
    private ArrayList<RoomService> rsList;
    private FileIOHandler fileIO;
    private int count = 1;
    private Scanner sc;

    /**
     * Overloaded constructor for RoomServiceManager
     * some initialisation of few variables and
     * read room services from file
     * 
     * @param sc
     */
    public RoomServiceManager(Scanner sc) {
        // TODO implement here
    	rsList = new ArrayList<RoomService>();
		fileIO = new FileIOHandler();
		this.sc = sc;
		
		Object[] objArray = fileIO.readObject(RoomService.class);
		for (Object o : objArray) {
			RoomService rs = (RoomService) o;
			rsList.add(rs);
		}
		
		count = rsList.size() + 1;
    }

    /**
     * allows for placing orders for room service and
     * is added to list of room services and updated to file
     *  
     * @param mList 
     * @return
     */
    public RoomService orderRoomService(ArrayList<MenuItem> mList) {
    	RoomService rs = new RoomService();
		String remarks = "";
		System.out.print("Remarks: ");
		remarks = sc.nextLine();
		rs.placeOrder(count, remarks, mList);
		rsList.add(rs);
		fileIO.writeObject(rsList.toArray(), RoomService.class);
		count++;
		
		return rs;
    }
  
    /**
     * finds and removes room service if it exists and
     * updates it to file
     * 
     * @param rs 
     * @return
     */
    public void removeRoomService(RoomService rs) {
    	if (Objects.equals(rs, null)) {
			System.out.println("Room service does not exist");
			return;
		}
		else {
			rsList.remove(rs);
			fileIO.writeObject(rsList.toArray(), RoomService.class);
		}
        return;
    }

    /**
     * updates room service using the updateRoomServiceMenu() and
     * writes to file
     * @param rs 
     * @return
     */
    public void updateRoomService(RoomService rs) {
        // TODO implement here
    	int option = 0;
		
		if (Objects.equals(rs, null)) {
			System.out.println("Room service does not exist");
			return;
		}
		else {
			do {
				updateRoomServiceMenu();
				option = verifyOption(option, "Enter choice: ");
				switch (option) {
					case 1:
						rs.setOrderStatus(OrderStatus.CONFIRMED);
						break;
					case 2:
						rs.setOrderStatus(OrderStatus.PREPARING);
						break;
					case 3:
						rs.setOrderStatus(OrderStatus.DISPATCHED);
						break;
					case 4:
						rs.setOrderStatus(OrderStatus.DELIVERED);
						break;
					default:
						System.out.println("No such option");
						break;
				}
			} while (option != 1 && option != 2 && option != 3 && option != 4);
		}
		fileIO.writeObject(rsList.toArray(), RoomService.class);
        return;
    }

    /**
     * menu for updating room service details
     * @return
     */
    private void updateRoomServiceMenu() {
        // TODO implement here
    	System.out.println("\n~----------------------~");
		System.out.println("! Update order status: !");
		System.out.println("! 1. Confirmed         !");
		System.out.println("! 2. Preparing         !");
		System.out.println("! 3. Dispatched        !");
		System.out.println("! 4. Delivered         !");
		System.out.println("~----------------------`");
		System.out.print("Enter an option: ");
        return;
    }

    /**
     * assures that user enters an int
     * 
     * @param option 
     * @param input 
     * @return
     */
    private int verifyOption(int option, String input) {
        // TODO implement here
    	boolean invalid = true;
		
		while (invalid) {
			if (!sc.hasNextInt()) {
				System.out.println("Invalid input. Please enter an integer");
				sc.nextLine();
				System.out.print(input);
			}
			else {
				invalid = false;
				option = sc.nextInt();
				sc.nextLine();	// clear the "\n" in the buffer
			}
		}
		return option;
        
    }

    /**
     * return room service based on room id
     * @param id 
     * @return
     */
    public RoomService getRoomServiceById(int id) {
    	RoomService rs = null;
		for (RoomService tmp : rsList) {
			if (tmp.getId() == id) {
				rs = tmp;
				break;
			}
		}
		return rs;
    }
}