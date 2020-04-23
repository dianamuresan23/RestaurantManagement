package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import business.BaseProduct;
import business.CompositeProduct;
import business.MenuItem;
import business.Order;
import business.Restaurant;
import data.RestaurantSerializator;


public class Controller {
	private AdministratorInterface admin;
	private WaiterInterface waiter;
	private ChefInterface chef;
	private Restaurant restaurant;
	private Login login;
	
	
	
	
	public Controller(Login login,Restaurant res)
	{
		AdministratorInterface adm=new AdministratorInterface();
		WaiterInterface waiter=new WaiterInterface();
		ChefInterface chef=new ChefInterface();
		this.admin=adm;
		this.waiter=waiter;
		this.chef=chef;
		this.admin.addListener(new Listener());
		this.waiter.addListener(new Listener());
		this.restaurant=res;
		this.restaurant.addObserver(chef);
		this.login=login;
	    this.login.addListener(new Listener());
		
	}
	class Listener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			if (e.getSource()==login.getAdmin())
			{
				admin.setFrame();
			}
			if (e.getSource()==login.getWaiter())
			{
				waiter.setFrame();
			}
			if (e.getSource()==login.getChef())
			{
				chef.setFrame();
			}
			if (e.getSource()==admin.getDeleteMenuItem())
			{
				int id=admin.deleteMenuItemFrame();
				if (!restaurant.existsMenuItemId(id))
				{
					admin.showMessage("Nu exista produsul");
				}
				else
				{
				restaurant.deleteMenuItem(id);
				RestaurantSerializator.serialize(restaurant.getMenu(),"restaurant.txt");
				}
			}
			if (e.getSource()==admin.getViewMenuItems())
			{
				ArrayList<MenuItem> menu=restaurant.getMenu();
				admin.viewMenuItems(menu);
			}
			if (e.getSource()==admin.getAddMenuItem())
			{
				admin.addMenuItemFrame();
			}
			if (e.getSource()==admin.getAddBaseProduct())
			{
				admin.addBaseProductFrame();
			}
			if (e.getSource()==admin.getAddB())
			{
				String p=admin.getPrice();
				double price=Double.parseDouble(p);
				String name=admin.getName();
				
				int id=1 + (int)(Math.random() * ((100 - 1) + 1));
				while(restaurant.existsMenuItemId(id))
				{
					id=1 + (int)(Math.random() * ((100 - 1) + 1));
				}
				
				BaseProduct base=new BaseProduct(name,price,id);
				restaurant.createMenuItem(base);
				RestaurantSerializator.serialize(restaurant.getMenu(),"restaurant.txt");
				
			
			}
			if (e.getSource()==admin.getAddCompositeProduct())
			{
				admin.addCompositeProductFrame();
			}
			if (e.getSource()==admin.getAddC())
			{
				String p=admin.getPrice();
				String name=admin.getName();
				String i=admin.getItems();
				String[] items=i.split(" ");
				int id=1 + (int)(Math.random() * ((100 - 1) + 1));
				while(restaurant.existsMenuItemId(id)) {
					id=1 + (int)(Math.random() * ((100 - 1) + 1));
				}
				
				CompositeProduct comp=new CompositeProduct(id,name);
			
				for (MenuItem m: restaurant.getMenu())
				{
					for (String s:items)
					{
					if (m.getId()==Integer.parseInt(s))
					{
						comp.addItem(m);
					}
					}
				}
				if (!("".equals(p)))
				{
					double price=Double.parseDouble(p);
				
				    comp.setPrice(price);
				}
				else
				{
					
					comp.setPrice(comp.computePrice());
				}
				restaurant.createMenuItem(comp);
				RestaurantSerializator.serialize(restaurant.getMenu(),"restaurant.txt");
			}
			if (e.getSource()==admin.geteditMenuItem())
			{
				admin.editMenuItemFrame();
			}
			if (e.getSource()==admin.getEdit())
			{
				int id=Integer.parseInt(admin.getId());
				if (!restaurant.existsMenuItemId(id))
				{
					admin.showMessage("Produsul nu exista");
				}
				else
				{
					String name=admin.getName();
					String pr=admin.getPrice();
					restaurant.editMenuItem(name,pr,id);
					
				}
				
			}
			if (e.getSource()==waiter.getViewOrders())
			{
				
				Map<Order,ArrayList<MenuItem>> orders=new Hashtable<Order,ArrayList<MenuItem>>();
				orders=restaurant.getOrders();
				
				waiter.viewOrdersFrame(orders);
			
			}
			if (e.getSource()==waiter.getComputePrice())
			{
				int id=waiter.computePriceFrame();
				double price=restaurant.computePrice(id);
				waiter.showPrice(price);
			}
			if (e.getSource()==waiter.getComputeBill())
			{
				int id=waiter.computeBillFrame();
				restaurant.generateBill(id);
			}
			if (e.getSource()==waiter.getAddOrder())
			{
				waiter.addNewOrderFrame();					
			}
			if (e.getSource()==waiter.getAddNewOrder())
			{
				String i=waiter.getItems();
				String[] it=i.split(" ");
				ArrayList<MenuItem> items=new ArrayList<MenuItem>();
				for(MenuItem m:restaurant.getMenu())
				{
					for (String s :it)
					{
						int id=Integer.parseInt(s);
						if (id==m.getId())
						{
							items.add(m);
						}
					}
				}
				
				String table=waiter.getNofTable();
				
				int t=Integer.parseInt(table);
				
				int id=1 + (int)(Math.random() * ((100 - 1) + 1));
				while(restaurant.existsOrderId(id))
				{
					id=1 + (int)(Math.random() * ((100 - 1) + 1));
				}
		
				Order order=new Order(id,t);
				restaurant.createOrder(order,items);
				
			}
		}
	
	}

}
