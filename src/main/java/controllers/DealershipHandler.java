package controllers;

import models.Car;
import models.Dealership;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class DealershipHandler extends DefaultHandler {
    //variables para almacenar los datos (models)
    Dealership dealership = new Dealership();
    Car auxCar;
    //para almacenar el texto contenido en un nodo texto
    private StringBuilder buffer = new StringBuilder();

    public Dealership getDealership(){
        return dealership;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //almacenar los caracteres de texto del nodetext
        buffer.append(ch, start, length);
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "concesionario"->
                dealership.setCars(new ArrayList<>());
            case "coche"->{
                auxCar = new Car();
                auxCar.setId(Integer.valueOf(attributes.getValue("id")));
            }
            case "marca", "modelo", "cilindrada"->
                //vaciar el buffer para poder almacenar el contenido de texto
                buffer.delete(0, buffer.length());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "coche" ->
                dealership.getCars().add(auxCar);
            case "marca" ->
                auxCar.setBrand(buffer.toString());
            case "modelo"->
                auxCar.setModel(buffer.toString());
            case "cilindrada" ->
                auxCar.setEngine(Double.valueOf(buffer.toString()));
        }
    }


}
