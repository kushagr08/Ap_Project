package snake_vs_block_5;

import java.io.IOException;
import java.util.ArrayList;

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
 * <p>xmlparse class to read data from savedata.xml for resume</p>
 * <p>4 fields itemstr,xposstr,yposstr,valuestr to read attributes of each object</p>
 * 
 *
 */
public class xmlparse {

		
	private String itemStr,xposStr,yposStr,valueStr;
	//this code return the xml data as object to main.java
	
	
	/**
	 * @return arraylist of latest serialized objects' attributes
	 * <p>parsing the objects' serialized attributes from savedata.xml</p>
	 */
	public ArrayList<itemObj> ReadXml() {
		
		
		ArrayList<itemObj> itmobjArr; 
		itmobjArr = new ArrayList<itemObj>();
	    
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Instanced the xml parser
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("savedata.xml");
			NodeList itemsList = doc.getElementsByTagName("items");
			for (int i = 0; i < itemsList.getLength(); i++) {
				Node itemNode = itemsList.item(i);
				if (itemNode.getNodeType() == itemNode.ELEMENT_NODE) {
					Element item = (Element) itemNode;
					NodeList iList = item.getChildNodes();
					for (int j = 0; j < iList.getLength(); j++) {
						Node n = iList.item(j);
						if (n.getNodeType() == n.ELEMENT_NODE) {
							Element e = (Element) n;
							if (e.getTagName() == "item") {
								itemStr=e.getTextContent();
							}
							if (e.getTagName() == "xpos") {
								xposStr=e.getTextContent();
							}
							if (e.getTagName() == "ypos") {
								yposStr=e.getTextContent();
							}
							if (e.getTagName() == "value") {
								valueStr=e.getTextContent();
							}
						}

					}
				}
				
				itemObj itm =new itemObj(itemStr,xposStr,yposStr,valueStr);
				itmobjArr.add(itm);
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < itmobjArr.size(); i++) {
		}
		return itmobjArr;
	}
	
	
}
