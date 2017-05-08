package datastructures;

/**
 * This class has methods to get data, setdata on a particular node
 * The childs can also be set and gotten and a checker called isLeaf 
 * is there to see if there are left and right nodes.
 * @author Tseki
 *
 * @param <T> type
 */
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T>{
	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;

	
	public DefaultBinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Gets the data 
	 * @return data gotten
	 */
	@Override
	public T getData() {
		return data;
	}
	
	/**
	 * Sets the data 
	 * @param data being set 
	 */
	@Override
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Returns the left node
	 * @return left node
	 */
	@Override
	public BinaryTreeNode<T> getLeftChild() {
		return left;
	}
	
	/**
	 * Returns the right node
	 * @return right node
	 */
	@Override
	public BinaryTreeNode<T> getRightChild() {		
		return right;
	}

	/**
	 * Sets left child to the node passed in
	 * @param left left node
	 */
	@Override
	public void setLeftChild(BinaryTreeNode<T> left) {
		this.left =  left;
		
	}
	
	/**
	 * Sets right child to node passed in 
	 * @param right right node
	 */
	@Override
	public void setRightChild(BinaryTreeNode<T> right) {
		this.right = right;
		
	}
	
	/**
	 * Checks if the left and right nodes exist
	 * @return true or false if left or right is null
	 */
	@Override
	public boolean isLeaf() {
		if(left == null && right == null){
		return true;
	}else{
		return false;
		}
	}

	
}
