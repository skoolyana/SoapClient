package com.example.demo.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import org.json.XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
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

import com.example.demo.XMLToJSONConverter;

import org.json.JSONObject; 
 





public class SoapClientUtil {
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


	
	
	
	/*
	 * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Header>
        <s0:ConvState soapenv:actor="http://schemas.xmlsoap.org/soap/actor/next" soapenv:mustUnderstand="1" xmlns:s0="http://www.datalex.com/m3"/>
    </soapenv:Header>
    <soapenv:Body>
        <InventoryAvailabilitySv xmlns="http://www.datalex.com/m3">
            <InventoryAvailabilitySvRQ MajorVersion="1" ClientId="DVC-MOCK" Username="DVC-MOCK" xmlns="urn:runtime.hri.rqrs.datalex.com">
                <InventoryAvailabilityRQ>
                    <InventoryProduct Sequence="1" ComponentCode="CHECKEDBAG_10KG" InventoryKeyCode="CARRIER_AND_FLIGHT_NUMBER_INVKEY" FreeSale="false">
                        <InventoryComponent Sequence="1" ConsumptionDateTime="2022-12-20T13:34:00.000" SaleDateTime="2022-12-12T10:51:08.670">
                            <AvailabilityInfo Amount="3"/>
                            <GroupRef GroupIDRef="ID-9"/>
                        </InventoryComponent>
                    </InventoryProduct>
                </InventoryAvailabilityRQ>
            </InventoryAvailabilitySvRQ>
        </InventoryAvailabilitySv>
    </soapenv:Body>
</soapenv:Envelope>
	 * 
	 * 
	 * 
	 * 
	 * */

	public static void main(String[] args) throws Exception {

		String soapEndpointUrl = "http://10.160.5.244:8080/soap/OTA/com/datalex/m3/M3.jws";
		//String soapAction = "https://www.easycodeforall.com/virtualsrv/soap/xml_xml/m1642276960983";
		
		// Create request object
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();

		// createSoapEnvelope(soapMessage);
		SOAPPart soapPart = soapMessage.getSOAPPart();
		String myxmlNamespace = "xmlns";
		String myxmlNamespaceHeader = "xmlns";
		
		String myNamespaceURI = "http://www.datalex.com/m3";

		
		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		//envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
		
		//envelope.("SOAP-ENV"); // delete standard namespace which was already set
		
		envelope.addNamespaceDeclaration("xmlns", "http://schemas.xmlsoap.org/soap/envelope/");
		
		envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
		
		envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		
		
		
		
		
		
		
		
		// <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">

		
		
		
		// <soapenv:Header>
        //<s0:ConvState soapenv:actor="http://schemas.xmlsoap.org/soap/actor/next" soapenv:mustUnderstand="1" xmlns:s0="http://www.datalex.com/m3"/>
    //</soapenv:Header>
		
		 SOAPHeader  soapHeader = envelope.getHeader();

		  // Add a ConvState element to the SOAP header
		    SOAPElement convStateElement = soapHeader.addChildElement("ConvState", "s0", "http://www.datalex.com/m3");
		    convStateElement.setAttribute("actor", "http://schemas.xmlsoap.org/soap/actor/next");
		    convStateElement.setAttribute("mustUnderstand", "1");

		    // Get the SOAP body
		    SOAPBody soapBody = soapMessage.getSOAPBody();

		    // Add an InventoryAvailabilitySv element to the SOAP body
		    SOAPElement inventoryAvailabilitySvElement = soapBody.addChildElement("InventoryAvailabilitySv", "", "http://www.datalex.com/m3");

		    // Add an InventoryAvailabilitySvRQ element to the InventoryAvailabilitySv element
		    SOAPElement inventoryAvailabilitySvRQElement = inventoryAvailabilitySvElement.addChildElement("InventoryAvailabilitySvRQ", "", "urn:runtime.hri.rqrs.datalex.com");
		    inventoryAvailabilitySvRQElement.setAttribute("MajorVersion", "1");
		    inventoryAvailabilitySvRQElement.setAttribute("ClientId", "DVC-MOCK");
		    inventoryAvailabilitySvRQElement.setAttribute("Username", "DVC-MOCK");

		    // Add an InventoryAvailabilityRQ element to the InventoryAvailabilitySvRQ element
		    SOAPElement inventoryAvailabilityRQElement = inventoryAvailabilitySvRQElement.addChildElement("InventoryAvailabilityRQ");

		    // Add an InventoryProduct element to the InventoryAvailabilityRQ element
		    SOAPElement inventoryProductElement = inventoryAvailabilityRQElement.addChildElement("InventoryProduct");
		    inventoryProductElement.setAttribute("Sequence", "1");
		    inventoryProductElement.setAttribute("ComponentCode", "CHECKEDBAG_10KG");
		    inventoryProductElement.setAttribute("InventoryKeyCode", "CARRIER_AND_FLIGHT_NUMBER_INVKEY");
		    inventoryProductElement.setAttribute("FreeSale", "false");

		    // Add an InventoryComponent element to the InventoryProduct element
		    SOAPElement inventoryComponentElement = inventoryProductElement.addChildElement("InventoryComponent");
		    inventoryComponentElement.setAttribute("Sequence", "1");
		    inventoryComponentElement.setAttribute("ConsumptionDateTime", "2022-12-20T13:34:00.000");
		    inventoryComponentElement.setAttribute("SaleDateTime", "2022-12-12T10:51:08.670");

		    // Add an AvailabilityInfo element to the InventoryComponent element
		    SOAPElement availabilityInfoElement = inventoryComponentElement.addChildElement("AvailabilityInfo");
		    availabilityInfoElement.setAttribute("Amount", "3");
		
		 // Add an GroupRef element to the InventoryComponent element
		    SOAPElement groupRefElement = inventoryComponentElement.addChildElement("GroupRef");
		    groupRefElement.setAttribute("GroupIDRef", "ID-9");
		
		
		

		//soapMessage.writeTo(System.out);

		// SOAP message headers
		MimeHeaders headers = soapMessage.getMimeHeaders();
		//headers.addHeader("SOAPAction", soapAction);
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
		
		//Node elm = soapResponse.getSOAPBody().getElementsByTagName("SOAP-ENV:Body");
		
		String respAsString = toStringDocument(elm.getOwnerDocument());
		System.out.println("respAsString=" + respAsString);
				soapConnection.close();

				System.out.println("----------");
				
				System.out.println(XMLToJSONConverter.xmlToJson(respAsString));
				

				
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




