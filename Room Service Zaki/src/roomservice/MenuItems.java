package roomservice;

public class MenuItems {
	
	private int itemID;
	private String item;
	private int qtyRemaining;
	private double price;
	private String description;
	
	
	public MenuItems() {
		
	}
	public MenuItems(int itemID, String item, int qtyRemaining, double price, String description) {
		super();
		this.itemID = itemID;
		this.item = item;
		this.qtyRemaining = qtyRemaining;
		this.price = price;
		this.description = description;
	}
	
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQtyRemaining() {
		return qtyRemaining;
	}
	public void setQtyRemaining(int qtyRemaining) {
		this.qtyRemaining = qtyRemaining;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
