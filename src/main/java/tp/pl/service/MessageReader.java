package tp.pl.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import tp.pl.model.Command;
import tp.pl.model.Message;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MessageReader {
	
	public List<Message> process() {
		List<Message> messages = new ArrayList<Message>();
		
		DefaultHandler handler = new DefaultHandler() {
			boolean bmessage = false;
			boolean bqty = false;
			boolean bcommand = false;
			Message message;
			public void startElement(String uri, String localName,String qName,
		                Attributes attributes) throws SAXException {
				if (qName.equalsIgnoreCase("MESSAGE")) {
					message = new Message();
					bmessage = true;
					message.setProductType(attributes.getValue("productType"));
					message.setPrice(new BigDecimal(attributes.getValue("price")));
				}
				if (qName.equalsIgnoreCase("QTY")) {
					bqty = true;
				}
				if (qName.equalsIgnoreCase("COMMAND")) {
					bcommand = true;
				}
			}
	
			public void endElement(String uri, String localName,
				String qName) throws SAXException {
				if (qName.equalsIgnoreCase("MESSAGE"))
					messages.add(message);
			}
	
			public void characters(char ch[], int start, int length) throws SAXException {
				if (bqty) {
					message.setQty(new BigDecimal(new String(ch, start, length)));
					bqty = false;
				}
	
				if (bcommand) {
					message.setCommand(Command.valueOf(new String(ch, start, length).toUpperCase()));
					bcommand = false;
				}
			}
		};
	
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			InputStream in = getClass().getResourceAsStream("/inputdata.xml"); 
			saxParser.parse(in,handler);
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return messages;
	}
}
