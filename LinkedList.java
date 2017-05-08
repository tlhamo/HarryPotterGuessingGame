package datastructures;

/**
 * This class contains methods that help with inserting new data,
 * to new nodes or deleting nodes. It also contains a toString method
 * to convert node data to string, a isEmpty method which checks if the 
 * list is empty and also a size method which returns the size of the list.
 * 
 * @author Tseki
 * date 28 March 2017
 */

public class LinkedList<T> {	
	private LinkedListNode<T> head;
	//initially, the head is null
	public LinkedList(){		
		head = null;
	}
	
	/**
	 * Get data stored in head node of list.
	 * @return data at head
	 */
	public T getFirst(){
		if(!isEmpty()){
		return head.getData();
	}return null;
	}
	 
	/**
	 * Get the head node of the list.
	 * @return head node
	 */
	public LinkedListNode<T> getFirstNode(){
		//if the list has a head, return the value of head
		if(!isEmpty()){
			return head;
		}
		return null;
	}
	 
	/**
	 * Get data stored in last node of list.
	 * @return last node data
	 */
	public T getLast(){
		LinkedListNode<T> lastNode = getLastNode();
		if(lastNode != null){
		return lastNode.getData();
	} return null;
	}
	 
	/**
	 * Get the tail node of the list.
	 * @return temp which represents last node
	 */
	public LinkedListNode<T> getLastNode(){
		//Keeps running till it finds a node which points to a null value which
		//indicates that the last node has been found
		if(head != null){
		LinkedListNode<T> temp;
		temp = head;
		while(temp.getNext() != null){		
			temp = temp.getNext();
		}	
			return temp;
		}return null; 
	}
	 
	/**
	 * Insert a new node with data at the head of the list.
	 * @param data to set 
	 */
	public void insertFirst( T data ){
		LinkedListNode<T> newNode = new LinkedListNode<T>(data, head);
		head = newNode;
	}	
	 
	/**
	 * Insert a new node with data after currentNode
	 * @param currentNode  node to alter
	 * @param data    data to set
	 */
	public void insertAfter( LinkedListNode<T> currentNode, T data ){	
		LinkedListNode<T> newNode = new LinkedListNode<T>(data, currentNode.getNext());
		if(isEmpty()){
			insertFirst(data);
		}else{ //making the current node point to the new node
			currentNode.setNext(newNode);			
		}
	}
	 
	/**
	 * Insert a new node with data at the end of the list.
	 * @param data .
	 */
	public void insertLast( T data ){	
		LinkedListNode<T> newNode = new LinkedListNode<T>(data, null);
		//if the LinkedList is empty, make newNode the first point
		if(isEmpty()){
			insertFirst(data);
		}else{
			LinkedListNode<T> tempNode = head;
			//run this until the new node points to a null value
			//which indicates the last node
			while(tempNode.getNext() != null){
				tempNode = tempNode.getNext();				
			}
			//make last node's next point to new node
			tempNode.setNext(newNode);
		}
	}
	 
	/**
	 * Remove the first node
	 */
	public void deleteFirst(){
		//making the first node the second node
		head = head.getNext();
		}
	 
	/**
	 * Remove the last node
	 * If the list isn't empty, execute loop till it finds a node whose next value is null
	 * then make current null and set the previous which is the second last node to point 
	 * to null
	 */
	public void deleteLast(){
		if(size() == 1){
			head = null;
		}
		if(!isEmpty()){
		LinkedListNode<T> previous = null;
		LinkedListNode<T> current = head;
		while(current.getNext() != null){
			previous = current;
			current = current.getNext();
		}	
		current = null;
		previous.setNext(null);
	}
	}
	 
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 * Changing the currentNode to point to the node after the next
	 * @param currentNode  .
	 */
	public void deleteNext( LinkedListNode<T> currentNode ){
		LinkedListNode<T> temp;		
		if(currentNode.getNext() != null){
			temp = currentNode.getNext();	
			currentNode.setNext(temp.getNext());   
		}
	}
	 
	/**
	 * @return size, the number of nodes in this list.
	 * 
	 */
	public int size(){
		
		int size = 0;
		LinkedListNode<T> currentNode = head;
		while(currentNode != null){
			size++;
			currentNode = currentNode.getNext();
		}
		return size;
	}
	 
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 */
	public boolean isEmpty(){
		if(head == null){
			return true;
		}else{
			return false;
		}
	}
	 
	/**
	 * Return a String representation of the list.
	 */
	public String toString(){
		  String result = "";
          LinkedListNode<T> current = head; 
          if(head != null){
          result = head.toString();
          while(current.getNext() != null){
              current = current.getNext();
        	  result += "\n" + current.toString() ;
          }return result;
          }else{
  return result;
	}
	}
}
