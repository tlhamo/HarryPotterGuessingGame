




import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

/**
 * This class is the Tree class that creates a tree for storing the information of 
 * xml file
 * @author Tseki
 *
 */
public class GameTree {
	private BinaryTreeNode<String> previousNode;
	private DefaultBinaryTree<String> tree;
	private BinaryTreeNode<String> currentNode;
	
	/**
	 * Constructor for Game tree that takes in the node from 
	 * the class with GUIS which received the node from the application 
	 * @param t that will have childred or has children
	 */
	public GameTree(DefaultBinaryTreeNode<String> t) {
		tree = new DefaultBinaryTree<String>();
		tree.setRoot(t);
		currentNode = tree.getRoot();
	}
	
	/**
	 * Returns current Node
	 * @return currentNode 
	 */
	public BinaryTreeNode<String> getCurrentNode() {
		return currentNode;
	}
	
	
	/**
	 * Sets the node in the gui class that is currently being evaluated 
	 * to currentNode in this class 
	 * @param newNode helps track current node here
	 */
	public void setCurrentNode(BinaryTreeNode<String> newNode) {
		currentNode = newNode;

	}
	/**
	 * Sets the previous Node from the gui class to previous node in this class
	 * Tracker for previous node
	 * @param previousNode before currentnode
	 */
	public void setPreviousNode(BinaryTreeNode<String> previousNode) {
		this.previousNode = previousNode;

	}
	
	/**
	 * Returns the previous node 
	 * @return previousNode to keep track of previous node
	 */
	public  DefaultBinaryTreeNode<String> getPreviousNode(){
		return (DefaultBinaryTreeNode<String>) previousNode;
	}
	
	/**
	 * Gets the root of the tree
	 * @return root tree root
	 */
	public DefaultBinaryTreeNode<String> getRoot() {
		return (DefaultBinaryTreeNode<String>) tree.getRoot();
	}
	
	/**
	 * 
	 * @param filename that is being written from
	 * @param character that the user passed in
	 * @param question that the user passed in 
	 * @param userAnswer that the user passed in
	 */
	public void editTree(String filename, String character, String question, String userAnswer) {
		BinaryTreeNode<String> temp = currentNode;
		BinaryTreeNode<String> newNode = new DefaultBinaryTreeNode<String>(
				question, null, null);

		previousNode.setRightChild(newNode);
		if (userAnswer.equals("yes") || userAnswer.equals("Yes")) {
			newNode.setRightChild(temp);
			newNode.setLeftChild(new DefaultBinaryTreeNode<String>(character,
					null, null));

		} else if (userAnswer.equals("no") || userAnswer.equals("No")) {
			newNode.setLeftChild(temp);
			newNode.setRightChild(new DefaultBinaryTreeNode<String>(character,
					null, null));
		}
		//calls writeTofile from writer class
		 Writer.writeToFile(filename, tree);
	}

	
}
