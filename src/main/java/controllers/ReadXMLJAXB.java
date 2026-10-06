package controllers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import models.Dealership;

import java.nio.file.Path;

public class ReadXMLJAXB {

    public Dealership readDealarship(Path p) throws JAXBException {
        Dealership newDealarship = new Dealership();

        //la librería trabaja creando un JAXBContext que es el que utiliza el mapeo de las etiquetas
        JAXBContext jaxbContext = JAXBContext.newInstance(Dealership.class);
        //Para traer a mis clases java la info del xml hago un unmarshall
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        //el unmarshaller nos deja volcar en nuestra variable de clase la del contexto el contenido del xml
        newDealarship = (Dealership) jaxbUnmarshaller.unmarshal(p.toFile());

        return newDealarship;
    }
}
