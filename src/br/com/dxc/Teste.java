package br.com.dxc;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
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
		
		//RECUPERA O ELEMENTO DENTRO DA STRING
		 String xml = "<app:applyTranslateRulesOut xmlns:app=\"http://www.gvt.com.br/Commons/ApplyTranslateRules/\"><customerOrder><can:purchaseOrderNumber xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">8-A61F473FF09-1</can:purchaseOrderNumber><can:customerOrderType xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">INSADI</can:customerOrderType><can:CustomerOrderComprisedOf xmlns:can=\"http://www.gvt.com.br/CanonicalModel\"><can:productBundle><can:ID>C005DA80DD</can:ID><can:associatedProductId>C005DA80DD</can:associatedProductId></can:productBundle></can:CustomerOrderComprisedOf></customerOrder><product><can:provisioningCode xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">VBLG11</can:provisioningCode><can:ProductRealizedAsCFService xmlns:can=\"http://www.gvt.com.br/CanonicalModel\"><can:customerFacingServiceAtomic><can:serviceId>110008860006208</can:serviceId><can:place><can:PlacePhysicalResourceAssoc><can:PhysicalLink><can:mediaType>FIBRA</can:mediaType></can:PhysicalLink></can:PlacePhysicalResourceAssoc></can:place><can:serviceTechonology>VOIP2</can:serviceTechonology></can:customerFacingServiceAtomic></can:ProductRealizedAsCFService></product><address><can:PlacePhysicalResourceAssoc xmlns:can=\"http://www.gvt.com.br/CanonicalModel\"><can:PhysicalLink><can:mediaType>FIBRA</can:mediaType><can:accessTecnology>GPON</can:accessTecnology></can:PhysicalLink></can:PlacePhysicalResourceAssoc><can:PostOfficeLogicalAddress xmlns:can=\"http://www.gvt.com.br/CanonicalModel\"><can:id/></can:PostOfficeLogicalAddress><can:city xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">SAO PAULO</can:city><can:addressType xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">R</can:addressType><can:id xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">8-420674298474</can:id><can:streetName xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">FAWCETT,CEL</can:streetName><can:stateOrProvince xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">SP</can:stateOrProvince><can:streetNrFirst xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">1026</can:streetNrFirst><can:locality xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">04167031</can:locality><can:postcode xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">04167031</can:postcode><can:cnl xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">11000</can:cnl><can:cnlAcronym xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">SPO</can:cnlAcronym><can:streetCode xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">105864</can:streetCode><can:neighborhood xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">VILA MORAES</can:neighborhood><can:complement xmlns:can=\"http://www.gvt.com.br/CanonicalModel\"/><can:complementValue xmlns:can=\"http://www.gvt.com.br/CanonicalModel\"/><can:customAddress xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">FAWCETT,CEL (GVT: 105864), SAO PAULO, SP, 1026</can:customAddress><can:reference xmlns:can=\"http://www.gvt.com.br/CanonicalModel\"/><can:networkOwner xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">VIVO1</can:networkOwner><can:telephonicArea xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">AF</can:telephonicArea><can:centralOffice xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">JB</can:centralOffice><can:addressInvolvesPlaceAdaptation xmlns:can=\"http://www.gvt.com.br/CanonicalModel\"><can:InfrastructureAdaptation/></can:addressInvolvesPlaceAdaptation></address><SystemIdentification><can:system xmlns:can=\"http://www.gvt.com.br/CanonicalModel\">GVT</can:system></SystemIdentification></app:applyTranslateRulesOut>";
		 recuperaStringXML(xml);
		
	}
	
	private static void recuperaStringXML(String xml) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		
		Document xmlDocument = dBuilder.parse(new InputSource(new StringReader(xml)));
        // Pega os elementos em que o nome da tag seja "can:customerOrderType":
        NodeList nodes = xmlDocument.getElementsByTagName("can:customerOrderType");
        for(int i = 0; i < nodes.getLength(); i++) {
        	System.out.println(nodes.item(i).getTextContent());
        }
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
