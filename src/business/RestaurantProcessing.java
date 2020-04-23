package business;

import java.util.ArrayList;

public interface RestaurantProcessing {
	public void createMenuItem(MenuItem item);
	public void deleteMenuItem(int itemId);
	public void editMenuItem(String name,String price,int id);
	public void createOrder(Order order,ArrayList<MenuItem> items);
	public double computePrice(int orderId);
	public void generateBill(int orderId);

}
 