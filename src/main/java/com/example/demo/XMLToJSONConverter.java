package com.example.demo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLToJSONConverter {
    public static void main(String[] args) throws Exception {
        String xml = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=" +
                     "\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                     "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
                     "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
                     "<SOAP-ENV:Header></SOAP-ENV:Header>" +
                     "<SOAP-ENV:Body>" +
                     "<InventoryAvailabilitySvResponse xmlns=" +
                     "\"http://www.datalex.com/m3\">" +
                     "<InventoryAvailabilitySvRS MajorVersion=" +
                     "\"1\" xmlns=" +
                     "\"urn:runtime.hri.rqrs.datalex.com\"></InventoryAvailabilitySvRS>" +
                     "</InventoryAvailabilitySvResponse>" +
                     "</SOAP-ENV:Body>" +
                     "</SOAP-ENV:Envelope>";

        XmlMapper xmlMapper = new XmlMapper();
        JsonNode root = xmlMapper.readTree(xml);
       
        JsonNode body = root.get("Body");
       
        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(body);
       
        System.out.println(json);
    }


    public static String xmlToJson(String xml) throws JsonMappingException, JsonProcessingException
    {
    	
    	XmlMapper xmlMapper = new XmlMapper();
        JsonNode root = xmlMapper.readTree(xml);
       
        JsonNode body = root.get("Body");
       
        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(body);
        
        return json;
    	
    }


    }