package presentation;

import java.awt.Dimension;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import business.MenuItem;
import business.Order;
import business.Restaurant;

public class ChefInterface implements Observer {
	JFrame frame;
	TextArea text=new TextArea(5,30);
	JScrollPane pane;
	
	public ChefInterface()
	{

		frame=new JFrame("Chef");
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600,350));
		
		
	     pane=new JScrollPane(text);
	    
	    
	    frame.setContentPane(pane);
		frame.setVisible(false);
		
	}
	public void setFrame()
	{
		this.frame.setVisible(true);
	}
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	
			text.append("Comanda pentru bucatar:\n");
			System.out.println("Comanda");
			
			ArrayList<MenuItem> ord=(ArrayList<MenuItem>)arg;
			String items=ord.toString();
		
			text.append(items);
			text.append("\n");
		
		
	}

}
