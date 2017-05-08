import javax.swing.JFrame;

import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

/**
 * Application class for the restrictedTwenty questions game
 * It creates the frame and reads the xml file that will 
 * be converted to a tree
 * @author Tseki
 *
 */
public class RestrictedTwentyQuestionsApplication {
	
	public static void main(String[] args){
	
		JFrame gameFrame = new JFrame("20 Questions");	
		
	    gameFrame.setSize(1000, 600);		    
	    
	  //  String filename = args[0];
		 
		DefaultBinaryTreeNode<String>  t = Reader.readFromFile("/Users/Tseki/Desktop/CS201/FinalProject/src/harrypotter.xml");
		 
		gameFrame.add( new RestrictedTwentyQuestions(t));
		
		gameFrame.setDefaultCloseOperation(3);
		    
		gameFrame.setVisible(true);
    
}
}
