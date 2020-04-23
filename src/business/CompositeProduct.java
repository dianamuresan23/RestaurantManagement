package business;

import java.io.Serializable;
import java.util.ArrayList;

public class CompositeProduct extends MenuItem implements Serializable {
	private ArrayList<MenuItem> items=new ArrayList<MenuItem>();
	//private double price;

	public CompositeProduct(int id,String name)
	{
		super(name,id);
	}
	public void addItem(MenuItem m)
	{
		items.add(m);
	}
	public void removeItem(MenuItem m)
	{
		items.remove(m);
	}

	public double computePrice() {
		// TODO Auto-generated method stub
		double price=0;
		for (MenuItem m: items)
		{
			price+=m.computePrice();
		}
		
		return price;
		
	}
	
	   public void showItemDetails()  
	    { 
	        for(MenuItem m:items) 
	        { 
	            m.showItemDetails();
	        } 
	    }

	@Override
	public String toString() {
		return  items.toString();
	}

	

	
	

}
