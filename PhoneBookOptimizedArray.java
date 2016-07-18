import javax.swing.JOptionPane;


public class PhoneBookOptimizedArray  {
	private int next;			//to hold the index of the location for next insert
	private int size;			//to hold the size of array
	private PhoneListing[] data;	//Phone array named as data
	
	//no argument constructor that initialize 0 to next,  
	//100 to size and allocate data with size
	public PhoneBookOptimizedArray ()
	{
		next = 0;
		size = 100;
		data = new PhoneListing[size];
	}
	//method insert that accepts a node of Record to insert to array
	//data then return true if success, otherwise return false
	public boolean insert(PhoneListing newStudent)
	{
		if(next >= size)						//the structure is full
			return false;
		data[next] = newStudent.deepCopy();  	//store a deep cop of the client's node
		if(data[next] == null)					//insufficient system memory
			return false;
		next = next + 1;						//prepare for the next insert
		return true;		
	}
	//method fetch that accepts a String and uses it as a key to search then 
	//returns the Records node found
	public PhoneListing fetch(String targetKey)
	{
		PhoneListing node;
		PhoneListing temp;
		//access the node using a sequential search
		int i = 0;
		while (i < next && !(data[i].compareTo(targetKey) == 0))
		{
			i++;
		}
		if (i == next)		//node not found
			return null;
		//deep copy the node's information into the client's node
		node = data[i].deepCopy();
		//move the node up one position in the array, unless it is the first node
		if(i != 0)
		{
			temp = data[i - 1];
			data[i - 1] = data[i];
			data[i] = temp;
		}
		return node;
	}
	//method delete that accepts a String and uses it as a key to search. When the key
	//is matched, remove the node found and move the last element into the deleted node’s
	//position, return true. If the node cannot be found, return false
	public boolean delete(String targetKey)
	{
		//access the node using a sequential search
		int i = 0;
		while (i < next && !(data[i].compareTo(targetKey) == 0))
		{
			i++;
		}
		if (i == next)		//node not found
			return false;
		//move the last node into the deleted node 's position
		data[i] = data[next - 1];
		data[next - 1] = null;
		next = next - 1;
		return true;	//node found and deleted		
	}
	//method update that accept a String as a key of name and a node is an object
	//of Students. It will call delete the node with the name matched with the key
	//and insert the new node. Return true if success, otherwise return false
	public boolean update(String targetKey, PhoneListing newStudentNode)
	{
		if(delete(targetKey) == false)				//node not in the structure
			return false;
		else if(insert(newStudentNode) == false)	//insufficient memory
			return false;
		else
			return true;							//node found and updated
	}
	public void showAll( )	
    {  	for(int i = 0; i < next; i++)
		System.out.println(data[i].toString());    
    	if(next == 0) // check for an empty array
    	JOptionPane.showMessageDialog(null, "The structure is empty.  Please add an entry.");       
    }// end showAll method	
	
	//method insertAll converts all the phone entries to String to be inputted in the file
	public String insertAll()	    	
	{	
		String str = "";	
		
		for(int i = 0; i < next; i++)		
		str = str + data[i].toString();			
		
		return str;	
	}
}
