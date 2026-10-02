package ui;

import controllers.ReadXMLDOM;
import controllers.ReadXMLSAX;
import models.Car;
import models.Dealership;
import myLib.UserMethods;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;


public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private boolean exitMenu = false;

    public void showMenu(){
        UserMethods userMethods = new UserMethods();
        do{
            userMethods.myPrinter("Choose an option: ");
            userMethods.myPrinter("1. Read XML file using DOM");
            userMethods.myPrinter("2. Read XML file using SAX");
            userMethods.myPrinter("3. Read XML file using JAXB");
            userMethods.myPrinter("4. Write XML file using JAXB");
            userMethods.myPrinter("0. Exit.");
            processOption(requestOption());
        }while(!exitMenu);
    }
    private String requestOption(){
        return this.scanner.nextLine();
    }

    private void processOption(String option){
        UserMethods userMethods = new UserMethods();
        switch(option){
            case "0" -> exitMenu = true;
            case "1" -> {
                Path p = userMethods.fileToRead("Introduce the path to the file to be read with DOM: ");
                ReadXMLDOM readXMLDOM = new ReadXMLDOM();
                try {
                    Dealership myDealership = readXMLDOM.readDealearshipxml(p);
                    for (Car car : myDealership.getCars()){
                        userMethods.myPrinter(car.getBrand());
                    }
                } catch (IOException e) {
                    userMethods.myPrinter("Something went wrong reading the file.");
                } catch (SAXException e) {
                    userMethods.myPrinter("The xml file does not match the requirements.");
                }

            }
            case "2" -> {
                Path p = userMethods.fileToRead("Introduce the path to the file to be read with SAX: ");
                ReadXMLSAX readXMLSAX = new ReadXMLSAX();
                try {
                    Dealership myDealershipSAX = readXMLSAX.saxController(p);
                    for (Car car : myDealershipSAX.getCars()){
                        userMethods.myPrinter(car.getBrand());
                    }
                } catch (ParserConfigurationException e) {
                    userMethods.myPrinter("The handler does not match the file.");
                } catch (SAXException e) {
                    userMethods.myPrinter("SAX Exception");
                } catch (IOException e) {
                    userMethods.myPrinter("The file can not be read.");
                }

            }
            case "3" -> {
                Path p = userMethods.fileToRead("Introduce the path to the file to be read with JAXB: ");
            }
            case "4" -> {
                Path p = userMethods.fileToWrite("Introduce the path for writing the file: ");

            }
            default -> userMethods.myPrinter("Wrong option.");
        }
    }
}
