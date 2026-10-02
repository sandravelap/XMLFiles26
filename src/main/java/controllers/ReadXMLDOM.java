package controllers;

import models.Car;
import models.Dealership;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class ReadXMLDOM {
    public Dealership readDealearshipxml (Path p) throws IOException, SAXException {
        Dealership myDealership = new Dealership();
        myDealership.setCars(new ArrayList<>());
        //la librería w3c dom trabaja creando un Document con las clases y métodos siguientes:
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = null;
        try {
            parser = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            myDealership = null;
        }
        Document document = parser.parse(p.toFile());
        // para poder usar los métodos getElement(s) necesito un Element con el raiz
        Element root = document.getDocumentElement();
        // guardo en listas de nodos los nodos con la información que quiero recuperar
        NodeList cars =root.getElementsByTagName("coche");
        NodeList brands = root.getElementsByTagName("marca");
        NodeList models = root.getElementsByTagName("modelo");
        NodeList engines = root.getElementsByTagName("cilindrada");
        // necesito un Car para almacenar la información que irá al Dealership
        Car auxCar;
        //recorro mis coches del xml
        for (int i=0; i<cars.getLength(); i++){
            auxCar = new Car();
            //accedemos al contenido de los nodos texto
            auxCar.setBrand(brands.item(i).getTextContent());
            auxCar.setModel(models.item(i).getTextContent());
            //suponemos que el esquema del xml no permite que no llegue un Double aquí.
            auxCar.setEngine(Double.valueOf(engines.item(i).getTextContent()));
            //accedemos al contenido del atributo y para eso transformamos el node car en Element
            Element elementCar = (Element) cars.item(i);
            auxCar.setId(Integer.valueOf(elementCar.getAttribute("id")));
            myDealership.getCars().add(auxCar);
        }
        return myDealership;
    }
}
