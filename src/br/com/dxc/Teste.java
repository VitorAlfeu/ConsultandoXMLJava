package br.com.dxc;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author jprates
 *16/10/2019
 */

public class Teste {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		//RECUPERA UM ÚNICO ELEMENTO NO ARQUIVO 
		recuperaDadosXML("pasta\\teste.xml");
		
		//PERCORRE OS ELEMENTOS NO ARQUIVO
		recuperarElementoXML("pasta\\teste.xml");
		
	}
	
	private static String recuperaDadosXML(String xml) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xml);
		
		String textContent = doc.getElementsByTagName("can:customerOrderType").item(0).getTextContent();
		System.out.println("Recupera elemento unico: " + textContent);
		return textContent;
	}
		
	private static String recuperarElementoXML(String xml) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xml);
		
		NodeList listaXML = doc.getElementsByTagName("customerOrder");
		int tamanhoLista = listaXML.getLength();
		
		for( int i = 0; i < tamanhoLista; i++) {
			Node noXML = listaXML.item(i);
			
			if (noXML.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoXML = (Element) noXML;
				NodeList listaElementoFilhaXML = elementoXML.getChildNodes();
				int tamanhoListaFilhaXml = listaElementoFilhaXML.getLength();
				
				for (int j = 0; j < tamanhoListaFilhaXml; j++) {
					Node nFilhoXML = listaElementoFilhaXML.item(j);
					
					if (nFilhoXML.getNodeType() == Node.ELEMENT_NODE) {
						Element elementoFilhoXML = (Element) nFilhoXML;
						
						switch (elementoFilhoXML.getTagName()) {
						case "can:purchaseOrderNumber":
							System.out.println("purchaseOrderNumber = " + elementoFilhoXML.getTextContent());
							break;
						case "can:customerOrderType":
							System.out.println("customerOrderType = " + elementoFilhoXML.getTextContent());
							break;
						default:
							break;
						}
						
					}
					
				}
				
			}
			
		}
		return xml;
	}
	
}
