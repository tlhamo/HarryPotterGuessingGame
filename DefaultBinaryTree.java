package datastructures;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;



/**
 * The DefaultBinaryTree class implements methods from Binary 
 * Sets each dwarf node, contains the traversal methods 
 * Has methods to get root and check if the Linked List is empty
 * The traversals add data into the linked list 
 * @author Tseki
 *
 * @param <T> type
 */
public class DefaultBinaryTree<T> implements BinaryTree<T>{
	
public BinaryTreeNode<T> root;
	//linkedLists with type DefaultBinaryTree

	
	public DefaultBinaryTree(){	
	//inorderTraversal();
	//preorderTraversal();
	//postorderTraversal();
	}
	
	/**
	 * Main method that instantiates a new DefaultBinaryTree 
	 * and adds nodes to the tree 
	 * @param args
	 */
	//public static void main(String args[]){
		
	//}
	
	/**
	 * Gets the root of tree
	 * @return root
	 */
	@Override
	public BinaryTreeNode getRoot() {
		return root;
	}
	
	/**
	 * Sets the root of tree
	 * @param root tree root
	 */
	@Override
	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	/**
	 * Checks if the linked list is empty or not
	 */
	@Override
	public boolean isEmpty() {
		if (root != null){
			return false;
		}
		return true;
		}
	
	/**
	 * Calls the recursive inorderTraversal method
	 */
	@Override
	public LinkedList<T> inorderTraversal() {
		LinkedList<T> dwarfs = new LinkedList<T>();
		inorderTraversal(getRoot(), dwarfs);
		return  dwarfs;
	}
	
	/**
	 * Gets the left Child then prints then gets right child 
	 * @param node starts at root
	 * @param dwarfs1 linkedList that is being evaluated
	 */
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> dwarfs){		
		if(node != null){								
		inorderTraversal(node.getLeftChild(), dwarfs);		
		dwarfs.insertLast((T) node.getData());
		inorderTraversal(node.getRightChild(), dwarfs);
		}
	}
	
	/**
	 * Calls the recursive preorderTraversal method
	 * @return linked list that was added to
	 */
	@Override
	public LinkedList<T> preorderTraversal() {
			LinkedList<T> dwarfs = new LinkedList<T>();
			preorderTraversal(getRoot(), dwarfs);	
			return dwarfs;
		}	
	
	/**
	 * Recursive method that prints each node that it travels to 
	 * @param node that will shift to left or right child
	 * @param dwarfs2 linked list that was added to
	 */
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T> dwarfs){
		if(node != null){
			dwarfs.insertLast((T) node.getData());
			preorderTraversal(node.getLeftChild(), dwarfs);
			preorderTraversal(node.getRightChild(), dwarfs);				
			}		
		}
	
	/**
	 * Calls the recursive postorderTraversal method
	 * @return dwarfs linked list that was added to 
	 */
	@Override
	public LinkedList postorderTraversal() {
		LinkedList<T> dwarfs = new LinkedList<T>();
		postorderTraversal(getRoot(), dwarfs);
		return dwarfs;
	}
	
	/**
	 * Recursive postOrder traversal method
	 * @param node starts at root and makes it way through the tree
	 * @param dwarfs3 linked list that is 
	 */
	private void postorderTraversal(BinaryTreeNode<T> node, LinkedList<T> dwarfs){		
		if(node != null){			
			postorderTraversal(node.getLeftChild(), dwarfs);
			postorderTraversal(node.getRightChild(), dwarfs);
			dwarfs.insertLast((T) node.getData());
			}
		
		}


	
}
