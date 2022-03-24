package reservation;

public class Reservation {
	
	private int reservationID;
	
	private String checkIn;
	private String checkOut;
	
	private int numAdult;
	private int numChild;
	
	private ReservationStatus reserveStatus;
	
	private double roomCost;
	
	//constructor, will need randomID, input for child+adult, input for checkIn + checkOut.
	public Reservation(int child, int adult, String inDate, String outDate) {
		
		this.numChild = child;
		this.numAdult = adult;
		
		this.checkIn = inDate;
		this.checkOut = outDate;
		
		//need function to auto assign status?
		
		//need function to calc room cost?
		
		
	}
	
	//all other methods
	public int getID() {
		
		return this.reservationID;
		
	}
	
	public ReservationStatus getStatus() {
		
		return this.reserveStatus;
	}
	
	
	
	public String getDate(int condition) { //1 for check-in date, 0 for check-out date. Or should we use two separate functions?
		
		if (condition == 1) return this.checkIn; 
		
		else return this.checkOut;
		
		
	}
	
	
	
	public int getNumGuest() { //do we need to know num of child & adults separately? can modify param if needed.
		
		return this.numAdult + this.numChild;
		
	}
	
	public double getCost() { //can include params to calculate discount for child etc.
		
		return this.roomCost;
		
	}
	
	

}
