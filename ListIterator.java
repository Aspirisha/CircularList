package circularlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Class to create a list iterator for a circular list
 * @author Daniel Cody
 */
public class ListIterator<E> implements Iterator<E> {
	
	//list to iterate through
	protected CircularList<E> list;
	//index that it is at
	private int index;
	
	/**
	 * Constructor
	 * @param list to be iterated through
	 */
	public ListIterator(CircularList<E> list)
	{
		this.list = list;
		this.index = 0;
	}
	
	/**
	 * boolean method which returns if there is a next element in the list
	 * @return true if next element exists
	 */
	public boolean hasNext()
	{
		return index < list.size();
	}
	
	/**
	 * object method which returns the next element in the list 
	 * @return next element in list if it exists
	 * @throws NoSuchElementException
	 */
	public E next()
	{
		//create the object
		E e;	
		try{
			e = list.get(index++);;
		} catch(IndexOutOfBoundsException t){
			throw new NoSuchElementException(); 
		} 
		
		return e;
	}
	
	/**
	 * Unused method
	 * @throws UnsupporttedOperationException
	 */
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
}
