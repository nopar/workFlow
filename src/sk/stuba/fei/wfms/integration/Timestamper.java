package sk.stuba.fei.wfms.integration;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.WebServiceException;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.tsp.TSPAlgorithms;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TimeStampRequest;
import org.bouncycastle.tsp.TimeStampRequestGenerator;
import org.bouncycastle.tsp.TimeStampResponse;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import stuba.fei.wfms.wsc.TS;
import stuba.fei.wfms.wsc.TSSoap;

/**
 * 
 * @author Matej Pivarci
 */
public class Timestamper {
    
    private static byte[] getTimestamp(String base64data) 
            throws WebServiceException 
    {
        TSSoap port = (new TS()).getTSSoap();
        String out = port.getTimestamp(base64data);
        if(out == null)
            throw new WebServiceException("Webová služba nedostupná");
        return out.getBytes();
    }
    
    private static byte[] getSignValue(String xmlFilePath) 
            throws ParserConfigurationException,
                    SAXException,
                    IOException 
    {
        DocumentBuilderFactory docFactory = 
                DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new File(xmlFilePath));
        
        Node signValElm = 
                doc.getElementsByTagName("ds:SignatureValue").item(0);
        
        String out = signValElm.getChildNodes().item(0).getNodeValue();
        
        return out.getBytes();
    }
    
    
    private static String createTSinB64(String xmlFilePath) 
            throws 
            ParserConfigurationException, 
            IOException, 
            SAXException,
            WebServiceException,
            TSPException
    {
        TimeStampRequestGenerator rGen = new TimeStampRequestGenerator();
        rGen.setCertReq(false);
        
        byte[] signValue = getSignValue(xmlFilePath);
        TimeStampRequest req = rGen.generate(TSPAlgorithms.SHA1, signValue);
        
        byte[] encoded = req.getEncoded();
        
        byte[] resp = getTimestamp(Base64.encodeBase64String(encoded));
        TimeStampResponse tsResp = 
                new TimeStampResponse(Base64.decodeBase64(resp));
        
        //tsResp.validate(req);
        
        return 
            Base64.encodeBase64String(tsResp.getTimeStampToken().getEncoded());
    }
    
    public static void injectTimestamp(String xmlFilePath) 
            throws 
            ParserConfigurationException, 
            SAXException, 
            IOException, 
            WebServiceException, 
            TSPException, 
            TransformerConfigurationException, 
            TransformerException 
    {
        
        DocumentBuilderFactory docFactory = 
                DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new File(xmlFilePath));
        
        Node qualProp = 
                doc.getElementsByTagName("xades:QualifyingProperties").item(0);
        
        Element unProp =
                doc.createElement("xades:UnsignedProperties");
        
        Element unSigProp = 
                doc.createElement("xades:UnsignedSignatureProperties");
        
        Element sTS = doc.createElement("xades:SignatureTimeStamp");
        Attr att = doc.createAttribute("id");
        att.setValue("timeStamp42");
        
        String ts = createTSinB64(xmlFilePath);
        
        Element ensTS = doc.createElement("xades:EncapsulatedTimeStamp");
        ensTS.appendChild(doc.createTextNode(ts));
        
        sTS.appendChild(ensTS);
        sTS.setAttributeNode(att);
        
        unSigProp.appendChild(sTS);
        unProp.appendChild(unSigProp);
        qualProp.appendChild(unProp);
        
        // final write
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	DOMSource source = new DOMSource(doc);
	StreamResult result = new StreamResult(new File(xmlFilePath));
	transformer.transform(source, result);
    }
    
}
