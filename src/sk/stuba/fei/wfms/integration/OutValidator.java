package sk.stuba.fei.wfms.integration;

import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import sk.stuba.fei.wfms.xmlhandler.HandlerXML;

/**
 * @author Matej Pivarci
 */
public class OutValidator {
    
    private File xmlToVal = null;
    
    public File getXmlToVal() {
        return xmlToVal;
    }
    public void setXmlToVal(File xmlToVal) {
        this.xmlToVal = xmlToVal;
    }
    
    public OutValidator(File xmlToVal) {
        this.xmlToVal = xmlToVal;
    }

    public String valXades() 
            throws Exception,IOException,SAXException 
    {
        if(xmlToVal==null)
            throw new Exception("File to validate not provided!");
        
        boolean valid;
        valid = HandlerXML.XsdValidateXml(xmlToVal.getPath(),"schemas/Rteam_xades.xsd");
        
        // @TODO
        
        if(valid)
            return "File is valid.";
        else 
            return "File is invalid.";
    }
     
}
