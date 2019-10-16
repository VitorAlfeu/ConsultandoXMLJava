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

public class Teste {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse("pasta\\teste.txt");
		
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
						case "can:customerOrderType":
							System.out.println("customerOrderType de " + elementoFilhoXML.getTextContent());
							break;

						default:
							break;
						}
						
					}
					
				}
				
				
				//String customerOrderType = elementoXML.getAttribute("customerOrderType");//customerOrderType
				
				//System.out.println("customerOrderType de" + customerOrderType);
				
				
				
			}
			
			
		}
	}
}
