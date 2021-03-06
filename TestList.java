package CircularList;

/**
 * Class to test the circularlist package
 */
public class TestList {

    public static void main(String [] args)
    {
	// Create a CircularList of Strings
	CircularList<String> cl = new CircularListArrayBased<String>();
	
	// Add elements
	cl.add("A"); 
	cl.add("B"); 
	cl.add("C");
	cl.add("D");
	cl.add("E");
	cl.add("F"); 
	cl.add("G");  
	cl.add(7, "Insert");
	
	cl.remove(2);
	
	System.out.println(cl.size());
	System.out.println(cl.get(7));
	
	// Use the foreach loop to print out elements from the iterator
	System.out.print("{ ");
	int i = 1;
	for(String s : cl) {
	    System.out.print(s + " ");
	    if(i++ > 25)
		break;
	}
	System.out.println("}");	
    }
	
}
