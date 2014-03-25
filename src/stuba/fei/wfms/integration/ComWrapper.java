package stuba.fei.wfms.integration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComFailException;
import com.jacob.com.LibraryLoader;
import com.jacob.com.Variant;
import java.io.StringReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * This class wraps Java COM Bridge (JACOB) open source library and uses it for
 * integrate COM bridge in Dsigner Xades xml signature program from Ditec.This
 * bridge and integration is tested only on 32-bit MS Windows systems with
 * installed program from Ditec.
 * @author Matej Pivarci
 */
public class ComWrapper {
    
    /**
     * Global variable for storing library dll file.
     */
    private String jacobDllFile;
    /**
     * Global variable for setting up if library is loaded.
     */
    private boolean libLoaded = false;
    /**
     * Getter for dll file.
     * @return Dll file path.
     */
    public String getJacobDllFile() {
	return jacobDllFile;
    }
    /**
     * Setter for dll file.
     * @param jacobDllFile Full file path.
     */
    public final void setJacobDllFile(String jacobDllFile) {
	this.jacobDllFile = jacobDllFile;
    }
    /**
     * Method for reading XML file as pure String in UTF-8 char encoding.
     * @param file Input XML file.
     * @return XML file contents as long String.
     * @throws IOException In case of I/O read/write error with given file.
     */
    private static String readXmlAsString (File file) 
            throws IOException {
	String out = "";
	String line;
	
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            while((line = br.readLine()) != null) {
                out += line;
            }
        }
	
	return out;
    }
    /**
     * Private method for creating Variant object via Dsig XML plugin to load it
     * into signature application.
     * @param xmlFile XML file to be signed.
     * @param xsdFile Schema for validation purposes.
     * @param xsdURI Schema namespace.
     * @param xslFile Transformation file to transform given XML to plain text.
     * @param xslURI XSLT namespace.
     * @param namespace Default XML file namespace.
     * @return JACOB object as Variant. 
     * @throws ComFailException Occurs when Dsig activeX component fails to load.
     * @throws IOException Read/write error with given files.
     * @throws Exception Other exceptions, mostly from third party app.
     */
    private Variant dSigCreateXmlObject(
	File xmlFile, File xsdFile, String xsdURI,
	File xslFile, String xslURI, String namespace) 
            throws ComFailException, IOException, Exception {

        if(!libLoaded) 
            throw new Exception("Cannot create object, library not loaded");
	
	String xml = readXmlAsString(xmlFile);
	String xsd = readXmlAsString(xsdFile);
	String xsl = readXmlAsString(xslFile);
		
	ActiveXComponent xmlPlugin = new ActiveXComponent("DSig.XmlPlugin");
		
	Variant obj = 
		xmlPlugin.invoke(
                    "CreateObject", 
                    new Variant[] {
                	new Variant("objectID"),
			new Variant(xmlFile.getName()),
			new Variant(xml),
			new Variant(xsd),
			new Variant(namespace),
			new Variant(xsdURI),
			new Variant(xsl),
			new Variant(xslURI)	
                    }
		);
	if(obj.getvt() == Variant.VariantEmpty)
            throw new Exception("Dsigner plugin error while creating XML object: " 
                        	+ xmlPlugin.getPropertyAsString("ErrorMessage"));
		
        return obj;
    }
    /**
     * Constructor with given path to JACOB DLL file.
     * @param jacobDllFile
     */
    public ComWrapper(String jacobDllFile){
	setJacobDllFile(jacobDllFile);
    }
    /**
     * Default blank constructor.
     */
    public ComWrapper(){}
    /**
     * Method for saving XML file from pure text source.
     * @param xml XML plain text.
     * @param path Given path to output file.
     * @throws IOException Read/write error with given file.
     * @throws TransformerConfigurationException Configuration of save error.
     * @throws TransformerException Cannot save given XML as file.
     */
    public static void saveXmlAsString(String xml, String path) 
            throws IOException, 
                   TransformerConfigurationException,
                   TransformerException {
        // create file on disc
        File xmlFile = new File(path);
        xmlFile.createNewFile();
        //creating new factory for transform
        TransformerFactory trFactory = TransformerFactory.newInstance();
        Transformer transformer = trFactory.newTransformer();
        //setting source and destination for transform
        StreamSource source = new StreamSource(new StringReader(xml));
        StreamResult result = new StreamResult(xmlFile);
    
        transformer.transform(source, result);
    }
    /**
     * Method for loading JACOB library.Must be called before signing method.
     * @throws UnsatisfiedLinkError DLL file with given path not found.
     */
    public void loadLibrary() 
            throws UnsatisfiedLinkError {
	System.setProperty(LibraryLoader.JACOB_DLL_PATH, new File(jacobDllFile).getAbsolutePath());
	LibraryLoader.loadJacobLibrary();
	libLoaded = true;
    }
    /**
     * Sign method with Xades and sha256 digest algorithm.
     * @param xmlFile XML file to sign.
     * @param xsdFile Schema for validation.
     * @param xsdURI Schema namespace.
     * @param xslFile Transformation file to transform given XML to plain text.
     * @param xslURI XSLT namespace.
     * @param namespace Default XML file namespace.
     * @return Signed XML file as pure text.
     * @throws ComFailException Occurs when Dsig activeX component fails to load.
     * @throws IOException Read/write error with given files.
     * @throws Exception Other exceptions, mostly from third party app.
     */
    public String signXades256(
        File xmlFile, File xsdFile, String xsdURI,
	File xslFile, String xslURI, String namespace) 
            throws ComFailException, IOException, Exception {

        if(!libLoaded) 
            throw new Exception("Cannot create signature, library not loaded");
		
	ActiveXComponent dSigner = new ActiveXComponent("DSig.XadesSig");
	Variant object = 
            dSigCreateXmlObject(xmlFile, xsdFile, xsdURI, xslFile, xslURI, namespace);
		
	Variant respAddO = dSigner.invoke("AddObject", object);
	if( respAddO.getInt() != 0 )
            throw new Exception("Adding object to Dsig Xades failed!");
		
	Variant respSign = 
            dSigner.invoke("Sign", new Variant[]{
                new Variant("signID"),
		new Variant("sha256"),
		new Variant("urn:oid:1.3.158.36061701.1.2.1")
            });
	if( respSign.getInt() != 0 )
            throw new Exception("Dsigner error while creating signature: " 
				+ dSigner.getPropertyAsString("ErrorMessage"));
		
	return dSigner.getPropertyAsString("SignedXmlWithEnvelope");
	}
        
	/* main example
	public static void main(String[] args) {
		ComWrapper cw = new ComWrapper("lib/jacob-1.17-x86.dll");
		String ns = "http://wfms.fei.stuba.sk/team/R";
		try {
			cw.loadLibrary();
			String sxml = cw.signXades256(new File("users.xml"), new File("schemas/users.xsd"), ns, new File("schemas/users.xsl"), ns, ns);
			System.out.println(sxml);
		} catch(UnsatisfiedLinkError | Exception e) {
			System.out.println(e.getMessage());
		}
	}
        */
}

