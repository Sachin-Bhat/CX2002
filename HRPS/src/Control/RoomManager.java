package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;
import Entity.Room;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class RoomManager {
    /**
     * Default constructor
     */
    public RoomManager() {}
    private ArrayList<Room> roomList;
    private FileIOHandler fileIO = new FileIOHandler();
    private int count = 1;
    private Scanner sc;
    private final int FLOORS = 6;
    private final int ROOMS_PER_FLOOR = 8;

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
        this.sc = sc;
        roomList = new ArrayList<Roomt>();
        fileIO = new FileIOHandler();

        Object[] objList = fileIO.readObject(Room.class);
        for (Object o : objList) {
            Room room = (Room) o;
            roomList.add(room);
        }
        count = roomList.size() + 1;
    }

    /**
     * logic in auto setting rate by room type and bed type
     * @param rType
     * @param bType
     * @return
     */
    private float assignRate(RoomType rType, BedType bType) {
        float rate=0;
        //rates are cost per night in SGD
        //add rate of rType
        if(rType == RoomType.SINGLE){
            rate += 200.00f; //edit for SINGLE rate
        }else if(rType == RoomType.DOUBLE){
            rate += 300.00f; //edit for DOUBLE rate
        }else if(rType == RoomType.DELUXE){
            rate += 500.00f; //edit for DELUXE rate
        }else if(rType == RoomType.VIP){
            rate += 800.00f; //edit for VIP rate
        }
        //add rate of bType
        if(bType == BedType.SINGLE){
            rate += 80.00f; //edit for SINGLE rate
        }else if(bType == BedType.DOUBLE){
            rate += 100.00f; //edit for DOUBLE rate
        }else if(bType == BedType.MASTER){
            rate += 150.00f; //edit for MASTER rate
        }
        return rate;
    }

    /**
     * menu for updating room type
     * @return
     */
    private void roomTypeMenu() {
        System.out.println("Available room types: ");
        System.out.println("1. Single");
        System.out.println("2. Double");
        System.out.println("3. Deluxe");
        System.out.println("4. VIP");
    }
    /**
     * returns room type based on user's choice
     * @param sc
     * @return
     */
    private RoomType chooseRoomType(Scanner sc) {
        int option;
        RoomType rType = null;
        do {
            roomTypeMenu();
            option = verifyOption(option, "Enter an option: ");

            switch (option) {
                case 1:
                    rType = RoomType.SINGLE;
                    break;
                case 2:
                    rType = RoomType.DOUBLE;
                    break;
                case 3:
                    rType = RoomType.DELUXE;
                    break;
                case 4:
                    rType = RoomType.VIP;
                    break;
                default:
                    System.out.println("No such option");
                    break;
            }
        } while (option!=1 && option!=4);
        return rType;
    }

    /**
     * menu for updating bed type
     * @return
     */
    private void bedTypeMenu() {
        System.out.println("Choose bed type: ");
        System.out.println("1. Single");
        System.out.println("2. Double");
        System.out.println("3. Master");
    }
    /**
     * returns bed type based on user's choice
     * @param sc
     * @return
     */
    private BedType chooseBedType(Scanner sc) {
        int option;
        BedType bType = null;

        do {
            bedTypeMenu();
            option = verifyOption(option, "Enter an option: ");

            switch (option) {
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
                    System.out.println("No such option");
                    break;
            }
        } while (option != 1 && option != 3);
        return bType;
    }

    /**
     * menu for updating the availability status
     * @return
     */
    private void availabilityStatusMenu() {
        System.out.println("Availability options: ");
        System.out.println("1. Vacant");
        System.out.println("2. Occupied");
        System.out.println("3. Reserved");
        System.out.println("4. Under Maintenance");
    }
    /**
     * returns availability status based on user's choice
     * @param sc
     * @return
     */
    private AvailabilityStatus chooseAvailabilityStatus(Scanner sc) {
        int option;
        AvailabilityStatus aStat = null;
        do {
            availabilityStatusMenu();
            option = verifyOption(option, "Enter an option: ");

            switch (option) {
                case 1:
                    aStat = AvailabilityStatus.VACANT;
                    break;
                case 2:
                    aStat = AvailabilityStatus.OCCUPIED;
                    break;
                case 3:
                    aStat = AvailabilityStatus.RESERVED;
                    break;
                case 4:
                    aStat = AvailabilityStatus.UNDER_MAINTENANCE;
                    break;
                default:
                    System.out.println("No such option");
                    break;
            }
        } while (option != 1 && option != 4);
        return bType;
    }

    /**
     * menu for updating enable/disable wifi
     * @return
     */
    private void wifiMenu() {
        System.out.println("Updating WiFi options: ");
        System.out.println("1. Enable room WiFi");
        System.out.println("2. Disable room WiFi");
    }
    /**
     * returns a boolean whether wifi is enabled based on user's choice
     * @param sc
     * @return
     */
    private boolean chooseWifi(Scanner sc) {
        int option;
        boolean hasWifi = false;
        do {
            wifiMenu();
            option = verifyOption(option, "Enter an option: ");

            switch (option) {
                case 1:
                    hasWifi = true;
                    break;
                case 2:
                    hasWifi = false;
                    break;
                default:
                    System.out.println("No such option");
                    break;
            }
        } while (option != 1 && option != 2);
        return hasWifi;
    }

    /**
     * menu for updating allow/prohibit smoking
     * @return
     */
    private void smokingMenu() {
        System.out.println("Updating Smoking options: ");
        System.out.println("1. Allow smoking in room");
        System.out.println("2. Prohibit smoking in room");
    }
    /**
     * returns a boolean whether smoking is allowed based on user's choice
     * @param sc
     * @return
     */
    private boolean chooseSmoking(Scanner sc) {
        int option;
        boolean isSmoking = false;
        do {
            smokingMenu();
            option = verifyOption(option, "Enter an option: ");

            switch (option) {
                case 1:
                    isSmoking = true;
                    break;
                case 2:
                    isSmoking = false;
                    break;
                default:
                    System.out.println("No such option");
                    break;
            }
        } while (option != 1 && option != 2);
        return isSmoking;
    }

    /**
     * menu for updating the room details
     * @return
     */
    private void updateRoomMenu() {
        System.out.println("\n~--------------------------------~");
        System.out.println("Options to update:                ");
        System.out.println("\t 0. Nothing else                ");
        System.out.println("\t 1. ID                          ");
        System.out.println("\t 2. Room Type                   ");
        System.out.println("\t 3. Rate                        ");
        System.out.println("\t 4. Bed Type                    ");
        System.out.println("\t 5. Availability                ");
        System.out.println("\t 6. Has Wifi                    ");
        System.out.println("\t 7. Is Smoking                  ");
        System.out.println("\t 8. View                        ");
        System.out.println("\t 9. Level                       ");
        System.out.println("\t 10. Number                     ");
        System.out.println("~--------------------------------~");
    }
    /**
     * allow user to update room details after providing updateRoomMenu() and
     * update to file
     *
     * @param room
     * @return
     */
    public void updateRoom(String room) {
        int updateChoice = -1;
        if (room == null) {
            System.out.println("Room was not found");
        }
        else {
            do {
                updateRoomMenu();
                updateChoice = verifyOption(updateChoice, "Enter an option: ");
                switch(updateChoice) {
                    case 0: //nothing left, room summary
                        System.out.println("Room details are :");
                        listRoomDetails();
                        break;
                    case 1: //Updating id
                        System.out.print("Enter ID to update: ");
                        room.setId(sc.nextLine());
                        break;
                    case 2: //Updating room type
                        room.setRType(chooseRoomType(sc));
                        room.setRate(assignRate(room.getRType, room.getBType)); //auto-update new rate
                        break;
                    case 3: //Updating rate
                        System.out.print("Updating rate...");
                        room.setRate(assignRate(room.getRType, room.getBType));
                        break;
                    case 4: //Updating bed type
                        room.setBType(chooseBedType(sc));
                        room.setRate(assignRate(room.getRType, room.getBType)); //auto-update new rate
                        break;
                    case 5: //Updating availability
                        room.setAvailStatus(chooseAvailabilityStatus(sc));
                        break;
                    case 6: //Updating wifi
                        room.setWifi(chooseWifi(sc));
                        break;
                    case 7: //Updating smoking
                        room.setSmoking(chooseSmoking(sc));
                        break;
                    case 8: //Updating view
                        System.out.println("Enter new view description: ");
                        room.setView(sc.nextLine());
                        break;
                    case 9: //Updating room level
                        int num=0;
                        do {
                            System.out.print("Enter new level: ");
                            num = sc.nextInt;
                            if(verifyRoom(num, room.getRNo).getAvailStatus!=AvailabilityStatus.VACANT){
                                System.out.println("Room already occupied.");
                                break;
                            }
                            if(num>=2 && num<=7){
                                room.setRLevel(num);
                                System.out.println("New level set.");
                            }else System.out.println("Invalid level.");
                        }while(num>=2 && num <=7);
                        break;

                    case 10: //Updating room number
                        do {
                            System.out.print("Enter new room number: ");
                            num = sc.nextInt;
                            if(verifyRoom(room.getRLevel, num).getAvailStatus!=AvailabilityStatus.VACANT){
                                System.out.println("Room already occupied.");
                                break;
                            }
                            if(num>=1 && num<=8){
                                room.setRLevel(num);
                                System.out.println("New room number set.");
                            }else System.out.println("Invalid room number.");
                        }while(num>=1 && num <=8);
                        break;
                    default:
                        System.out.println("No such option");
                        break;
                }
            } while (updateChoice != 0);
        }
        fileIO.writeObject(roomList.toArray(), Room.class);
    }

    /**
     * lists the room details
     * @param r
     * @return
     */
    private void listRoomDetails(Room r) {
        System.out.println("\t Room ID: " + r.getId());
        System.out.println("\t Room type: "+r.getType());
        System.out.println("\t Room rate: "+r.getRate());
        System.out.println("\t Room bed type: "+r.getBType());
        System.out.println("\t Room availability: "+r.getAvailStatus());
        System.out.println("\t Room WiFi option: "+r.getWifi());
        System.out.println("\t Room Smoking option: "+r.getSmoking());
        System.out.println("\t Room view: "+r.getView());
        System.out.println("\t Room Number: "); r.levelNumToString();
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
        if(response){return "Yes";}else return "No";
    }

    /**
     * return room if room is found
     * return null otherwise
     * @param rLevel
     * @param rNo
     * @return
     */
    private Room verifyRoom(int rLevel, int rNo) {
        for(Room r : roomList){
            if(r.getRLevel == rLevel && r.getRNo == rNo){
                return r;
            }
        }
        return null;
    }

    /**
     * create and add a room to list of rooms and
     * update to file
     * @param sc
     * @return
     */
    public void addRoom(Scanner sc) {
        Room room = null;

        System.out.print("Enter room id: ");
        int id = sc.nextInt();
        System.out.print("Enter room level: ");
        int level = sc.nextInt();
        System.out.print("Enter room number: ");
        int num = sc.nextInt();

        //check if room is vacant using lev and no, if taken then break
        if(!isVacantRoom(verifyRoom(level,num))){
            System.out.println("Room already occupied.");
            break;
        }

        RoomType rType = chooseRoomType(sc);
        BedType bType = chooseBedType(sc);
        //autosetting rate
        float rate = assignRate(rType, bType);

        AvailabilityStatus aStatus = chooseAvailabilityStatus(sc);
        boolean wifi = chooseWifi(sc);
        boolean smoking = chooseSmoking(sc);

        System.out.print("Enter view description: ");
        String view = sc.nextLine();

        //constructor
        room = new Room(id, rType, rate, bType, aStatus, wifi, smoking, view, level, num);
        count++;

        roomList.add(room);
        System.out.println("Room added successfully!");

        fileIO.writeObject(roomList.toArray(), room.getClass());
    }

    /**
     * checks if a string is an int
     * @param str
     * @return
     */
    private boolean isStringInt(String str) {
        boolean isInt = false;
        try{
            int num = Integer.parseInt(str);
            isInt = true;
        }
        catch (NumberFormatException ex){
            isInt = false;
        }
        return isInt;
    }

    /**
     * lists rooms by the occupancy rate
     * @return
     */
    public void listRoomsByOccupancyRate() {
        // list room by vacancy, categorize by rType
        System.out.println("Listing rooms by occupancy: ");
        System.out.println("- SINGLE: ");
        for(Room r : roomList){
            if(isVacantRoom(r) && r.getRType==RoomType.SINGLE){
                r.levelNumToString(); System.out.print(", ");
            }
        }
        System.out.println("- DOUBLE: ");
        for(Room r : roomList){
            if(isVacantRoom(r) && r.getRType==RoomType.DOUBLE){
                r.levelNumToString(); System.out.print(", ");
            }
        }
        System.out.println("- DELUXE: ");
        for(Room r : roomList){
            if(isVacantRoom(r) && r.getRType==RoomType.DELUXE){
                r.levelNumToString(); System.out.print(", ");
            }
        }
        System.out.println("- VIP: ");
        for(Room r : roomList){
            if(isVacantRoom(r) && r.getRType==RoomType.VIP){
                r.levelNumToString(); System.out.print(", ");
            }
        }
    }

    /**
     * list rooms by the room status
     * @return
     */
    public void listRoomsByRoomStatus() {
        // list ALL rooms by status type
        System.out.println("Listing rooms by availability: ");
        System.out.println("- VACANT: ");
        for(Room r : roomList){
            if(r.getAvailStatus()==AvailabilityStatus.VACANT){
                r.levelNumToString(); System.out.print(", ");
            }
        }
        System.out.println("- OCCUPIED: ");
        for(Room r : roomList){
            if(r.getAvailStatus()==AvailabilityStatus.OCCUPIED){
                r.levelNumToString(); System.out.print(", ");
            }
        }
        System.out.println("- RESERVED: ");
        for(Room r : roomList){
            if(r.getAvailStatus()==AvailabilityStatus.RESERVED{
                r.levelNumToString(); System.out.print(", ");
            }
        }
        System.out.println("- UNDER_MAINTENANCE: ");
        for(Room r : roomList){
            if(r.getAvailStatus()==AvailabilityStatus.UNDER_MAINTENANCE){
                r.levelNumToString(); System.out.print(", ");
            }
        }
    }

    /**
     * return true if vacant
     * false otherwise
     *
     * @param room
     * @return
     */
    public boolean isVacantRoom(Room room) {
        if(room.getAvailStatus() == AvailabilityStatus.VACANT){
            return true;
        }else return false;
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
        if(isVacantRoom(newR)){
            tempNo = oldR.getRNo();
            tempLevel = oldR.getRLevel();

            oldR.setRNo(newR.getRNo());
            oldR.setRLevel(newR.getRLevel);
            newR.setRNo(tempNo);
            newR.setRLevel(tempLevel);
        }else{
            System.out.println("New room isn't vacant at the moment.");
        }
    }

    /**
     * return room based on room id
     * useful in ReservationManager to set room object
     *
     * @param id
     * @return
     */
    public Room getRoomById(int id) {
        Room room = null;
        for(Room temp : roomList) {
            if (temp.getId() == id) {
                room = temp;
                break;
            }
        }
        return room;
    }

    /**
     * lists room details by room number
     *
     * @param rLevel
     * @param rNum
     * @return
     */
    public void listRoomDetailsByRNo(int rLevel, int rNum) {
        for(Room r : roomList){
            if(r.getRLevel == rLevel && r.getRNo == rNum){
                listRoomDetails(r);
            }
        }
    }

    /**
     * convenient method to write to file
     * nothing much, just a short hand of a method from FileIOHandler really
     *
     * @return
     */
    public void writeToFile() {
        // TODO implement here
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
        boolean invalid = true;
        while (invalid) {
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input type. Please enter an integer!");
                sc.nextLine();	// clear the input in the buffer (if any)
                System.out.print(input);
            } else {
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
        boolean invalid = true;
        while (invalid) {
            if (!sc.hasNextFloat()) {
                System.out.println("Invalid input type. Please enter a float type!");
                sc.nextLine();	// clear the input in the buffer (if any)
                System.out.print(input);
            } else {
                invalid = false;
                option = sc.nextFloat();
                sc.nextLine();	// clear the "\n" in the buffer (if any)
            }
        }
        return option;
    }
}