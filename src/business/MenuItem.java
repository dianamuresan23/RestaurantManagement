package business;

import java.io.Serializable;

public abstract class MenuItem implements Serializable{
	private String name;
	private int id;
	private double price;
	
	public MenuItem(String name,int id)
	{
		this.name=name;
		this.id=id;
	}
	public MenuItem(String name, double price,int id)
	{
		this.name=name;
		this.id=id;
		this.price=price;
	}
	public double getPrice()
	{
		return this.price;
	}
	public void setPrice(double price)
	{
		this.price=price;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public  int getId()
	{
		return this.id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	
	public abstract void showItemDetails();
	
	public abstract double computePrice();
		
	
}
