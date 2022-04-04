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
    private final int MAX_ROOMS = 48;
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
        private final int FLOORS = 6;
        private final int ROOMS_PER_FLOOR = 8;


    }

    /**
     * logic in auto setting rate by room type and bed type
     * @param rType
     * @param bType
     * @return
     */
    private float assignRate(RoomType rType, BedType bType) {
        // TODO implement here
        //do i assign each type to a rate and add??
        return 0.0f;
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
        } while (option!=1 && option!=2 && option!=3 && option!=4);
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
        } while (option != 1 && option != 2 && option != 3);
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
        } while (option != 1 && option != 2 && option != 3 && option != 4);
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
        System.out.println("! What needs to be updated:      !");
        System.out.println("! 0. Nothing                     !");
        System.out.println("! 1. ID                          !");
        System.out.println("! 2. Room Type                   !");
        System.out.println("! 3. Rate                        !");
        System.out.println("! 4. Bed Type                    !");
        System.out.println("! 5. Availability                !");
        System.out.println("! 6. Has Wifi                    !");
        System.out.println("! 7. Is Smoking                  !");
        System.out.println("! 8. View                        !");
        System.out.println("! 9. Level                       !");
        System.out.println("! 10. Numbe                      !");
        System.out.println("! 11. All details                !");
        System.out.println("~--------------------------------~");
        System.out.print("Enter an option: ");
    }

    /**
     * allow user to update room details after providing updateRoomMenu() and
     * update to file
     *
     * @param room
     * @return
     */
    public void updateRoom(String room) {
        // TODO implement here
        return;
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
        System.out.printf("\t Room level: %02d%n-%02d%n", r.getRLevel(), r.getRNo());
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
        // TODO implement here
        return null;
    }

    /**
     * create and add a room to list of rooms and
     * update to file
     *
     * @return
     */
    public void addRoom() {
        // TODO implement here
        return;
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
        // TODO implement here
        return;
    }

    /**
     * list rooms by the room status
     * @return
     */
    public void listRoomsByRoomStatus() {
        // TODO implement here
        return;
    }

    /**
     * return room if vacant
     * null otherwise
     *
     * @param room
     * @return
     */
    public Room returnVacantRoom(Room room) {
        if(room.getAvaiLStatus() == VACANT){
            return room;
        }else return null;
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
     * @param rNum
     * @return
     */
    public void listRoomDetailsByRNo(String rNum) {
        // TODO implement here
        return;
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
