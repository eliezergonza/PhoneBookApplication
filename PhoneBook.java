import javax.swing.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.*;
import java.awt.*;

public class PhoneBook extends JFrame implements ActionListener {

		//Declare an object of PhoneBookUnsortedOptimizedArray
			PhoneBookOptimizedArray phoneEntry;
			
		String name, phone, address;  // To hold text entered		
		
		 // Create the Panel
		 JPanel Panel  = new JPanel();   
	   	 
		//Create the Message
		 JLabel nameLabel   = new JLabel("This is a Phone Book Application.  What action do you want to perform?"); 
			
		 //Create the Buttons
	     JButton addBttn = new JButton("ADD");  
	     JButton deleteBttn = new JButton("REMOVE");
	     JButton updateBttn = new JButton("UPDATE");  
	     JButton findBttn   = new JButton("SEARCH"); 
	     JButton dispalayBttn   = new JButton("DISPLAY");	  
	     
	     public PhoneBook()throws IOException
	     {  
	   	  //Set the title bar text.
	   	  super ("Phone Book");
	   	  
	   	  //Create containter for panel
	   	  Container c = getContentPane(); 
	      c.setLayout(new BorderLayout()); 	      
	      c.add(Panel,BorderLayout.CENTER); 

	        //add the buttons, message
	      	  Panel.add(nameLabel);
	          Panel.add(addBttn);  
	          Panel.add(deleteBttn);  
	          Panel.add(updateBttn);  
	          Panel.add(findBttn);
	          Panel.add(dispalayBttn);               

	        //Register an event listener with all buttons 
	         addBttn.addActionListener(this);  
	         deleteBttn.addActionListener(this); 
	         updateBttn.addActionListener(this); 
	         findBttn.addActionListener(this);  
	         dispalayBttn.addActionListener(this);       
	         
	       //Declare and initialized an object of PhoneBookUnsortedOptimizedArray
	        phoneEntry = new PhoneBookOptimizedArray();
	        
	      //Open the file.
			File file = new File("C:\\Users\\Eli\\Desktop\\JavaEclipse\\PhoneBook\\data.txt");
			Scanner inputFile = new Scanner(file);
	        
	      //Read the information from the file		
			while (inputFile.hasNext())
			{	
			String line = inputFile.nextLine();			//read full line
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter(" – ");
			name = lineScan.next();
			phone = lineScan.next();
			address = lineScan.next();
			PhoneListing fileEntry  = new PhoneListing(name, phone, address);
		    phoneEntry.insert(fileEntry);
			}		
						// Indicate that you are planning to use a file
						File fleExample = new File("C:\\Users\\Eli\\Desktop\\JavaEclipse\\PhoneBook\\data.txt");
					    // Create that file and prepare to write some values to it
						PrintWriter output = new PrintWriter(fleExample);    	   
					    output.print(phoneEntry.insertAll());
				  	       
					    //Close the files	   	    
					    output.close();	
					    inputFile.close();					  
		}	
	public void actionPerformed(ActionEvent e){		    
		//Determine which button was clicked and display a message
		if(e.getSource() == addBttn)	
		{	
			//Create an instance of the addButton
			addButton adding = new addButton();		
		}
		if(e.getSource() == deleteBttn)
		{
			//Create an instance of the removeButton
			removeButton remove = new removeButton();	
		}
		if(e.getSource() == updateBttn)
		{
			//Create an instance of the updateButton
			updateButton update = new updateButton();			
		}
		if(e.getSource() == findBttn)
		{	
			//Create an instance of the searchButton
			searchButton find = new searchButton();
		}
		if(e.getSource() == dispalayBttn)
		{		
			phoneEntry.showAll();
		}		   
	 }
	//addButton class allows user to enter new phone listing
	public class addButton extends JFrame
	{
	   private JPanel panel;           // A panel container	   
	   private JLabel nameLable;	   // to hold Name message
	   private JLabel phoneLable;		// to hold Phone message
	   private JLabel addressLable;	   // to hold Address message
	   private JTextField nameField; // To hold user input
	   private JTextField phoneField; // To hold user input
	   private JTextField addressField; // To hold user input
	   private JButton addingButton;       // adds entry
	   private final int WINDOW_WIDTH = 200;  // Window width
	   private final int WINDOW_HEIGHT = 150; // Window height

	   /**
	    *  Constructor
	    */

