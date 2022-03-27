package roomservice;

public class RoomService implements Menu{
	
	private Menu menuList;
	private double serviceCost;
	private OrderRegister order = new OrderRegister();
	
	public RoomService() {
		
	}
	public RoomService(Menu menuList, double serviceCost, OrderRegister order) {
		super();
		this.menuList = menuList;
		this.serviceCost = serviceCost;
		this.order = order;
	}
	
	public Menu getMenuList() {
		return menuList;
	}
	public void setMenuList(Menu menuList) {
		this.menuList = menuList;
	}
	public double getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}
	public OrderRegister getOrder() {
		return order;
	}
	public void setOrder(OrderRegister order) {
		this.order = order;
	}
	
}
