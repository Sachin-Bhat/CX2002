/**
 * 
 */
package Control;

import java.util.ArrayList;
import java.util.Scanner;

import Entity.CardType;
//import Entity.CreditCard;
import Entity.Guest;

/**
 * @author BHAT SACHIN <SACHIN008@ntu.edu.sg>
 *
 */
public class GuestManager {
	/**
     * Default constructor for GuestManager
     */
    public GuestManager() {
    }

    /**
     * 
     */
    private ArrayList<Guest> guestList;

    /**
     * 
     */
    private FileIOHandler fileIO;

    /**
     * 
     */
    private int count = 1;

    /**
     * 
     */
    private Scanner sc;

    /**
     * Overloaded constructor
     * used in initialising a few variables
     * Also retrieves guests from file
     * @param sc
     */
    public GuestManager(Scanner sc) {
        // TODO implement here
    	this.sc = sc;
		guestList = new ArrayList<Guest>();
		fileIO = new FileIOHandler();
		
		Object[] objList = fileIO.readObject(Guest.class);
		for (Object o : objList) {
			Guest guest = (Guest) o;
			guestList.add(guest);
		}
		count = guestList.size() + 1;
    }

    /**
     * To add guest to guestList and write to file
     * @return guest
     */
    public Guest addGuest() {
        // TODO implement here
    	Guest guest = null;
    	char gender;
		String id, name, address, country, nationality, exp = "";
		int cvv = 0;
		long cardNo = 0, contactNo = 0;
		CardType cType = null;
		
		System.out.print("Enter the name: ");
		name = sc.nextLine();
		
		System.out.print("Enter the passport number: ");
		id = sc.nextLine();
		
		System.out.print("Enter the gender(M/F): ");
		gender = sc.next().charAt(0);
		
		System.out.print("Enter the address: ");
	    	sc.next();
		address = sc.nextLine();
		
		System.out.print("Enter the country: ");
		country = sc.nextLine();
		
		System.out.print("Enter the nationality: ");
		nationality = sc.nextLine();
		
		System.out.print("Enter the contact details: ");
		contactNo = verifyCard(contactNo, "Enter the contact details: "); // @issue
		
		cType = getCardType();
		
		System.out.print("Enter the credit card number:");
		cardNo = verifyCard(cardNo, "Enter the credit card number: "); // @issue
		
		System.out.print("Enter the CVV: ");
		cvv = verifyOption(cvv, "Enter CVV: "); // @issue
		
		System.out.print("Enter the expiry date (mm/yy): ");
		exp = verifyExpiry(exp, "Enter expiry date (mm/yy): ");
		
		guest = new Guest(count, id, name, address, country, gender, nationality, contactNo, cType, cardNo, cvv, exp);
		
		count++;
		
		guestList.add(guest);
		System.out.println("Guest Added Successfully!");
		
		fileIO.writeObject(guestList.toArray(), guest.getClass());
		
		return guest;
        
    }

    /**
     * searches and returns guest object by name if found
     * null otherwise
     * @param name 
     * @return guest, null
     */
    public Guest searchGuest(String name) {
        // TODO implement here
    	if (guestList.size() == 0) {
			return null;
		}
		for (Guest guest: guestList) {
			if (name.equalsIgnoreCase(guest.getName())) {
				return guest;
			}
		}
		return null;
    }

    /**
     * lists guest details by name
     * @param name 
     * @return
     */
    public void listDetailsGuest(String name) {
        // TODO implement here
    	Guest guest = searchGuest(name);
		if (guest != null)
			printDetailsGuest(guest);
		else 
			System.out.println("Guest was not found...");
        return;
    }

    /**
     * list guest details
     * @param g 
     * @return
     */
    public void printDetailsGuest(Guest g) {
        // TODO implement here
    	System.out.println("\nGuest Details: ");
		System.out.println("\tName: " + g.getName());
		System.out.println("\tPassport No: " + g.getId());
		System.out.println("\tGender: " + g.getGender());
		System.out.println("\tAddress: " + g.getAddress());
		System.out.println("\tCountry: " + g.getCountry());
		System.out.println("\tNationality: " + g.getNationality());
		System.out.println("\tContact No: " + g.getContactNo());
		System.out.println();
		System.out.println("Credit Card Details:");
		System.out.println("\tCard No: " + g.getCreditCard().getCardNo());
		System.out.println("\tCard Type: " + g.getCreditCard().getCardType().toString());
		System.out.println("\tCVV: " + g.getCreditCard().getCVV());
		System.out.println("\tExpiry: " + g.getCreditCard().getExpiry());
		System.out.println("\tHolder Name: " + g.getCreditCard().getName());
		System.out.println("\tAddress: " + g.getCreditCard().getAddress());
		System.out.println("\tCountry: " + g.getCreditCard().getCountry());
        return;
    }

