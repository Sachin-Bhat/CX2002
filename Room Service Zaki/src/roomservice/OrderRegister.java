package roomservice;

public class OrderRegister {
	
	private int orderID;
	private String orderTime;
	private String remarks;
	private OrderStatus ordStatus;
	private double mealCost;
	
	public OrderRegister() {
		
	}
	public OrderRegister(int orderID, String orderTime, OrderStatus ordStatus, double mealCost) {
		super();
		this.orderID = orderID;
		this.orderTime = orderTime;
		this.ordStatus = ordStatus;
		this.mealCost = mealCost;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public OrderStatus getOrdStatus() {
		return ordStatus;
	}
	public void setOrdStatus(OrderStatus ordStatus) {
		this.ordStatus = ordStatus;
	}
	public double getMealCost() {
		return mealCost;
	}
	public void setMealCost(double mealCost) {
		this.mealCost = mealCost;
	}
	
}
