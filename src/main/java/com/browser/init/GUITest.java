package com.browser.init;


import javax.swing.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITest {

	public static void main(String[] args) {
		
		//Frame
		final JFrame frame= new JFrame("Avinash");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		
		//Menu Bar
		JMenuBar menubar = new JMenuBar();
		
		//Main Menu Items
		JMenu menu1=new JMenu("File");
		JMenu menu2= new JMenu("View");
		
		//Sub Menu Items
		JMenuItem menuitem1= new JMenuItem("Open");
		JMenuItem menuitem2= new JMenuItem("SaveAs");
		JMenuItem menuitem3= new JMenuItem("Window");
		
		//Add sub menu items to main menu items
		menu1.add(menuitem1);
		menu1.add(menuitem2);
		menu2.add(menuitem3);
		
		//Add menu items to menu bar
		menubar.add(menu1);
		menubar.add(menu2);
		
		//panel
		JPanel panel = new JPanel();
		JLabel lable =new JLabel("Enter Text");
		JTextField textfield= new JTextField(10);
		JButton button1 =new JButton("Launch Chrome");
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			  {
			    // display/center the jdialog when the button is pressed
			  //  JDialog d = new JDialog(frame, "Test Running", true);
			   // d.setLocationRelativeTo(frame);
			    //d.setVisible(true);
			    System.setProperty(Util.DriverName, Util.path);
			    WebDriver d1=new ChromeDriver();
				d1=new ChromeDriver();
				d1.get(Util.URL);
				d1.manage().window().maximize();
				d1.quit();
			    
			    
				}
		});
		JButton button2 =new JButton("Reset");
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			  {
			    // display/center the jdialog when the button is pressed
			    JDialog d = new JDialog(frame, "Test Running", true);
			    d.setLocationRelativeTo(frame);
			    d.setVisible(true);
		}});
		
		//panel.add(lable);
		//panel.add(textfield);
		//panel.add(textfield);
		panel.add(button1);
		//panel.add(button2);
		
		//Set Layout
		frame.getContentPane().add(BorderLayout.SOUTH,panel);
		frame.getContentPane().add(BorderLayout.NORTH,menubar);
		frame.setVisible(true);

	}
	
}