	   public addButton()
	   {
	      // Call the JFrame constructor.
	      super("Add");
	      // Set the size and location of the window	      
	      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	      setLocation(350,350); 	      
	      // Build the panel and add it to the frame.
	      buildPanel();
	      // Add the panel to the frame's content pane.
	      add(panel);
	      // Display the window.
	      setVisible(true);
	   }

	   /**
	    *  The buildPanel method adds a label, text field, and
	    *  a button to a panel.
	    */

	   private void buildPanel()
	   {
	      // Create the label, text field, and button components.		 
		  nameLable = new JLabel("Name:");
	      nameField = new JTextField(10);
	      phoneLable = new JLabel("Phone:");
	      phoneField = new JTextField(10);
	      addressLable = new JLabel("Address:");
	      addressField = new JTextField(10);
	      addingButton = new JButton("ADD");	      
	      // Add an action listener to the button.
	      addingButton.addActionListener(new AddButtonListener());
	      // Create a panel to hold the components.
	      panel = new JPanel();	      
	      // Add the label, text field, and button to the panel.	     
	      panel.add(nameLable);
	      panel.add(nameField);
	      panel.add(phoneLable);
	      panel.add(phoneField);
	      panel.add(addressLable);
	      panel.add(addressField);
	      panel.add(addingButton);	     
	   }

	   /**
	    *  Private inner class that handles the event when
	    *  the user clicks the calculate button.
	    */

	   private class AddButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  	name = nameField.getText();
			    phone = phoneField.getText();
			    address = addressField.getText();  
			    
			    PhoneListing entry  = new PhoneListing(name, phone, address);
			    phoneEntry.insert(entry);			
				
