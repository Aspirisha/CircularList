package CircularList;

import java.util.Iterator;

/**
 * Class to create an array based circular list
 * @author Dan Cody
 */
public class CircularListArrayBased<E> implements CircularList<E>{

	//array making the list
	Object[] items;
	
	//number of items in the list
	private int size;
	
	//size of the entire array space allocated
	private int ARRAY_SIZE = 16;
	
	/**
	 * Constructor
	 * sets size = 0 and creates the array
	 */
	public CircularListArrayBased()
	{
		size = 0;
		items = new Object[ARRAY_SIZE];
	}
	
	/**
	 * method to see if list is empty
	 * @return boolean of if it is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * method to return an int of the size
	 * @return an int of the size of the list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * method to clear and empty the list
	 */
	@Override
	public void clear() {
		ARRAY_SIZE = 16;
		items = new Object[ARRAY_SIZE];
		size = 0;
	}

	/**
	 * method to add an element to the end of the list
	 * @param item  which you wish to add to the list
	 * @return true if the add is successful
	 */
	@Override
	public boolean add(E item) {
		//check to see if array needs to grow
		if(size >= ARRAY_SIZE)
			grow();

		//add to next spot of the array
		items[size++] = item;
		return true;
	}

	/**
	 * method to add an element to the index 
	 * @param index  spot at which to add the item
	 * @param item  object you wish to add to the list
	 * @throws IndexOutOfBoudnsException if index < 0
	 */
	@Override
	public void add(int index, E item) throws IndexOutOfBoundsException {
		if(index > 0)
		{
			//check to see if size of the array needs to be grown
			if(size >= ARRAY_SIZE)
				grow();
			
			//check to make sure the list can be circular
			if(index > size)
				index = ((index % size) - 1);
			
			//create a tempory array
			Object[] tempItems = new Object[ARRAY_SIZE];

			//fill the temporary array
			for(int i=0; i < size; i++)
				tempItems[i] = items[i];
			
			//add the new item
			items[index] = item;
			
			//fill the rest of the array
			for(int i=index; i < size; i++)
				items[i + 1] = tempItems[i];
			
			//garbage collect the temporary array
			tempItems = null;
		
			size++;
				
		}else
			throw new IndexOutOfBoundsException();
	}

	/**
	 * method to remove an element from the list at a specific index
	 * @param index  spot at which to remove an item
	 * @return the item of which you removed
	 * @throws IndexOutOfBoudnsException if index < 0
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		//create a counter
		int counter = 0;
		//get the object to return
		Object ret = items[index];
		
		for(int i=0; i < size - 1; i++)
		{
			//move all the items to their correct spots
			if(i >= index)
			{
				items[index + counter] = items[index + counter + 1];
				counter++;
			}
		}
		//decrease size by 1
		size--;
		return (E) ret;
	}

	/**
	 * method to get an item at a specific index
	 * @param index  spot at which to get an item
	 * @return the object of which you want to get
	 * @throws IndexOutOfBoudnsException if index < 0
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		//check to throw exception
		if(index < 0)
			throw new IndexOutOfBoundsException();
		else
		{
			//check to make it circular
			if(index >= size)
				index = (index % size);
			return (E) items[index];
		}
	}

	/**
	 * method to create an iterator
	 * @return the iterator object
	 */
	@Override
	public Iterator<E> iterator() {
		return new ListIterator<E>(this);
	}
	
	/**
	 * method to grow the size of the array by (3/2) + 1
	 */
	public void grow(){
		//increse the array size
		ARRAY_SIZE = ((ARRAY_SIZE * 3)/2) + 1;
		
		//create the new array
		Object[] newItem = new Object[ARRAY_SIZE];
		
		//add the items to the new array
		for(int i=0; i < size; i++)
			newItem[i] = items[i];	
		
		//have items point to the new array
		items = newItem;
		
		//clear the old pointer
		newItem = null;
	}


}
