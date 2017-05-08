package datastructures;

/**
 * 
 * The LinkedListNode class keeps in memory what the data 
 * at a node is and contains methods to aid with pointers
 * to next nodes 
 * 
 * @author Tseki
 * date  28 March 2017
 */
		
public class LinkedListNode<T> {
	
	private T data;
	private LinkedListNode<T> next;
	
	public LinkedListNode(T data, LinkedListNode<T> next){
		this.data = data;
		this.next = next;
		
	}
	/**
	 * @param data Set data at this node.
	 */
	public void setData( T data ){
		this.data = data; 
	}
	 
	/**
	 * @return the data stored at this node.
	 */
	public T getData(){
		return data;
	}
	 
	/**
	 * @param node Set the next pointer to passed node.
	 */
	public void setNext( LinkedListNode<T> node ){
		next = node;
	}
	 
	/**
	 * @return Get (pointer to) next node.
	 */
	public LinkedListNode<T> getNext(){
		return next;
		
	}
	 
	/**
	 * Returns a String representation of this node.
	 */
	public String toString(){
		if(data != null){
			return data.toString();
		}else{
			return " ";
		}
	}
}
