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
	System.out.println("Total Room Charge(Weekdays: "+ calculateWeekdays() +", Weekends: "+ calculateWeekends() +"): " + "$SGD" + calculateRoomCharge());
	if (rs.getRoomServiceList().size() != 0) {
		System.out.println("Room Service Charges:");
		getRoomServicePriceList();
		System.out.printf("Total Room Service Charge: + $SGD%.2f\n",rs.getRoomServicePrice());
	}

	if(calculateDiscount() != 0)
		System.out.printf("Discount: - $SGD%.2f\n",calculateDiscount());
	System.out.printf("Tax Charge: + $SGD%.2f\n",calculateTaxCharge());
	System.out.printf("Total bill is: $SGD%.2f",calculateTotalBill());
        return;
    }

    /**
     * @param bill 
     * @return
     */
    public void invoiceSummary(Bill bill) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    private void getRoomServicePriceList() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    private void paymentMenu() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void paymentByCashOrCredit() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public int calcWeekends() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int calcWeekdays() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public float calcRoomCost() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public double calcDiscount() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return
     */
    public double calcTax() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return
     */
    public double calcGrandTotal() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @param taxRate 
     * @return
     */
    public void setTaxRate(double taxRate) {
        // TODO implement here
        return;
    }

    /**
     * @param discountRate 
     * @return
     */
    public void setDiscountRate(double discountRate) {
        // TODO implement here
        return;
    }

    /**
     * @param weekendRate 
     * @return
     */
    public void setWeekendRate(double weekendRate) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public double getTaxRate() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return
     */
    public double getDiscountRate() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return
     */
    public double getWeekendRate() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @param option 
     * @param input 
     * @return
     */
    private int verifyOption(int option, String input) {
        // TODO implement here
        return 0;
    }
}
