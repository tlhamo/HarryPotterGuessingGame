import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTreeNode;

/**
 * This class contains all the GUI functionalities for the Unrestricted Twenty
 * Questions Game like jbuttons, labels etc. It also instatiates the a binary
 * tree.
 * 
 * @author Tseki
 *
 */
public class UnrestrictedTwentyQuestions extends JPanel implements
ActionListener {
    private JButton startButton, yesButton, noButton, submitButton, newGame;
    private JPanel otherPanel, characterPanel, questionPanel;
    private JTextField askInputCharacter, askInputYesNo, askInputQuestion;
    private JLabel label, ask, ask1, ask2;
    private GameTree tree;
    private BinaryTreeNode < String > newNode;
    private BinaryTreeNode < String > previousNode;
    private DefaultBinaryTreeNode < String > t;
    private boolean isPresent = false;
    private boolean isPressed = false;

    /**
     * The constructor takes in the TreeNode which was read from the xmlfile in
     * the main Application class
     * 
     * @param t
     *            Node that has all the other nodes attached
     */
    public UnrestrictedTwentyQuestions(DefaultBinaryTreeNode < String > t) {
        super(new BorderLayout());
        this.t = t;
        tree = new GameTree(t);
        newNode = tree.getCurrentNode();
        label = new JLabel();
        createCharacterPanel();
        createQuestionPanel();
        createOtherPanel();
        newGame();
        validate();
    }

    /**
     * Creates the Character Panel with images
     */
    public void createCharacterPanel() {
        characterPanel = new JPanel();
        characterPanel.add(new JLabel("Pick a character!"));
        addCharacterImages();
        characterPanel.setLayout(new GridLayout(0, 5));
        characterPanel.add(label);
        add(characterPanel, BorderLayout.NORTH);
        characterPanel.setBackground(new Color(216, 115, 17));
    }

    /**
     * Creates the other panel that hass the subbit button, start button and new
     * game button
     */
    public void createOtherPanel() {
        startButton = new JButton("start");
        startButton.addActionListener(this);
        otherPanel = new JPanel();
        submitButton = new JButton("submit");
        submitButton.addActionListener(this);
        submitButton.setVisible(false);
        otherPanel.add(submitButton);
        otherPanel.add(startButton);
        otherPanel.setLayout(new GridLayout(0, 3));
        add(otherPanel, BorderLayout.SOUTH);
    }

    /**
     * Creates question panel
     */
    public void createQuestionPanel() {
        questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(0, 1));
        add(questionPanel);
    }

    /**
     * Starts the game
     */
    public void startGame() {
        addYesNoButton();
        
        validate();
        startButton.setVisible(false);
    }

    /**
     * Contains all the methods for specific buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startGame();
            label.setText(t.getData());
        } else if (e.getSource() == yesButton) {
            isPressed = true;
            if (newNode.getLeftChild() != null) {
                updatePreviousNode();
                newNode = newNode.getLeftChild();
                updateNewNode();
            }
        } else if (e.getSource() == noButton) {
            isPressed = true;
            if (newNode.getRightChild() != null) {
                updatePreviousNode();
                newNode = newNode.getRightChild();
                updateNewNode();
            } else {
                if (isPresent) {
                    addQuestions();
                } else {
                    askCharacter();
                    askQuestion();
                    askYesOrNo();
                    validate();
                    submitButton.setVisible(true);
                }
            }
        } else if (e.getSource() == submitButton) {
            newNode = tree.getRoot();
            label.setText(newNode.getData());
            removeQuestions();
            tree.editTree("harrypottercopy.xml", askInputCharacter.getText(),
                askInputQuestion.getText(), askInputYesNo.getText());
            validate();
        } else if (e.getSource() == newGame) {
            if (isPressed) {
                newNode = tree.getRoot();

                label.setText(newNode.getData());
                // removeQuestions();
                validate();
            }
        }
    }
    
    /**
     * Updates the previous node to new position
     */
    public void updatePreviousNode() {
        previousNode = newNode;
        tree.setPreviousNode(previousNode);
        validate();
    }
    
    /**
     * Updates the current node to new position
     */
    public void updateNewNode() {
        tree.setCurrentNode(newNode);
        label.setText(newNode.getData());
        validate();
    }

    /**
     * Remove the jtextfields for that the user fills in
     */
    public void removeQuestions() {
        askInputCharacter.setVisible(false);
        askInputQuestion.setVisible(false);
        askInputYesNo.setVisible(false);
        ask.setVisible(false);
        ask1.setVisible(false);
        ask2.setVisible(false);

    }

    public void addQuestions() {
        askInputCharacter.setVisible(true);
        askInputQuestion.setVisible(true);
        askInputYesNo.setVisible(true);
        ask.setVisible(true);
        ask1.setVisible(true);
        ask2.setVisible(true);
    }

    /**
     * Asks the user to write the character they were thinking of
     */
    public void askCharacter() {
        isPresent = true;
        ask = new JLabel("Which character were you thinking of?");
        ask.setBounds(5, 100, 400, 50);
        questionPanel.add(ask);
        askInputCharacter = new JTextField();
        askInputCharacter.setBackground(Color.RED);
        askInputCharacter.setBounds(410, 10, 400, 50);
        askInputCharacter.setPreferredSize(new Dimension(80, 20));
        askInputCharacter.addActionListener(this);
        questionPanel.add(askInputCharacter);
    }

    /**
     * Asks the user to write a question for their character answer
     */
    public void askQuestion() {
        ask1 = new JLabel(
            "Please write a yes or no question for your character!");
        ask1.setBounds(5, 400, 400, 50);
        questionPanel.add(ask1);
        askInputQuestion = new JTextField();
        askInputQuestion.setBackground(Color.YELLOW);
        askInputQuestion.setBounds(410, 20, 400, 50);
        askInputQuestion.setPreferredSize(new Dimension(80, 20));
        askInputQuestion.addActionListener(this);
        questionPanel.add(askInputQuestion);

    }

    /**
     * Asks the user to write if the answer to the question is yes or no
     */
    public void askYesOrNo() {
        ask2 = new JLabel("Is the answer to your question yes or no?");
        ask2.setBounds(5, 50, 400, 50);
        questionPanel.add(ask2);
        askInputYesNo = new JTextField();
        askInputYesNo.setBackground(Color.BLUE);
        askInputYesNo.setBounds(410, 20, 400, 50);
        askInputYesNo.setPreferredSize(new Dimension(80, 20));
        askInputYesNo.addActionListener(this);
        questionPanel.add(askInputYesNo);
    }

    public boolean decisionButtonsPressed() {
        return isPressed;
    }

    /**
     * Adds character images to the character panel
     */
    public void addCharacterImages() {
        characterPanel
            .add(new JLabel(
                new ImageIcon(
                    "/Users/Tseki/Desktop/CS201/FinalProject/content/hermione.png")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/ron.jpg")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/harry.jpg")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/luna.png")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/snape.jpg")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/goyle.png")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/cedric.jpg")));
        characterPanel
            .add(new JLabel(
                new ImageIcon(
                    "/Users/Tseki/Desktop/CS201/FinalProject/content/voldemort.jpg")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/hagrid.jpg")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/nevill.jpg")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/susan.jpg")));
        characterPanel
            .add(new JLabel(
                new ImageIcon(
                    "/Users/Tseki/Desktop/CS201/FinalProject/content/mcgonagal.png")));
        characterPanel
            .add(new JLabel(
                new ImageIcon(
                    "/Users/Tseki/Desktop/CS201/FinalProject/content/dumbledore.jpg")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/myrtle.png")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/nick.png")));
        characterPanel.add(new JLabel(new ImageIcon(
            "/Users/Tseki/Desktop/CS201/FinalProject/content/fred.jpg")));
        add(new JLabel(
            new ImageIcon(
                "/Users/Tseki/Desktop/CS201/FinalProject/content/xyYxEkoZakoSI.gif")));
    }

    /**
     * Adds the yes or no button for user response to questions
     */
    public void addYesNoButton() {
        yesButton = new JButton("yes");
        yesButton.addActionListener(this);
        noButton = new JButton("no");
        noButton.addActionListener(this);
        characterPanel.add(yesButton, BorderLayout.SOUTH);
        characterPanel.add(noButton, BorderLayout.SOUTH);
    }
    
    /**
     * Resets the game and starts with the first question
     */
    public void newGame() {
        newGame = new JButton("New Game");
        newGame.addActionListener(this);
        otherPanel.add(newGame);
        if (askInputQuestion != null && askInputYesNo != null &&
            askInputCharacter != null) {
            removeQuestions();
        }
    }

}