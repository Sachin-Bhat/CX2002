
package Control;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Objects;

import Entity.Reservation;
import Entity.Room;
import Entity.RoomService;
import Entity.Guest;
import Entity.ReservationStatus;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import java.io.*;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class ReservationManager {
	/**
	 * Default constructor
	 */
	public ReservationManager() {}
	
	
	private ArrayList<Reservation> rezList;
	private FileIOHandler fileIO;
	private GuestManager gMgr;
	private RoomManager rMgr;
	private RoomServiceManager rsMgr;
	private int count = 1;
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
		this.gMgr = gMgr;
		this.rMgr = rMgr;
		this.rsMgr = rsMgr;
		
		this.sc = sc;
		this.rezList = new ArrayList<Reservation>();
		fileIO = new FileIOHandler();
		
		Object[] objList = fileIO.readObject(Reservation.class);
		for (Object o : objList) {
			Reservation rs = (Reservation) o;
			rezList.add(rs);
		}
		this.count = this.rezList.size() + 1;
		
		
	}

	/**
	 * creates and adds a new reservation to a reservation list and
	 * writes to file
	 * @return
	 */
	public void newReservation() {
		// TODO implement here
		
		int input;
		int month, day, year;
		Reservation rs = new Reservation(this.count);
		//get & set values for this rs
		
		Guest guest = new Guest(); //not sure
		Room room = new Room();
		rs.setGuest(guest);
		rs.setRoom(room);
		
		
		
		System.out.print("Enter number of adults: ");
		input = sc.nextInt();
		rs.setNoAdults(input);
		
		
		System.out.print("Enter number of kids: ");
		input = sc.nextInt();
		rs.setNoKids(input);
		
		if (rs.getCheckIn() == null) {
			System.out.print("Enter check-in year: ");
			year = sc.nextInt();
			System.out.print("Enter check-in month: ");
			month = sc.nextInt();
			System.out.print("Enter check-in day: ");
			day = sc.nextInt();
			
			LocalDate inDate = LocalDate.of(year, Month.of(month), day);
			rs.setCheckIn(inDate);
		
		}
		
		if (rs.getCheckOut() == null) {
			System.out.print("Enter check-out year: ");
			year = sc.nextInt();
			System.out.print("Enter check-out month: ");
			month = sc.nextInt();
			System.out.print("Enter check-out day: ");
			day = sc.nextInt();
			
			LocalDate outDate = LocalDate.of(year, Month.of(month), day);
			rs.setCheckOut(outDate);
		}
		
		
		if (room.getAvailStatus() == AvailabilityStatus.OCCUPIED || room.getAvailStatus() == AvailabilityStatus.RESERVED) {
			rs.setRezStatus(ReservationStatus.WAITLIST);
		}
		
		else rs.setRezStatus(ReservationStatus.CONFIRMED);
		
		this.rezList.add(rs);
		
		
		//write to file
		this.fileIO.writeSingleObject(rs, Reservation); //wtf
		
		this.count++; 
		return;
	}

	/**
	 * searches and returns reservation if found
	 * null otherwise
	 * @return
	 */
	public Reservation searchReservation(int targetCode) { //should have a name option? idk
		// TODO implement here
		int tempCode;
		
		for(int i=0; i<this.count; i++) {
			
			tempCode = this.rezList.get(i).getRezCode();
			
			if(tempCode == targetCode) return this.rezList.get(i);
			
		}
		
		return null;
	}
	
	public Reservation searchReservation(String name) { //should have a name option? idk
		// TODO implement here
		String tempName;
		
		for(int i=0; i<this.count; i++) {
			
			tempName = this.rezList.get(i).getGuest().getName();
			
			if(tempName.equals(name)) return this.rezList.get(i);
			
		}
		
		return null;
	}
	
	

	/**
	 * updates guest's details or room number based on reservation and
	 * writes to file
	 * @return
	 */
	public void updateReservation() {
		// TODO implement here
		System.out.print("Enter the reservation number: ");
		int targetNum = sc.nextInt();
		Reservation target = searchReservation((int) targetNum);
		
		if (target == null) {
			System.out.println("Not found");
			return;
			}
		
		else {
			
			updateReservationMenu();
			
			int input = sc.nextInt();
			
			switch(input) {
			case 1:
				Guest tempGuest = target.getGuest();
				System.out.printf("Enter new guest name: ");
				tempGuest.setName(sc.next());
				target.setGuest(tempGuest);
				break;
				
			case 2:
				Room tempRoom = target.getRoom();
				System.out.printf("Enter new room number: ");
				tempRoom.setNumber(sc.nextInt());
				target.setRoom(tempRoom);
				break;
				
			case 3:
				System.out.printf("Current check-in date: %s", target.getCheckIn());
				System.out.printf("Current check-out date: ", target.getCheckOut());
				
				System.out.printf("Enter new check-in date: ");
				target.setCheckIn(null);
				
				System.out.printf("Enter new check-out date: ");
				target.setCheckOut(null);
			
			}
			
			
			
			
			
		}
		
		
		return;
	}

	/**
	 * menu for update reservation
	 * @return
	 */
	private void updateReservationMenu() {
		// TODO implement here
		System.out.println("What would you like to update?");
		System.out.println("1: Guest Details");
		System.out.println("2: Room number");
		System.out.println("3: Check-in/out dates");
		
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
		System.out.printf("Input the reservation number to be removed: ");
		
		int target = sc.nextInt();
		
		Reservation tempRez = searchReservation(target);
		
		if (tempRez != null) rezList.remove(tempRez);
		else System.out.println("Not found");
		
		return;
	}

	/**
	 * prints the reservation details if found
	 * error message otherwise
	 * @return
	 */
	public void printReservation() {
		// TODO implement here
		System.out.printf("Input the reservation number to be queried: ");
		
		int target = sc.nextInt();
		
		Reservation tempRez = searchReservation(target);
		
		if (tempRez != null) tempRez.printRezDetails();
		else System.out.println("Not found");
		
		return;
	}

	/**
	 * prints all reservation which are currently not expired
	 * @return
	 */
	public void printAllReservations() {
		// TODO implement here
		for(int i=0; i<this.count; i++) {
			Reservation tempRez = this.rezList.get(i);
			ReservationStatus tempstat = tempRez.getRezStatus();
			
			if(tempstat != ReservationStatus.EXPIRED) {
				System.out.printf("%s\t\t", tempRez.getRezCode());
				System.out.printf("%s", tempstat);
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
		
		return;
	}

	/**
	 * assures user enters an int
	 * @param option 
	 * @param input 
	 * @return
	 */
	private int verifyOption(int option, String input) {
		// TODO implement here
		
		if (isInt(input) == 1 && Integer.valueOf(input) == option) return 1; //how do we know what option they want??
		
		return 0;
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
		
		if (isInt(room) == 1) return 1;
		
		return 0;
	}

	/**
	 * checks if input is an int
	 * @param input 
	 * @return
	 */
	private int isInt(String input) {
		// TODO implement here
		Scanner sc = new Scanner(input.trim());
	    if(!sc.hasNextInt(10)) return 0;
	    // we know it starts with a valid int, now make sure there's nothing left
	    sc.nextInt(10);
	    if (sc.hasNext()) return 0;
	    else return 1;
	}

	/**
	 * remove a valid room service from reservation and room service manager and
	 * updates to file
	 * @return
	 */
	public void removeRoomService() { //is this through room service id?
		// TODO implement here
		int targetNum;
		System.out.print("Enter the reservation number: ");
		String input = sc.next();
		
		if (isInt(input) == 1) targetNum = Integer.parseInt(input);
		Reservation tempRez = searchReservation(targetNum);
		
		if (tempRez == null) {
			System.out.printf("Not found");
			return;
		}
		
		return;
	}

	/**
	 * allow user to update room service status
	 * @return
	 */
	public void updateRoomService() {
		// TODO implement here
		//find
		
		//get set
		
		//write
		
		return;
	}

	/**
	 * searches a reservation and print all the room services for that reservation
	 * @return
	 */
	public void printRoomService() {
		// TODO implement here
		
		
		
		
		
		return;
	}

	/**
	 * assures that user enters a valid time and according to the format specified
	 * @param time 
	 * @param date 
	 * @param input
	 * @return time
	 */
	private void verifyTime(String time, DateTimeFormatter date, String input) {
		// TODO implement here
	}

	/**
	 * allows the guest to check in without a reservation and
	 * updates to file
	 * @return
	 */
	public void checkIn() {
		// TODO implement here
		
		
		
		
		
		return;
	}

	/**
	 * guest check in using a valid reservation and
	 * updates to file
	 * @param rez 
	 * @return
	 */
	public void checkIn(Reservation rez) {		
		rez.setRezStatus(ReservationStatus.CHECKED_IN);
		
		
		//TODO update to file
		return;
	}

	/**
	 * sets reservation status to expired 
	 * @return
	 */
	public void expireReservation(Reservation rez) {
		// TODO implement here
		
		if (rez.getCheckIn().isAfter(LocalDate.now())) rez.setRezStatus(ReservationStatus.EXPIRED);
		else {
			System.out.println("Date is not past today yet, continue?(Y/N)"); //need manual override?
			char option = sc.next().charAt(0);
			if (Character.compare(option, 'Y') == 0) rez.setRezStatus(ReservationStatus.EXPIRED);
		}
		
		return;
	}

	/**
	 * check out the guest from the hotel and
	 * update to file
	 * @return
	 */
	public Reservation checkOut(Reservation rez) {
		// TODO implement here
		
		rez.setRezStatus(ReservationStatus.CHECKED_OUT);
		
		return null;
	}
}

