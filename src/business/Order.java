package business;

import java.util.Date;

public class Order {
	int orderId;
	Date date;
	int table;
	
	public Order(int orderId, int table)
	{
		this.orderId=orderId;
		this.date=new Date();
		this.table=table;
	}

	public int getOrderId()
	{
		return this.orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId=orderId;
	}
	public Date getDate()
	{
		return this.date;
	}
	public void setDate(Date date)
	{
		this.date=date;
	}
	public int getTable()
	{
		return this.table;
	}
	public void setTable(int table)
	{
		this.table=table;
	}

	@Override
    public boolean equals(Object obj)
    {
    	if (obj!=null && obj instanceof Order)
    	{
    		int id=((Order)obj).getOrderId();
    		Date date=((Order)obj).getDate();
    		int table=((Order)obj).getTable();
    		if ( date!=null  && id==this.getOrderId() && date.equals(this.getDate()) && table==this.getTable())
    		{
    			return true;
    		}
    	}
    	
    	return false;
    }

    @Override
    public int hashCode()
    {
    	int hash=0;
    	hash=this.orderId + this.date.getDay()+this.date.getMonth()+this.date.getYear()+ this.table;
    	return hash;
    }


}
