/**
 * 
 */
package Entity;

import java.io.Serializable;

import java.util.Objects;
import java.util.ArrayList;

import java.time.LocalDate;

//import Entity.OrderStatus;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 * @author CHNG QIHON <LCHNG002@e.ntu.edu.sg>
 * @author JIANG YUNJUN <YJIANG035@e.ntu.edu.sg>
 * @author NEO SUNWEN <SNEO020@e.ntu.edu.sg>
 * @author ZAKI BIN ZAINUDIN <ZAKI003@e.ntu.edu.sg>
 */
public class Reservation implements Serializable {
	/**
     * Default constructor
     */
    public Reservation() {
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1234L;

    /**
     * 
     */
    private int rezCode;

    /**
     * 
     */
    private Guest guest;

    /**
     * 
     */
    private Room room;

    /**
     * 
     */
    private LocalDate checkIn;

    /**
     * 
     */
    private LocalDate checkOut;

    /**
     * 
     */
    private int noAdults;

    /**
     * 
     */
    private int noKids;

    /**
     * 
     */
    private ReservationStatus rezStatus;

    /**
     * 
     */
    private ArrayList<RoomService> rsList;

    /**
     * Constructor for Reservation with one argument
     * @param count
     */
    public Reservation(int count) {
        // TODO implement here
    	this.rezCode = count;
		this.guest = null;
		this.room = null;
		this.checkIn = null;
		this.checkOut = null;
		this.noAdults = 0;
		this.noKids = 0;
		this.rezStatus = ReservationStatus.CONFIRMED;
		this.rsList = new ArrayList<RoomService>();
    }

    /**
     * @return
     */
    public int getRezCode() {
        // TODO implement here
        return rezCode;
    }

    /**
     * @param guest 
     * @return
     */
    public void setGuest(Guest guest) {
        // TODO implement here
    	this.guest = guest;
        return;
    }

    /**
     * @return
     */
    public Guest getGuest() {
        // TODO implement here
        return guest;
    }

    /**
     * @param room 
     * @return
     */
    public void setRoom(Room room) {
        // TODO implement here
    	this.room = room;
        return;
    }

    /**
     * @return
     */
    public Room getRoom() {
        // TODO implement here
        return room;
    }

    /**
     * @param checkIn 
     * @return
     */
    public void setCheckIn(LocalDate checkIn) {
        // TODO implement here
    	this.checkIn = checkIn;
        return;
    }

    /**
     * @return
     */
    public LocalDate getCheckIn() {
        // TODO implement here
        return checkIn;
    }

    /**
     * @param checkOut 
     * @return
     */
    public void setCheckOut(LocalDate checkOut) {
        // TODO implement here
    	this.checkOut = checkOut;
        return;
    }

    /**
     * @return
     */
    public LocalDate getCheckOut() {
        // TODO implement here
        return checkOut;
    }

    /**
     * @param noAdults 
     * @return
     */
    public void setNoAdults(int noAdults) {
        // TODO implement here
    	this.noAdults = noAdults;
        return;
    }

    /**
     * @return
     */
    public int getNoAdults() {
        // TODO implement here
        return noAdults;
    }

    /**
     * @param noKids 
     * @return
     */
    public void setNoKids(int noKids) {
        // TODO implement here
    	this.noKids = noKids;
        return;
    }

    /**
     * @return
     */
    public int getNoKids() {
        // TODO implement here
        return noKids;
    }

    /**
     * @param rezStatus
     */
    public void setRezStatus(ReservationStatus rezStatus) {
        // TODO implement here
    	this.rezStatus = rezStatus;
    }

    /**
     * @return
     */
    public ReservationStatus getRezStatus() {
        // TODO implement here
        return rezStatus;
    }

    /**
     * lists out reservation details
     * @return
     */
    public void printRezDetails() {
        // TODO implement here
    	System.out.println("-------------------------------------Reservation Details-----------------------------------------");
		System.out.println("\nReservation details:");
		System.out.println("Reservation Code: " + rezCode);
		System.out.println("Reservation Status: " + this.getRezStatus().toString());
		System.out.println("Check In Date: " + checkIn.toString());
		System.out.println("No of adults: " + this.getNoAdults());
		System.out.println("No of kids: " + this.getNoKids());
		System.out.println("\nGuest details:");
		System.out.println("Name: " + guest.getName());
		System.out.println("Passport: " + guest.getId());
		System.out.println("Gender: " + guest.getGender());
		System.out.println("Country: " + guest.getCountry());
		System.out.println("Nationality: " + guest.getNationality());
		System.out.println("Contact Number: " + guest.getContactNo());
		System.out.println("\nRoom details:");
		System.out.println("Room: " + String.format("%02d-%02d", room.getRLevel(), room.getRNo()));
		System.out.println("Room Type: " + room.getRType().toString());
		System.out.println("Bed Type: " + room.getBType().toString());
		System.out.println("Wifi Enabled: " + booleanToString(room.getWifi()));
		System.out.println("Smoking Allowed: " + booleanToString(room.getSmoking()));
		System.out.println("Room rate: $" + room.getRate() + " /day");
		System.out.println("\n***Your reservation will expire on failure to arrive after 1 day of the scheduled check-in date.***");
        return;
    }

    /**
     * checkout a reservation
     * @return
     */
    public void checkOut() {
        // TODO implement here
    	System.out.println("Checked out successfully!");
    	this.rezStatus = ReservationStatus.CHECKED_OUT;
        return;
    }

    /**
     * This method return a string depending on the binary response
	 * Returns "Yes" if true
	 * Returns "No" if false
     * @param response 
     * @return
     */
    private String booleanToString(boolean response) {
        // TODO implement here
    	if (response) {
			return "Yes";
		}
		else {
			return "No";
		}
    }

    /**
     * removes room occupation by setting status to VACANT
     * @return
     */
    public void removeRoomOccupancy() {
        // TODO implement here
    	this.room.setAvailStatus(AvailabilityStatus.VACANT);
		this.room = null;
        return;
    }

    /**
     * Print all ordered room services
     * @return
     */
    public void listRoomServices() {
        // TODO implement here
    	if (rsList.size() == 0) {
			System.out.println("No room services ordered");
			return;
		}
		System.out.println("Lists of room services ordered: ");
		for (RoomService rs : rsList) {
			rs.printOrderReceipt();
		}
        return;
    }

    /**
     * @param rs 
     * @return
     */
    public void addRoomService(RoomService rs) {
        // TODO implement here
    	System.out.println();
    	System.out.println();
		rs.printOrderReceipt();
		this.rsList.add(rs);
        return;
    }

    /**
     * @param rs 
     * @return
     */
    public void addRoomServiceWithoutPrintOrder(RoomService rs) {
        // TODO implement here
    	this.rsList.add(rs);
        return;
    }

    /**
     * @return
     */
    public ArrayList<RoomService> getRSList() {
        // TODO implement here
    	return this.rsList;
        
    }

    /**
     * @return
     */
    public void clearRSList() {
        // TODO implement here
    	this.rsList = new ArrayList<RoomService>();
        return;
    }

    /**
     * @return
     */
    public double getRSPrice() {
        // TODO implement here
    	return this.calcRoomService(rsList);
        
    }

    /**
     * @param rsList 
     * @return
     */
    public double calcRoomService(ArrayList<RoomService> rsList) {
        // TODO implement here
    	double rsTotal = 0;
		for (RoomService rs : rsList) {
			rsTotal += rs.getMenuItemGrandTotal();
		}
		return rsTotal;
        
    }

    /**
     * @param id 
     * @return
     */
    public RoomService getRSById(int id) {
        // TODO implement here
    	RoomService rs = null;
		
		for (RoomService tmp : rsList) {
			if (tmp.getId() == id) {
				rs = tmp;
				break;
			}
		}
        return rs;
    }

    /**
     * @param rs 
     * @return
     */
    public void removeRoomService(RoomService rs) {
        // TODO implement here
    	if (Objects.equals(rs, null)) {
			System.out.println("Room service does not exist!");
		}
		else {
			rsList.remove(rs);
		}
        return;
    }

}