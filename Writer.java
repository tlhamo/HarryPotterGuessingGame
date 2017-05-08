import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;

/**
 * This Class overwrites file with new inputed data that the user gave.
 * It walks through the tree checking it's data and sets appends children
 * to document based on the data in each node of tree
 * @author Tseki
 *
 */
public class Writer {
	
	/**
	 * Writes on the xml file to inlcude the new user inputed answer
	 * 
	 * @param filename name of file to edit
	 * @param tree that will be read for information to put into xml file
	 */
	public static void writeToFile(String filename, DefaultBinaryTree<String> tree) {
		File xmlFile = new File(filename);
		Document document = null;

		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			document = documentBuilder.newDocument();
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}
		document.appendChild(addNode(tree.getRoot(), document));
		
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");

			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(xmlFile);
			transformer.transform(source, result);
		} catch (Exception e) {
			// recovery action!
			System.out.println("You have reached exception: " + e);
		}
	}

	/**
	 * Adds children to the doc root by corresponding to the information in the root and its children
	 * Creates question element and answer element
	 * creates q and ans attributes
	 * @param root reads the root and its children for information
	 * @param doc  adds information to the document
	 * @return and element with children and null is there was nothing in the tree
	 */
	private static Element addNode(BinaryTreeNode<String> root, Document doc) {
		Element xmle = doc.createElement("question");
		xmle.setAttribute("q", root.getData().toString());
		if(root != null){
			if(root.isLeaf()){
			 Element xmlLeaf = doc.createElement("answer");
			 xmlLeaf.appendChild( doc.createTextNode(root.getData().toString()));
			 xmlLeaf.setAttribute("q", null);
			 return xmlLeaf;
			}
			else{
				Element xmly = addNode(root.getLeftChild(), doc);
				if(!root.getLeftChild().isLeaf()){
				xmly.setAttribute("q", root.getLeftChild().getData().toString());
				}
				xmly.setAttribute("ans", "yes");
				xmle.appendChild(xmly);
				Element xmln = addNode(root.getRightChild(), doc);
				if(!root.getRightChild().isLeaf()){
				xmln.setAttribute("q", root.getRightChild().getData().toString());
				}
				xmln.setAttribute("ans", "no");
				xmle.appendChild(xmln);
				}
				return xmle;
			}
		//if the tree has nothing in it 
		return null;
		}
	}

	

