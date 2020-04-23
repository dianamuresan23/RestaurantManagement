package main;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import business.BaseProduct;
import business.CompositeProduct;
import business.MenuItem;
import business.Order;
import business.Restaurant;
import data.RestaurantSerializator;
import presentation.Controller;
import presentation.Login;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	BaseProduct p1=new BaseProduct("cartofi natur",5,1);
		BaseProduct p2=new BaseProduct("snitel de pui",10,2);
		CompositeProduct c1=new CompositeProduct(3,"cartofi natur cu snitel de pui");
		c1.addItem(p1);
		c1.addItem(p2);
		c1.setPrice(c1.computePrice());
		ArrayList<MenuItem> menu=new ArrayList<MenuItem>();
		menu.add(p1);
		menu.add(p2);
		menu.add(c1);
		//RestaurantSerializator.serialize(menu,"restaurant.txt");*/
		ArrayList<MenuItem> mmm=RestaurantSerializator.deserialize("restaurant.txt");
		
		Map<Order,ArrayList<MenuItem>> orderss=new Hashtable<Order,ArrayList<MenuItem>>();
		Restaurant restaurant=new Restaurant(orderss,mmm);
		
		Login login=new Login();
		Controller c=new Controller(login,restaurant);

	}

}
