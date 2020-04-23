package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Login {
	private static final int Y_AXIS = 0;
	private JButton Administrator=new JButton("Administrator");
	private JButton Waiter=new JButton("Waiter");
	private JButton Chef=new JButton("Chef");
	
	
	public Login()
	{
		JFrame frame=new JFrame("Restaurant");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(400,400));
		frame.setLocationRelativeTo(null);
		
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(204, 204, 255));
		
		Administrator.setBounds(100,100,200,50);
		Waiter.setBounds(100,150,200,50);
		Chef.setBounds(100,200,200,50);
		
		
		Administrator.setBackground(new Color(255, 255, 255));
		Waiter.setBackground(new Color(255, 255, 255));
		Chef.setBackground(new Color(255, 255, 255));
		
		Administrator.setFont(new Font("TimesRoman",Font.BOLD,18));
		Waiter.setFont(new Font("TimesRoman",Font.BOLD,18));
		Chef.setFont(new Font("TimesRoman",Font.BOLD,18));
		
		
		
		
		
		p.add(Administrator);
		p.add(Waiter);
		p.add(Chef);
		
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	public JButton getAdmin()
	{
		return this.Administrator;
	}
	public JButton getWaiter()
	{
		return this.Waiter;
		
	}
	public JButton getChef()
	{
		return this.Chef;
	}
	 void addListener(ActionListener listen)
		
		{

			Administrator.addActionListener(listen);
			Waiter.addActionListener(listen);
		    Chef.addActionListener(listen);
			
			
		}
	
}
