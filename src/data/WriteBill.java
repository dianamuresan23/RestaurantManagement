package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import business.MenuItem;
import business.Order;

public class WriteBill {
	private Order ord;
	private ArrayList<MenuItem> items=new ArrayList<MenuItem>();
	double price;
	
	public WriteBill(ArrayList<MenuItem> items,double price,Order order)
	{
		this.ord=order;
		this.items=items;
		this.price=price;
	}
	public void print() throws IOException 
	{
		  File file = new File("bill.txt");
	      file.createNewFile();
	      FileWriter writer = new FileWriter(file); 
	      String id="ID: "+ord.getOrderId()+"\n";
	      String date="Date: "+ord.getDate()+"\n";
	      writer.write(id);
	      writer.write(date);
	      for(MenuItem m:items)
	      {
	    	  String s=m.toString();
	    	  s+="\n";
	      writer.write(s); 
	      }
	      String p="Price: "+String.valueOf(price);
	      writer.write(p);
	      writer.flush();
	      writer.close();

	     
	      
	}
	
}
