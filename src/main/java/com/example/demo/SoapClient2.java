package com.example.demo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;



public class SoapClient2 {
	// SOAP Request
	/**
	 *
	 * <pre>
	 * {@code
	 * <soapenv:Envelope
			xmlns:ns="https://www.easycodeforall.com/xml-utility-online"
			xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	 *    <soapenv:Header />
	 *    <soapenv:Body>
	 *      <ns:request>
	 *       <ns:student>
	 *        <ns:id>123</ns:id>
	 *        <ns:name type="ENGG">SAGAR DUTTA</ns:name>
	 *       </ns:student>
	 *      </ns:request>
	 *    </soapenv:Body>
	 * </soapenv:Envelope>
	 * 
	</pre>
	
	 * }
	 */

	// SOAP Response
	/**
	 *
	 * <pre>
	 * {@code
	 * <SOAP-ENV:Envelope
			SOAP-ENV:encodingStyle="http://www.w3.org/2001/12/soap-encoding"
			xmlns:SOAP-ENV="http://www.w3.org/2001/12/soap-envelope">
	 *    <SOAP-ENV:Body
				xmlns:m="https://www.easycodeforall.com/xml-utility-online">
	 *       <m:GetStudentResponse>
	 *          <m:Student>Student registration is done. </m:Student>
	 *       </m:GetStudentResponse>
	 *    </SOAP-ENV:Body>
	 * </SOAP-ENV:Envelope>
	 * 
	</pre>
	
	 * }
	 */

	public static void main(String[] args) throws Exception {

		String soapEndpointUrl = "https://www.easycodeforall.com/virtualsrv/soap/xml_xml/m1642276960983?SRV=SoapTestService";
		String soapAction = "https://www.easycodeforall.com/virtualsrv/soap/xml_xml/m1642276960983";

		// Create request object
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();

		// createSoapEnvelope(soapMessage);
		SOAPPart soapPart = soapMessage.getSOAPPart();

		String myNamespace = "ns";
		String myNamespaceURI = "https://www.easycodeforall.com/xml-utility-online";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();

		// Request part as String
		String str = "";
        str = str + "<ns:request xmlns:ns=\"https://www.easycodeforall.com/xml-utility-online\">\n";
 
		str = str + "      <ns:student>\n";
 
		str = str + "       <ns:id>123</ns:id>\n";
 
		str = str + "       <ns:name type=\"ENGG\">SAGAR DUTTA</ns:name>\n";
 
		str = str + "      </ns:student>\n";
 
		str = str + "     </ns:request>\n"; 

		// Add request element to soap message
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document requestPart = documentBuilder.parse(
				new InputSource(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes())))));

		Element toBeImported = requestPart.getDocumentElement();
		soapBody.appendChild(soapBody.getOwnerDocument().importNode(toBeImported, true));

		soapMessage.writeTo(System.out);

		// SOAP message headers
		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", soapAction);
		soapMessage.saveChanges();

		// Log/print the request soap message to console
		System.out.println("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println("\n");

		// Create SOAP Connection
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		// Send SOAP Message to Server
		SOAPMessage soapResponse = soapConnection.call(soapMessage, soapEndpointUrl);

		// Print the webservice Response
		System.out.println("Response From Webservice:");
		soapResponse.writeTo(System.out);
		System.out.println();

		// Get SoapPart of the response as String.
		Element elm = soapResponse.getSOAPPart().getDocumentElement();
		String respAsString = toStringDocument(elm.getOwnerDocument());
		System.out.println("respAsString=" + respAsString);

		soapConnection.close();

	}

	private static String toStringDocument(Document doc) throws TransformerException {
		StringWriter sw = new StringWriter();
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.transform(new DOMSource(doc), new StreamResult(sw));
		return sw.toString();
	}
}




