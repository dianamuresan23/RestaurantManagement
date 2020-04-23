package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import business.MenuItem;
import business.Order;

public class WaiterInterface {
	
	private JButton addOrder=new JButton("Add new Order");
	private JButton viewOrders=new JButton("View Orders");
	private JButton computeBill=new JButton("Compute Bill");
	private JButton computePrice=new JButton("Compute Price");
	private JButton addNewOrder=new JButton("Add");;
	
	private JTextField orderTable;
	private JTextField items;
	
	private JFrame table;
	private JFrame f;
    JFrame frame;
	
	public WaiterInterface()
	{
		 frame =new JFrame("Waiter");
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(450,350));
		frame.setLocation(100,100);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(204, 204, 255));
		
	    addOrder.setBounds(120,70,210,40);
	    viewOrders.setBounds(120,120,210,40);
	    computeBill.setBounds(120,170,210,40);
	    computePrice.setBounds(120,220,210,40);

	    addOrder.setBackground(new Color(255, 255, 255));
	    viewOrders.setBackground(new Color(255, 255, 255));
	    computeBill.setBackground(new Color(255, 255, 255));
	    computePrice.setBackground(new Color(255, 255, 255));

	    addOrder.setFont(new Font("TimesRoman",Font.BOLD,18));
	    viewOrders.setFont(new Font("TimesRoman",Font.BOLD,18));
	    computeBill.setFont(new Font("TimesRoman",Font.BOLD,18));
	    computePrice.setFont(new Font("TimesRoman",Font.BOLD,18));
		
		p.add(addOrder);
		p.add(viewOrders);
		p.add(computeBill);
		p.add(computePrice);
	
		
		frame.setContentPane(p);
		//f.getContentPane().setBackground( new Color(102, 0, 51) );
	
		frame.setVisible(false);
	}
	public void setFrame()
	{
		this.frame.setVisible(true);
	}
	public JButton getAddOrder()
	{
		return this.addOrder;
	}
	public JButton getViewOrders()
	{
		return this.viewOrders;
	}
	public JButton getComputeBill()
	{
		return this.computeBill;
	}
	public JButton getComputePrice()
	{
		return this.computePrice;
	}
	public JButton getAddNewOrder()
	{
		return this.addNewOrder;
	}
	public String getNofTable()
	{
		return orderTable.getText();
	}
	public String getItems()
	{
		return items.getText();
	}

	public JTable createTable(Map<Order,ArrayList<MenuItem>> orderss)
	{
		JTable table;
	
		ArrayList<String> columnNames=new ArrayList<String>();
		columnNames.add("Order Id");
		columnNames.add("Date");
		columnNames.add("Table");
		columnNames.add("Items");
	
		Object[] columns=columnNames.toArray();
		Object [][] data=new Object[20][20];
		int i=0;
		Set<Order> orders=orderss.keySet();
		for (Order ord:orders)
		{
			int k=0;

			data[i][k]=ord.getOrderId();
			k+=1;
			data[i][k]=ord.getDate();
			k+=1;
			data[i][k]=ord.getTable();
			k+=1;
			data[i][k]=orderss.get(ord).toString();
			
			i++;
			
		}
		
		table=new JTable(data,columns);
		return table;
	}

	
    void addListener(ActionListener listen)
	
	{

		addOrder.addActionListener(listen);
		viewOrders.addActionListener(listen);
		computeBill.addActionListener(listen);
		computePrice.addActionListener(listen);
		addNewOrder.addActionListener(listen);
	
	}
    public void viewOrdersFrame(Map<Order,ArrayList<MenuItem>> orders)
    {
    	table=new JFrame("Orders");
    	table.setSize(new Dimension(600,350));

    	JTable t=new JTable();
    	t=createTable(orders);
    	t.setPreferredSize( new Dimension(400, 600) );
    	JScrollPane p=new JScrollPane(t);
    	p.setPreferredSize(new Dimension(480, 300));
   
    	table.add(p);
		//f.getContentPane().setBackground( new Color(102, 0, 51) );
		table.setVisible(true);
    	
    }
    public int computePriceFrame()
    {
    	 f = new JFrame("Compute Price");       
         String i = JOptionPane.showInputDialog(f, "Order id");
         int id=Integer.parseInt(i);
         return id;
    }
    public int computeBillFrame()
    {
    	 f = new JFrame("Compute Bill");       
         String i = JOptionPane.showInputDialog(f, "Order id");
         int id=Integer.parseInt(i);
         return id;
    }
    
    public void showPrice(double price)
    {
    	f=new JFrame("Price ");
    	String s ="Price is " + price;
    	JOptionPane.showMessageDialog(f,s);
    }
    public void addNewOrderFrame()
    {
    	f=new JFrame("Add new Order");
    	f.setSize(new Dimension(300,350));
    	f.setLocation(100,450);
    	
    	JPanel p=new JPanel();
    	p.setLayout(null);
    	p.setBackground(new Color(204, 204, 255));
    	
    	orderTable=new JTextField(20);
    	items = new JTextField(20);
    	

    	JLabel ordIt=new JLabel("Items");
    	JLabel ordT=new JLabel("Table");
    	
    	ordT.setBounds(60,40,180,40);
    	ordT.setFont(new Font("TimesRoman",Font.BOLD,12));
    	ordT.setBackground(new Color(204, 204, 255));
    	
    	orderTable.setBounds(100,40,180,40);
    	orderTable.setBackground(new Color(255,255,255));
    	orderTable.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	ordIt.setBounds(60,90,180,40);
    	ordIt.setBackground(new Color(204, 204, 255));
    	ordIt.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	items.setBounds(100,90,180,40);
    	items.setFont(new Font("TimesRoman",Font.BOLD,12));
    	items.setBackground(new Color(255,255,255));
    	
      	
    	addNewOrder.setBounds(80,200,180,40);
    	addNewOrder.setBackground(new Color(255,255,255));
    	addNewOrder.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	p.add(ordT);
    	p.add(orderTable);
    	p.add(ordIt);
    	p.add(items);
    	
    	p.add(addNewOrder);
    	
    	f.setContentPane(p);
    	f.setVisible(true);
    }
    public void showMessage(String mess)
    {
    	JFrame f=new JFrame();
    	JOptionPane.showMessageDialog(f,mess);
    }
    
   

}
