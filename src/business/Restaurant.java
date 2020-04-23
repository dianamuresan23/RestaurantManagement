package business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.TreeSet;

import data.RestaurantSerializator;
import data.WriteBill;


public class Restaurant extends Observable implements RestaurantProcessing {
   Map<Order,ArrayList<MenuItem>> orders=new Hashtable<Order,ArrayList<MenuItem>>();
   ArrayList<MenuItem> menu=new ArrayList<MenuItem>();
   
   public Restaurant(Map<Order,ArrayList<MenuItem>> orders,ArrayList<MenuItem> menu)
   {
	   this.orders=orders;
	   this.menu=menu;
   }
  
   public void addOrder(Order order,ArrayList<MenuItem> items)
   {
	   this.orders.put(order,items);
   }
   public void addMenuItem(MenuItem item)
   {
	   this.menu.add(item);
   }
   public void deleteMenuItem(int itemId)
   {
	   MenuItem item=null;
	   for(MenuItem m:this.menu)
	   {
		   if (m.getId()==itemId)
		   {
			   item=m;
			   break;
		   }
	   }
	   this.menu.remove(item);
   }
   public ArrayList<MenuItem> getMenu()
   {
	   return this.menu;
   }
   public Map<Order,ArrayList<MenuItem>> getOrders()
   {
	   return this.orders;
   }
   
   public double computePrice(int orderId)
   {
	   double price=0;
	   Set<Order> ord=this.orders.keySet(); 
	   for (Order o:ord )
	   {
		   if (o.getOrderId()==orderId)
		   {
			   ArrayList<MenuItem> items=this.orders.get(o);
			  
			   for (MenuItem m: items)
			   {
				   System.out.println(m.getPrice());
				   price+=m.getPrice();
			   }
		   }
	   }
	   return price;
	   
   }

public void createMenuItem(MenuItem item) {
	// TODO Auto-generated method stub
	this.menu.add(item);
	
}

public void editMenuItem(String name,String pr,int id) {
	// TODO Auto-generated method stub
	MenuItem item=null;
	for(MenuItem m:this.menu)
	{
		if (m.getId()==id)
		  {item=m;
		break;}
	}
	if (!("".equals(name)))
	{
		item.setName(name);
	}
	if (!("".equals(pr)))
	{
		double price=Double.parseDouble(pr);
		item.setPrice(price);
	}
	RestaurantSerializator.serialize(this.menu,"restaurant.txt");
	
}

public void createOrder(Order order,ArrayList<MenuItem> items) {
	// TODO Auto-generated method stub
	
	this.orders.put(order,items);
	setChanged();
	notifyObservers(items);
}



public void generateBill(int orderId) {
	// TODO Auto-generated method stub
	 double price=0;
	 ArrayList<MenuItem> items=null;
	 Order order = null;
	 Set<Order> o=this.orders.keySet(); 
	   for (Order ord:o)
	   {
		   if (ord.getOrderId()==orderId)
		   {
			   order=ord;
			    items=this.orders.get(ord);
			   for (MenuItem m: items)
			   {
				   price+=m.getPrice();
			   }
		   }
	   }
	   WriteBill fw=new WriteBill(items,price,order);
	   try {
		fw.print();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public boolean existsOrderId(int id)
{
	for (Order ord:this.orders.keySet())
	{
		if (ord.getOrderId()==id)
			return true;
	}
	return false;
}
public boolean existsMenuItemId(int id)
{
	for (MenuItem item: this.menu)
	{
		if (item.getId()==id)
		{
			return true;
		}
	}
	return false;
}


   
   
   
}