    /**
     * updates guest details and writes into the file
     * @param g 
     * @return
     */
    public void updateDetailsGuest(Guest g) {
        // TODO implement here
    	int updateChoice = -1;
		if (g == null) {
			System.out.println("Guest was not found");
		}
		else {
			do {
				long number = 0;
				updateMenuGuest();
				updateChoice = verifyOption(updateChoice, "Enter an option: ");
				
				switch(updateChoice) {
					case 0:
						System.out.println("\nThe updated guest details are:");
						printDetailsGuest(g);
						break;
						
					case 1:
						System.out.print("Update name: ");
						g.setName(sc.nextLine());
						break;
						
					case 2:
						System.out.print("Update passport number: ");
						g.setId(sc.nextLine());
						break;
						
					case 3:
						System.out.print("Update address: ");
						g.setAddress(sc.nextLine());
						break;
						
					case 4:
						System.out.print("Update country: ");
						g.setCountry(sc.nextLine());
						break;
						
					case 5:
						System.out.print("Update nationality: ");
						g.setNationality(sc.nextLine());
						break;
						
					case 6:
						System.out.print("Update gender(M/F): ");
						g.setGender(sc.next().charAt(0));
						break;
						
					case 7:
						System.out.print("Update contact number: ");
						number = verifyCard(number, "Update contact number: ");
						g.setContactNo(number);
						break;
						
					case 8:
						updateCreditCard(g);
						break;
						
					case 9:
						System.out.print("Update name: ");
						g.setName(sc.nextLine());
						System.out.print("Update address: ");
						g.setAddress(sc.nextLine());
						System.out.print("Update country: ");
						g.setCountry(sc.nextLine());
						System.out.print("Update nationality: ");
						g.setNationality(sc.nextLine());
						System.out.print("Update gender(M/F): ");
						g.setGender(sc.next().charAt(0));
						System.out.println("Update contact number: ");
						number = verifyCard(number, "Update contact number: ");
						g.setContactNo(number);
						updateCreditCard(g);
						printDetailsGuest(g);
						break;
						
					default:
						System.out.println("No such option");
						break;
				}
			} while (updateChoice != 0 && updateChoice != 9);
		}
		
		fileIO.writeObject(guestList.toArray(), Guest.class);
        return;
    }

    /**
     * searches and updates guest details by name and writes to file 
     * @param name 
     * @return
     */
    public void updateDetailsGuest(String name) {
        // TODO implement here
    	Guest guest = searchGuest(name);
		updateDetailsGuest(guest);
        return;
    }

    /**
     * this is the menu to update guest
     * @return
     */
    private void updateMenuGuest() {
        // TODO implement here
    	System.out.println("\n~--------------------------------~");
		System.out.println("! What needs to be updated:      !");
		System.out.println("! 0. Nothing                     !");
		System.out.println("! 1. Name                        !");
		System.out.println("! 2. Passport Number             !");
		System.out.println("! 3. Address                     !");
		System.out.println("! 4. Country                     !");
		System.out.println("! 5. Nationality                 !");
		System.out.println("! 6. Gender                      !");
		System.out.println("! 7. Contact Number              !");
		System.out.println("! 8. Credit Card                 !");
		System.out.println("! 9. All details                 !");
		System.out.println("~--------------------------------~");
		System.out.print("Enter an option: ");
        return;
    }

    /**
     * menu for updating credit card details
     * @return
     */
    private void updateMenuCreditCard() {
        // TODO implement here
    	System.out.println("\n~--------------------------------~");
		System.out.println("! What needs to be updated:      !");
		System.out.println("! 0. Nothing                     !");
		System.out.println("! 1. Card Number                 !");
		System.out.println("! 2. Card Type                   !");
		System.out.println("! 3. CVV                         !");
		System.out.println("! 4. Expiry                      !");
		System.out.println("! 5. Name                        !");
		System.out.println("! 6. Address                     !");
		System.out.println("! 7. Country                     !");
		System.out.println("! 8. All details                 !");
		System.out.println("~--------------------------------~");
		System.out.print("Enter an option: ");
        return;
    }

