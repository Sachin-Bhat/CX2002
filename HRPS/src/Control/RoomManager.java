package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

import Entity.AvailabilityStatus;
import Entity.BedType;
import Entity.Room;
import Entity.RoomType;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class RoomManager {
	/**
     * Default constructor
     */
    public RoomManager() {}
    private ArrayList<Room> rList;
    private FileIOHandler fileIO = new FileIOHandler();
    private int count = 1;
    private Scanner sc;
    /**
     * Overloaded constructor for RoomManager
     * initialisation of a few variables (including setting the hotel layout and status/type initialisation logic)
     * is able to recreate the 48 rooms (assumptions from pdf guide) and
     * writes it back to file if empty or 
     * recreate rooms and write back to file
     * 
     * @param sc
     */
    public RoomManager(Scanner sc) {
        // TODO implement here
    	rList = new ArrayList<Room>();
		this.sc = sc;
		Object[] objArray = fileIO.readObject(Room.class);
		
		if(objArray.length == 0) {
			int roomNumber = 1;
			 for (int i = 0; i < 48; i++) {
				if (i == 6 || i == 12 || i == 18 || i == 24 || i == 36) {
					roomNumber = 1;
				}
				if (i < 12) {
					if (i < 6) {
						rList.add(new Room(count, RoomType.SINGLE, (float)150.00, BedType.SINGLE, AvailabilityStatus.VACANT, true, false, "great view", 2, roomNumber));
						roomNumber++;
					}
					else {
						rList.add(new Room(count, RoomType.SINGLE, (float)175.00, BedType.DOUBLE, AvailabilityStatus.VACANT, true, false, "great view", 3, roomNumber));
						roomNumber++;
					}
				}
				else if (i >= 12 && i < 24){
					if (i < 18) {
						rList.add(new Room(count, RoomType.DOUBLE, (float)200.00, BedType.SINGLE, AvailabilityStatus.VACANT, true, false, "great view", 4, roomNumber));
						roomNumber++;
					}
					else {
						rList.add(new Room(count, RoomType.DOUBLE, (float)225.00, BedType.DOUBLE, AvailabilityStatus.VACANT, true, false, "great view", 5, roomNumber));
						roomNumber++;
					}
				}
				else if (i >= 24 && i < 36) {
					rList.add(new Room(count, RoomType.VIP, (float)250.00, BedType.MASTER, AvailabilityStatus.VACANT, true, false, "great view", 6, roomNumber));
					roomNumber++;
				}
				else {
					rList.add(new Room(count, RoomType.DELUXE, (float)275.00, BedType.MASTER, AvailabilityStatus.VACANT, true, false, "nice view", 7, roomNumber));
					roomNumber++;
				}
				count++;
			}
			fileIO.writeObject(rList.toArray(), Room.class); 
		}
		else {
			for (Object o : objArray) {
				Room r = (Room) o;
				rList.add(r);
			}
			count = rList.size() + 1;
		}
    }

    /**
     * logic in auto setting rate by room type and bed type
     * @param rType 
     * @param bType 
     * @return
     */
    private float assignRate(RoomType rType, BedType bType) {
        // TODO implement here
    	if (rType.equals(RoomType.SINGLE)) {
			if (bType.equals(BedType.SINGLE)) {
				return 150;
			}
			else {
				return 175;
			}
		}
		else if (rType.equals(RoomType.DOUBLE)) {
			if (bType.equals(BedType.SINGLE)) {
				return 200;
			}
			else {
				return 225;
			}
		}
		else if (rType.equals(RoomType.VIP)) {
			return 250;
		}
		else {
			return 275;
		}
    }

    /**
     * menu for updating room type
     * @return
     */
    private void roomTypeMenu() {
        // TODO implement here
    	System.out.println("\n~-------------------~");
		System.out.println("! Choose room type: !");
		System.out.println("! 1. Single         !");
		System.out.println("! 2. Double         !");
		System.out.println("! 3. VIP Suite      !");
		System.out.println("! 4. Deluxe         !");
		System.out.println("~-------------------~");
		System.out.print("Enter an option: ");
        return;
    }

    /**
     * returns room type based on user's choice
     * @param sc 
     * @return
     */
    private RoomType chooseRoomType(Scanner sc) {
        // TODO implement here
    	int rtOption = -1;
		RoomType rType = null;
		do {
			roomTypeMenu();
			rtOption = verifyOption(rtOption, "Enter an option: ");
			switch(rtOption) {
				case 1:
					rType =  RoomType.SINGLE;
					break;
				case 2:
					rType =  RoomType.DOUBLE;
					break;
				case 3:
					rType =  RoomType.VIP;
					break;
				case 4:
					rType =  RoomType.DELUXE;
					break;
				default:
					System.out.println("No such option");
					break;
			}
			
		} while (rtOption != 1 && rtOption != 2 && rtOption != 3 && rtOption != 4);
		return rType;
    }

    /**
     * menu for updating bed type
     * @return
     */
    private void bedTypeMenu() {
        // TODO implement here
    	System.out.println("\n~------------------~");
		System.out.println("! Choose bed type: !");
		System.out.println("! 1. Single        !");
		System.out.println("! 2. Double        !");
		System.out.println("! 3. Master        !");
		System.out.println("~------------------~");
		System.out.print("Enter an option: ");
        return;
    }

    /**
     * returns bed type based on user's choice
     * @param sc 
     * @return
     */
    private BedType chooseBedType(Scanner sc) {
        // TODO implement here
    	int btOption = -1;
		BedType bType = null;
		do {
			bedTypeMenu();
			btOption = verifyOption(btOption, "Enter an option: ");
			switch(btOption) {
				case 1:
					bType = BedType.SINGLE;
					break;
				case 2:
					bType = BedType.DOUBLE;
					break;
				case 3:
					bType = BedType.MASTER;
					break;
				default:
					System.out.println("No such option...");
					break;
			}
		} while (btOption != 1 && btOption != 2 && btOption != 3);
		return bType;
    }
    /**
     * menu for updating the availability status
     * @return
     */
    private void availabilityStatusMenu() {
        // TODO implement here
    	System.out.println("\n~-----------------------------~");
		System.out.println("! Choose availability status: !");
		System.out.println("! 1. Vacant                   !");
		System.out.println("! 2. Occupied                 !");
		System.out.println("! 3. Reserved                 !");
		System.out.println("! 4. Under Maintenance        !");
		System.out.println("~-----------------------------~");
		System.out.print("Enter an option: ");
        return;
    }

    /**
     * returns availability status based on user's choice
     * @param sc 
     * @return
     */
    private AvailabilityStatus chooseAvailabilityStatus(Scanner sc) {
        // TODO implement here
    	int asOption = -1;
		AvailabilityStatus status = null;
		
		do {
			availabilityStatusMenu();
			asOption = verifyOption(asOption, "Enter an option: ");
			switch(asOption) {
				case 1:
					status = AvailabilityStatus.VACANT;
					break;
				case 2:
					status = AvailabilityStatus.OCCUPIED;
					break;
				case 3:
					status = AvailabilityStatus.RESERVED;
					break;
				case 4:
					status = AvailabilityStatus.UNDER_MAINTENANCE;
					break;
				default:
					System.out.println("No such option...");
					break;
			}
			
		} while (asOption != 1 && asOption != 2 && asOption != 3 && asOption != 4);
		return status;
    }

    /**
     * menu for updating enable/disable wifi
     * @return
     */
    private void wifiMenu() {
        // TODO implement here
    	System.out.println("\n~------------------------~");
		System.out.println("! Choose wifi option:    !");
		System.out.println("! 1. Yes                 !");
		System.out.println("! 2. No                  !");
		System.out.println("~------------------------~");
		System.out.print("Enter an option: ");
        return;
        
    }

    /**
     * returns a boolean whether wifi is enabled based on user's choice
     * @param sc 
     * @return
     */
    private boolean chooseWifi(Scanner sc) {
        // TODO implement here
    	int wOption = -1;
		boolean wifi = false;
		
		do {
			wifiMenu();
			wOption = verifyOption(wOption, "Enter an option: ");
			switch(wOption) {
				case 1:
					wifi = true;
					break;
				case 2:
					wifi = false;
					break;
				default:
					System.out.println("No such option");
					break;
			}
		} while (wOption != 1 && wOption != 2);
		return wifi;
    }

    /**
     * menu for updating allow/prohibit smoking
     * @return
     */
    private void smokingMenu() {
        // TODO implement here
    	System.out.println("\n~------------------------~");
		System.out.println("! Choose smoking option: !");
		System.out.println("! 1. Yes                 !");
		System.out.println("! 2. No                  !");
		System.out.println("~------------------------~");
		System.out.print("Enter an option: ");
        return;
    }

    /**
     * returns a boolean whether smoking is allowed based on user's choice
     * @param sc 
     * @return
     */
    private boolean chooseSmoking(Scanner sc) {
        // TODO implement here
    	int sOption = -1;
		boolean smoking = false;
		
		do {
			smokingMenu();
			sOption = verifyOption(sOption, "Enter an option: ");
			switch(sOption) {
				case 1:
					smoking = true;
					break;
				case 2:
					smoking = false;
					break;
				default:
					System.out.println("No such option");
					break;
			}
		} while (sOption != 1 && sOption != 2);
		return smoking;
        
    }

    /**
     * menu for updating the room details
     * @return
     */
    private void updateRoomMenu() {
        // TODO implement here
    	System.out.println("\n~--------------------------------~");
		System.out.println("! What needs to be updated:      !");
		System.out.println("! 0. Nothing                     !");
		System.out.println("! 1. Room type                   !");
		System.out.println("! 2. Bed type                    !");
		System.out.println("! 3. Room rate                   !");
		System.out.println("! 4. Availability status         !");
		System.out.println("! 5. View                        !");
		System.out.println("! 6. Wifi option                 !");
		System.out.println("! 7. Smoking option              !");
		System.out.println("! 8. All                         !");
		System.out.println("~--------------------------------~");
		System.out.print("Enter an option: ");
        return;
    }

    /**
     * lists the room details
     * @param r 
     * @return
     */
    public void listRoomDetails(Room r) {
        // TODO implement here
    	System.out.println("\n+----------Room Details Summary------------+");
		System.out.println("Room ID: " + r.getId());
		System.out.println("Room number: " + String.format("%02d-%02d", r.getRLevel(), r.getRNo()));
		System.out.println("Room type: " + r.getRType().toString());
		System.out.println("Bed Type: " + r.getBType().toString());
		System.out.println("Room rate: $" + r.getRate());
		System.out.println("Availability Status: " + r.getAvailStatus().toString());
		System.out.println("Wifi Enabled: " + booleanToString(r.getWifi()));
		System.out.println("Smoking Allowed: " + booleanToString(r.getSmoking()));
		System.out.println("Facing: " + r.getView());
        return;
    }

    /**
     * returns a String based on the boolean
	 * returns Yes if true
	 * returns No if false
	 * 
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
     * return room if room is found
	 * return null otherwise
     * @param rLevel 
     * @param rNo 
     * @return
     */
    private Room verifyRoom(int rLevel, int rNo) {
        // TODO implement here
    	Room room = null;
		for (Room tmp : rList) {
			if (tmp.getRLevel() ==  rLevel && tmp.getRNo() == rNo) {
				room = tmp;
				break;
			}
		}
		return room;
        
    }

    /**
     * create and add a room to list of rooms and
     * update to file
     * 
     * @return
     */
    public void addRoom() {
        // TODO implement here
    	RoomType rType = null;
		BedType bType = null;
		AvailabilityStatus status = null;
		boolean hasWifi = false, isSmoking = false, invalid = true;
		int rLevel = -1, rNo = -1;
		Room room = null;
		
		rType = chooseRoomType(sc);
		bType = chooseBedType(sc);
		float rate = assignRate(rType, bType);
		status = chooseAvailabilityStatus(sc);
		hasWifi = chooseWifi(sc);
		isSmoking = chooseSmoking(sc);
		System.out.print("View: ");
		String view = sc.nextLine();
		
		while(invalid) {
			System.out.print("Enter room level: ");
			rLevel = verifyOption(rLevel, "Enter room level: ");
			if (rLevel > 1 && rLevel < 8) {
				System.out.print("Enter room number: ");
				rNo = verifyOption(rNo, "Enter room number: ");
				room = verifyRoom(rLevel, rNo);
				if (room == null) {
					invalid = false;
				}
				else {
					System.out.println("Invalid room number");
				}
			}
			else {
				System.out.println("Invalid room level");
			}
		}

		Room newRoom = new Room(count, rType, rate, bType, status, hasWifi, isSmoking, view, rLevel, rNo);
		rList.add(newRoom);
		System.out.println("New room "+ newRoom.getRLevel()+"-"+newRoom.getRNo()+" has been created.");
		fileIO.writeObject(rList.toArray(), Room.class);
		count++;
        return;
    }

    /**
     * checks if a string is an int
     * @param str 
     * @return
     */
    private boolean isStringInt(String str) {
        // TODO implement here
    	try
	    {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException exception)
	    {
	        return false;
	    }
  
    }

    /**
     * allow user to update room details after providing updateRoomMenu() and
     * write object to file
     * 
     * @param room 
     * @return
     */
    public void updateRoom(String room) {
        // TODO implement here
    	int option = -1;
		float rate = 0;
		String[] part = room.split("-");
		if(!isStringInt(part[0]) || !isStringInt(part[1])){
			System.out.println("Invalid format");
			return;
		}
		Room r = verifyRoom(Integer.parseInt(part[0]), Integer.parseInt(part[1]));
		if (Objects.equals(r, null)) {
			System.out.println("Invalid room");
		}
		else {
			do {
				updateRoomMenu();
				option = verifyOption(option, "Enter an option: ");
				switch (option) {
					case 0:
						System.out.println("The new room details are:");
						listRoomDetails(r);
						break;
					case 1:
						r.setRType(chooseRoomType(sc));
						System.out.println("New room type set");
						fileIO.writeObject(rList.toArray(), Room.class);
						break;
					case 2:
						r.setBType(chooseBedType(sc));
						System.out.println("New bed type set");
						fileIO.writeObject(rList.toArray(), Room.class);
						break;
					case 3:
						System.out.print("Enter rate: ");
						rate = verifyRate(rate, "Enter rate: ");
						r.setRate(rate);
						System.out.println("New room rate set");
						fileIO.writeObject(rList.toArray(), Room.class);
						break;
					case 4:
						r.setAvailStatus(chooseAvailabilityStatus(sc));
						System.out.println("New availability status set");
						fileIO.writeObject(rList.toArray(), Room.class);
						break;
					case 5:
						System.out.print("Enter view: ");
						r.setView(sc.nextLine());
						System.out.println("New view set");
						fileIO.writeObject(rList.toArray(), Room.class);
						break;
					case 6:
						r.setWifi(chooseWifi(sc));
						System.out.println("New wifi option set");
						fileIO.writeObject(rList.toArray(), Room.class);
						break;
					case 7:
						r.setSmoking(chooseSmoking(sc));
						System.out.println("New smoking option set");
						fileIO.writeObject(rList.toArray(), Room.class);
						break;
					case 8:
						r.setRType(chooseRoomType(sc));
						r.setBType(chooseBedType(sc));
						System.out.print("Enter rate: ");
						rate = verifyRate(rate, "Enter rate: ");
						r.setRate(rate);
						r.setAvailStatus(chooseAvailabilityStatus(sc));
						System.out.print("Enter view: ");
						r.setView(sc.nextLine());
						System.out.println("New view set");
						r.setWifi(chooseWifi(sc));
						r.setSmoking(chooseSmoking(sc));
						fileIO.writeObject(rList.toArray(), Room.class);
						System.out.println("Room details updated successfully!\n\nThe new room details are:");
						listRoomDetails(r);
						break;
					default:
						System.out.println("No such option");
						break;
				}
			} while (option != 0 && option != 8);
		}
        return;
    }

    /**
     * lists rooms by the occupancy rate
     * @return
     */
    public void listRoomsByOccupancyRate() {
        // TODO implement here
    	ArrayList<String> vacantR = new ArrayList<String>();
		int totalRooms = 0;
		for (RoomType type : RoomType.values()) {
			totalRooms = 0;
			vacantR.clear();
			System.out.print(type.toString() + ": ");
			for (Room room : rList) {
				if (type.equals(room.getRType())) {
					if (room.getAvailStatus().equals(AvailabilityStatus.VACANT)) {
						vacantR.add(String.format("%02d-%02d", room.getRLevel(), room.getRNo()));
					}
					totalRooms++;
				}
			}
			System.out.printf("\tNumber Vacant: %d out of %d\n", vacantR.size(), totalRooms);
			System.out.print("\t\tRooms: ");
			for (String str : vacantR) {
				System.out.print(str + ", ");
			}
			System.out.println("");
		}
        return;
    }

    /**
     * list rooms by the room status
     * @return
     */
    public void listRoomsByRoomStatus() {
        // TODO implement here
    	for (AvailabilityStatus status : AvailabilityStatus.values()) {
			System.out.println(status.toString() + " : ");
			System.out.print("\tRooms : ");
			for (Room room : rList) {
				if (status.equals(room.getAvailStatus())) {
					System.out.printf("%s, ", String.format("%02d-%02d", room.getRLevel(), room.getRNo()));
				}
			}
			System.out.println();
		}
        return;
    }

    /**
     * return room if vacant
     * null otherwise
     * 
     * @param room 
     * @return
     */
    public Room returnVacantRoom(String room) {
        // TODO implement here
    	String[] part = room.split("-");
		Room r = verifyRoom(Integer.parseInt(part[0]), Integer.parseInt(part[1]));
		if (Objects.equals(r, null)) {
			System.out.println("Invalid room");
		}
		else {
			if (!r.getAvailStatus().equals(AvailabilityStatus.VACANT) ) {
				r = null;
				System.out.println("Room is not vacant");
			}
		}
		return r;
    }

    /**
     * provision to change availability status of 2 rooms if
     * guest needs to switch rooms
     * new room gets old room status
	 * old room status is now vacant
	 * 
     * @param oldR 
     * @param newR 
     * @return
     */
    public void shiftRoom(Room oldR, Room newR) {
        // TODO implement here
    	newR.setAvailStatus(oldR.getAvailStatus());
		oldR.setAvailStatus(AvailabilityStatus.VACANT);
        return;
    }

    /**
     * return room based on room id
	 * useful in ReservationManager to set room object
	 * 
     * @param id 
     * @return
     */
    public Room getRoomById(int id) {
        // TODO implement here
    	Room room = null;
		
		for (Room tmp : rList) {
			if (tmp.getId() == id) {
				room = tmp;
				break;
			}
		}
		return room;
        
    }

    /**
     * lists room details by room number
     * 
     * @param rNum 
     * @return
     */
    public void listRoomDetailsByRNo(String rNum) {
        // TODO implement here
    	String[] part = rNum.split("-");
		Room room = verifyRoom(Integer.parseInt(part[0]), Integer.parseInt(part[1]));
		if(room == null) {
			System.out.println("Invalid Room Number.");
		}
		else {
			listRoomDetails(room);
		}
        return;
    }

    /**
     * Convenient method to write to file
     * nothing much, just a short hand of a method from FileIOHandler really
     * 
     * @return
     */
    public void writeToFile() {
        // TODO implement here
    	fileIO.writeObject(rList.toArray(), Room.class);
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
				System.out.println("Invalid input type. Please enter an integer!");
				sc.nextLine();	// clear the input in the buffer (if any)
				System.out.print(input);
			}
			else {
				invalid = false;
				option = sc.nextInt();
				sc.nextLine();	// clear the "\n" in the buffer (if any)
			}
		}
        return option;
    }

    /**
     * assures that rate is entered and formatted properly (i.e. 2dp)
     * 
     * @param rate 
     * @param input 
     * @return
     */
    private float verifyRate(float rate, String input) {
        // TODO implement here
    	boolean invalid = true;
		
		while (invalid) {
			if (!sc.hasNextFloat()) {
				System.out.println("Invalid rate. Please enter a rate");
				sc.nextLine();	// clear the input in the buffer
				System.out.print(input);
			}
			else {
				invalid = false;
				rate = sc.nextFloat();
				sc.nextLine();	// clear the "\n" in the buffer
			}
		}
		
		return rate;
    }
}