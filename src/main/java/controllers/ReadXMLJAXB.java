package controllers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import models.Book;
import models.BookCatalog;
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
    public void readWriteBookCatalog(Path p) throws JAXBException {
        BookCatalog newBookCatalog = new BookCatalog();
        final Path outputPath = Path.of("target/BookCatalog.xml");
        //la librería trabaja creando un JAXBContext que es el que utiliza el mapeo de las etiquetas
        JAXBContext jaxbContext = JAXBContext.newInstance(BookCatalog.class);
        //Para traer a mis clases java la info del xml hago un unmarshall
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        //el unmarshaller nos deja volcar en nuestra variable de clase la del contexto el contenido del xml
        newBookCatalog = (BookCatalog) jaxbUnmarshaller.unmarshal(p.toFile());
        Marshaller bookMarshaller = jaxbContext.createMarshaller();
        bookMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        bookMarshaller.marshal(newBookCatalog, outputPath.toFile());

    }
}