    /**
     * updates the credit card. 
     * No need to write to file as this is method is 
     * only accessible on updateDetailsGuest()
     * @param g 
     * @return
     */
    private void updateCreditCard(Guest g) {
        // TODO implement here
    	int updateChoice = -1, cvv = -1;
		long cardNo = 0;
		String exp = null;
		do {
			updateMenuCreditCard();
			updateChoice = verifyOption(updateChoice, "Enter an option: ");
			
			switch (updateChoice) {
				case 0:
					System.out.println("Exiting out...");
					break;
					
				case 1:
					System.out.print("Update card number: ");
					cardNo = verifyCard(cardNo, "Update card number: ");
					g.getCreditCard().setCardNo(cardNo);
					break;
					
				case 2:
					g.getCreditCard().setCardType(getCardType());
					break;
					
				case 3:
					System.out.print("Update CVV: ");
					cvv = verifyOption(cvv, "Update CVV: ");
					g.getCreditCard().setCVV(cvv);
					break;
					
				case 4:
					System.out.print("Update expiry: ");
					exp = verifyExpiry(exp, "Update expiry: ");
					g.getCreditCard().setExpiry(exp);
					break;
					
				case 5:
					System.out.print("Update holder name: ");
					g.getCreditCard().setName(sc.nextLine());
					break;
					
				case 6:
					System.out.print("Update address: ");
					g.getCreditCard().setAddress(sc.nextLine());
					break;
					
				case 7:
					System.out.print("Update country: ");
					g.getCreditCard().setCountry(sc.nextLine());
					break;
					
				case 8:
					System.out.print("Update card number: ");
					cardNo = verifyCard(cardNo, "Update card number: ");
					g.getCreditCard().setCardNo(cardNo);
					g.getCreditCard().setCardType(getCardType());
					System.out.print("Update CVV: ");
					cvv = verifyOption(cvv, "Update CVV: ");
					g.getCreditCard().setCVV(cvv);
					System.out.print("Update expiry: ");
					exp = verifyExpiry(exp, "Update expiry: ");
					g.getCreditCard().setExpiry(exp);
					System.out.print("Update holder name: ");
					g.getCreditCard().setName(sc.nextLine());
					System.out.print("Update address: ");
					g.getCreditCard().setAddress(sc.nextLine());
					System.out.print("Update country: ");
					g.getCreditCard().setCountry(sc.nextLine());
					System.out.println("Exiting out...");
					break;
					
				default:
					System.out.println("No such option");
					break;
			}
		} while(updateChoice != 0 && updateChoice != 8);
        return;
    }

    /**
     * gets credit card type from enum
     * @return cType
     */
    private CardType getCardType() {
        // TODO implement here
    	int option = -1;
		CardType cType = null;
		
		do {
			System.out.println("\n~-------------------~");
			System.out.println("! Choose card type: !");
			System.out.println("! 1. Mastercard     !");
			System.out.println("! 2. Visa           !");
			System.out.println("~-------------------~");
			System.out.print("Enter an option: ");
			
			option = verifyOption(option, "Enter choice: ");
			
			switch (option) {
				case 1:
					cType = CardType.MASTERCARD;
					break;
				case 2:
					cType = CardType.VISA;
					break;
				default:
					System.out.println("No such option");
					break;
			}
		} while (option != 1 && option != 2);
		
		return cType;
        
    }

    /**
     * return guest based on guestId
	 * useful in ReservationManager to make guests' reservation
     * @param guestId 
     * @return
     */
    public Guest getGuestById(int guestId) {
        // TODO implement here
    	Guest guest = null;
		
		for (Guest temp : guestList) {
			if (temp.getGuestId() == guestId) {
				guest = temp;
				break;
			}
		}
		return guest;
        
    }

    /**
     * assures that user has to enter an int
     * @param option 
     * @param input 
     * @return option
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
     * Assures the entry of long
     * @param cardNum 
     * @param input 
     * @return cardNum
     */
    private long verifyCard(long cardNum, String input) {
        // TODO implement here
    	boolean invalid = true;
		
		while (invalid) {
			if (!sc.hasNextLong()) {
				System.out.println("Invalid input type. Please enter an integer!");
				sc.nextLine();	// clear the input in the buffer (if any)
				System.out.print(input);
			}
			else {
				invalid = false;
				cardNum = sc.nextLong();
				sc.nextLine();	// clear the "\n" in the buffer (if any)
			}
		}
        return cardNum;
    }

    /**
     * @param expiry 
     * @param input 
     * @return expiry
     */
    private String verifyExpiry(String expiry, String input) {
        // TODO implement here
    	boolean invalid = true;
    	int	isNum1 = 0, isNum2 = 0;
		
		while (invalid) {
			expiry = sc.nextLine();
			if (!expiry.contains("/")) {
				System.out.println("Invalid expiry date. Please enter an expiry date(mm/yy)!");
				System.out.print(input);
			}
			else {
				String[] partList = expiry.split("/");
				if (partList.length == 2) {
					isNum1 = isInt(partList[0]);
					isNum2 = isInt(partList[1]);
				}
				if (isNum1 == 0|| isNum2 == 0) {
					System.out.println("Invalid expiry date. Please enter an expiry date(mm/yy)!");
					System.out.print(input);
				}
				else {
					invalid = false;
				}
			}
		}
    	return expiry;
    }

    /**
     * checks if String is an int
     * @param input 
     * @return 0, 1
     */
    private int isInt(String input) {
        // TODO implement here
    	try {
			Integer.parseInt(input);
			return 1;
		}
		catch (Exception e) {
			return 0;
		}
    }
}
