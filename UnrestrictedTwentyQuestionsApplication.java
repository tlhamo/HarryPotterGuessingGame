import javax.swing.JFrame;
import datastructures.DefaultBinaryTreeNode;

/**
 * Application class for the unrestrictedTwenty questions game
 * It creates the frame and reads the xml file that will 
 * be converted to a tree
 * @author Tseki
 *
 */
public class UnrestrictedTwentyQuestionsApplication {
	
	public static void main(String[] args){
	
		JFrame gameFrame = new JFrame("20 Questions");	
		
	    gameFrame.setSize(1500, 600);		    
	    
	  //  String filename = args[0];
		 
		DefaultBinaryTreeNode<String>  t = Reader.readFromFile("/Users/Tseki/Desktop/CS201/FinalProject/src/harrypotter.xml");
		 
		gameFrame.add( new UnrestrictedTwentyQuestions(t));
		
		gameFrame.setDefaultCloseOperation(3);
		 
		gameFrame.setVisible(true);
    
}
}
