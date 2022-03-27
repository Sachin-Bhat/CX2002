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
     * @param rez 
     * @param sc
     */
    public void Payment(Reservation rez, Scanner sc) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void invoiceSummary() {
        // TODO implement here
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
