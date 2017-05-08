import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTreeNode;
/**
 * The Restricted twenty questions game gives the player 16 characters 
 * to choose from and the application guess the character depending on the 
 * yes and no answers 
 * This class contains the GUI layout for the game 
 * @author Tseki
 *
 */
public class RestrictedTwentyQuestions extends JPanel implements ActionListener{
		private  JButton startButton;
		private JPanel characterPanel, bottomPanel;
		private DefaultBinaryTreeNode<String> t;
		private GameTree tree;
		private  JLabel label;
		private JButton noButton, yesButton, newGame;
		private BinaryTreeNode<String> newNode; 
	
	/**
	 * Constructor creates a borderLayout for the GUI and adds the panels 
	 * @param t node with children
	 */
	 public RestrictedTwentyQuestions(DefaultBinaryTreeNode<String> t){
		 	super(new BorderLayout());
			this.t = t;			
			tree = new GameTree(t);
			newNode = tree.getCurrentNode();				 	
		    label = new JLabel();
		    createCharacterPanel();
		    createBottomPanel();
		    validate();
		}
	
	 /**
	 * Creating the character Panel
	 */
	 public void createCharacterPanel(){
		 characterPanel = new JPanel();    
		 characterPanel.add(new JLabel("Pick a character from the HarryPotter series!"));
		 addCharacterImages();
		 characterPanel.add(label);
		 characterPanel.setLayout(new GridLayout(0,5));
		 characterPanel.setBackground(new Color(216,115,17));
		 add(characterPanel, BorderLayout.NORTH);
	 }
	 
	 /**
	  * Creating the bottom panel
	  */
	 public void createBottomPanel(){
		 bottomPanel = new JPanel();   
		 startButton = new JButton("start");
		 startButton.addActionListener(this);
		 newGame = new JButton("New Game");
		 newGame.addActionListener(this);
		 bottomPanel.add(startButton);
		 bottomPanel.add(newGame);
		 add(bottomPanel, BorderLayout.SOUTH);
	 }
	
	 /**
	  * Starts the game by adding the yes and no buttons
	  */
	public void startGame(){		
	   	addYesNoButton();
	   	validate();
	   	startButton.setVisible(false);
	}
	
	/**
	 * Start, yes and no button functionalities depending on which button was clicked
	 * There is the yesButton, noButton, startButton, and Newgame button
	 * @param e the button clicked 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == startButton){
		startGame();
		label.setText(t.getData());
		validate();
	}else if (e.getSource() == yesButton){		
		if(newNode.getLeftChild() != null){
			newNode = newNode.getLeftChild();
			label.setText(newNode.getData());
			validate();
			}
	}else if (e.getSource() == noButton){	
		if(newNode.getRightChild() != null){
			newNode = newNode.getRightChild();
			label.setText(newNode.getData());
			validate();
			}		
	}else if(e.getSource() == newGame){
			newNode = tree.getRoot();
			label.setText(newNode.getData());
			validate();
		}
	}
	
	/**
	 * Adds the yes and no buttons for the user to click 
	 */
	public void addYesNoButton(){
		 yesButton = new JButton("yes");
		 yesButton.addActionListener(this);
		 noButton = new JButton("no");
		 noButton.addActionListener(this);
		 characterPanel.add(yesButton, BorderLayout.SOUTH);
		 characterPanel.add(noButton, BorderLayout.SOUTH);
	}
	
	/**
	 * Adds the harry potter images to the GUI
	 */
	public void addCharacterImages(){
		 	characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/hermione.png")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/ron.jpg")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/harry.jpg")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/luna.png")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/snape.jpg")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/goyle.png")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/cedric.jpg")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/voldemort.jpg")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/hagrid.jpg")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/nevill.jpg")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/susan.jpg")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/mcgonagal.png")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/dumbledore.jpg")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/myrtle.png")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/nick.png")));
		    characterPanel.add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/fred.jpg")));	
		    add(new JLabel(new ImageIcon("/Users/Tseki/Desktop/CS201/FinalProject/content/xyYxEkoZakoSI.gif")));
	}
	
	
}