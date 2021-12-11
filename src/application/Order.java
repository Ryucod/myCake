package application;

public class Order {

	private String orderList;
	private int price;
	
	public Order(String orderList, int price) {
		super();
		this.orderList = orderList;
		this.price = price;
	}

	public String getOrderList() {
		return orderList;
	}

	public void setOrderList(String orderList) {
		this.orderList = orderList;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
