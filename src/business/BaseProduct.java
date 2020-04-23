package business;

import java.io.Serializable;

public class BaseProduct extends MenuItem implements Serializable{
   // double price;
    
    public BaseProduct(String name,double price,int id)
    {
    	super(name,price,id);
    }
  
  
	@Override
	public String toString() {
		return  getName() ;
	}
	public void showItemDetails()
	{
		System.out.println(getName() + " "+ this.getPrice());
	}
	public double computePrice() {
		// TODO Auto-generated method stub
		return this.getPrice();
		
	}

}
