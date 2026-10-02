package controllers;

import models.Dealership;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class ReadXMLSAX {
    public Dealership saxController (Path p) throws ParserConfigurationException, SAXException, IOException {
        Dealership myDealership = new Dealership();
        DealershipHandler handler = new DealershipHandler();
        myDealership.setCars(new ArrayList<>());
        SAXParserFactory saxParserFactory = SAXParserFactory.newDefaultInstance();
        SAXParser parser = saxParserFactory.newSAXParser();
        parser.parse(p.toFile(),handler);
        myDealership = handler.getDealership();
        return myDealership;
    }
}
