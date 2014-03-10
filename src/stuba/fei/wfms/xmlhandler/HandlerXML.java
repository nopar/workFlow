package stuba.fei.wfms.xmlhandler;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Handler class wrapping native Java operations with XML files with only String
 * inputs/outputs.Uses DOM structure and factories.
 * @version 1.2
 * @author Matej Pivarci
 */
public class HandlerXML {

    /**
     * Root element name, default name if not set is null.
     */
    private String root = null;
    
    /**
     * Variable to hold current handlers loaded XML document.
     */
    private Document doc;
    
    /**
     * Getter for root variable.
     * @return String name of root element.
     */
    public String getRoot() 
    {
        return root;
    }

    /**
     * Setter for root variable.
     * @param root Root element name to set.
     */
    public void setRoot(String root) 
    {
        this.root = root;
    }

    /**
     * Constructor for creating new handler with provided root element name.
     * @param root Provided root element name.
     */
    public HandlerXML(String root) 
    {
        this.root = root;
    }
    
    /**
     * Default empty constructor
     */
    public HandlerXML() {
    }
    
    /** 
     * Load XML DOM from provided file path or create new clean structure and 
     * set root element variable.
     * @param xmlFilePath Path to XML file.
     * @throws Exception When I/O error is triggered with file, or document
     * builder from factory cannot be made, or parsing issues.
     */
    public void loadXml(String xmlFilePath) 
            throws Exception 
    {
        // creating new builder
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        
        File xmlFile = new File(xmlFilePath);
        
        if(xmlFile.exists()) {
            // parse XML file and set root element name from it
            doc = dBuilder.parse(xmlFile);
            root = doc.getDocumentElement().getNodeName();
        } else {
            doc = dBuilder.newDocument();
            // checkes whether root element name is given and 
            // creates it, if not, raises exception
            if(root != null) {
                Element rootElement = doc.createElement(root);
                doc.appendChild(rootElement);
            } else {
                throw new Exception("Name for root element not set");
            }
        }
    }
    
    /**
     * Private method for retrieving last Node from loaded document with 
     * provided name.
     * @param name Tag name of the node.
     * @return Last node object found in loaded document with provided tag name.
     * @throws Exception When node is not found in loaded DOM structure.
     */
    private Node getNode(String name) 
            throws Exception 
    {
        NodeList nl = doc.getElementsByTagName(name);
        if(nl.getLength() == 0 )
            throw new Exception("Element '" + name + "' not found!");
        return nl.item(nl.getLength()-1);
    }
    
    /**
     * Create element in loaded document with provided name inside parent
     * identified with last occurrence of his name.
     * @param parent Parent element of creating element.
     * @param name Name of element.
     * @throws Exception When node is not found in loaded DOM structure or
     * no DOM structure is found.
     */
    public void createTag(String parent, String name) 
            throws Exception 
    {
        if(doc == null) 
            throw new Exception("No document loaded. Cannot create element!");
        Node elm = doc.createElement(name);
        this.getNode(parent).appendChild(elm);
    }
    
    /**
     * Create element in loaded document with provided name inside parent 
     * identified with last occurrence of his name and inserts text in it.
     * @param parent Parent element of creating element.
     * @param name Name of element.
     * @param innerText Text inside element.
     * @throws Exception When node is not found in loaded DOM structure.
     */
    public void createTag(String parent, String name, String innerText) 
            throws Exception 
    {
        if(doc == null) 
            throw new Exception("No document loaded. Cannot create element!");
        Node elm = doc.createElement(name);
        elm.appendChild(doc.createTextNode(innerText));
        this.getNode(parent).appendChild(elm);
    }
    
    /**
     * Create attribute in loaded document.Set it to last occurrence of given 
     * element with provided name and value.If this element already has this 
     * attribute with this name,the value is rewritten.
     * @param element Name of element to which set attribute
     * @param name Name of attribute
     * @param value Value of attribute
     * @throws Exception In case of document not loaded or element with provided
     * name does not exist.
     */
    public void createAttr(String element, String name, String value)
            throws Exception
    {
        if(doc == null) 
            throw new Exception("No document loaded. Cannot create attribute!");
        Attr at = doc.createAttribute(name);
        Element elm = (Element) this.getNode(element);
        elm.setAttribute(name, value);
    }
    
    
    /**
     * Method for saving loaded XML DOM structure into XML file with given path.
     * @param xmlFilePath Path to XML file to save to.
     * @return True or false if save was successful.
     * @throws Exception When is not possible to create transformer from factory
     * or I/O error with file transformation.
     */
    public boolean saveXml(String xmlFilePath) 
            throws Exception 
    {
        if(doc == null) 
            throw new Exception("No document loaded. Cannot save!");
        
        // create file on disc
        File xmlFile = new File(xmlFilePath);
        xmlFile.createNewFile();
        //creating new factory for transform
        TransformerFactory trFactory = TransformerFactory.newInstance();
        Transformer transformer = trFactory.newTransformer();
        //setting source and destination for transform
        DOMSource source = new DOMSource(doc);
	StreamResult result = new StreamResult(xmlFile);
    
        transformer.transform(source, result);
        
        return true;
    }
    
    /**
     * Static method for XML validation against XSD schema.
     * @param xmlFilePath Input XML file path.
     * @param xsdFilePath XSD schema path.
     * @return True or false if xml is valid against schema or not.
     * @throws IOException When I/O error with both files occurs.
     * @throws SAXException When XML file is not valid.
     */
    public static boolean XsdValidateXml(String xmlFilePath, String xsdFilePath)
            throws IOException, SAXException
    {
        try {
            SchemaFactory factory =
                  SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFilePath)));
        } catch (SAXException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Static method for XML transformation using provided XSL file.
     * @param xmlFilePath Path to input XML file.
     * @param xslFilePath Path to XSL transformation file.
     * @param outputFile Path to output file.
     * @return True or false if transformation was successful or it wasn't.
     * @throws Exception In case of I/O error with files, or creation of 
     * transformation factory.
     */
    public static boolean xslTransformXml(String xmlFilePath, 
                                  String xslFilePath,
                                  String outputFile) 
            throws Exception
    {
        //setting factory for transformation with specified XSL
        TransformerFactory tFactory = TransformerFactory.newInstance();            
        Transformer transformer =
                tFactory.newTransformer(new StreamSource(xslFilePath));
        //setting source and destination for transform
        StreamSource source = new StreamSource(new File(xmlFilePath));
	StreamResult result = new StreamResult(new File(outputFile));
        
        transformer.transform(source, result);
        
        return true;
    }
            
    /*public static void main(String[] args) {
        System.out.println("Initialize");
        
        HandlerXML hxml = new HandlerXML("root");
        
        String user = "user";
        String filePath = "doc.xml";
        
        try {
            hxml.loadXml(filePath);
            
            hxml.createTag(hxml.getRoot(), user);
            hxml.createAttr(user, "gender", "M");
            hxml.createTag(user, "name", "Paťo Novotný");            
            //hxml.createAttr("city", "district","Zvolen");
            hxml.createTag(user, "age", "24");
            hxml.createTag(user, "role", "admin");
            
            System.out.println(hxml.xslTransformXml(filePath, "doc.xsl", "out.txt"));
            //System.out.println(hxml.saveXml(filePath));
            //System.out.println(hxml.XsdValidateXml(filePath, "doc.xsd"));
            
        } catch (Exception ex) {
            System.out.println("");
        }
    }*/
}
