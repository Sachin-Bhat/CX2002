/**
 * 
 */
package Entity;

import java.util.Scanner;
import java.util.ArrayList;

import java.time.Period;
import java.time.DayOfWeek;
import java.time.temporal.ChronoField;

import Entity.OrderStatus;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class Payment {
	
	/**
     * Default constructor
     */
    public Payment() {
    }

    /**
     * 
     */
    private double taxRate;

    /**
     * 
     */
    private double discountRate;

    /**
     * 
     */
    private double weekendRate;

    /**
     * 
     */
    private Reservation rez;

    /**
     * 
     */
    private Scanner sc;

    /**
     * Constructor for Payment
     * Initialising the taxRate, discountRate, weekendRate, Reservation, and Scanner class
     * @param rez 
     * @param sc
     */
    public Payment(Reservation rez, Scanner sc) {
        // TODO implement here
        this.taxRate = 0.08;
        this.weekendRate = 1.25;
        this.discountRate = 0.2;
        this.rez = rez;
        this.sc = sc;
    }

    /**
     * @return
     */
    public void invoiceSummary() {
        // TODO implement here
        System.out.println("\nHotel Checkout Invoice Summary");
        System.out.println("Total Room Charge(Weekdays: "+ calcWeekdays() +", Weekends: "+ calcWeekends() +"): " + "$SGD" + calcRoomCost());
        if (rez.getRSList().size() != 0) {
            System.out.println("Room Service Charges:");
            getRoomServicePriceList();
            System.out.printf("Total Room Service Charge: + $SGD%.2f\n",rez.getRSPrice());
        }

        if(calcDiscount() != 0)
            System.out.printf("Discount: - $SGD%.2f\n",calcDiscount());
        System.out.printf("Tax : + $SGD%.2f\n",calcTax());
        System.out.printf("Total bill is: $SGD%.2f",calcGrandTotal());
        return;
    }

    /**
     * @param bill 
     * @return
     */
    public void invoiceSummary(Bill bill) {
        // TODO implement here
        bill.printReceipt();
        return;
    }

    /**
     * @return
     */
    private void getRoomServicePriceList() {
        // TODO implement here
        ArrayList<RoomService> rsList = rez.getRSList();
        for (RoomService rs : rsList) {
            System.out.println("Room Service <"+ rsList.indexOf(rs)+1 +">");
            //during payment change all room service status to delivered.
            rs.setOrderStatus(OrderStatus.DELIVERED);
            rs.printOrderReceipt();
        }
        return;
    }

    /**
     * @return
     */
    private void paymentMenu() {
        // TODO implement here
        System.out.println("\n~--------------------------------~");
        System.out.println("! Payment by:                    !");
        System.out.println("! 1. Cash                        !");
        System.out.println("! 2. Credit Card                 !");
        System.out.println("~--------------------------------~");
        System.out.print("Enter an option: ");
        return;
    }

    /**
     * @return
     */
    public void paymentByCashOrCredit() {
        // TODO implement here
        int updateChoice = -1;
        do {
            paymentMenu();
            updateChoice = verifyOption(updateChoice, "Enter an option: ");

            switch (updateChoice) {
            case 1:
                System.out.println("Payment Details:");
                System.out.println("Paid by: Cash");
                System.out.printf("Total Cost: SGD$%.2f\n",calcGrandTotal());
                System.out.printf("Amount Paid: SGD$%.2f\n",calcGrandTotal());
                System.out.println("Payment successful");
                break;
            case 2:
                System.out.println("Payment Details:");
                System.out.println("Paid by: Credit Card");
                System.out.println("Type: " + rez.getGuest().getCreditCard().getCardType());
                System.out.println("Name: " + rez.getGuest().getCreditCard().getName());
                System.out.println("Address: " + rez.getGuest().getCreditCard().getAddress());
                System.out.printf("Amount Billed: $%.2f\n",calcGrandTotal());
                System.out.println("Payment successful");
                break;
            default:
                System.out.println("Invalid choice");
                break;
            }

        } while (updateChoice != 1 && updateChoice != 2);
        return;
    }

    /**
     * @return
     */
    public int calcWeekends() {
        // TODO implement here
        int noWeekend = 0;
        Period stayed = Period.between(rez.getCheckIn(), rez.getCheckOut()); //Get the period between check in date and check out date.
        int totalDays = stayed.getDays(); //Calculate the total days between check in date and check out date.
        for(int d=0; d<totalDays; d++){
            DayOfWeek day = DayOfWeek.of((rez.getCheckIn().plusDays(d).get(ChronoField.DAY_OF_WEEK))); //Get the name of each day.
            if(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)
                noWeekend++;
        }
        return noWeekend;
    }

    /**
     * @return
     */
    public int calcWeekdays() {
        // TODO implement here
        int noWeekday = 0;
        Period stayed = Period.between(rez.getCheckIn(), rez.getCheckOut()); //Get the period between check in date and check out date.
        int totalDays = stayed.getDays(); //Calculate the total days between check in date and check out date.
        for(int d=0; d<totalDays; d++){
            DayOfWeek day = DayOfWeek.of((rez.getCheckIn().plusDays(d).get(ChronoField.DAY_OF_WEEK))); //Get the name of each day.
            if(day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY)
                noWeekday++;
        }
        return noWeekday;
    }

    /**
     * @return
     */
    public float calcRoomCost() {
        // TODO implement here
        float totalPrice = 0;
        Period stayed = Period.between(rez.getCheckIn(), rez.getCheckOut()); //Get the period between check in date and check out date.
        int totalDays = stayed.getDays(); //Calculate the total days between check in date and check out date.
        for(int d=0; d<totalDays; d++){
            DayOfWeek day = DayOfWeek.of((rez.getCheckIn().plusDays(d).get(ChronoField.DAY_OF_WEEK))); //Get the name of each day.
            if(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY){
                totalPrice += rez.getRoom().getRate() * weekendRate;

            }
            else{

                totalPrice += rez.getRoom().getRate();
            }
        }
        return totalPrice;
    }

    /**
     * @return
     */
    public double calcDiscount() {
        // TODO implement here
        return (rez.getRSPrice() + calcRoomCost()) * discountRate;

    }

    /**
     * @return
     */
    public double calcTax() {
        // TODO implement here
        return (rez.getRSPrice() + calcRoomCost() - calcDiscount()) * taxRate;

    }

    /**
     * @return
     */
    public double calcGrandTotal() {
        // TODO implement here
        return (rez.getRSPrice() + calcRoomCost() - calcDiscount()) + calcTax();

    }

    /**
     * @param taxRate 
     * @return
     */
    public void setTaxRate(double taxRate) {
        // TODO implement here
        this.taxRate = taxRate;
        return;
    }

    /**
     * @param discountRate 
     * @return
     */
    public void setDiscountRate(double discountRate) {
        // TODO implement here
        this.discountRate = discountRate;
        return;
    }

    /**
     * @param weekendRate 
     * @return
     */
    public void setWeekendRate(double weekendRate) {
        // TODO implement here
        this.weekendRate = weekendRate;
        return;
    }

    /**
     * @return
     */
    public double getTaxRate() {
        // TODO implement here
        return taxRate;
    }

    /**
     * @return
     */
    public double getDiscountRate() {
        // TODO implement here
        return discountRate;
    }

    /**
     * @return
     */
    public double getWeekendRate() {
        // TODO implement here
        return weekendRate;
    }

    /**
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
}