/**
 * 
 */
package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

import Entity.Reservation;
import Entity.Room;
import Entity.RoomService;
import Entity.AvailabilityStatus;
import Entity.Guest;
import Entity.ReservationStatus;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
//import java.time.LocalDateTime;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class ReservationManager extends Manager{
	/**
     * Default constructor
     */
    public ReservationManager() {
    }

    /**
     * 
     */
    private ArrayList<Reservation> rezList;

    /**
     * 
     */
    private FileIOHandler fileIO;

    /**
     * 
     */
    private GuestManager gMgr;

    /**
     * 
     */
    private RoomManager rMgr;

    /**
     * 
     */
    private RoomServiceManager rsMgr;

    /**
     * 
     */
    private int count = 1;

    /**
     * 
     */
    private Scanner sc;

    /**
     * Overloaded constructor for ReservationManager
     * used to initialise variables and 
     * retrieve reservations from the file
     * 
     * @param gMgr 
     * @param rMgr 
     * @param rsMgr 
     * @param sc
     */
    public ReservationManager(GuestManager gMgr, RoomManager rMgr, RoomServiceManager rsMgr, Scanner sc) {
        // TODO implement here
    	rezList = new ArrayList<Reservation>();
		fileIO = new FileIOHandler();
		this.gMgr = gMgr;
		this.rMgr = rMgr;
		this.rsMgr = rsMgr;
		this.sc = sc;
		
		Object[] objList = fileIO.readObject(Reservation.class);
		for (Object o : objList) {
			Reservation rez = (Reservation) o;
			Guest guest = gMgr.getGuestById(rez.getGuest().getGuestId());
			Room room = rMgr.getRoomById(rez.getRoom().getId());
			
			// set the proper room service object
			ArrayList<RoomService> rsList = rez.getRSList();
			if (rsList.size() > 0) {
				rez.clearRSList();
				for (RoomService rs1 : rsList) {
					RoomService rs = rsMgr.getRoomServiceById(rs1.getId());
					rez.addRoomServiceWithoutPrintOrder(rs);
				}
			}
			count = rezList.size() + 1;
			
			rez.setRoom(room);
			rez.setGuest(guest);
			rezList.add(rez);
		}
    }

    /**
     * creates and adds a new reservation to a reservation list and
     * writes to file
     * @return
     */
    public void newReservation() {
        // TODO implement here
    	Guest guest = gMgr.addGuest();
		
		// checking room
		Room room = null;
		String s;
		int validRoom = 0;
		while (Objects.equals(room, null)) {
			rMgr.listRoomsByOccupancyRate();
			
			do {
				System.out.print("Enter room number (level-number): ");
				s = sc.nextLine();
				validRoom = verifyRoom(s);
			} while (validRoom < 1);
			
			room = rMgr.returnVacantRoom(s);
		}
		
		Reservation rez = new Reservation(count);
		count++;
		int noAdults = 0;
		int noKids = 0;
		
		// set the check in date and reservation status
		System.out.print("Enter check in date (yyyymmdd): ");
		DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
		String time = "";
		time  = verifyTime(time, dateFormatter, "Enter date (yyyymmdd): ");
		rez.setCheckIn(LocalDate.parse(time, dateFormatter));
		rez.setRezStatus(ReservationStatus.CONFIRMED);
		room.setAvailStatus(AvailabilityStatus.RESERVED);
		
		rMgr.writeToFile();
		rez.setGuest(guest);
		rez.setRoom(room);
		
		// set the no of adults and children
		System.out.print("Enter no of adults: ");
		noAdults = verifyOption(noAdults, "Enter no of adults: ");
		rez.setNoAdults(noAdults);
		System.out.print("Enter no of kids: ");
		noKids = verifyOption(noKids, "Enter no of kids: ");
		rez.setNoKids(noKids);
				
		rezList.add(rez);
		
		fileIO.writeObject(rezList.toArray(), Reservation.class);
		
		rez.printRezDetails();
        return;
    }

    /**
     * searches and returns reservation if found
     * null otherwise
     * @return
     */
    public Reservation searchReservation() {
        // TODO implement here
    	String name;
		Reservation rez = null;
		
		System.out.print("Enter guest's name: ");
		name = sc.nextLine();
		
		for (Reservation tmp : rezList) {
			if (tmp.getGuest().getName().equals(name)) {
				rez = tmp;
				break;
			}
		}
		
		return rez;
        
    }

    /**
     * updates guest's details or room number based on reservation and
     * writes to file
     * @return
     */
    public void updateReservation() {
        // TODO implement here
    	int option = -1;
		Reservation rez = searchReservation();
		
		if (Objects.equals(rez, null)) {
			System.out.println("Reservation does not exist");
			return;
		}
		do {
			updateReservationMenu();
			option = verifyOption(option, "Enter an option: ");
			switch(option) {
				case 0:
					System.out.println("Going back...");
					break;
				case 1:
					gMgr.updateDetailsGuest(rez.getGuest());
					fileIO.writeObject(rezList.toArray(), Reservation.class);
					break;
				case 2:
					int noAdults = 0;
					System.out.print("Enter no of adults: ");
					noAdults = verifyOption(noAdults, "Enter no of adults: ");
					rez.setNoAdults(noAdults);
					fileIO.writeObject(rezList.toArray(), Reservation.class);
					break;
				case 3:
					int noKids = 0;
					System.out.print("Enter no of kids: ");
					noKids = verifyOption(noKids, "Enter no of kids: ");
					rez.setNoKids(noKids);
					fileIO.writeObject(rezList.toArray(), Reservation.class);
					break;
				default:
					System.out.println("No such option");
					break;
			}
		} while (option != 0 && option != 1 && option != 2);
        return;
    }

    /**
     * menu for update reservation
     * @return
     */
    private void updateReservationMenu() {
        // TODO implement here
    	System.out.println("\n~--------------------------------~");
		System.out.println("! What needs to be updated:      !");
		System.out.println("! 0. Nothing                     !");
		System.out.println("! 1. Update Guest Details        !");
		System.out.println("! 2. No of adults                !");
		System.out.println("! 3. No of children              !");
		System.out.println("~--------------------------------~");
		System.out.print("Enter an option: ");
        return;
    }

    /**
     * removes a reservation from the reservation list if found and
     * writes/updates to file
	 * prints error message otherwise
     * @return
     */
    public void removeReservation() {
        // TODO implement here
    	Reservation rez = searchReservation();
		
		if(Objects.equals(rez, null)) {
			System.out.println("Reservation does not exist");
		}
		else {
			rez.removeRoomOccupancy();
			rezList.remove(rez);
			fileIO.writeObject(rezList.toArray(), Reservation.class);
			rMgr.writeToFile();
			System.out.println("Reservation removed successfully");
		}
        return;
    }

    /**
     * prints the reservation details if found
     * error message otherwise
     * @return
     */
    public void printReservation() {
        // TODO implement here
    	Reservation rez = searchReservation();
		
		if(Objects.equals(rez, null)) {
			System.out.println("Reservation does not exist");
		}
		else {
			rez.printRezDetails();
		}
        return;
    }

    /**
     * prints all reservation which are currently not expired
     * @return
     */
    public void printAllReservations() {
        // TODO implement here
    	for (Reservation rez : rezList) {
			//if the date of the reservation check in has passed
			if(rez.getCheckIn().isBefore(LocalDate.now())) {
				//set reservation status to expired.
				rez.setRezStatus(ReservationStatus.EXPIRED);
			}
			if (rez.getRezStatus() != ReservationStatus.EXPIRED) {
				rez.printRezDetails();
			}
		}
        return;
    }

    /**
     * adds room service to reservation and 
     * writes to file
     * @param rez 
     * @param rs 
     * @return
     */
    public void addRoomService(Reservation rez, RoomService rs) {
        // TODO implement here
    	rez.addRoomService(rs);
		fileIO.writeObject(rezList.toArray(), Reservation.class);
        return;
    }

    /**
     * assures user enters an int
     * @param option 
     * @param input 
     * @return
     */
    protected int verifyOption(int option, String input) {
        // TODO implement here
    	boolean invalid = true;
		
		while (invalid) {
			if (!sc.hasNextInt()) {
				System.out.println("Invalid Input. Please enter an integer");
				sc.nextLine();	// clear the input in the buffer
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
     * if valid room number is entered -> 1
     * else -> 0
     * thus assuring user always enters right room number
     * @param room 
     * @return
     */
    private int verifyRoom(String room) {
        // TODO implement here
    	int isNum1 = 0, isNum2 = 0;
		if (!room.contains("-")) {
			System.out.println("Invalid room");
			return 0;
		}
		else {
			String[] part = room.split("-");
			if (part.length == 2) {
				isNum1 = isInt(part[0]);
				isNum2 = isInt(part[1]);
			}
			if (isNum1==0 || isNum2==0) {
				System.out.println("Invalid room");
				return 0;
			}
		}
		return 1;
        
    }

    /**
     * checks if input is an int
     * @param input 
     * @return
     */
    private int isInt(String input) {
        // TODO implement here
    	try {
			Integer.parseInt(input);
			return 1;
		}
		catch (Exception exception) {
			return 0;
		}
        
    }

    /**
     * remove a valid room service from reservation and room service manager and
     * updates to file
     * @return
     */
    public void removeRoomService() {
        // TODO implement here
    	Reservation reZ = searchReservation();
		if (Objects.equals(reZ, null)) {
			System.out.println("Reservation does not exist");
			return;
		}
		else {
			reZ.listRoomServices();
			if (reZ.getRSList().size() == 0) {
				return;
			}
			else {
				int id = -1;
				System.out.print("Enter room service id: ");
				id = verifyOption(id, "Enter room service id: ");
				RoomService rs = reZ.getRSById(id);
				if (Objects.equals(rs, null)) {
					System.out.println("Room Service does not exist");
				}
				else {
					rsMgr.removeRoomService(rs);
					reZ.removeRoomService(rs);
					fileIO.writeObject(rezList.toArray(), Reservation.class);
				}
			}
		}
        return;
    }

    /**
     * allow user to update room service status
     * @return
     */
    public void updateRoomService() {
        // TODO implement here
    	Reservation rez = searchReservation();
		if (Objects.equals(rez, null)) {
			System.out.println("Reservation does not exist");
			return;
		}
		else {
			rez.listRoomServices();
			if (rez.getRSList().size() == 0) {
				return;
			}
			else {
				int id = -1;
				System.out.print("Enter room service id: ");
				id = verifyOption(id, "Enter room service id: ");
				RoomService rs = rez.getRSById(id);
				if (Objects.equals(rs, null)) {
					System.out.println("Room Service does not exist");
				}
				else {
					rsMgr.updateRoomService(rs);
				}
			}
		}
        return;
    }

    /**
     * searches a reservation and print all the room services for that reservation
     * @return
     */
    public void printRoomService() {
        // TODO implement here
    	Reservation rez = searchReservation();
		if (Objects.equals(rez, null)) {
			System.out.println("Reservation does not exist");
		}
		else {
			rez.listRoomServices();
		}
        return;
    }

    /**
     * assures that user enters a valid time and according to the format specified
     * @param time 
     * @param date 
     * @param input
     * @return 
     * @return time
     */
    private String verifyTime(String time, DateTimeFormatter date, String input) {
        // TODO implement here
    	boolean invalid = true;
		time = sc.nextLine();
		
		while (invalid) {
			try {
				LocalDate.parse(time, date);
			}
			catch (DateTimeParseException exception) {
				invalid = true;
				System.out.println("Invalid date. Please enter a valid date (yyyymmdd).");
				System.out.print(input);
				time = sc.nextLine();
				continue;
			}
			invalid = false;
		}
		return time;
    }

    /**
     * allows the guest to check in without a reservation and
     * updates to file
     * @return
     */
    public void checkIn() {
        // TODO implement here
    	Guest guest = gMgr.addGuest();
		
		// checking room
		Room room = null;
		String s;
		int validRoom = 0;
		while (Objects.equals(room, null)) {
			rMgr.listRoomsByOccupancyRate();
			
			do {
				System.out.print("Enter room number (level-number): ");
				s = sc.nextLine();
				validRoom = verifyRoom(s);
			} while (validRoom < 1);
			
			room = rMgr.returnVacantRoom(s);
		}
		
		Reservation r = new Reservation(count);
		int noOfAdults = 0, noOfChildren = 0;
		
		r.setCheckIn(LocalDate.now());
		r.setRezStatus(ReservationStatus.CHECKED_IN);
		room.setAvailStatus(AvailabilityStatus.OCCUPIED);
		
		rMgr.writeToFile();
		r.setGuest(guest);
		r.setRoom(room);
		
		// set the no of adults and children
		System.out.print("Enter no of adults: ");
		noOfAdults = verifyOption(noOfAdults, "Enter no of adults: ");
		r.setNoAdults(noOfAdults);
		System.out.print("Enter no of kids: ");
		noOfChildren = verifyOption(noOfChildren, "Enter no of kids: ");
		r.setNoKids(noOfChildren);
				
		rezList.add(r);
		
		fileIO.writeObject(rezList.toArray(), Reservation.class);
		
		r.printRezDetails();
        return;
    }

    /**
     * guest check in using a valid reservation and
     * updates to file
     * @param rez 
     * @return
     */
    public void checkIn(Reservation rez) {
        // TODO implement here
    	if (Objects.equals(rez, null)) {
			System.out.println("Reservation does not exist");
			return;
		}
		else {
			if (rez.getRezStatus() == ReservationStatus.CONFIRMED) {
				rez.setRezStatus(ReservationStatus.CHECKED_IN);
				rez.getRoom().setAvailStatus(AvailabilityStatus.OCCUPIED);
				fileIO.writeObject(rezList.toArray(), Reservation.class);
				rMgr.writeToFile();
				System.out.println("Guest checked in successfully");
			}
			else {
				System.out.println("Reservation does not exist");
			}
		}
        return;
    }

    /**
     * sets reservation status to expired 
     * @return
     */
    public void expireReservation() {
        // TODO implement here
    	Reservation rez = searchReservation();
		if (Objects.equals(rez, null)) {
			System.out.println("Reservation does not exist");
			return;
		}
		else {
			rez.setRezStatus(ReservationStatus.EXPIRED);
		}
        return;
    }

    /**
     * check out the guest from the hotel and
     * update to file
     * @return
     */
    public Reservation checkOut() {
        // TODO implement here
    	Reservation rez = null;
		rez = searchReservation();
		if (Objects.equals(rez, null)) {
			System.out.println("Reservation does not exist");
			return rez;
		}
		else {
			rez.getRoom().setAvailStatus(AvailabilityStatus.VACANT);
			rez.setCheckOut(LocalDate.now());
			rez.setRezStatus(ReservationStatus.CHECKED_OUT);
			
			fileIO.writeObject(rezList.toArray(), Reservation.class);
			rMgr.writeToFile();
			
			return rez;
		}
    }
}