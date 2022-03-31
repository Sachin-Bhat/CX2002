import java.time.LocalDate;
import java.util.ArrayList;

public class Reservation {

	private int rezCode;
	private Guest guest;
	private Room room;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private int noAdults;
	private int noKids;
	
	private ReservationStatus rezStatus;
	
	private ArrayList<RoomService> rsList;
	
	public Reservation(int count) { //clarify on parameter
		
		
		
	}
	
	public int getRezCode() {
		return this.rezCode;
	}
	
	public void setGuest(Guest guest) {
		this.guest = guest;
		return;
	}
	
	public Guest getGuest() {
		return this.guest;
	}
	
	public void setRoom(Room room) {
		this.room = room;
		return;
	}
	
	
	public Room getRoom() {
		return this.room;
	}
	
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
		return;
	}
	
	public LocalDate getCheckIn() {
		return this.checkIn;
	}
	
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	
	public LocalDate getCheckOut() {
		return this.checkOut;
	}
	
	public void setNoAdults(int number) {
		this.noAdults = number;
		return;
	}
	
	public int getNoAdults() {
		return this.noAdults;
	}
	
	public void setNoKids(int number) {
		this.noKids = number;
		return;
	}
	
	public int getNoKids() {
		return this.noKids;
	}
	
	public void setRezStatus(ReservationStatus status) {
		this.rezStatus = status;
		return;
	}
	
	public ReservationStatus getRezStatus() {
		return this.rezStatus;
	}
	
	public void printRezDetails() { 
		System.out.printf("Reservation number: %d \n", this.rezCode);
		System.out.printf("Guest name: %s \n", this.guest.getName()); //check how to access guest name
		System.out.printf("Room number: %d \n", this.room.getId()); //check how to access room number
		System.out.printf("Check-in date: %s \n", this.checkIn);
		System.out.printf("Check-out date: %s \n", this.checkOut);
		System.out.printf("Number of adults: %d \n", this.noAdults);
		System.out.printf("Number of kids: %d \n", this.noKids);
		System.out.printf("Reservation Status: %s \n", this.rezStatus);
		return;
	}
	
	
	public void checkOut() {
		//this.checkOut = LocalDate.now();
		this.rezStatus = ReservationStatus.CHECKED_OUT;
		return;
	}
	
	private String booleanToString(boolean response) {
		if (response) return "True";
		else return "False";
	}
	
	public void removeRoomOccupancy() { //shouldnt this be under Room?
		this.guest = null;
		this.noAdults = 0;
		this.noKids = 0;
		return;
	}
	
	public void listRoomServices() {
		int size = this.rsList.size();
		for(int i=0; i<size; i++) {
			System.out.printf("%s", this.rsList[i].getId()); //correct?
		}
		return;
	}
	
	public void addRoomService(RoomService rs) {
		this.rsList.add(rs);
		//need sort?
		return;
	}
	
	public void addRoomServiceWithoutPrintOrder(RoomService rs) {
		//dont know yet
		return;
	}
	
	public ArrayList<RoomService> getRSList() {
		return this.rsList;
	}
	
	public void clearRSList() {
		this.rsList.clear();
		this.rsList.trimToSize();
		return;
	}
	
	public double getRSPrice() {
		double sum=0;
		int size = this.rsList.size();
		
		for(int i=0; i<size; i++) {
			 sum += this.rsList[i].getMenuItemGrandTotal();
		}
		return sum;
		
	}
	
	public double calcRoomService(ArrayList<RoomService> rsList) {
		//dont know yet
	}
	
	
	public RoomService getRSById(int id) {
		int size = this.rsList.size();
		
		for (int i=0; i<size; i++) {
			if (this.rsList[i].getId() == id) return this.rsList[i];
		}
		
		return null; //if not found
		
	}
	
	public void removeRoomService(RoomService rs) {
		//first check if contains rs
		if (this.rsList.contains(rs)) this.rsList.remove(rs);
		return;
	}
	
	
	
	
}
