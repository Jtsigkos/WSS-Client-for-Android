package de.kp.wsclient.security;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SecBase {

    protected Element createSTR(Document xmlDoc) {
        
    	String qualifiedName = SecConstants.WSSE_PRE + ":" + SecConstants.SECURITY_TOKEN_REFERENCE;
    	Element secRef = xmlDoc.createElementNS(SecConstants.WSSE_NS, qualifiedName);
 
    	Element ref = createReference(xmlDoc);
    	
    	ref.setAttribute("URI", "#" + SecConstants.SENDER_CERT);
    	ref.setAttribute("ValueType",  SecConstants.X509TOKEN_NS + "#X509v3");
 
    	secRef.appendChild(ref);
    	return secRef;
    	
    }
   
    protected Element createReference(Document xmlDoc) {

    	String qualifiedName = SecConstants.WSSE_PRE + ":" + SecConstants.REFERENCE;
    	Element ref = xmlDoc.createElementNS(SecConstants.WSSE_NS, qualifiedName);
    	
    	return ref;
    	
    }


    protected Element getSecHeader(Document xmlDoc) {

	    NodeList nodes = xmlDoc.getElementsByTagNameNS(SecConstants.WSSE_NS, SecConstants.SECURITY);
	    if (nodes.getLength() == 0) return null;

        return (Element) nodes.item(0);

    }

}