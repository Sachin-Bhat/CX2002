/**
 * 
 */
package Boundary;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import Control.GuestManager;
import Control.MenuItemManager;
import Control.ReservationManager;
import Control.RoomManager;
import Control.RoomServiceManager;
import Entity.Bill;
import Entity.CheckOutBill;
import Entity.MenuItem;
import Entity.Payment;
import Entity.Reservation;
import Entity.RoomService;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class HotelApp {
	/**
     * Default constructor
     */
    public HotelApp() {
    }

    /**
     * @return
     */
    public static void main() {
        // TODO implement here
    	Scanner sc = new Scanner(System.in);
		RoomManager rMgr = new RoomManager(sc);
		GuestManager gMgr = new GuestManager(sc);
		MenuItemManager mMgr = new MenuItemManager(sc);
		RoomServiceManager rsMgr = new RoomServiceManager(sc);
		ReservationManager rezMgr = new ReservationManager(gMgr, rMgr, rsMgr, sc);
		
		int option = -1;
		
		do {
			menu();
			option = verifyOption(option, sc);
			switch (option) {
				case 0:
					System.out.println("Bye Bye!!");
					sc.close();
					break;
				case 1:
					guestOption(gMgr, sc);
					break;
				case 2:
					roomOption(rezMgr, rMgr, sc);
					break;
				case 3:
					rezOption(gMgr, rMgr, rezMgr, rsMgr, mMgr, sc);
					break;
				case 4:
					menuItemOption(mMgr, sc);
					break;
				case 5:
					roomServiceOption(rezMgr, rsMgr, mMgr, sc);
					break;
				case 6:
					checkInCheckOutExpiredOption(rezMgr, sc);
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
			
		}while (option != 0);
		

		
		//functions:
//		1. Create/Update/Search guests detail (Search by name using keyword/s)
//		2. Create/Update/Remove/Print reservation
//		3. Create/Update rooms details (include setting status "like Under Maintenance",
//		4. Entering room service orders - list menu items for selection
//		5. Create/Update/Remove room service menu items.
//		6. Check room availability
//		7. Room Check-in (for walk-in or reservation)
//		8. Room Check-out and print bill invoice (with breakdowns on days of stay, room service order items
//		and its total, tax and total amount)
        return;
    }

    /**
     * @return
     */
    private static void menu() {
        // TODO implement here
    	System.out.println("\n~-----------------------------------------------------~");
		System.out.println("! Welcome to the Hotel Reservation and Payment System !");
		System.out.println("! What would you like to do?                          !");
		System.out.println("! 0. Exit the program                                 !");
		System.out.println("! 1. Update/Search guest details                      !");
		System.out.println("! 2. Create/Update/List/Get details room              !");
		System.out.println("! 3. Create/Update/Remove/Print reservation           !");
		System.out.println("! 4. Create/Update/Remove/List menu items             !");
		System.out.println("! 5. Create/Update/Remove/Print room service          !");
		System.out.println("! 6. Guest Check In/Check Out/Expire Reservation      !");
		System.out.println("~-----------------------------------------------------~");
		System.out.print("Enter option: ");
        return;
    }

    /**
     * @return
     */
    private static void guestMenu() {
        // TODO implement here
    	System.out.println("\n~------------------------------------------~");
		System.out.println("! What would you like to do ?              !");
		System.out.println("! 0. Go back                               !");
		System.out.println("! 1. Update guest details                  !");
		System.out.println("! 2. Search for guest and list its details !");
		System.out.println("~------------------------------------------~");
		System.out.print("Enter option: ");
        return;
    }

    /**
     * @param gMgr 
     * @param sc 
     * @return
     */
    private static void guestOption(GuestManager gMgr, Scanner sc) {
        // TODO implement here
    	int option = -1;
		String name;
		do {
			guestMenu();
			option = verifyOption(option, sc);
			switch (option) {
				case 0:
					System.out.println("Going back...");
					break;
				case 1:
					System.out.print("Search guest's name: ");
					name = sc.nextLine();
					gMgr.updateDetailsGuest(name);
					break;
				case 2:
					System.out.print("Search guest's name: ");
					name = sc.nextLine();
					gMgr.listDetailsGuest(name);
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		}while (option != 0 && option != 1 && option != 2);
        return;
    }

    /**
     * @return
     */
    private static void menuItemMenu() {
        // TODO implement here
    	System.out.println("\n~------------------------------------------~");
		System.out.println("! What would you like to do ?              !");
		System.out.println("! 0. Go back                               !");
		System.out.println("! 1. Create new menu item                  !");
		System.out.println("! 2. Update menu item                      !");
		System.out.println("! 3. Remove menu item                      !");
		System.out.println("! 4. List all menu items                   !");
		System.out.println("~------------------------------------------~");
		System.out.print("Enter option: ");
        return;
    }

    /**
     * @param mMgr 
     * @param sc 
     * @return
     */
    private static void menuItemOption(MenuItemManager mMgr, Scanner sc) {
        // TODO implement here
    	int option = -1;
		
		do {
			menuItemMenu();
			option = verifyOption(option, sc);
			switch (option) {
				case 0:
					System.out.println("Going back...");
					break;
				case 1:
					mMgr.addMenuItem();
					break;
				case 2:
					System.out.print("Enter menu item name: ");
					mMgr.updateMenuItem(sc.nextLine());;
					break;
				case 3:
					System.out.print("Enter menu item name: ");
					mMgr.removeMenuItem(sc.nextLine());
					break;
				case 4:
					mMgr.listMenuItems();
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		} while (option != 0 && option != 1 && option != 2 && option != 3 && option != 4);
        return;
    }

    /**
     * @return
     */
    private static void roomMenu() {
        // TODO implement here
    	System.out.println("\n~------------------------------------------~");
		System.out.println("! What would you like to do ?              !");
		System.out.println("! 0. Go back                               !");
		System.out.println("! 1. Create new room                       !");
		System.out.println("! 2. Update room details                   !");
		System.out.println("! 3. List Room                             !");
		System.out.println("! 4. Check room details                    !");
		System.out.println("~------------------------------------------~");
		System.out.print("Enter option: ");
        return;
    }

    /**
     * @param rezMgr 
     * @param rMgr 
     * @param sc 
     * @return
     */
    private static void roomOption(ReservationManager rezMgr, RoomManager rMgr, Scanner sc) {
        // TODO implement here
    	int option = -1;
		
		do {
			roomMenu();
			option = verifyOption(option, sc);
			switch (option) {
				case 0:
					System.out.println("Going back...");
					break;
				case 1:
					rMgr.addRoom();
					break;
				case 2:
					System.out.print("Enter room (level-number): ");
					rMgr.updateRoom(sc.nextLine());
					break;
				case 3:
					listRoom(rMgr, sc);
					break;
				case 4: //Check room details

					//prompt for option to search by guest name or room id.	
					getRoomDetails(rezMgr, rMgr,sc);
					
			        //l
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		} while (option != 0 && option != 1 && option != 2 && option != 3);
        return;
    }

    /**
     * @return
     */
    private static void listRoomDetailsMenu() {
        // TODO implement here
    	System.out.println("\n~--------------------------------~");
		System.out.println("! Get Room details by:           !");
		System.out.println("! 1. Room number                 !");
		System.out.println("! 2. Guest name                  !");
		System.out.println("~--------------------------------~");
		System.out.print("Enter option: ");
        return;
    }

    /**
     * @param rezMgr 
     * @param rMgr 
     * @param sc 
     * @return
     */
    private static void getRoomDetails(ReservationManager rezMgr, RoomManager rMgr, Scanner sc) {
        // TODO implement here
    	int option = -1;
		do {
			listRoomDetailsMenu();
			option = verifyOption(option, sc);
			switch (option) {
				case 1: //search for room by room number id.
					System.out.print("Please enter the room number: ");
					String roomNo = sc.nextLine();		
					rMgr.listRoomDetailsByRNo(roomNo);
					break;
				case 2: //search for room by guest name.
					
					Reservation rez = rezMgr.searchReservation();
					if(rez == null) {
						System.out.println("You have entered an invalid guest name.");
					}else {
						rMgr.listRoomDetails(rez.getRoom());
					}
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		} while (option != 1 && option != 2);
        return;
    }

    /**
     * @return
     */
    private static void listRoomMenu() {
        // TODO implement here
    	System.out.println("\n~--------------------------------~");
		System.out.println("! Select display type:           !");
		System.out.println("! 1. List Room by occupancy rate !");
		System.out.println("! 2. List Room by room status    !");
		System.out.println("~--------------------------------~");
		System.out.print("Enter option: ");
        return;
    }

    /**
     * @param rMgr 
     * @param sc 
     * @return
     */
    private static void listRoom(RoomManager rMgr, Scanner sc) {
        // TODO implement here
    	int option = -1;
		do {
			listRoomMenu();
			option = verifyOption(option, sc);
			switch (option) {
				case 1:
					rMgr.listRoomsByOccupancyRate();
					break;
				case 2:
					rMgr.listRoomsByRoomStatus();
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		} while (option != 1 && option != 2);
        return;
    }

    /**
     * @return
     */
    private static void rezMenu() {
        // TODO implement here
    	System.out.println("\n~-------------------------------~");
		System.out.println("! What would you like to do ?   !");
		System.out.println("! 0. Go back                    !");
		System.out.println("! 1. Create reservation         !");
		System.out.println("! 2. Update reservation detail  !");
		System.out.println("! 3. Remove reservation         !");
		System.out.println("! 4. Print a reservation detail !");
		System.out.println("! 5. Print all reservations     !");
		System.out.println("~-------------------------------~");
		System.out.print("Enter option: ");
        return;
    }

    /**
     * @param gMgr 
     * @param rMgr 
     * @param rsMgr 
     * @param mMgr 
     * @param sc 
     * @return
     */
    private static void rezOption(GuestManager gMgr, RoomManager rMgr, ReservationManager rezMgr, RoomServiceManager rsMgr, MenuItemManager mMgr, Scanner sc) {
        // TODO implement here
    	int option = -1;
		
		do {
			rezMenu();
			option = verifyOption(option, sc);
			switch(option) {
				case 0:
					System.out.println("Going back...");
					break;
				case 1:

					rezMgr.newReservation();
					break;
				case 2:
					rezMgr.updateReservation();
					break;
				case 3:
					rezMgr.removeReservation();
					break;
				case 4:
					rezMgr.printReservation();
					break;
				case 5:
					rezMgr.printAllReservations();
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		} while (option != 0 && option != 1 && option != 2 && option != 3 && option != 4);
        return;
    }

    /**
     * @return
     */
    private static void roomServiceMenu() {
        // TODO implement here
    	System.out.println("\n~-----------------------------~");
		System.out.println("! What would you like to do ? !");
		System.out.println("! 0. Go back                  !");
		System.out.println("! 1. Add room service         !");
		System.out.println("! 2. Update room service      !");
		System.out.println("! 3. Remove room service      !");
		System.out.println("! 4. Print all room service   !");
		System.out.println("~-----------------------------~");
		System.out.print("Enter option: ");
        return;
    }

    /**
     * @param rezMgr 
     * @param rsMgr 
     * @param mMgr 
     * @param sc 
     * @return
     */
    private static void roomServiceOption(ReservationManager rezMgr, RoomServiceManager rsMgr, MenuItemManager mMgr, Scanner sc) {
        // TODO implement here
    	int option = -1;
		
		do {
			roomServiceMenu();
			option = verifyOption(option, sc);
			switch (option) {
				case 0:
					System.out.println("Going back...");
					break;
				case 1:
					addRoomService(rezMgr, rsMgr, mMgr);
					break;
				case 2:
					rezMgr.updateRoomService();
					break;
				case 3:
					rezMgr.removeRoomService();
					break;
				case 4:
					rezMgr.printRoomService();
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		} while (option != 0 && option != 1 && option != 2);
        return;
    }

    /**
     * @param rezMgr 
     * @param rsMgr 
     * @param mMgr 
     * @return
     */
    private static void addRoomService(ReservationManager rezMgr, RoomServiceManager rsMgr, MenuItemManager mMgr) {
        // TODO implement here
    	Reservation rez = rezMgr.searchReservation();
		if (Objects.equals(rez, null)) {
			System.out.println("Guest does not exist");
			return;
		}
					
		ArrayList<MenuItem> mList = new ArrayList<MenuItem>();
		System.out.println("");
		mList = mMgr.selectMenuItem();
		if (mList.size() == 0) {
			System.out.println("Menu Item List is empty. Exiting...");
			return;
		}
		
		RoomService rs = rsMgr.orderRoomService(mList);
		rezMgr.addRoomService(rez, rs);
		
		System.out.println("Service Added Successfully!");
        return;
    }

    /**
     * @return
     */
    private static void checkInCheckOutExpiredMenu() {
        // TODO implement here
    	System.out.println("\n~---------------------------------~");
		System.out.println("! What would you like to do ?     !");
		System.out.println("! 0. Go back                      !");
		System.out.println("! 1. Guest Check In (Walk In)     !");
		System.out.println("! 2. Guest Check In (Reservation) !");
		System.out.println("! 3. Guest Check Out              !");
		System.out.println("! 4. Expire a reservation         !");
		System.out.println("~---------------------------------~");
		System.out.print("Enter option: ");
        return;
    }

    /**
     * @param rezMgr 
     * @param sc 
     * @return
     */
    private static void checkInCheckOutExpiredOption(ReservationManager rezMgr, Scanner sc) {
        // TODO implement here
    	int option = 0;
		
		do {
			checkInCheckOutExpiredMenu();
			option = verifyOption(option, sc);
			switch (option) {
				case 0:
					System.out.println("Going back...");
					break;
				case 1:
					rezMgr.checkIn();
					break;
				case 2:
					rezMgr.checkIn(rezMgr.searchReservation());
					break;
				case 3:
					checkOut(rezMgr, sc);
					break;
				case 4:
					rezMgr.expireReservation();
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		} while (option != 0 && option != 1 && option != 2 && option != 3);
        return;
    }

    /**
     * @param rezMgr 
     * @param sc 
     * @return
     */
    private static void checkOut(ReservationManager rezMgr, Scanner sc) {
        // TODO implement here
    	Reservation rez = rezMgr.checkOut();
		
		if (!Objects.equals(rez, null)) {
			Payment p = new Payment(rez, sc);
			Bill bill = new CheckOutBill(rez.getRSList(), p);
			p.invoiceSummary(bill);
			p.paymentByCashOrCredit();
		}
        return;
    }

    /**
     * @param option 
     * @param sc 
     * @return
     */
    private static int verifyOption(int option, Scanner sc) {
        // TODO implement here
    	boolean invalid = true;
		
		while (invalid) {
			if (!sc.hasNextInt()) {
				System.out.println("Invalid input type. Please enter an integer!");
				sc.nextLine();	// clear the input in the buffer (if any)
				System.out.print("Enter an option: ");
			}
			else {
				invalid = false;
				option = sc.nextInt();
				sc.nextLine();	// clear the "\n" in the buffer (if any)
			}
		}
        return option;
    }
}