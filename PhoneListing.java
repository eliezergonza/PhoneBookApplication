
import javax.swing.*;

public class PhoneListing {
	private String name;
	private String phoneNumber;
	private String address;
	

	//constructors 
	//no-argument constructor
	public PhoneListing()
	{
		name = "Unknown";
		phoneNumber = "Unknown";
		address = "Unkonwn";
		
	}
	//constructor: that accepts two Strings, one int and double
	public PhoneListing (String n, String ph, String a)
	{
		name = n;
		phoneNumber = ph;
		address = a;	
	}
	//copy constructor: that accepts an existing Listing object
	public PhoneListing (PhoneListing obj)
	{
		name = obj.name;
		phoneNumber = obj.phoneNumber;
		address = obj.address;			
	}
	
	 //mutator methods - allow us to change the private data of the class 
	public void setname(String n)
	{
		name = n;
	}
	public void setPhoneNumber(String id)
	{
		phoneNumber = id;
	}
	public void setAddress(String a)
	{
		address = a;
	}
	
	
	//accessor methods - allow us to retrieve private data -- can not change the data 
	public String getName()
	{
		return name;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public String getAddress()
	{
		return address;
	}
	
	//method toString that returns a String with the information of the Listing 	
	public String toString()
	 {
		 	 String str =  "Name: " + name +
				 "\nPhone Number: " + phoneNumber +
				 "\nAddress:  " + address + "\n";				
		 return str;
	 }
	//method deepCopy: no argument, this method will return an 
	//object of PhoneListing with the same information as the current object
	public PhoneListing deepCopy()
	{
		PhoneListing copy = new PhoneListing(name, phoneNumber, address);
		return copy;
	}
	//method compareTo that accepts a String as a target key. It will compare
	//the name with the target key and return the result as true or false.
	public int compareTo(String targetkey)
	{
		return(name.compareTo(targetkey));
	}
	//method input that uses JOptionPane to read the value for each field
	public void input()
	{
		String str; 		//use for input
		name = JOptionPane.showInputDialog("Enter the students's name: ");
		phoneNumber = JOptionPane.showInputDialog("Enter the student's phone number:  ");
		address = JOptionPane.showInputDialog("Enter the student's address: ");
				
	}

}
