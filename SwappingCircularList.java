package CircularList;

import java.util.EmptyStackException;


/**
 * Class to create a refrence based circular linked list
 * @author Dan Cody
 */
public class SwappingCircularList<E> {
	
	private int capacity;
	private int size;
	
	//head of the linked list
	private Node<E> head;
	private Node<E> tail;


	private Class<E> type;
	/**
	 * Constructor
	 * sets size = 0 and sets the head to null
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public SwappingCircularList(Class<E> itemClass, int _cap) throws InstantiationException, IllegalAccessException	
	{
		size = 0; 
		capacity = _cap;
		if (_cap < 1)
			capacity = 1;
		
		type = itemClass;
		E item = type.newInstance();
		head = new Node<E>(item);
		Node<E> cur = head;
		for (int i = 1; i < capacity; i++) {
			cur.next = new Node<E>(type.newInstance());
			cur = cur.next;
		}
		cur.next = head;
		tail = head;
	}
	
	/**
	 * method to check if the list is empty
	 * @return boolean if the list is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * method to check the size of the list
	 * @return int of the size
	 */
	public int size() {
		return size;
	}

	/**
	 * method to clear the list
	 */
	public void clear() {
		tail = head;
		size = 0;
	}

	/**
	 * returns previous tail item, writes new one
	 * @param item
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public E push(E item) throws InstantiationException, IllegalAccessException {
		E ret = tail.item;
		if (size == capacity - 1) {
			grow();
		}
		tail.item = item;
		tail = tail.next;
		size++;
		return ret;
	}

	public E pop(E exchnageItem) {
		if (size == 0) {
			throw new EmptyStackException();
		}
		E ret = head.item;
		head.item = exchnageItem;
		head = head.next;
		size--;
		return ret;
	}
	
	void grow() throws InstantiationException, IllegalAccessException {
		Node<E> tempHead = new Node<E>(type.newInstance());
		Node<E> cur = tempHead;
		int deltaCap = capacity / 2 + 1;
		for (int i = 1; i < deltaCap; i++) {
			cur.next = new Node<E>(type.newInstance());
			cur = cur.next;
		}
		capacity += deltaCap;
		tail.next = tempHead;
		cur.next = head;
	}


}
