package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import business.BaseProduct;
import business.CompositeProduct;
import business.MenuItem;

public class AdministratorInterface {
	private JButton addMenuItem=new JButton("Add new MenuItem");
	private JButton deleteMenuItem=new JButton("Delete MenuItem");
	private JButton editMenuItem=new JButton("Edit MenuItem");
	private JButton viewMenuItems=new JButton("View MenuItems");
	private JButton addBaseProduct=new JButton("Add Base Product");
	private JButton addCompositeProduct=new JButton("Add Composite Product");
    private JButton addB=new JButton("Add");
    private JButton addC=new JButton("Add");
    private JButton edit=new JButton("Edit");
	
	private JTextField price=new JTextField(20);
	private JTextField name=new JTextField(20);
	private JTextField items=new JTextField(20);
	private JTextField id=new JTextField(20);
	
	
	private JFrame f;
	private JFrame table;
	JFrame frame;

	
	public AdministratorInterface()
	{
	     frame =new JFrame("Administrator");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(450,350));
		
		frame.setLocation(1000,100);
		
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(204, 204, 255));
		
	    addMenuItem.setBounds(120,70,210,40);
	    deleteMenuItem.setBounds(120,120,210,40);
	    editMenuItem.setBounds(120,170,210,40);
	    viewMenuItems.setBounds(120,220,210,40);

	    addMenuItem.setBackground(new Color(255, 255, 255));
	    deleteMenuItem.setBackground(new Color(255, 255, 255));
	    editMenuItem.setBackground(new Color(255, 255, 255));
	    viewMenuItems.setBackground(new Color(255, 255, 255));

	    addMenuItem.setFont(new Font("TimesRoman",Font.BOLD,18));
	    deleteMenuItem.setFont(new Font("TimesRoman",Font.BOLD,18));
	    editMenuItem.setFont(new Font("TimesRoman",Font.BOLD,18));
	    viewMenuItems.setFont(new Font("TimesRoman",Font.BOLD,18));
	    
	    
	    
		
		p.add(addMenuItem);
		p.add(deleteMenuItem);
		p.add(editMenuItem);
		p.add(viewMenuItems);
		
		frame.setContentPane(p);
		//f.getContentPane().setBackground( new Color(102, 0, 51) );
		
		
		frame.setVisible(false);
	
	}
	public void setFrame()
	{
		this.frame.setVisible(true);
	}
	public JTable createTable(ArrayList<MenuItem> items)
	{
		JTable table;

		ArrayList<String> columnNames=new ArrayList<String>();
		columnNames.add("MenuItem Id");
	    columnNames.add("Name");
	    columnNames.add("Composition");
	    columnNames.add("Price");
	    
		Object[] columns=columnNames.toArray();
		Object [][] data=new Object[20][20];
		int i=0;
		for (MenuItem item:items)
		{
			int k=0;
		
		    data[i][k]=item.getId();
		    k+=1;
		    data[i][k]=item.getName();
		    k+=1;
		    if (item instanceof BaseProduct)
		    {
		    	data[i][k]="-";
		    	k+=1;
		    }
		    if (item instanceof CompositeProduct)
		    {
		    	data[i][k]=item.toString();
		    	k+=1;
		    }
		    data[i][k]=item.getPrice();
				
				
			
			i++;
			
		}
		
		table=new JTable(data,columns);
		return table;
	}
	
	public JButton getAddMenuItem()
	{
		return this.addMenuItem;
	}
	public JButton getDeleteMenuItem()
	{
		return this.deleteMenuItem;
	}
	public JButton geteditMenuItem()
	{
		return this.editMenuItem;
	}
	public JButton getViewMenuItems()
	{
		return this.viewMenuItems;
	}
	public JButton getAddBaseProduct()
	{
		return this.addBaseProduct;
	}
	public JButton getAddCompositeProduct()
	{
		return this.addCompositeProduct;
	}
	public JButton getAddB()
	{
		return this.addB;
	}
	public JButton getAddC()
	{
		return this.addC;
	}
	public JButton getEdit()
	{
		return this.edit;
	}
	public String getPrice()
	{
		return price.getText();
	}
	public String getName()
	{
		return name.getText();
	}
	public String getItems()
	{
		return items.getText();
	}
	public String getId()
	{
		return id.getText();
	}
    void addListener(ActionListener listen)
	
	{

		addMenuItem.addActionListener(listen);
		deleteMenuItem.addActionListener(listen);
		editMenuItem.addActionListener(listen);
		viewMenuItems.addActionListener(listen);
		addBaseProduct.addActionListener(listen);
		addCompositeProduct.addActionListener(listen);
		addB.addActionListener(listen);
		addC.addActionListener(listen);
		edit.addActionListener(listen);
		
	}
    
    public int deleteMenuItemFrame()
    {
    	 f = new JFrame("Delete MenuItem");       
        String name = JOptionPane.showInputDialog(f, "MenuItem id");
        int id=Integer.parseInt(name);
        return id;
    }
    public void viewMenuItems(ArrayList<MenuItem> items)
    {
    	
    	for(MenuItem m:items)
    	{
    		System.out.println(m.toString());
    	}
    	table =new JFrame("MenuItems");
    	table.setSize(new Dimension(600,350));
    	JTable t=new JTable();
    	t=createTable(items);
    	t.setPreferredSize( new Dimension(400, 600) );
    	JScrollPane p=new JScrollPane(t);
    	p.setPreferredSize(new Dimension(480, 300));
    	//p.add(t);
    	table.add(p);
		//f.getContentPane().setBackground( new Color(102, 0, 51) );
		table.setVisible(true);
    	
    }
    public void addMenuItemFrame()
    {
    	f=new JFrame("Add new Item");
    	f.setSize(new Dimension(300,300));
    	f.setLocation(1000,500);
    	JPanel p=new JPanel();
    	p.setLayout(null);
    	p.setBackground(new Color(204, 204, 255));
    	
    	addBaseProduct.setBounds(60,100,180,40);
    	addCompositeProduct.setBounds(60,150,180,40);
    	addBaseProduct.setBackground(new Color(255,255,255));
    	addCompositeProduct.setBackground(new Color(255,255,255));
    	addBaseProduct.setFont(new Font("TimesRoman",Font.BOLD,12));
    	addCompositeProduct.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	p.add(addBaseProduct);
    	p.add(addCompositeProduct);
    	
    	f.add(p);
    	f.setVisible(true);
    	
    }
    public void addBaseProductFrame()
    {
    	f=new JFrame("Add new Base Product");
    	f.setSize(new Dimension(300,300));
    	
    	JLabel p=new JLabel("Price");
    	JLabel n=new JLabel("Name");
    	
    	JPanel pan=new JPanel();
    	f.setLocation(1000,500);
    
    	pan.setLayout(null);
    	pan.setBackground(new Color(204, 204, 255));
    	
    	p.setBounds(60,40,180,40);
    	p.setFont(new Font("TimesRoman",Font.BOLD,12));
    	p.setBackground(new Color(204, 204, 255));
    	
    	price.setBounds(100,40,180,40);
    	price.setBackground(new Color(255,255,255));
    	price.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	n.setBounds(60,90,180,40);
    	n.setBackground(new Color(204, 204, 255));
    	n.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	name.setBounds(100,90,180,40);
    	name.setFont(new Font("TimesRoman",Font.BOLD,12));
    	name.setBackground(new Color(255,255,255));
    	
    	addB.setBounds(80,200,180,40);
    	addB.setBackground(new Color(255,255,255));
    	addB.setFont(new Font("TimesRoman",Font.BOLD,12));
   
    	
    	pan.add(p);
    	pan.add(price);
    	pan.add(n);
    
    	pan.add(name);
    	pan.add(addB);
    	f.add(pan);
    	f.setVisible(true);
    	
    }
    public void addCompositeProductFrame()
    {
    	f=new JFrame("Add new Composite Product");
    	f.setSize(new Dimension(300,300));
    	
    	JLabel p=new JLabel("Price");
    	JLabel n=new JLabel("Name");
    	JLabel i=new JLabel("Items");
    	
    	JPanel pan=new JPanel();
    	f.setLocation(1000,500);
        
    	pan.setLayout(null);
    	pan.setBackground(new Color(204, 204, 255));
    	
    	p.setBounds(60,40,180,40);
    	p.setFont(new Font("TimesRoman",Font.BOLD,12));
    	p.setBackground(new Color(204, 204, 255));
    	
    	price.setBounds(100,40,180,40);
    	price.setBackground(new Color(255,255,255));
    	price.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	n.setBounds(60,90,180,40);
    	n.setBackground(new Color(204, 204, 255));
    	n.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	name.setBounds(100,90,180,40);
    	name.setFont(new Font("TimesRoman",Font.BOLD,12));
    	name.setBackground(new Color(255,255,255));
    	
    	i.setBounds(60,140,180,40);
    	i.setBackground(new Color(204, 204, 255));
    	i.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	items.setBounds(100,140,180,40);
    	items.setFont(new Font("TimesRoman",Font.BOLD,12));
    	items.setBackground(new Color(255,255,255));
    	
    	
    	
    	addC.setBounds(80,200,180,40);
    	addC.setBackground(new Color(255,255,255));
    	addC.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	
    	pan.add(n);
    	pan.add(name);
    	pan.add(p);
    	pan.add(price);
    	pan.add(i);
    	pan.add(items);
    	pan.add(addC);
    	
    	f.add(pan);
    	f.setVisible(true);
    	
    	
    	
    }
    public void editMenuItemFrame()
    {
    	f=new JFrame("Edit MenuItem");
    	f.setSize(new Dimension(400,400));
    	f.setLocation(1000,500);
    	
    	JLabel i=new JLabel("Id");
    	JLabel p=new JLabel("Price");
    	JLabel n=new JLabel("Name");
    	
    	JPanel pan=new JPanel();
    	pan.setLayout(null);
        pan.setBackground(new Color(204, 204, 255));
    	
    	i.setBounds(60,40,180,40);
    	i.setFont(new Font("TimesRoman",Font.BOLD,12));
    	i.setBackground(new Color(204, 204, 255));
    	
    	id.setBounds(100,40,180,40);
    	id.setBackground(new Color(255,255,255));
    	id.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	n.setBounds(60,90,180,40);
    	n.setBackground(new Color(204, 204, 255));
    	n.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	name.setBounds(100,90,180,40);
    	name.setFont(new Font("TimesRoman",Font.BOLD,12));
    	name.setBackground(new Color(255,255,255));
    	
    	p.setBounds(60,140,180,40);
    	p.setBackground(new Color(204, 204, 255));
    	p.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	price.setBounds(100,140,180,40);
    	price.setFont(new Font("TimesRoman",Font.BOLD,12));
    	price.setBackground(new Color(255,255,255));
    	
    	edit.setBounds(80,200,180,40);
    	edit.setBackground(new Color(255,255,255));
    	edit.setFont(new Font("TimesRoman",Font.BOLD,12));
    	
    	pan.add(n);
    	pan.add(name);
    	pan.add(p);
    	pan.add(price);
    	pan.add(i);
    	pan.add(id);
    	pan.add(edit);
    	
    	f.add(pan);
    	f.setVisible(true);
    	
    	
    }
    public void showMessage(String mess)
    {
    	JFrame f=new JFrame();
    	JOptionPane.showMessageDialog(f,mess);
    }
	

}
