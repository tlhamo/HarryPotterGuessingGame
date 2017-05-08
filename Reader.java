
import javax.xml.parsers.*;

import org.w3c.dom.*;

import datastructures.DefaultBinaryTreeNode;

import java.io.*;


/**
 * The reader calls reads the file by parsing through it and returns a binarytreenode with child nodes
 * that will be put into the tree
 * 
 * @author Tseki
 *
 */
public class Reader {
	/**
	 * Converts file to an XML file, creates a document that is the parsed xml,
	 * catches exception
	 * @param filename file that will be parsed
	 * @return binary tree node and will create a tree based off of this
	 */
	public static DefaultBinaryTreeNode<String> readFromFile(String filename){
		
		File xmlFile = new File(filename);
		
		Document document = null;
		
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(xmlFile);
		}catch(Exception e){
			System.out.println("Exception e caught");
		return null;
		
		}	
		//calls the recursive method
		return parsePeople(document.getDocumentElement());
	}


	/**
	 * This method parses through the xml file and checks for specific node names and attribute tags
	 * and sets left and right child accordingly. If yes, setleftchild, if no, setrightchild
	 * @param root starting node of tree
	 * @return btn a binary tree node that has the attached children
	 */
	private static DefaultBinaryTreeNode<String> parsePeople(Node root) {	
		//make it an element so that the attributes can be accessed
		Element el = (Element) root;
		//create a new binary tree node which will be the first root and will have child nodes attached
		DefaultBinaryTreeNode<String> btn = new DefaultBinaryTreeNode<String>(el.getAttribute("q"), null, null);		
		if (root.getNodeName().equals("question")  && root.hasChildNodes()) {	
			NodeList pList = root.getChildNodes();
			for (int i = 0; i < pList.getLength(); i++) {	
		        Node n = pList.item(i);	      
			if(n.getNodeType() == Node.ELEMENT_NODE){
		        Element currentElt = (Element)n; 
		         if(!currentElt.getNodeName().equals("answer") && currentElt.getAttribute("ans").equals("yes")){
					btn.setLeftChild(parsePeople(n));
				}else if(!currentElt.getNodeName().equals("answer") && currentElt.getAttribute("ans").equals("no")){
					btn.setRightChild(parsePeople(n));				
				}else if(currentElt.getNodeName().equals("answer") && currentElt.getAttribute("ans").equals("yes")){
					btn.setLeftChild(new DefaultBinaryTreeNode<String> (n.getTextContent(), null, null));
				}else if(currentElt.getNodeName().equals("answer") && currentElt.getAttribute("ans").equals("no")){
					btn.setRightChild(new DefaultBinaryTreeNode<String> (currentElt.getTextContent(), null, null));
					
				}
			}
			
		}
		
	}
		return btn;
	}
	
	
	
}


		