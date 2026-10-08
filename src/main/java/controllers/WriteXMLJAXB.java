package controllers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import models.Dealership;

import java.nio.file.Path;

public class WriteXMLJAXB {
    public String writeDealership(Path p) {
        String message ="";
        //leemos el archivo para poder cargar un Concesionario que escribir después:
        final Path xmlPath = Path.of("src/main/resources/concesionario.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Dealership.class);
            //primero lo leo con el unmarshaller y lo cargo en una variable Dealership
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Dealership xmlDealership = (Dealership) jaxbUnmarshaller.unmarshal(xmlPath.toFile());
            //y ahora ya lo puedo escribir en un archivo con el marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(xmlDealership, p.toFile());
        } catch (JAXBException e) {
            message="Something went wrong.";
        }


        return message;
    }
}
