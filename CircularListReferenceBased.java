package CircularList;

import java.util.Iterator;

/**
 * Class to create a refrence based circular linked list
 * @author Dan Cody
 */
public class CircularListReferenceBased<E> implements CircularList<E> {
	
	//size of the array
	private int size;
	
	//head of the linked list
	private Node<E> head;
	
	/**
	 * Constructor
	 * sets size = 0 and sets the head to null
	 */
	public CircularListReferenceBased()	
	{
		size = 0; 
		head = null;
	}
	
	/**
	 * method to check if the list is empty
	 * @return boolean if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	/**
	 * method to check the size of the list
	 * @return int of the size
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * method to clear the list
	 */
	@Override
	public void clear() {
		size = 0;
		head = null;	
	}

	/**
	 * method to add an element at the end of the list
	 * @param item  object to add to the list
	 * @return true if the item is added
	 */
	@Override
	public boolean add(E item) {
		//create the new node
		Node<E> n = new Node<E>(item, head);
		
		//check if its empty
		if(!isEmpty())
		{
			//if not empty make a new node at the head
			Node<E> curr = head;
			
			//find the last node
			for(int i = 1; i < size ; i++)
				curr = curr.getNext();
			
			//set the next one to the new node
			curr.next = n;
		}else{
			//have the new node point to itself and set it to the head
			head = n;
			n.next = n;
		}
		
		//increase the size
		size++;
		return true;
	}

	/**
	 * method to add a method to the index
	 * @param index  spot at where to add the item
	 * @param item  object to add at the index
	 * @throws IndexOutOfBoundsException if index is < 0
	 */
	@Override
	public void add(int index, E item) throws IndexOutOfBoundsException {
		//check to see if you should throw exception
		if ( index >= 0)
		{
			//create the new node
			Node<E> newNode = new Node<E>(item);
			//have it point to the head
			Node<E> curr = head;
			
			//if index is 0 have it point to itself and make it the head
			if(index == 0)
			{
				newNode.next = head;
				head = newNode;
			}else
			{
				//get the current node
				for(int i = 1; i < index; i++)
					curr = curr.getNext();
				
				//add it after and set its next
				Node<E> nextNode = curr.getNext();
				curr.next = newNode;
				newNode.next = nextNode;
			}
			//create size
			size++;
		 }
		 else
			throw new IndexOutOfBoundsException();
		}

	/**
	 * method to remove and return an object
	 * @param index  spot to remove an item
	 * @return object that is removed at the index
	 * @throws IndexOutOfBoudnsException if index < 0
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		//create the node pointing to the head
		Node<E> curr = head;
		//if index is 0 then have have the size decrease and reset head
		if(index == 0)
		{
			head = curr.getNext();
			size--;
			return curr.getItem();
		}
		else
		{
			//get the current node
			for(int i = 0; i < index - 1; i++)
				curr = curr.getNext();
			
			//set the next node, decrease the size and return it
			Node<E> rem = curr.getNext();
			curr.next = rem.getNext();
			size--;
			return curr.getItem();
		}
	}

	/**
	 * method to get the object based on index
	 * @param index  spot at to get the item
	 * @return object at that specific index
	 * @throws IndexOutOfBoudnsException if index < 0
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		//check to throw the exception
		if(index >= 0)
		{
			//check to see if list is not empty
			if(!isEmpty())
			{
				//create node to head
				Node<E> curr = head;
				
				//get the current node
			    for(int i = 0; i < index ; i++)
			    	curr = curr.getNext();
			    
			    //return the item
			    E dataItem = curr.getItem();
			    return dataItem;	
			}
			//if is empty return null
			else
				return null;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * method to create the iterator
	 * @return the iterator object
	 */
	@Override
	public Iterator<E> iterator() {
		return new ListIterator<E>(this);
	}

}
