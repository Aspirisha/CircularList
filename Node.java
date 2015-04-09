package CircularList;

/**
 * Class to create a node for a linked list
 * @author Dan Cody
 */
public class Node<E> {
	//item in the node
	E item;
	//pointer to the next node
	Node <E> next;
	
	/**
	 * Constructor
	 * @param item  item to be added to node
	 */
	public Node(E item){
		this.item = item;
		next = null;
	}
	
	/**
	 * Constructor
	 * @param item  item to be added to node
	 * @param next  refrence to next node in list
	 */
	public Node(E item, Node<E> next){
		this.item=item;
		this.next=next;
	}
	
	/**
	 * method to set the item 
	 * @param item  value to be set as item
	 */
	public void setItem(E item){
		this.item = item;
	}
	
	/**
	 * method to set the next
	 * @param next  refrence to the next node
	 */
	public void setNext(Node<E> next){
		this.next = next;
	}
	
	/**
	 * method to get item
	 * @return object of the item
	 */
	public E getItem(){
		return item;
	}
	
	/**
	 * method to get the next node
	 * @return the next Node object
	 */
	public Node<E> getNext(){
		return next;
	}
}