				// Display a message dialog showing the result.
				JOptionPane.showMessageDialog(null, name + " with phone number " + phone +
		        		 		" has been added to the phone book.");
		        clear();
	      }	  	   
	   }

		public void clear()  
		{  
			nameField.setText("");  
			phoneField.setText("");  
			addressField.setText(""); 
		}
	  
}
	//removeButton class allows user to enter new phone listing
	public class removeButton extends JFrame
	{
	   private JPanel panel;           // A panel container	   
	   private JLabel nameLable;	    // to hold Name message 
	   private JTextField nameField; // To hold user input	   
	   private JButton removeButton;       // Performs calculation
	   private final int WINDOW_WIDTH = 300;  // Window width
	   private final int WINDOW_HEIGHT = 150; // Window height

	   /**
	    *  Constructor
	    */

	   public removeButton()
	   {
	      // Call the JFrame constructor.
	      super("Remove");

	      // Set the size of the window and location	      
	      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	      setLocation(350,350); 
	      
	      // Build the panel and add it to the frame.
	      buildPanel();

	      // Add the panel to the frame's content pane.
	      add(panel);

	      // Display the window.
	      setVisible(true);
	   }

	   /**
	    *  The buildPanel method adds a label, text field, and
	    *  a button to a panel.
	    */

	   private void buildPanel()
	   {
	      // Create the label, text field, and button components.
		 
		  nameLable = new JLabel("Enter the NAME you want to remove:");
	      nameField = new JTextField(10);
	      removeButton = new JButton("REMOVE");	     
	      
	      // Add an action listener to the button.
	      removeButton.addActionListener(new RemoveButtonListener());	      

	      // Create a panel to hold the components.
	      panel = new JPanel();
	      
	      // Add the label, text field, and button to the panel.	     
	      panel.add(nameLable);
	      panel.add(nameField);	      
	      panel.add(removeButton);	     
	   }

	   /**
	    *  Private inner class that handles the event when
	    *  the user clicks the calculate button.
	    */

	   private class RemoveButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  	name = nameField.getText();			    
	    	  	phoneEntry.delete(name);
				JOptionPane.showMessageDialog(null, name + " has been deleted from the phone book.");
				clear();
	      }	  	   
	   }

		public void clear()  
		{  
			nameField.setText("");  
		}
	  
}
	//updateButton class allows user to update a phone listing
	public class updateButton extends JFrame
	{
	   private JPanel panel;           // A panel container	   
	   private JLabel nameLable;		// to hold Name message	  
	   private JLabel addressLable;	   // to hold Address message
	   private JTextField nameField; // To hold user input	   
	   private JTextField addressField; // To hold user input
	   private JButton updaButton;       // Performs calculation
	   private final int WINDOW_WIDTH = 250;  // Window width
	   private final int WINDOW_HEIGHT = 200; // Window height

	   /**
	    *  Constructor
	    */

	   public updateButton()
	   {
	      // Call the JFrame constructor.
	      super("Update");

	      // Set the size of the window and location	      
	      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	      setLocation(350,350); 
	      
	      // Build the panel and add it to the frame.
	      buildPanel();

	      // Add the panel to the frame's content pane.
	      add(panel);

	      // Display the window.
	      setVisible(true);
	   }

	   /**
	    *  The buildPanel method adds a label, text field, and
	    *  a button to a panel.
	    */

	   private void buildPanel()
	   {
	      // Create the label, text field, and button components.
		 
		  nameLable = new JLabel("Enter the NAME you want to update:");
	      nameField = new JTextField(15);
	      
	      addressLable = new JLabel("Enter the new ADDRESS:");
	      addressField = new JTextField(15);
	      updaButton = new JButton("UPDATE");	     
	      
	      // Add an action listener to the button.
	      updaButton.addActionListener(new UpdateButtonListener());	      

	      // Create a panel to hold the components.
	      panel = new JPanel();
	      
	      // Add the label, text field, and button to the panel.	     
	      panel.add(nameLable);
	      panel.add(nameField);
	      
	      panel.add(addressLable);
	      panel.add(addressField);
	      panel.add(updaButton);
	     
	   }

	   /**
	    *  Private inner class that handles the event when
	    *  the user clicks the calculate button.
	    */

	   private class UpdateButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  	name = nameField.getText();			    
			    address = addressField.getText();  
			    
			    PhoneListing student = phoneEntry.fetch(name);
				student.setAddress(address);
				JOptionPane.showMessageDialog(null, "The address for " + name + " has been updated to " + address);
				phoneEntry.update(name, student);
		        clear();
	      }	  	   
	   }

		public void clear()  
		{  
			nameField.setText("");  
			 
			addressField.setText(""); 
		}
	  
}
	//searchButton class allows user to update a phone listing
	public class searchButton extends JFrame
	{
	   private JPanel panel;           // A panel container	   
	   private JLabel nameLable;	   // to hold Name message	  
	   private JTextField nameField; // To hold user input	   
	   private JButton findButton;       // Performs calculation
	   private final int WINDOW_WIDTH = 250;  // Window width
	   private final int WINDOW_HEIGHT = 150; // Window height

	   /**
	    *  Constructor
	    */

	   public searchButton()
	   {
	      // Call the JFrame constructor.
	      super("Search");

	      // Set the size of the window and location	      
	      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	      setLocation(350,350); 
	      
	      // Build the panel and add it to the frame.
	      buildPanel();

	      // Add the panel to the frame's content pane.
	      add(panel);

	      // Display the window.
	      setVisible(true);
	   }

	   /**
	    *  The buildPanel method adds a label, text field, and
	    *  a button to a panel.
	    */

	   private void buildPanel()
	   {
	      // Create the label, text field, and button components.
		 
		  nameLable = new JLabel("Enter the NAME you want to search:");
	      nameField = new JTextField(15);
	      findButton = new JButton("SEARCH");	     
	      
	      // Add an action listener to the button.
	      findButton.addActionListener(new SearchButtonListener());	      

	      // Create a panel to hold the components.
	      panel = new JPanel();
	      
	      // Add the label, text field, and button to the panel.	     
	      panel.add(nameLable);
	      panel.add(nameField);	      
	      panel.add(findButton);
	     
	   }

	   /**
	    *  Private inner class that handles the event when
	    *  the user clicks the calculate button.
	    */

	   private class SearchButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  	name = nameField.getText();	
	    	  	if ( phoneEntry.fetch(name)== null)
	    	  	JOptionPane.showMessageDialog(null, "There is no entry for " + name);
	    	  	else
	    	  	JOptionPane.showMessageDialog(null, phoneEntry.fetch(name));	    	  	
				clear();
	      }	  	   
	   }

		public void clear()  
		{  
			nameField.setText("");  
		}	
	}
	public static void main(String[] args) throws IOException {
		//Create an instance of the PhoneBook
		PhoneBook ph = new PhoneBook();
		
		//Specify what happens when the class button is clicked
	     ph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	     
	   //Set the size and location of the window;
	     ph.setSize(450,125);  
	     ph.setLocation(350,350); 
	     
	  // Display the window.
	     ph.setVisible(true); 	 
	   	  
	  }
}


